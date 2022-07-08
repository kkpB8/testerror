/**
 * 
 */
package com.devglan.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.devglan.domain.FederationProfile;
import com.devglan.domain.SHGProfile;
import com.devglan.domain.UploadShgMeeting;
import com.devglan.domain.UploadVoMeeting;
import com.devglan.model.Processing_JsonEntity;
import com.devglan.model.TransactionStatusEntity;

public interface TenantService {

	public List<Processing_JsonEntity> findByFlag(Short flag);
	
	public void updateFlagAndTime(BigInteger id,Short flag,Short time);
	
	public String createSHGProfileUpload(String role,SHGProfile SHGProfile,List<MultipartFile> uploadFiles);
	
	public String createUpdateFederationProfile(String role,FederationProfile federationProfile,List<MultipartFile> uploadFiles);
	
	public TransactionStatusEntity insertIntoTransaction(String transactionId,BigInteger processingId, String userId,String role);
	
	public void saveTransactionStatus(TransactionStatusEntity transactionStatusEntity);

	public String createMeetingProfileUpload(String role,UploadShgMeeting uploadShgMeeting) throws Exception;

	public Boolean createMeetingSummary();

	public String createVoMeetingProfileUpload(String role, UploadVoMeeting uploadVoMeeting);

	public void processLoanPaymentVouchers();


	public void processGroupLoanPaymentVouchers();
}
