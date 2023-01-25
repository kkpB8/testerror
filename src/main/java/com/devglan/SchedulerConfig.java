package com.devglan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.devglan.model.ShgProfileEntity;
import com.devglan.tenant.dao.SHGProfileDao;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.devglan.domain.FederationProfile;
import com.devglan.domain.SHGProfile;
import com.devglan.domain.UploadShgMeeting;
import com.devglan.domain.UploadVoMeeting;
import com.devglan.model.Processing_JsonEntity;
import com.devglan.model.TransactionStatusEntity;
import com.devglan.service.TenantService;
import com.google.gson.Gson;



@Component
public class SchedulerConfig{
	private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);
	@Autowired
	TenantService tenantService;
   @Autowired
   private SHGProfileDao shgProfileDao;

   @Scheduled(initialDelay = 10000,fixedDelay = 120000)
	  public void run() {
	  logger.info("Scheduler started successfully");

	  System.out.println("SWATI GOGIA");
	  String transactionId = "";
	  try {
	  List<Processing_JsonEntity> processingJsonList = tenantService.findByFlag(Processing_JsonEntity.noReadFlag);
	  for(Processing_JsonEntity processingJsonTemp : processingJsonList) {
	
		  tenantService.updateFlagAndTime(processingJsonTemp.getId(),Processing_JsonEntity.processingFlag,Processing_JsonEntity.startTimeFlag);
		
		  String json = processingJsonTemp.getJson();
          Gson g = new Gson();
           transactionId = processingJsonTemp.getTransaction_id();
           String role = processingJsonTemp.getRole();
           String userId = processingJsonTemp.getUser_id();
           logger.info(g.toJson(processingJsonTemp.getJson()));
           //if(true) {
	           TransactionStatusEntity transactionStatusEntity1 = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),userId,role);
	           transactionStatusEntity1.setStatus(TransactionStatusEntity.pending);
	           //transactionStatusEntity.setRole(role);
	           transactionStatusEntity1.setRemarks("Record in Proccessing state");
	           tenantService.saveTransactionStatus(transactionStatusEntity1);
           //}
          if(processingJsonTemp.getCbo_type().equals(Processing_JsonEntity.shgLookupVal)){
              SHGProfile shgProfile = g.fromJson(json, SHGProfile.class);
              shgProfile.setTransaction_id(transactionId);
              shgProfile.setProcessingId(processingJsonTemp.getId());
              try {
            	    String returnStatus="";
              if(processingJsonTemp.getFiles()!=null &&
                      !processingJsonTemp.getFiles().equals("")){
                  String path = processingJsonTemp.getFiles();
                  File folder = new File(path);
                  File[] uploadFiles = folder.listFiles();
                  List<MultipartFile> uploadMultipartFiles = new ArrayList<>();

                  for(File file : uploadFiles){
                      FileInputStream input = null;
                      try {
                          input = new FileInputStream(file);

                      MultipartFile multipartFile = new MockMultipartFile("file",
                              file.getName(), "image/jpg", IOUtils.toByteArray(input));
                          uploadMultipartFiles.add(multipartFile);
                      } catch (FileNotFoundException e) {
                    	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),userId,role);
	           	           transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
	           	           //transactionStatusEntity.setRole(role);
	           	           transactionStatusEntity.setRemarks("File not found file name - "+file.getName());
	           	           tenantService.saveTransactionStatus(transactionStatusEntity);
                          e.printStackTrace();
                      } catch (IOException e) {
                    	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),userId,role);
	           	           transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
	           	           //transactionStatusEntity.setRole(role);
	           	           transactionStatusEntity.setRemarks("Error in file processing");
	           	           tenantService.saveTransactionStatus(transactionStatusEntity);
                          e.printStackTrace();
                      }
                  }

                  returnStatus =   tenantService.createSHGProfileUpload(role,shgProfile,uploadMultipartFiles);
              }
              else
            	  returnStatus = tenantService.createSHGProfileUpload(role,shgProfile,null);
              if(returnStatus.equals("Success")) {
            	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),shgProfile.getUploaded_by(),role);
                  transactionStatusEntity.setStatus(TransactionStatusEntity.success);
                  //transactionStatusEntity.setRole(role);
                  transactionStatusEntity.setRemarks("Data inserted/updated successfully");
                  tenantService.saveTransactionStatus(transactionStatusEntity);
                  try {
                     //ShgProfileEntity shgProfileEntity= shgProfileDao.fetchByGUID(shgProfile.getGuid(),Boolean.TRUE);
                     //jsonCreationAtInsertion(shgProfileEntity.getShgId());
                  }catch (Exception e){
                     System.out.println("Error in Json creation");
                     e.printStackTrace();
                  }
              }
              }
              catch(Exception e) {
            	  if(transactionId!=null && !transactionId.equals("")){
         			 TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),shgProfile.getUploaded_by(),role);
         	          transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
         	        transactionStatusEntity.setRemarks(e.toString());

         	          tenantService.saveTransactionStatus(transactionStatusEntity);
         		 }
            	  e.printStackTrace();
              }



          }

          else   if(processingJsonTemp.getCbo_type().equals(Processing_JsonEntity.federationLookupVal)){
        	  FederationProfile federationProfile = g.fromJson(json, FederationProfile.class);
        	federationProfile.setTransaction_id(federationProfile.getTransaction_id());
        	federationProfile.setProcessingId(processingJsonTemp.getId());
        	  String returnStatus="";
        	  if(processingJsonTemp.getFiles()!=null &&
                      !processingJsonTemp.getFiles().equals("")){
                  String path = processingJsonTemp.getFiles();
                  File folder = new File(path);
                  File[] uploadFiles = folder.listFiles();
                  List<MultipartFile> uploadMultipartFiles = new ArrayList<>();
                  for(File file : uploadFiles){
                      FileInputStream input = null;
                      try {

                          input = new FileInputStream(file);

                      MultipartFile multipartFile = new MockMultipartFile("file",
                              file.getName(), "image/jpg", IOUtils.toByteArray(input));
                          uploadMultipartFiles.add(multipartFile);
                      } catch (FileNotFoundException e) {
                    	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),userId,role);
	           	           transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
	           	           //transactionStatusEntity.setRole(role);
	           	           transactionStatusEntity.setRemarks("File not found file name - "+file.getName());
	           	           tenantService.saveTransactionStatus(transactionStatusEntity);
                         e.printStackTrace();
                     } catch (IOException e) {
                   	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),userId,role);
	           	           transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
	           	           //transactionStatusEntity.setRole(role);
	           	           transactionStatusEntity.setRemarks("Error in file processing");
	           	           tenantService.saveTransactionStatus(transactionStatusEntity);
                         e.printStackTrace();
                     }
                  }
                  returnStatus =   tenantService.createUpdateFederationProfile(role,federationProfile,uploadMultipartFiles);
          }
        	  else
        		  returnStatus =  tenantService.createUpdateFederationProfile(role,federationProfile,null);
        	  if(returnStatus.equals("Success")) {
            	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),federationProfile.getUploaded_by(),role);
                  transactionStatusEntity.setStatus(TransactionStatusEntity.success);
                 // transactionStatusEntity.setRole(role);
                  transactionStatusEntity.setRemarks("Data inserted/updated successfully");
                  tenantService.saveTransactionStatus(transactionStatusEntity);
              }
        	 }

          else if(processingJsonTemp.getCbo_type().equals(Processing_JsonEntity.voMeetingLookupVal)){
              try {


                  String returnStatus="";
                  UploadVoMeeting uploadVoMeeting = g.fromJson(json, UploadVoMeeting.class);
                  if(uploadVoMeeting.getTransactionId()!=null)
                      transactionId = uploadVoMeeting.getTransactionId();
                  else
                      transactionId = "unknown";
                  uploadVoMeeting.setProcessingId(processingJsonTemp.getId());
                  uploadVoMeeting.setUserId(processingJsonTemp.getUser_id());
                  returnStatus = tenantService.createVoMeetingProfileUpload(role,uploadVoMeeting);
                  if(returnStatus.equals("Success")) {
                	  tenantService.createMeetingSummary();
                      TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),processingJsonTemp.getUser_id().toString(),role);
                      transactionStatusEntity.setStatus(TransactionStatusEntity.success);
                      //transactionStatusEntity.setRole(role);
                      transactionStatusEntity.setRemarks("Data inserted/updated successfully");
                      tenantService.saveTransactionStatus(transactionStatusEntity);

                  }


              }
              catch(Exception e) {
                  // if(transactionId!=null && !transactionId.equals("")){
                  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),processingJsonTemp.getUser_id().toString(),role);
                  transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
                  //transactionStatusEntity.setRole(role);
                  transactionStatusEntity.setRemarks(e.toString());

                  tenantService.saveTransactionStatus(transactionStatusEntity);
                  //}
                  e.printStackTrace();
              }
            tenantService.updateFlagAndTime(processingJsonTemp.getId(),Processing_JsonEntity.executedFlag,Processing_JsonEntity.EndTimeFlag);


          }
          //tenantService.updateFlagAndTime(processingJsonTemp.getId(),Processing_JsonEntity.executedFlag,Processing_JsonEntity.EndTimeFlag);


          else if(processingJsonTemp.getCbo_type().equals(Processing_JsonEntity.meetingLookupVal)){
        	  try {


        	  String returnStatus="";
        	  UploadShgMeeting uploadShgMeeting = g.fromJson(json, UploadShgMeeting.class);

        	  transactionId = uploadShgMeeting.getTransactionId();

        	  uploadShgMeeting.setProcessingId(processingJsonTemp.getId());
        	  uploadShgMeeting.setUserId(processingJsonTemp.getUser_id());
        	  returnStatus = tenantService.createMeetingProfileUpload(role,uploadShgMeeting);
        	 if(returnStatus.equals("Success")) {
        		 tenantService.createMeetingSummary();
            	  TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),processingJsonTemp.getUser_id().toString(),role);
                  transactionStatusEntity.setStatus(TransactionStatusEntity.success);
                  //transactionStatusEntity.setRole(role);
                  transactionStatusEntity.setRemarks("Data inserted/updated successfully");
                  tenantService.saveTransactionStatus(transactionStatusEntity);

              }


        	  }
              catch(Exception e) {
            	 // if(transactionId!=null && !transactionId.equals("")){
         			 TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,processingJsonTemp.getId(),processingJsonTemp.getUser_id().toString(),role);
         	          transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
         	         //transactionStatusEntity.setRole(role);
         	        transactionStatusEntity.setRemarks(e.toString());

         	          tenantService.saveTransactionStatus(transactionStatusEntity);
         		 //}
            	  e.printStackTrace();
              }
          }
          tenantService.updateFlagAndTime(processingJsonTemp.getId(),Processing_JsonEntity.executedFlag,Processing_JsonEntity.EndTimeFlag);

	  }
	  }

	  catch(Exception e) {
		 if(transactionId!=null && !transactionId.equals("")){
			 TransactionStatusEntity transactionStatusEntity = tenantService.insertIntoTransaction(transactionId,new BigInteger("0"),"unknown","unknown");
	          transactionStatusEntity.setStatus(TransactionStatusEntity.failure
	        		  );
	          //transactionStatusEntity.setRole("unkown");
	          transactionStatusEntity.setRemarks(e.toString());
	          tenantService.saveTransactionStatus(transactionStatusEntity);
		 }
		  e.printStackTrace();
	  }
	  }


@Scheduled(initialDelay = 10000,fixedDelay = 120000)
public void runLoanScheduler() {
        logger.info("Loan Scheduler started successfully");
        System.out.println("Running loan scheduler.....");
        this.tenantService.processLoanPaymentVouchers();
        this.tenantService.processGroupLoanPaymentVouchers();

    }

   @Scheduled(cron = "0 0 0 * * *",zone = "Indian/Maldives")
   public void meetingSummary() {
      logger.info("meetingSummary - > Scheduler started successfully");
      Boolean b = tenantService.createMeetingSummary();
      if(b){
         System.out.println("update successfully!!");
      }else{
         System.out.println("update failed!!");
      }
   }

  /* @Scheduled(initialDelay = 10000,fixedDelay = 999999999)
   public void runJsonCreationAtInsertion() {
      jsonCreationAtInsertion(BigInteger.valueOf(1200));

   }*/
   public void jsonCreationAtInsertion(BigInteger shgId){
      Long t1 = System.currentTimeMillis();
      System.out.println("Program  starting point. T1 -> "+ t1);
      String res = tenantService.jsonCreationAtInsertion(shgId);
      Long t2 = System.currentTimeMillis();
      System.out.println("Program  ending point T2 -> "+ t2);
      System.out.println("Total Time (T2 - T1) -> "+ (t2-t1));

   }

   /*@Scheduled(initialDelay = 10000,fixedDelay = 999999999)
   public void runJsonCreationAtInsertion() {
      tenantService.decryptEncryptAadhaar("FMF770QA4SYxoRVBCqaGvZEGcjbsor0TNwmNFQ53Fsw=","W3sqaLepBNqt1vjyBnh9TVnZJQSM672022112312274755");

   }*/




}


