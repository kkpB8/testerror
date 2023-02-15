/**
 *
 */
package com.devglan.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devglan.domain.*;
import com.devglan.domain.UploadVoMeeting;
import com.devglan.domain.VoFinTxnVouchers;
import com.devglan.model.*;
import com.devglan.tenant.dao.PGFunctionProcedureService;
import com.devglan.tenant.dao.*;
import com.devglan.utils.AESPasswordEncoder;
import com.devglan.utils.EncryptionAadhaarNrlm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.SerializationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devglan.mapper.GroupMapper;
import com.devglan.mapper.MeetingMapper;
import com.devglan.mapper.MemberMapper;
import com.devglan.mapper.VoMeetingMapper;
import com.devglan.service.TenantService;
import com.devglan.seshat.dao.TenantsDao;
import com.devglan.utils.ServiceConstants;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@Service

@Transactional(readOnly = true)
public class TenantServiceImpl<VoMtgDetDao, VoMemLoanScheduleDao, VoMemLoanDao, VoGroupLoanScheduleDao, VoMtgDao, VoMemLoanTxnDao, VoFinTxnDetMemDao, VoFinTxnDao, VoFinTxnDetGrpDao, VoGroupLoanTxnDao, VoLoanApplicationDao> implements TenantService {

	public String uploadDir = File.separator + "opt" + File.separator + "svn" + File.separator + "dynamic";;



	@Autowired
	private TransactionTemplate txTemplate;

	@Autowired
	private ProcessingJsonDao processingJsonDao;

	@Autowired
	private TenantsDao tenantsDao;

	@Autowired
	private SHGProfileDao shgProfileDao;

	@Autowired
	private DocumentDetailsDao documentDetailsDao;

	@Autowired
	private CboAddressesDetailsDao cboAddressesDetailsDao;

	@Autowired
	private CboPhoneNoDetailsDao cboPhoneNoDetailsDao;

	@Autowired
	private CboBankDetailsDao cboBankDetailsDao;

	@Autowired
	private SystemTagsDao systemTagsDao;

	@Autowired
	private CboKYCDetailsDao cboKYCDetailsDao;

	@Autowired
	private SHGDesignationDao shgDesignationDao;

	@Autowired
	MemberProfileDao memberProfileDao;

	@Autowired
	MemberAddressesDetailsDao memberAddressesDetailsDao;
	@Autowired
	CadreNonMemberDao cadreNonMemberDao;
	@Autowired
	CadreShgMembersDao cadreShgMembersDao;


	@Autowired
	MemberPhoneNoDetailsDao memberPhoneNoDetailsDao;

	@Autowired
	MemberBankDetailsDao memberBankDetailsDao;

	@Autowired
	MemberSystemTagsDao memberSystemTagsDao;

	@Autowired
	MemberKYCDetailsDao memberKYCDetailsDao;

	@Autowired
	private FederationProfileDao federationProfileDao;

	@Autowired
	private TransactionStatusDao transactionStatusDao;

	@Autowired
	private UsersRoleRightsMapDao usersRoleRightsMapDao;

	@Autowired
	private ShgMtgDao shgMtgDao;

	@Autowired
	private ShgMtgDetDao shgMtgDetDao;

	@Autowired
	private ShgFinTxnDao shgFinTxnDao;

	@Autowired
	private ShgFinTxnDetGrpDao shgFinTxnDetGrpDao;

	@Autowired
	private ShgGroupLoanDao shgGroupLoanDao;

	@Autowired
	private ShgGroupLoanTxnDao shgGroupLoanTxnDao;

	@Autowired
	private ShgLoanApplicationDao shgLoanApplicationDao;

	@Autowired
	private ShgMemLoanDao shgMemLoanDao;

	@Autowired
	private ShgMemLoanTxnDao shgMemLoanTxnDao;

	@Autowired
	private ShgMemSettlementDao shgMemSettlementDao;

	@Autowired
	private VoMemSettlementDao voMemSettlementDao;


	@Autowired
	private ShgFinTxnDetMemDao shgFinTxnDetMemDao;

	@Autowired
	private ShgMemLoanScheduleDao shgMemLoanScheduleDao;

	@Autowired
	private ShgGroupLoanScheduleDao shgGroupLoanScheduleDao;

	@Autowired
	private ShgMcpDao shgMcpDao;

	@Autowired
	private TestDao testDao;


	@Autowired
	private VoMtgEntityDao voMtgDao;

	@Autowired
	private VoMemLoanTxnEntityDao voMemLoanTxnDao;

	@Autowired
	private VoFinTxnDetMemEntityDao voFinTxnDetMemDao;

	@Autowired
	private VoFinTxnEntityDao voFinTxnDao;

	@Autowired
	private VoFinTxnDetGrpEntityDao voFinTxnDetGrpDao;

	@Autowired
	private VoGroupLoanTxnEntityDao voGroupLoanTxnDao;

	@Autowired
	private VoLoanApplicationEntityDao voLoanApplicationDao;

	@Autowired
	private VoGroupLoanDao voGroupLoanDao;

	@Autowired
	private VoGroupLoanScheduleEntityDao voGroupLoanScheduleDao;

	@Autowired
	private VoMemLoanEntityDao voMemLoanDao;

	@Autowired
	private VoMemLoanScheduleEntityDao voMemLoanScheduleDao;

	@Autowired
	private VoMtgDetEntityDao voMtgDetDao;

	@Autowired
	private MemberInsuranceDao memberInsuranceDao;



	@Autowired
	private ShgFinTxnVouchersDao shgFinTxnVouchersDao;

	@Autowired
	private VoFinTxnVouchersDao voFinTxnVouchersDao;

	@Autowired
	private PGFunctionProcedureService pgFunctionProcedureService;

	@Autowired
	private ClfFinTxnDetMemDao clfFinTxnDetMemDao;

	@Autowired
	private ClfMemLoanScheduleDao clfMemLoanScheduleDao;

	@Autowired
	private ClfMemLoanDao clfMemLoanDao;

	@Autowired
	private ClfFinTxnDetGrpDao clfFinTxnDetGrpDao;

	@Autowired
	private ClfGroupLoanScheduleDao clfGroupLoanScheduleDao;

	@Autowired
	private ClfGroupLoanDao clfGroupLoanDao;


	@Autowired
	private ClfMtgDetailsDao clfMtgDetailsDao;

	@Autowired
	private ProfileMasterDataDao profileMasterDataDao;

	@Autowired
	private MemberProfileMasterDataDao memberProfileMasterDataDao;
  

	public TenantServiceImpl() {
	}

	public TenantsEntity findByIdentifier(String identifier) {
		TenantsEntity tenants = tenantsDao.findByIdentifier(identifier);

		return tenants;
	}

	public Boolean saveProcessingJson() {
		Processing_JsonEntity processingJson = new Processing_JsonEntity();
		processingJson.setJson("{\"gg\",\"gg\"}");
		processingJsonDao.save(processingJson);
		return true;
	}

	// SCHEDULER METHODS
	@Override
	public List<Processing_JsonEntity> findByFlag(Short flag) {
		List<Processing_JsonEntity> processingJsonList = processingJsonDao.findByFlag(flag);
		return processingJsonList;
	}

	@Override
	public void updateFlagAndTime(BigInteger id, Short flag, Short time) {
		Processing_JsonEntity processingJson = processingJsonDao.findOne(id);
		processingJson.setFlag(flag);
		if (time.equals(Processing_JsonEntity.startTimeFlag)) {
			processingJson.setStart_time(new Timestamp(System.currentTimeMillis()));
		} else if (time.equals(Processing_JsonEntity.EndTimeFlag)) {
			processingJson.setEnd_time(new Timestamp(System.currentTimeMillis()));
		}
		processingJsonDao.save(processingJson);
	}

	// UPLOAD SHG PROFILE
	// UPLOAD
	@Transactional
	public String createSHGProfileUpload(String role, SHGProfile SHGProfile, List<MultipartFile> uploadFiles) {
		String returnString = "Success";
		try {
			BigInteger shgid = new BigInteger("0");
			// final SHGProfile SHGProfile = createSHGProfileUploadCommand.shgProfile();
			// final MultipartFile[] uploadFiles =
			// createSHGProfileUploadCommand.uploadFiles();
			// CHECK VALIDATION STARTS
			Boolean dataToBeInserted = Boolean.TRUE;
			String transactionId = SHGProfile.getTransaction_id();
			BigInteger processingId = SHGProfile.getProcessingId();
			// transaction start

			// transaction end
			// UserMasterEntity userMasterEntity =
			// userMasterDao.findByUserId(SHGProfile.getUploaded_by());
			UsersRoleRightsMapEntity userRoleRightsMapEntity = usersRoleRightsMapDao
					.findByUserId(SHGProfile.getUploaded_by(),role);
			if (!userRoleRightsMapEntity.getStateId().equals(SHGProfile.getState_id())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							SHGProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("State Does Match with Mapped State of User");
					saveTransactionStatus(transactionStatusEntity);
				}
				returnString="failure";
			}
			if (!userRoleRightsMapEntity.getDistrictId().equals(SHGProfile.getDistrict_id().toString())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							SHGProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("District Does Match with Mapped District of User");
					saveTransactionStatus(transactionStatusEntity);
				}
				returnString="failure";
			}
			if (!userRoleRightsMapEntity.getBlockId().equals(SHGProfile.getBlock_id().toString())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							SHGProfile.getUploaded_by(), role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Block Does Match with Mapped Block of User");
					saveTransactionStatus(transactionStatusEntity);
				}
				returnString="failure";
			}
			/*
			 * if
			 * (!userRoleRightsMapEntity.getPanchayatId().equals(SHGProfile.getPanchayat_id(
			 * ).toString())) { dataToBeInserted = Boolean.FALSE; if (transactionId != null
			 * && !transactionId.equals("")) { TransactionStatusEntity
			 * transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
			 * SHGProfile.getUploaded_by(),role);
			 * transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
			 * transactionStatusEntity.
			 * setRemarks("Panchayat Does Match with Mapped Panchayat of User");
			 * saveTransactionStatus(transactionStatusEntity); } returnString="failure"; }
			 */

			if (userRoleRightsMapEntity.getPanchayatId() != null && !userRoleRightsMapEntity.getPanchayatId().isEmpty()) {
				List<String> panchayatIds = new ArrayList<String>();

				if (!userRoleRightsMapEntity.getPanchayatId().contains(",")) {
					panchayatIds.add(userRoleRightsMapEntity.getPanchayatId());
				} else {
					panchayatIds = Stream.of(userRoleRightsMapEntity.getPanchayatId().split(",")).map(String::trim)
							.collect(Collectors.toList());
				}

				if (!panchayatIds.contains(SHGProfile.getPanchayat_id().toString())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								SHGProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Panchayat Does Match with Mapped Panchayat of User");
						saveTransactionStatus(transactionStatusEntity);
					}
					returnString="failure";
				}

			}



			if (userRoleRightsMapEntity.getVillageId() != null && !userRoleRightsMapEntity.getVillageId().isEmpty()) {
				List<String> villageIds = new ArrayList<String>();

				if (!userRoleRightsMapEntity.getVillageId().contains(",")) {
					villageIds.add(userRoleRightsMapEntity.getVillageId());
				} else {
					villageIds = Stream.of(userRoleRightsMapEntity.getVillageId().split(",")).map(String::trim)
							.collect(Collectors.toList());
				}

				if (!villageIds.contains(SHGProfile.getVillage_id().toString())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								SHGProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Village Does Match with Mapped Village of User");
						saveTransactionStatus(transactionStatusEntity);
					}
					returnString="failure";
				}

			}
			if (!SHGProfile.getUser_id().equals(SHGProfile.getUploaded_by())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							SHGProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
					saveTransactionStatus(transactionStatusEntity);
				}
				returnString="failure";
			}

			if (SHGProfile.getShg_id() != null && !SHGProfile.getShg_id().equals(shgid)) {
				ShgProfileEntity shgProfileEntity = shgProfileDao.findOne(SHGProfile.getShg_id());
				if (!SHGProfile.getUser_id().equals(shgProfileEntity.getUserId())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								SHGProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
						saveTransactionStatus(transactionStatusEntity);
					}
					returnString="failure";
				}

			}
			if (SHGProfile.getGuid() != null) {
				ShgProfileEntity shgProfileEntity = shgProfileDao.fetchByGUID(SHGProfile.getGuid(), Boolean.TRUE);
				if (shgProfileEntity != null) {
					if (!SHGProfile.getUser_id().equals(shgProfileEntity.getUserId())) {
						dataToBeInserted = Boolean.FALSE;
						if (transactionId != null && !transactionId.equals("")) {
							TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
									SHGProfile.getUploaded_by(),role);
							transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
							transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
							saveTransactionStatus(transactionStatusEntity);
						}
						returnString="failure";
					}
				}

			}

			// CHECK VALIDATION ENDS
			if (dataToBeInserted.equals(Boolean.TRUE)) {

				BigInteger cboCode = null;
				ShgProfileEntity ShgProfileEntity = null;
				BigInteger profileDocId=null;

				if (SHGProfile.getShg_id() != null && SHGProfile.getShg_id().equals(shgid))
					SHGProfile.setShg_id(null);
				if (SHGProfile.getGuid() != null) {
					ShgProfileEntity = shgProfileDao.fetchByGUID(SHGProfile.getGuid(), Boolean.TRUE);
					if (ShgProfileEntity != null) {
						SHGProfile.setShg_id(ShgProfileEntity.getShgId());
						SHGProfile.setParent_cbo_code(ShgProfileEntity.getParentCboId());
						profileDocId = ShgProfileEntity.getProfileDocumentId();

					}
				}
				ShgProfileEntity ShgProfileEntityAfterSave = GroupMapper.mapSHG(SHGProfile);
				ShgProfileEntityAfterSave.setProfileDocumentId(profileDocId);
				// Images Starts
				List<Map<String, BigInteger>> shgPhotoDocId = new ArrayList<>();
				Map<String, BigInteger> memberProfilePhotoDocId = new HashMap<>();
				Map<String, BigInteger> memberConsentFormPhotoDocId = new HashMap<>();
				List<Map<String, BigInteger>> memberBankPassbookPhotoDocId = new ArrayList<>();
				Map<String, BigInteger> memberKYCAdhaarFrontPhotoDocId = new HashMap<>();
				Map<String, BigInteger> memberKYCAdhaarRearPhotoDocId = new HashMap<>();
				Map<String, BigInteger> memberKYCElectionFrontPhotoDocId = new HashMap<>();
				Map<String, BigInteger> memberKYCElectionRearPhotoDocId = new HashMap<>();
				Map<String, BigInteger> shgProfilePhotoDocId = new HashMap<>();

				if (uploadFiles != null) {
					Integer autoNo = 1;
					for (MultipartFile uploadFile : uploadFiles) {
						try {
							String fileName = uploadFile.getOriginalFilename();

							String[] parts = fileName.split(",");
							String part2 = parts[1];
							String fileMappingTypeWithExtension = part2;
							String part1 = parts[0];

							String[] partsAgain = fileMappingTypeWithExtension.split(".");
							String fileMappingType = fileMappingTypeWithExtension.replaceAll(".jpg", "")
									.replaceAll(".png", "").replaceAll(".pdf", "");
							String path = "miscellaneous";
							String modifiedName = cboCode + "_";
							// PATH of file
							if (fileMappingType.equals(ServiceConstants.shgBankPhoto)) {
								path = ServiceConstants.shgBankPhoto;
								modifiedName = ServiceConstants.shgBankPhoto;
							} else if (fileMappingType.contains(ServiceConstants.memberProfilePhoto)) {

								path = ServiceConstants.memberProfilePhoto;
								modifiedName = ServiceConstants.memberProfilePhoto;
							} else if (fileMappingType.contains(ServiceConstants.memberConsentForm)) {

								path = ServiceConstants.memberConsentForm;
								modifiedName = ServiceConstants.memberConsentForm;
							} else if (fileMappingType.contains(ServiceConstants.memberBankPassbookPhoto)) {
								path = ServiceConstants.memberBankPassbookPhoto;
								modifiedName = ServiceConstants.memberBankPassbookPhoto;
							} else if (fileMappingType.contains(ServiceConstants.memberKYCAdhaarFrontPhoto)) {

								path = ServiceConstants.memberKYCAdhaarFrontPhoto;
								modifiedName = ServiceConstants.memberKYCAdhaarFrontPhoto + "_"
										+ MemberKYCDetailsEntity.kycAdhaar;
							} else if (fileMappingType.contains(ServiceConstants.memberKYCAdhaarRearPhoto)) {
								path = ServiceConstants.memberKYCAdhaarRearPhoto;
								modifiedName = ServiceConstants.memberKYCAdhaarRearPhoto + "_"
										+ MemberKYCDetailsEntity.kycAdhaarRear;
							} else if (fileMappingType.contains(ServiceConstants.memberKYCElectionFrontPhoto)) {

								path = ServiceConstants.memberKYCElectionFrontPhoto;
								modifiedName = ServiceConstants.memberKYCElectionFrontPhoto + "_"
										+ MemberKYCDetailsEntity.kycElectionId;
							} else if (fileMappingType.contains(ServiceConstants.memberKYCElectionRearPhoto)) {

								path = ServiceConstants.memberKYCElectionRearPhoto;
								modifiedName = ServiceConstants.memberKYCElectionRearPhoto + "_"
										+ MemberKYCDetailsEntity.kycElectionIdRear;
							} else if (fileMappingType.contains(ServiceConstants.shgProfilePhoto)) {
								path = ServiceConstants.shgProfilePhoto;
								modifiedName = ServiceConstants.shgProfilePhoto;
							}
							modifiedName += "_" + new Timestamp(System.currentTimeMillis()) + "_" + autoNo + "."
									+ FilenameUtils.getExtension(uploadFile.getOriginalFilename());
							;
							autoNo++;
							// FILE MODIFIED NAME

							Path copyLocationFrontDoc = Paths.get(uploadDir + File.separator + "uploadFiles"
									+ File.separator + path + File.separator + StringUtils.cleanPath(modifiedName));
							Files.copy(uploadFile.getInputStream(), copyLocationFrontDoc,
									StandardCopyOption.REPLACE_EXISTING);
							DocumentDetails documentDetails = new DocumentDetails();
							documentDetails.setFront_doc_original_name(uploadFile.getOriginalFilename());
							documentDetails.setFront_doc_modified_name(StringUtils.cleanPath(modifiedName));
							documentDetails.setDoc_path("uploadFiles" + File.separator + path);
							documentDetails.setCreated_by(SHGProfile.getCreated_by());
							DocumentDetailsEntity documentDetailsEntity = GroupMapper.map(documentDetails);
							DocumentDetailsEntity documentDetailsEntityAfterSave = documentDetailsDao
									.saveAndFlush(documentDetailsEntity);
							// new code
							if (fileMappingType.equals(ServiceConstants.shgBankPhoto)) {
								Map<String, BigInteger> shgPhotoDocIdTemp = new HashMap<>();
								shgPhotoDocIdTemp.put(part1, documentDetailsEntityAfterSave.getDocumentId());
								shgPhotoDocId.add(shgPhotoDocIdTemp);

							} else if (fileMappingType.contains(ServiceConstants.memberProfilePhoto)) {

								memberProfilePhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							}else if (fileMappingType.contains(ServiceConstants.memberConsentForm)) {

								memberConsentFormPhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							} else if (fileMappingType.contains(ServiceConstants.memberBankPassbookPhoto)) {
								Map<String, BigInteger> memberBankPassbookPhotoDocIdTemp = new HashMap<>();
								memberBankPassbookPhotoDocIdTemp.put(part1,
										documentDetailsEntityAfterSave.getDocumentId());
								memberBankPassbookPhotoDocId.add(memberBankPassbookPhotoDocIdTemp);
							} else if (fileMappingType.contains(ServiceConstants.memberKYCAdhaarFrontPhoto)) {

								memberKYCAdhaarFrontPhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							} else if (fileMappingType.contains(ServiceConstants.memberKYCAdhaarRearPhoto)) {

								memberKYCAdhaarRearPhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							} else if (fileMappingType.contains(ServiceConstants.memberKYCElectionFrontPhoto)) {

								memberKYCElectionFrontPhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							} else if (fileMappingType.contains(ServiceConstants.memberKYCElectionRearPhoto)) {

								memberKYCElectionRearPhotoDocId.put(fileMappingType,
										documentDetailsEntityAfterSave.getDocumentId());
							} else if (fileMappingType.contains(ServiceConstants.shgProfilePhoto)) {

								shgProfilePhotoDocId.put(ServiceConstants.shgProfilePhoto,
										documentDetailsEntityAfterSave.getDocumentId());
							}
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}

				// Images End
				if (shgProfilePhotoDocId != null && shgProfilePhotoDocId.size() > 0) {
					ShgProfileEntityAfterSave
							.setProfileDocumentId(shgProfilePhotoDocId.get(ServiceConstants.shgProfilePhoto));
				}

				if ((SHGProfile.getShg_id() != null || ShgProfileEntity != null))
					shgProfileDao.save(ShgProfileEntityAfterSave);
				else
					ShgProfileEntityAfterSave = shgProfileDao.saveAndFlush(ShgProfileEntityAfterSave);

				cboCode = ShgProfileEntityAfterSave.getShgId();

				// SAVE ADDRESSES

				List<CboAddressesDetailsEntity> cboAddressesDetailsEntityList = new ArrayList<CboAddressesDetailsEntity>();
				if (SHGProfile.getCboAddressesList() != null && SHGProfile.getCboAddressesList().size() > 0) {
					for (CBOAddresses cboAddressTemp : SHGProfile.getCboAddressesList()) {
						CboAddressesDetailsEntity cboAddressesDetailsEntity = null;
						if (cboAddressTemp.getCbo_address_id() != null) {
							cboAddressesDetailsEntity = cboAddressesDetailsDao
									.findOne(cboAddressTemp.getCbo_address_id());
						}  if (cboAddressTemp.getAddress_guid() != null) {
							cboAddressesDetailsEntity = cboAddressesDetailsDao.fetchByGUID(
									cboAddressTemp.getAddress_guid(), Boolean.TRUE, LookUpMasterEntity.shgLookupVal);
							if (cboAddressesDetailsEntity != null) {
								cboAddressTemp.setCbo_address_id(cboAddressesDetailsEntity.getCboAddressId());
							}
						}

						cboAddressTemp.setCbo_id(cboCode);
						cboAddressTemp.setCreated_by(SHGProfile.getCreated_by());
						if (SHGProfile.getUpdated_by() != null)
							cboAddressTemp.setUpdated_by(SHGProfile.getUpdated_by());
						cboAddressesDetailsEntity = GroupMapper.map(cboAddressTemp);
						cboAddressesDetailsEntityList.add(cboAddressesDetailsEntity);
					}
				}
				cboAddressesDetailsDao.save(cboAddressesDetailsEntityList);

				// SAVE PHONE NOs
				if (SHGProfile.getCboPhoneNoDetailsList() != null && SHGProfile.getCboPhoneNoDetailsList().size() > 0) {
					List<CboPhoneNoDetailsEntity> cboPhoneNoDetailsEntityList = new ArrayList<CboPhoneNoDetailsEntity>();
					for (CBOPhoneNoDetails cboPhoneNoTemp : SHGProfile.getCboPhoneNoDetailsList()) {
						CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity = null;
						if (cboPhoneNoTemp.getCbo_phone_id() != null) {
							cboPhoneNoDetailsEntity = cboPhoneNoDetailsDao.findOne(cboPhoneNoTemp.getCbo_phone_id());
						}  if (cboPhoneNoTemp.getPhone_guid() != null) {
							cboPhoneNoDetailsEntity = cboPhoneNoDetailsDao.fetchByGUID(cboPhoneNoTemp.getPhone_guid(),
									Boolean.TRUE, LookUpMasterEntity.shgLookupVal);
							if (cboPhoneNoDetailsEntity != null) {
								cboPhoneNoTemp.setCbo_phone_id(cboPhoneNoDetailsEntity.getCboPhoneId());
							}
						}

						cboPhoneNoTemp.setCbo_id(cboCode);
						cboPhoneNoTemp.setCreated_by(SHGProfile.getCreated_by());
						if (SHGProfile.getUpdated_by() != null)
							cboPhoneNoTemp.setUpdated_by(SHGProfile.getUpdated_by());
						cboPhoneNoDetailsEntity = GroupMapper.map(cboPhoneNoTemp);
						cboPhoneNoDetailsEntityList.add(cboPhoneNoDetailsEntity);
					}

					cboPhoneNoDetailsDao.save(cboPhoneNoDetailsEntityList);
				}

				// SAVE BANK DETAILS
				if (SHGProfile.getCboBankDetailsList() != null && SHGProfile.getCboBankDetailsList().size() > 0) {
					List<CboBankDetailsEntity> cboBankDetailsEntityList = new ArrayList<CboBankDetailsEntity>();
					for (CBOBankDetails cboBankDetailsTemp : SHGProfile.getCboBankDetailsList()) {
						CboBankDetailsEntity cboBankDetailsEntity = null;
						BigInteger bankDocId = null;
						if (cboBankDetailsTemp.getCbo_bank_id() != null) {
							cboBankDetailsEntity = cboBankDetailsDao.findOne(cboBankDetailsTemp.getCbo_bank_id());
						}  if (cboBankDetailsTemp.getBank_guid() != null) {
							cboBankDetailsEntity = cboBankDetailsDao.fetchByGUID(cboBankDetailsTemp.getBank_guid(),
									Boolean.TRUE, LookUpMasterEntity.shgLookupVal);
							if (cboBankDetailsEntity != null) {
								cboBankDetailsTemp.setCbo_bank_id(cboBankDetailsEntity.getCboBankId());
								bankDocId = cboBankDetailsEntity.getBankDocumentId();
							}
						}

						cboBankDetailsTemp.setCbo_id(cboCode);
						cboBankDetailsTemp.setCreated_by(SHGProfile.getCreated_by());
						if (SHGProfile.getUpdated_by() != null)
							cboBankDetailsTemp.setUpdated_by(SHGProfile.getUpdated_by());
						cboBankDetailsEntity = GroupMapper.map(cboBankDetailsTemp);
						cboBankDetailsEntity.setBankDocumentId(bankDocId);
						// shg bank image
						if (shgPhotoDocId != null && shgPhotoDocId.size() > 0) {
							for (Map<String, BigInteger> shgPhotoDocIdTemp : shgPhotoDocId) {
								for (String keys : shgPhotoDocIdTemp.keySet()) {
									if (keys.equals(cboBankDetailsEntity.getBankGuid())) {
										cboBankDetailsEntity.setBankDocumentId(shgPhotoDocIdTemp.get(keys));
									}
								}
							}
						}
						cboBankDetailsEntityList.add(cboBankDetailsEntity);
					}
					cboBankDetailsDao.save(cboBankDetailsEntityList);
				}



				// SAVE KYC DETAILS

				if (SHGProfile.getCboKYCDetails() != null) {
					CboKYCDetails cboKYCDetails = SHGProfile.getCboKYCDetails();
					List<CboKYCDetailsEntity> cboKYCDetailsEntityList = new ArrayList<CboKYCDetailsEntity>();
					cboKYCDetails.setCbo_id(cboCode);
					cboKYCDetails.setCreated_by(SHGProfile.getCreated_by());
					if (SHGProfile.getUpdated_by() != null)
						cboKYCDetails.setUpdated_by(SHGProfile.getUpdated_by());
					CboKYCDetailsEntity cboKYCDetailsEntity = GroupMapper.map(cboKYCDetails);
					cboKYCDetailsEntityList.add(cboKYCDetailsEntity);

					cboKYCDetailsDao.save(cboKYCDetailsEntityList);
				}

				// SAVE SYSTEM TAGS
				List<SystemTagsEntity> systemTagsEntityList = new ArrayList<SystemTagsEntity>();
				if (SHGProfile.getCboSystemTagsList() != null && SHGProfile.getCboSystemTagsList().size() > 0) {
					for (SystemTags systemTagsTemp : SHGProfile.getCboSystemTagsList()) {
						SystemTagsEntity systemTagsEntity = null;
						if (systemTagsTemp.getSystemtags_id() != null) {
							systemTagsEntity = systemTagsDao.findOne(systemTagsTemp.getSystemtags_id());
						}  if (systemTagsTemp.getSystem_tag_guid() != null) {
							systemTagsEntity = systemTagsDao.fetchByGUID(systemTagsTemp.getSystem_tag_guid(),
									Boolean.TRUE);
							if (systemTagsEntity != null) {
								systemTagsTemp.setSystemtags_id(systemTagsEntity.getSystemTagsId());
							}
						}
						systemTagsTemp.setCbo_code(cboCode);
						systemTagsTemp.setCreated_by(SHGProfile.getCreated_by());
						if (SHGProfile.getUpdated_by() != null)
							systemTagsTemp.setUpdated_by(SHGProfile.getUpdated_by());
						systemTagsEntity = GroupMapper.map(systemTagsTemp);
						systemTagsEntityList.add(systemTagsEntity);
					}
					systemTagsDao.save(systemTagsEntityList);
				}


				// add by mohit start
				// SAVE shg designation
				List<SHGDesignationEntity> shgDesignationEntityList = new ArrayList<SHGDesignationEntity>();
				if (SHGProfile.getShgDesignationList() != null && SHGProfile.getShgDesignationList().size() > 0) {
					for (SHGDesignation shgDesignationTemp : SHGProfile.getShgDesignationList()) {
						SHGDesignationEntity shgDesignationEntity = null;
						if (shgDesignationTemp.getMember_designation_id() != null) {
							shgDesignationEntity = shgDesignationDao
									.findOne(shgDesignationTemp.getMember_designation_id());
						}  if (shgDesignationTemp.getMember_designation_guid() != null) {
							shgDesignationEntity = shgDesignationDao
									.fetchByGUID(shgDesignationTemp.getMember_designation_guid(), Boolean.TRUE);
							if (shgDesignationEntity != null) {
								shgDesignationTemp
										.setMember_designation_id(shgDesignationEntity.getMemberDesignationId());
							}
						}
						shgDesignationTemp.setCbo_code(cboCode);
						shgDesignationTemp.setCreated_by(SHGProfile.getCreated_by());
						if (SHGProfile.getUpdated_by() != null)
							shgDesignationTemp.setUpdated_by(SHGProfile.getUpdated_by());
						shgDesignationEntity = GroupMapper.map(shgDesignationTemp);
						shgDesignationEntityList.add(shgDesignationEntity);
					}
					shgDesignationDao.save(shgDesignationEntityList);
				}

				// add by mohit end

				// save member details
				if (SHGProfile.getMemberProfileList() != null && SHGProfile.getMemberProfileList().size() > 0) {
					for (MemberProfile memberProfile : SHGProfile.getMemberProfileList()) {
						memberProfile.setCreated_by(SHGProfile.getCreated_by());
						memberProfile.setCbo_id(cboCode);
						// memberProfile.setUpdated_by(SHGProfile.getUpdated_by());

						String memberSeqNo = "";
						BigInteger memberProfilePhotoDocIdInternal = new BigInteger("0");
						;
						if (memberProfilePhotoDocId != null && memberProfilePhotoDocId.size()>0) {
							if (memberProfile.getSeq_no() != null)
								memberSeqNo = memberProfile.getSeq_no().toString().trim();

							for (String keys : memberProfilePhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberProfilePhoto, "");
								if (member.equals(memberSeqNo)) {
									memberProfilePhotoDocIdInternal = memberProfilePhotoDocId.get(keys);
								}
							}
						}

						BigInteger memberConsentFormPhotoDocIdInternal = new BigInteger("0");
						if (memberConsentFormPhotoDocId != null && memberConsentFormPhotoDocId.size()>0) {
							/*
							 * if (memberProfile.getSeq_no() != null) memberSeqNo =
							 * memberProfile.getSeq_no().toString().trim();
							 */
							for (String keys : memberConsentFormPhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberConsentForm, "");
								if (member.equals(memberSeqNo)) {
									memberConsentFormPhotoDocIdInternal = memberConsentFormPhotoDocId.get(keys);
								}
							}
						}

						BigInteger memberBankPassbookPhotoDocIdInternal = new BigInteger("0");
						/*
						 * if(memberBankPassbookPhotoDocId!=null){ for(String keys :
						 * memberBankPassbookPhotoDocId.keySet()) { String member =
						 * keys.replaceAll(ServiceConstants.memberBankPassbookPhoto,"");
						 * if(member.equals(memberSeqNo)){
						 * memberBankPassbookPhotoDocIdInternal=BigInteger.valueOf(
						 * memberBankPassbookPhotoDocId.get(keys).intValue());
						 *
						 * } } }
						 */
						BigInteger memberKYCAdhaarFrontPhotoDocIdInternal = new BigInteger("0");
						;

						if (memberKYCAdhaarFrontPhotoDocId != null && memberKYCAdhaarFrontPhotoDocId.size()>0) {
							for (String keys : memberKYCAdhaarFrontPhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberKYCAdhaarFrontPhoto, "");

								if (member.trim().equals(memberSeqNo.toString().trim())) {
									memberKYCAdhaarFrontPhotoDocIdInternal = BigInteger
											.valueOf(memberKYCAdhaarFrontPhotoDocId.get(keys).intValue());
								}
							}
						}
						BigInteger memberKYCAdhaarRearPhotoDocIdInternal = new BigInteger("0");
						;
						if (memberKYCAdhaarRearPhotoDocId != null && memberKYCAdhaarRearPhotoDocId.size()>0) {
							for (String keys : memberKYCAdhaarRearPhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberKYCAdhaarRearPhoto, "");
								if (member.equals(memberSeqNo)) {
									memberKYCAdhaarRearPhotoDocIdInternal = memberKYCAdhaarRearPhotoDocId.get(keys);
								}
							}
						}
						BigInteger memberKYCElectionFrontPhotoDocIdInternal = new BigInteger("0");
						;
						if (memberKYCElectionFrontPhotoDocId != null && memberKYCElectionFrontPhotoDocId.size()>0) {
							for (String keys : memberKYCElectionFrontPhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberKYCElectionFrontPhoto, "");
								if (member.equals(memberSeqNo)) {
									memberKYCElectionFrontPhotoDocIdInternal = memberKYCElectionFrontPhotoDocId
											.get(keys);
								}
							}
						}

						BigInteger memberKYCElectionRearPhotoDocIdInternal = new BigInteger("0");
						;
						if (memberKYCElectionRearPhotoDocId != null && memberKYCElectionRearPhotoDocId.size()>0) {
							for (String keys : memberKYCElectionRearPhotoDocId.keySet()) {
								String member = keys.replaceAll(ServiceConstants.memberKYCElectionRearPhoto, "");
								if (member.equals(memberSeqNo)) {
									memberKYCElectionRearPhotoDocIdInternal = memberKYCElectionRearPhotoDocId.get(keys);
								}
							}
						}

						createMembers(memberProfile, memberProfilePhotoDocIdInternal,memberConsentFormPhotoDocIdInternal, memberBankPassbookPhotoDocId,
								memberKYCAdhaarFrontPhotoDocIdInternal, memberKYCAdhaarRearPhotoDocIdInternal,
								memberKYCElectionFrontPhotoDocIdInternal, memberKYCElectionRearPhotoDocIdInternal);
						// this.commandGateway.process(new CreateMemberProfileCommand(memberProfile));
					}

				}

				shgProfileDao.updateReadFlag(cboCode, Boolean.TRUE);
			} else {
				returnString = "error";
			}
		} catch (Exception e) {
			String transactionId="unknown";
			if (SHGProfile.getTransaction_id() != null && !SHGProfile.getTransaction_id().equals("")) {
				transactionId = SHGProfile.getTransaction_id();
			}

			TransactionStatusEntity transactionStatusEntity = insertIntoTransaction
					(SHGProfile.getTransaction_id(),SHGProfile.getProcessingId(),
							SHGProfile.getUploaded_by(),role);
			transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
			transactionStatusEntity.setRemarks(e.getMessage());
			saveTransactionStatus(transactionStatusEntity);
			returnString="failure";
			e.printStackTrace();
		}
		return returnString;
	}

	// MEMBER
	@Transactional
	public String createMembers(MemberProfile memberProfile, BigInteger memberProfilePhotoDocId,BigInteger memberConsentFormPhotoDocId,
										 List<Map<String, BigInteger>> memberBankPassbookPhotoDocId, BigInteger memberKYCAdhaarFrontPhotoDocId,
										 BigInteger memberKYCAdhaarRearPhotoDocId, BigInteger memberKYCElectionFrontPhotoDocId,
										 BigInteger memberKYCElectionRearPhotoDocId) {
		// final MemberProfile memberProfile =
		// createMemberProfileCommand.memberProfile();
		String returnString = "Success";

		try {
			BigInteger memberId = null;
			MemberProfileEntity memberProfileEntity = null;
			BigInteger memberid = new BigInteger("0");
			BigInteger memberDocId = null;
			BigInteger memberConsentDocId = null;
			if (memberProfile.getMember_id() != null) {
				if (memberProfile.getMember_id().equals(memberid))
					memberProfile.setMember_id(null);
			}
			if (memberProfile.getMember_guid() != null) {
				memberProfileEntity = memberProfileDao.fetchByGUID(memberProfile.getMember_guid(), Boolean.TRUE);
				if (memberProfileEntity != null) {
					memberProfile.setMember_id(memberProfileEntity.getMemberId());
					memberDocId = memberProfileEntity.getMemberProfileDocumentId();
					memberConsentDocId = memberProfileEntity.getConsentFormId();
				}
			}
			MemberProfileEntity memberProfileEntityAfterSave = MemberMapper.map(memberProfile);
			memberProfileEntityAfterSave.setMemberProfileDocumentId(memberDocId);
			memberProfileEntityAfterSave.setConsentFormId(memberConsentDocId);
			if (memberProfilePhotoDocId != null && !memberProfilePhotoDocId.equals(BigInteger.ZERO)) {
				memberProfileEntityAfterSave.setMemberProfileDocumentId(memberProfilePhotoDocId);
			}
			if (memberConsentFormPhotoDocId != null && !memberConsentFormPhotoDocId.equals(BigInteger.ZERO)) {
				memberProfileEntityAfterSave.setConsentFormId(memberConsentFormPhotoDocId);
			}
			if (memberProfile.getMember_id() != null || memberProfileEntity != null)
				memberProfileDao.save(memberProfileEntityAfterSave);
			else
				memberProfileEntityAfterSave = memberProfileDao.saveAndFlush(memberProfileEntityAfterSave);

			memberId = memberProfileEntityAfterSave.getMemberId();

			// SAVE ADDRESSES
			// SWATI STARTS
			List<MemberAddressesDetailsEntity> memberAddressesDetailsEntityList = new ArrayList<MemberAddressesDetailsEntity>();
			if (memberProfile.getMemberAddressesList() != null && memberProfile.getMemberAddressesList().size() > 0) {
				for (MemberAddresses memberAddressesTemp : memberProfile.getMemberAddressesList()) {
					MemberAddressesDetailsEntity memberAddressesDetailsEntity = null;
					if (memberAddressesTemp.getMember_address_id() != null) {
						memberAddressesDetailsEntity = memberAddressesDetailsDao
								.findOne(memberAddressesTemp.getMember_address_id());
					}  if (memberAddressesTemp.getAddress_guid() != null) {
						memberAddressesDetailsEntity = memberAddressesDetailsDao
								.fetchByGUID(memberAddressesTemp.getAddress_guid(), Boolean.TRUE);
						if (memberAddressesDetailsEntity != null) {
							memberAddressesTemp.setMember_address_id(memberAddressesDetailsEntity.getMemberAddressId());
						}
					}

					memberAddressesTemp.setMember_code(memberId);
					memberAddressesTemp.setCbo_id(memberProfile.getCbo_id());
					memberAddressesTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberAddressesTemp.setUpdated_by(memberProfile.getUpdated_by());
					memberAddressesDetailsEntity = MemberMapper.map(memberAddressesTemp);
					memberAddressesDetailsEntityList.add(memberAddressesDetailsEntity);
				}
			}
			memberAddressesDetailsDao.save(memberAddressesDetailsEntityList);


			List<CadreShgMembersEntity> cadreShgMembersEntityList = new ArrayList<CadreShgMembersEntity>();
			if (memberProfile.getCadreShgMembersModeslList() != null && memberProfile.getCadreShgMembersModeslList().size() > 0) {
				for (CadreShgMembersModel memberCadreShgTemp : memberProfile.getCadreShgMembersModeslList()) {
					CadreShgMembersEntity cadreShgMembersEntity = null;
					if (memberCadreShgTemp.getUid() != null) {
						cadreShgMembersEntity = cadreShgMembersDao
								.findOne(memberCadreShgTemp.getUid());
					}  if (memberCadreShgTemp.getCadre_guid() != null) {
						cadreShgMembersEntity = cadreShgMembersDao
								.fetchByGUID(memberCadreShgTemp.getCadre_guid());
						if (cadreShgMembersEntity != null) {
							memberCadreShgTemp.setUid(cadreShgMembersEntity.getUid());
						}
					}

					memberCadreShgTemp.setMember_id(memberId);
					memberCadreShgTemp.setCbo_id(memberProfile.getCbo_id());
					memberCadreShgTemp.setMember_guid(memberProfile.getMember_guid());
					memberCadreShgTemp.setCreated_by(memberProfile.getCreated_by());
					memberCadreShgTemp.setUploaded_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberCadreShgTemp.setUpdated_by(memberProfile.getUpdated_by());
					cadreShgMembersEntity = MemberMapper.map(memberCadreShgTemp);
					cadreShgMembersEntityList.add(cadreShgMembersEntity);
				}
			}
			cadreShgMembersDao.save(cadreShgMembersEntityList);


			/*
			 * List<CadreNonMembersEntity> cadreNonMembersEntityList = new
			 * ArrayList<CadreNonMembersEntity>(); if
			 * (memberProfile.getCadreNonMembersModeslList() != null &&
			 * memberProfile.getCadreNonMembersModeslList().size() > 0) { for
			 * (CadreNonMembersModel cadreNonMembersModelTemp :
			 * memberProfile.getCadreNonMembersModeslList()) { CadreNonMembersEntity
			 * cadreNonMembersEntity = null; if (cadreNonMembersModelTemp.getUid() != null)
			 * { cadreNonMembersEntity = cadreNonMemberDao
			 * .findOne(cadreNonMembersModelTemp.getUid()); } else if
			 * (cadreNonMembersModelTemp.getUid() != null) { cadreNonMembersEntity =
			 * cadreNonMemberDao .fetchByGUID(cadreNonMembersModelTemp.getCadre_guid()); if
			 * (cadreNonMembersEntity != null) {
			 * cadreNonMembersModelTemp.setUid(cadreNonMembersEntity.getUid()); } }
			 *
			 * cadreNonMembersModelTemp.setUid(memberId);
			 * //cadreNonMembersModelTemp.set(memberProfile.getCbo_id());
			 * cadreNonMembersModelTemp.setCreatedBy(memberProfile.getCreated_by()); if
			 * (memberProfile.getUpdated_by() != null)
			 * cadreNonMembersModelTemp.setUpdatedBy(memberProfile.getUpdated_by());
			 * cadreNonMembersEntity = MemberMapper.map(cadreNonMembersModelTemp);
			 * cadreNonMembersEntityList.add(cadreNonMembersEntity); } }
			 * cadreNonMemberDao.save(cadreNonMembersEntityList);
			 */
			//
			// PHONE NO
			List<MemberPhoneNoDetailsEntity> memberPhoneNoDetailsEntityList = new ArrayList<MemberPhoneNoDetailsEntity>();
			if (memberProfile.getMemberPhoneNoDetailsList() != null
					&& memberProfile.getMemberPhoneNoDetailsList().size() > 0) {
				for (MemberPhoneNoDetails memberPhoneNoDetailsTemp : memberProfile.getMemberPhoneNoDetailsList()) {
					MemberPhoneNoDetailsEntity memberPhoneNoDetailsEntity = null;
					if (memberPhoneNoDetailsTemp.getMember_phone_details_id() != null) {
						memberPhoneNoDetailsEntity = memberPhoneNoDetailsDao
								.findOne(memberPhoneNoDetailsTemp.getMember_phone_details_id());
					} if (memberPhoneNoDetailsTemp.getPhone_guid() != null) {
						memberPhoneNoDetailsEntity = memberPhoneNoDetailsDao
								.fetchByGUID(memberPhoneNoDetailsTemp.getPhone_guid(), Boolean.TRUE);
						if (memberPhoneNoDetailsEntity != null) {
							memberPhoneNoDetailsTemp
									.setMember_phone_details_id(memberPhoneNoDetailsEntity.getMemberPhoneDetailsId());
						}
					}

					memberPhoneNoDetailsTemp.setMember_code(memberId);
					memberPhoneNoDetailsTemp.setCbo_id(memberProfile.getCbo_id());
					memberPhoneNoDetailsTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberPhoneNoDetailsTemp.setUpdated_by(memberProfile.getUpdated_by());
					memberPhoneNoDetailsEntity = MemberMapper.map(memberPhoneNoDetailsTemp);
					memberPhoneNoDetailsEntityList.add(memberPhoneNoDetailsEntity);
				}
			}
			memberPhoneNoDetailsDao.save(memberPhoneNoDetailsEntityList);

			// BANK DETAILS
			List<MemberBankDetailsEntity> memberBankDetailsEntityList = new ArrayList<MemberBankDetailsEntity>();
			if (memberProfile.getMemberBankList() != null && memberProfile.getMemberBankList().size() > 0) {
				for (MemberBank memberBankTemp : memberProfile.getMemberBankList()) {
					MemberBankDetailsEntity memberBankDetailsEntity = null;
					BigInteger memberBankDocId = null;
					if (memberBankTemp.getMember_bank_details_id() != null) {
						memberBankDetailsEntity = memberBankDetailsDao
								.findOne(memberBankTemp.getMember_bank_details_id());
					}  if (memberBankTemp.getBank_guid() != null) {
						memberBankDetailsEntity = memberBankDetailsDao.fetchByGUID(memberBankTemp.getBank_guid(),
								Boolean.TRUE);
						if (memberBankDetailsEntity != null) {
							memberBankTemp.setMember_bank_details_id(memberBankDetailsEntity.getMemberBankDetailsId());
							memberBankDocId = memberBankDetailsEntity.getMemberBankDocumentId();
						}
					}

					memberBankTemp.setMember_code(memberId);
					memberBankTemp.setCbo_id(memberProfile.getCbo_id());
					memberBankTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberBankTemp.setUpdated_by(memberProfile.getUpdated_by());
					memberBankDetailsEntity = MemberMapper.map(memberBankTemp);
					memberBankDetailsEntity.setMemberBankDocumentId(memberBankDocId);
					// member bank image
					if (memberBankPassbookPhotoDocId != null && memberBankPassbookPhotoDocId.size() > 0) {
						for (Map<String, BigInteger> memberBankPassbookPhotoDocIdTemp : memberBankPassbookPhotoDocId) {
							for (String keys : memberBankPassbookPhotoDocIdTemp.keySet()) {
								if (keys.equals(memberBankDetailsEntity.getBankGUID())) {
									memberBankDetailsEntity
											.setMemberBankDocumentId(memberBankPassbookPhotoDocIdTemp.get(keys));
								}
							}
						}
					}
					memberBankDetailsEntityList.add(memberBankDetailsEntity);
				}
			}
			memberBankDetailsDao.save(memberBankDetailsEntityList);

			// SYSTEM TAGS
			List<MemberSystemTagsEntity> memberSystemTagsEntityList = new ArrayList<MemberSystemTagsEntity>();
			if (memberProfile.getMemberSystemTagsList() != null && memberProfile.getMemberSystemTagsList().size() > 0) {
				for (MemberSystemTags memberSystemTagsTemp : memberProfile.getMemberSystemTagsList()) {
					MemberSystemTagsEntity memberSystemTagsEntity = null;
					if (memberSystemTagsTemp.getSystemtags_id() != null) {
						memberSystemTagsEntity = memberSystemTagsDao.findOne(memberSystemTagsTemp.getSystemtags_id());
					}  if (memberSystemTagsTemp.getSystem_tag_guid() != null) {
						memberSystemTagsEntity = memberSystemTagsDao
								.fetchByGUID(memberSystemTagsTemp.getSystem_tag_guid(), Boolean.TRUE);
						if (memberSystemTagsEntity != null) {
							memberSystemTagsTemp.setSystemtags_id(memberSystemTagsEntity.getSystemTagsId());
						}
					}

					memberSystemTagsTemp.setMember_code(memberId);
					memberSystemTagsTemp.setCbo_id(memberProfile.getCbo_id());
					memberSystemTagsTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberSystemTagsTemp.setUpdated_by(memberProfile.getUpdated_by());
					memberSystemTagsEntity = MemberMapper.map(memberSystemTagsTemp);
					memberSystemTagsEntityList.add(memberSystemTagsEntity);
				}
			}
			memberSystemTagsDao.save(memberSystemTagsEntityList);

			//Member Insurance
			List<MemberInsuranceEntity> memberInsuranceEntityList = new ArrayList<MemberInsuranceEntity>();
			if (memberProfile.getMemberInsuranceList() != null && memberProfile.getMemberInsuranceList().size() > 0) {
				for (MemberInsurance memberInsuranceTemp : memberProfile.getMemberInsuranceList()) {
					MemberInsuranceEntity memberInsuranceEntity = null;
					if (memberInsuranceTemp.getInsurance_id() != null) {
						memberInsuranceEntity = memberInsuranceDao.
								findOne(memberInsuranceTemp.getInsurance_id());
					} else if (memberInsuranceTemp.getInsurance_type() != null) {
						memberInsuranceEntity = memberInsuranceDao.
								fetchByMemberCodeAndInsuranceType(memberInsuranceTemp.getInsurance_type(),memberInsuranceTemp.getMember_code());
						if (memberInsuranceEntity != null) {
							memberInsuranceTemp.setInsurance_id(memberInsuranceEntity
									.getInsuranceId());
						}
					}

					memberInsuranceTemp.setMember_code(memberId);
					memberInsuranceTemp.setCbo_id(memberProfile.getCbo_id());
					memberInsuranceTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberInsuranceTemp.setUpdated_by(memberProfile.getUpdated_by());
					memberInsuranceEntity = MemberMapper.map(memberInsuranceTemp);
					memberInsuranceEntityList.add(memberInsuranceEntity);
				}
			}
			memberInsuranceDao.save(memberInsuranceEntityList);


			// SAVE KYC DETAILS
			List<MemberKYCDetailsEntity> memberKYCDetailsEntityList = new ArrayList<MemberKYCDetailsEntity>();
			if (memberProfile.getMemberKYCDetailsList() != null && memberProfile.getMemberKYCDetailsList().size() > 0) {
				for (MemberKYCDetails memberKYCDetailsTemp : memberProfile.getMemberKYCDetailsList()) {
					MemberKYCDetailsEntity memberKYCDetailsEntity = null;
					BigInteger kycFrontDocId=null;
					BigInteger kycRearDocId=null;
					if (memberKYCDetailsTemp.getMember_kyc_details_id() != null) {
						memberKYCDetailsEntity = memberKYCDetailsDao
								.findOne(memberKYCDetailsTemp.getMember_kyc_details_id());
					}  if (memberKYCDetailsTemp.getKyc_guid() != null) {
						memberKYCDetailsEntity = memberKYCDetailsDao.fetchByGUID(memberKYCDetailsTemp.getKyc_guid(),
								Boolean.TRUE);
						if (memberKYCDetailsEntity != null) {
							memberKYCDetailsTemp
									.setMember_kyc_details_id(memberKYCDetailsEntity.getMemberKycDetailsId());
							kycFrontDocId=memberKYCDetailsEntity.getKycFrontDocId();
							kycRearDocId=memberKYCDetailsEntity.getKycRearDocId();
						}
					}

					memberKYCDetailsTemp.setMember_code(memberId);
					memberKYCDetailsTemp.setCbo_id(memberProfile.getCbo_id());
					memberKYCDetailsTemp.setCreated_by(memberProfile.getCreated_by());
					if (memberProfile.getUpdated_by() != null)
						memberKYCDetailsTemp.setUpdated_by(memberProfile.getUpdated_by());

					memberKYCDetailsEntity = MemberMapper.map(memberKYCDetailsTemp);
					memberKYCDetailsEntity.setKycFrontDocId(kycFrontDocId);
					memberKYCDetailsEntity.setKycRearDocId(kycRearDocId);
					if (memberKYCDetailsTemp.getKyc_type().equals(MemberKYCDetailsEntity.kycAdhaar)) {

						if (memberKYCAdhaarFrontPhotoDocId != null && !memberKYCAdhaarFrontPhotoDocId.equals(BigInteger.ZERO)) {
							memberKYCDetailsEntity.setKycFrontDocId(memberKYCAdhaarFrontPhotoDocId);
						}
						if (memberKYCAdhaarRearPhotoDocId != null && !memberKYCAdhaarRearPhotoDocId.equals(BigInteger.ZERO)) {
							memberKYCDetailsEntity.setKycRearDocId(memberKYCAdhaarRearPhotoDocId);
						}
						//decrypt then encrypt with other logic
						if(memberKYCDetailsEntity.getKycNumber()!=null
								&& !memberKYCDetailsEntity.getKycNumber().isEmpty()
								&& !memberKYCDetailsEntity.getKycNumber().equals("-") ){
							String encAadhaarNo = decryptEncryptAadhaar(memberKYCDetailsEntity.getKycNumber(),
									memberKYCDetailsEntity.getMemberGUID());
							memberKYCDetailsEntity.setEnc_aadhar_no(encAadhaarNo);
						}
					}
					if (memberKYCDetailsTemp.getKyc_type().equals(MemberKYCDetailsEntity.kycElectionId)) {
						if (memberKYCElectionFrontPhotoDocId != null && !memberKYCElectionFrontPhotoDocId.equals(BigInteger.ZERO)) {
							memberKYCDetailsEntity.setKycFrontDocId(memberKYCElectionFrontPhotoDocId);
						}
						if (memberKYCElectionRearPhotoDocId != null && !memberKYCElectionRearPhotoDocId.equals(BigInteger.ZERO)) {
							memberKYCDetailsEntity.setKycRearDocId(memberKYCElectionRearPhotoDocId);
						}
					}
					memberKYCDetailsEntityList.add(memberKYCDetailsEntity);
				}
			}
			memberKYCDetailsDao.save(memberKYCDetailsEntityList);
			// SWATI ENDS

			memberProfileDao.updateReadFlag(memberId, Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Success";

	}



	// CREATE FEDERATION PROFILE
	@Transactional
	public String createUpdateFederationProfile(String role, FederationProfile federationProfile, List<MultipartFile> uploadFiles) {
		String returnString = "Success";
		try {
			BigInteger cboCode = null;
			FederationProfileEntity federationProfileEntity = null;
			BigInteger federationid = new BigInteger("0");

			// validation start

			Boolean dataToBeInserted = Boolean.TRUE;
			String transactionId = federationProfile.getTransaction_id();
			BigInteger processingId = federationProfile.getProcessingId();
			UsersRoleRightsMapEntity userRoleRightsMapEntity = usersRoleRightsMapDao
					.findByUserId(federationProfile.getUploaded_by(),role);
			if (!userRoleRightsMapEntity.getStateId().equals(federationProfile.getState_id())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,new BigInteger("0"),
							federationProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("State Does Not Match with Mapped State of User");
					saveTransactionStatus(transactionStatusEntity);
				}
			}
			if (!userRoleRightsMapEntity.getDistrictId().equals(federationProfile.getDistrict_id().toString())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							federationProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("District Does Not Match with Mapped District of User");
					saveTransactionStatus(transactionStatusEntity);
				}
			}
			if (!userRoleRightsMapEntity.getBlockId().equals(federationProfile.getBlock_id().toString())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							federationProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Block Does Not Match with Mapped Block of User");
					saveTransactionStatus(transactionStatusEntity);
				}
			}
			if (federationProfile.getCbo_type().equals(1) && federationProfile.getPanchayat_id() == null) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							federationProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Panchayat not null for VO");
					saveTransactionStatus(transactionStatusEntity);
				}
			}

			/*
			 * if(federationProfile.getPanchayat_id()!=null &&
			 * userRoleRightsMapEntity.getPanchayatId()!=null &&
			 * !userRoleRightsMapEntity.getPanchayatId().equals(federationProfile.
			 * getPanchayat_id().toString())) { dataToBeInserted=Boolean.FALSE;
			 * if(transactionId!=null && !transactionId.equals("")){ TransactionStatusEntity
			 * transactionStatusEntity =
			 * insertIntoTransaction(transactionId,federationProfile.getUploaded_by());
			 * transactionStatusEntity.setStatus(TransactionStatusEntity.failure );
			 * transactionStatusEntity.
			 * setRemarks("Panchayat Does Not Match with Mapped Panchayat of User");
			 * saveTransactionStatus(transactionStatusEntity); } }
			 */

			if (federationProfile.getPanchayat_id() != null && userRoleRightsMapEntity.getPanchayatId() != null
					&& !userRoleRightsMapEntity.getPanchayatId().isEmpty()) {
				List<String> panchayatIds = new ArrayList<String>();

				if (!userRoleRightsMapEntity.getPanchayatId().contains(",")) {
					panchayatIds.add(userRoleRightsMapEntity.getPanchayatId());
				} else {
					panchayatIds = Stream.of(userRoleRightsMapEntity.getPanchayatId().split(",")).map(String::trim)
							.collect(Collectors.toList());
				}

				if (!panchayatIds.contains(federationProfile.getPanchayat_id().toString())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								federationProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Panchayat Does Match with Mapped Village of User");
						saveTransactionStatus(transactionStatusEntity);
					}
				}
			}

			if (federationProfile.getVillage_id() != null && userRoleRightsMapEntity.getVillageId() != null
					&& !userRoleRightsMapEntity.getVillageId().isEmpty()) {
				List<String> villageIds = new ArrayList<String>();

				if (!userRoleRightsMapEntity.getVillageId().contains(",")) {
					villageIds.add(userRoleRightsMapEntity.getVillageId());
				} else {
					villageIds = Stream.of(userRoleRightsMapEntity.getVillageId().split(",")).map(String::trim)
							.collect(Collectors.toList());
				}

				if (!villageIds.contains(federationProfile.getVillage_id().toString())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								federationProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Village Does Match with Mapped Village of User");
						saveTransactionStatus(transactionStatusEntity);
					}
				}
			}
			if (!federationProfile.getUser_id().equals(federationProfile.getUploaded_by())) {
				dataToBeInserted = Boolean.FALSE;
				if (transactionId != null && !transactionId.equals("")) {
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
							federationProfile.getUploaded_by(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
					saveTransactionStatus(transactionStatusEntity);
				}
			}

			if (federationProfile.getFederation_id() != null
					&& !federationProfile.getFederation_id().equals(federationid)) {
				federationProfileEntity = federationProfileDao.findOne(federationProfile.getFederation_id());
				if (!federationProfile.getUser_id().equals(federationProfileEntity.getUserId())) {
					dataToBeInserted = Boolean.FALSE;
					if (transactionId != null && !transactionId.equals("")) {
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
								federationProfile.getUploaded_by(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
						saveTransactionStatus(transactionStatusEntity);
					}
				}
			}
			if (federationProfile.getGuid() != null) {
				federationProfileEntity = federationProfileDao.fetchByGUID(federationProfile.getGuid(), Boolean.TRUE);
				if (federationProfileEntity != null) {
					if (!federationProfile.getUser_id().equals(federationProfileEntity.getUserId())) {
						dataToBeInserted = Boolean.FALSE;
						if (transactionId != null && !transactionId.equals("")) {
							TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,processingId,
									federationProfile.getUploaded_by(),role);
							transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
							transactionStatusEntity.setRemarks("User Id Does Not matched with the Uploaded User");
							saveTransactionStatus(transactionStatusEntity);
						}
					}
				}
			}

			// validation end

			if (dataToBeInserted.equals(Boolean.TRUE)) {
				BigInteger profileDocId = null;
				if (federationProfile.getFederation_id() != null
						&& federationProfile.getFederation_id().equals(federationid))
					federationProfile.setFederation_id(null);
				if (federationProfile.getGuid() != null) {
					federationProfileEntity = federationProfileDao.fetchByGUID(federationProfile.getGuid(),
							Boolean.TRUE);
					if (federationProfileEntity != null) {
						federationProfile.setFederation_id(federationProfileEntity.getFederationId());
						federationProfile.setParent_cbo_code(federationProfileEntity.getParentCboId());
						profileDocId = federationProfileEntity.getFederationProfileDocId();
					}
				}
				FederationProfileEntity federationProfileEntityAfterSave = GroupMapper.mapFederation(federationProfile);
				federationProfileEntityAfterSave.setFederationProfileDocId(profileDocId);
				// Images Starts
				List<Map<String, BigInteger>> cboBankPhotoDocId = new ArrayList<>();
				List<Map<String, BigInteger>> cboKYCPhotoDocId = new ArrayList<>();
				Map<String, BigInteger> cboKYCTANNoPhotoDocId = new HashMap<String, BigInteger>();
				Map<String, BigInteger> federationProfilePhotoDocId = new HashMap<>();

				if (uploadFiles != null) {
					for (MultipartFile uploadFile : uploadFiles) {
						try {
							String fileName = uploadFile.getOriginalFilename();

							String[] parts = fileName.split(",");
							String part2 = parts[1];
							String fileMappingTypeWithExtension = part2;
							String part1 = parts[0];

							String[] partsAgain = fileMappingTypeWithExtension.split(".");
							String fileMappingType = fileMappingTypeWithExtension.replaceAll(".jpg", "")
									.replaceAll(".png", "").replaceAll(".pdf", "");
							String path = "miscellaneous";
							String modifiedName = cboCode + "_";
							// PATH of file
							if (fileMappingType.equals(ServiceConstants.cboBankPhoto)) {
								path = ServiceConstants.cboBankPhoto;
								modifiedName = ServiceConstants.cboBankPhoto;
							} else if (fileMappingType.contains(ServiceConstants.cboKYCRegNoPhoto)) {

								path = ServiceConstants.cboKYCRegNoPhoto;
								modifiedName = ServiceConstants.cboKYCRegNoPhoto;
							} else if (fileMappingType.contains(ServiceConstants.cboKYCTANNoPhoto)) {
								path = ServiceConstants.cboKYCTANNoPhoto;
								modifiedName = ServiceConstants.cboKYCTANNoPhoto;
							} else if (fileMappingType.contains(ServiceConstants.cboKYCPANNoPhoto)) {
								path = ServiceConstants.cboKYCPANNoPhoto;
								modifiedName = ServiceConstants.cboKYCPANNoPhoto;
							} else if (fileMappingType.contains(ServiceConstants.federationoProfilePhoto)) {
								path = ServiceConstants.federationoProfilePhoto;
								modifiedName = ServiceConstants.federationoProfilePhoto;
							}

							modifiedName += "_" + new Timestamp(System.currentTimeMillis()) + "."
									+ FilenameUtils.getExtension(uploadFile.getOriginalFilename());


							// FILE MODIFIED NAME

							Path copyLocationFrontDoc = Paths.get(uploadDir + File.separator + "uploadFiles"
									+ File.separator + path + File.separator + StringUtils.cleanPath(modifiedName));
							Files.copy(uploadFile.getInputStream(), copyLocationFrontDoc,
									StandardCopyOption.REPLACE_EXISTING);
							DocumentDetails documentDetails = new DocumentDetails();
							documentDetails.setFront_doc_original_name(uploadFile.getOriginalFilename());
							documentDetails.setFront_doc_modified_name(StringUtils.cleanPath(modifiedName));
							documentDetails.setDoc_path("uploadFiles" + File.separator + path);
							documentDetails.setCreated_by(federationProfile.getCreated_by());
							DocumentDetailsEntity documentDetailsEntity = GroupMapper.map(documentDetails);
							DocumentDetailsEntity documentDetailsEntityAfterSave = documentDetailsDao
									.saveAndFlush(documentDetailsEntity);
							// new code
							if (fileMappingType.equals(ServiceConstants.cboBankPhoto)) {
								Map<String, BigInteger> cboBankPhotoDocIdTemp = new HashMap<>();
								cboBankPhotoDocIdTemp.put(part1, documentDetailsEntityAfterSave.getDocumentId());
								cboBankPhotoDocId.add(cboBankPhotoDocIdTemp);

							}

							else if (fileMappingType.contains(ServiceConstants.cboKYCRegNoPhoto)) {
								Map<String, BigInteger> cboKYCRegNoPhotoDocIdTemp = new HashMap<>();
								cboKYCRegNoPhotoDocIdTemp.put(ServiceConstants.cboKYCRegNoPhoto,
										documentDetailsEntityAfterSave.getDocumentId());
								cboKYCPhotoDocId.add(cboKYCRegNoPhotoDocIdTemp);

							} else if (fileMappingType.contains(ServiceConstants.cboKYCTANNoPhoto)) {
								Map<String, BigInteger> cboKYCTANNoPhotoDocIdTemp = new HashMap<>();
								cboKYCTANNoPhotoDocIdTemp.put(ServiceConstants.cboKYCTANNoPhoto,
										documentDetailsEntityAfterSave.getDocumentId());
								cboKYCPhotoDocId.add(cboKYCTANNoPhotoDocIdTemp);
							} else if (fileMappingType.contains(ServiceConstants.cboKYCPANNoPhoto)) {
								Map<String, BigInteger> cboKYCPANNoPhotoDocIdTemp = new HashMap<>();
								cboKYCPANNoPhotoDocIdTemp.put(ServiceConstants.cboKYCPANNoPhoto,
										documentDetailsEntityAfterSave.getDocumentId());
								cboKYCPhotoDocId.add(cboKYCPANNoPhotoDocIdTemp);

							} else if (fileMappingType.contains(ServiceConstants.federationoProfilePhoto)) {
								federationProfilePhotoDocId.put(ServiceConstants.federationoProfilePhoto,
										documentDetailsEntityAfterSave.getDocumentId());
								//federationProfilePhotoDocId.add()

							}
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}

				// Images End
				if (federationProfilePhotoDocId != null && federationProfilePhotoDocId.size()>0) {
					federationProfileEntityAfterSave.setFederationProfileDocId(
							federationProfilePhotoDocId.get(ServiceConstants.federationoProfilePhoto));
				}

				if ((federationProfile.getFederation_id() != null || federationProfileEntity != null))
					federationProfileDao.save(federationProfileEntityAfterSave);
				else
					federationProfileEntityAfterSave = federationProfileDao
							.saveAndFlush(federationProfileEntityAfterSave);

				cboCode = federationProfileEntityAfterSave.getFederationId();

				// SAVE ADDRESSES

				List<CboAddressesDetailsEntity> cboAddressesDetailsEntityList = new ArrayList<CboAddressesDetailsEntity>();
				if (federationProfile.getCboAddressesList() != null
						&& federationProfile.getCboAddressesList().size() > 0) {
					for (CBOAddresses cboAddressTemp : federationProfile.getCboAddressesList()) {
						CboAddressesDetailsEntity cboAddressesDetailsEntity = null;
						if (cboAddressTemp.getCbo_address_id() != null) {
							cboAddressesDetailsEntity = cboAddressesDetailsDao
									.findOne(cboAddressTemp.getCbo_address_id());
						}  if (cboAddressTemp.getAddress_guid() != null) {
							cboAddressesDetailsEntity = cboAddressesDetailsDao.fetchByGUID(
									cboAddressTemp.getAddress_guid(), Boolean.TRUE, federationProfile.getCbo_type());
							if (cboAddressesDetailsEntity != null) {
								cboAddressTemp.setCbo_address_id(cboAddressesDetailsEntity.getCboAddressId());
							}
						}

						cboAddressTemp.setCbo_id(cboCode);
						cboAddressTemp.setCreated_by(federationProfile.getCreated_by());
						if (federationProfile.getUpdated_by() != null)
							cboAddressTemp.setUpdated_by(federationProfile.getUpdated_by());
						cboAddressesDetailsEntity = GroupMapper.map(cboAddressTemp);
						cboAddressesDetailsEntityList.add(cboAddressesDetailsEntity);
					}
				}
				cboAddressesDetailsDao.save(cboAddressesDetailsEntityList);

				// SAVE PHONE NOs
				if (federationProfile.getCboPhoneNoDetailsList() != null
						&& federationProfile.getCboPhoneNoDetailsList().size() > 0) {
					List<CboPhoneNoDetailsEntity> cboPhoneNoDetailsEntityList = new ArrayList<CboPhoneNoDetailsEntity>();
					for (CBOPhoneNoDetails cboPhoneNoTemp : federationProfile.getCboPhoneNoDetailsList()) {
						CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity = null;
						if (cboPhoneNoTemp.getCbo_phone_id() != null) {
							cboPhoneNoDetailsEntity = cboPhoneNoDetailsDao.findOne(cboPhoneNoTemp.getCbo_phone_id());
						}  if (cboPhoneNoTemp.getPhone_guid() != null) {
							cboPhoneNoDetailsEntity = cboPhoneNoDetailsDao.fetchByGUID(cboPhoneNoTemp.getPhone_guid(),
									Boolean.TRUE, federationProfile.getCbo_type());
							if (cboPhoneNoDetailsEntity != null) {
								cboPhoneNoTemp.setCbo_phone_id(cboPhoneNoDetailsEntity.getCboPhoneId());
							}
						}

						cboPhoneNoTemp.setCbo_id(cboCode);
						cboPhoneNoTemp.setCreated_by(federationProfile.getCreated_by());
						if (federationProfile.getUpdated_by() != null)
							cboPhoneNoTemp.setUpdated_by(federationProfile.getUpdated_by());
						cboPhoneNoDetailsEntity = GroupMapper.map(cboPhoneNoTemp);
						cboPhoneNoDetailsEntityList.add(cboPhoneNoDetailsEntity);
					}

					cboPhoneNoDetailsDao.save(cboPhoneNoDetailsEntityList);
				}

				// SAVE BANK DETAILS
				if (federationProfile.getCboBankDetailsList() != null
						&& federationProfile.getCboBankDetailsList().size() > 0) {
					List<CboBankDetailsEntity> cboBankDetailsEntityList = new ArrayList<CboBankDetailsEntity>();
					for (CBOBankDetails cboBankDetailsTemp : federationProfile.getCboBankDetailsList()) {
						CboBankDetailsEntity cboBankDetailsEntity = null;
						BigInteger cboBankDocId = null;
						if (cboBankDetailsTemp.getCbo_bank_id() != null) {
							cboBankDetailsEntity = cboBankDetailsDao.findOne(cboBankDetailsTemp.getCbo_bank_id());
						}  if (cboBankDetailsTemp.getBank_guid() != null) {
							cboBankDetailsEntity = cboBankDetailsDao.fetchByGUID(cboBankDetailsTemp.getBank_guid(),
									Boolean.TRUE, federationProfile.getCbo_type());
							if (cboBankDetailsEntity != null) {
								cboBankDetailsTemp.setCbo_bank_id(cboBankDetailsEntity.getCboBankId());
								cboBankDocId = cboBankDetailsEntity.getBankDocumentId();
							}
						}

						cboBankDetailsTemp.setCbo_id(cboCode);
						cboBankDetailsTemp.setCreated_by(federationProfile.getCreated_by());
						if (federationProfile.getUpdated_by() != null)
							cboBankDetailsTemp.setUpdated_by(federationProfile.getUpdated_by());
						cboBankDetailsEntity = GroupMapper.map(cboBankDetailsTemp);
						cboBankDetailsEntity.setBankDocumentId(cboBankDocId);
						// cbo bank image
						if (cboBankPhotoDocId != null && cboBankPhotoDocId.size() > 0) {
							for (Map<String, BigInteger> cboBankPhotoDocIdTemp : cboBankPhotoDocId) {
								for (String keys : cboBankPhotoDocIdTemp.keySet()) {
									if (keys.equals(cboBankDetailsEntity.getBankGuid())) {
										cboBankDetailsEntity.setBankDocumentId(cboBankPhotoDocIdTemp.get(keys));
									}
								}
							}
						}
						cboBankDetailsEntityList.add(cboBankDetailsEntity);
					}

					cboBankDetailsDao.save(cboBankDetailsEntityList);
				}


				// SAVE KYC DETAILS
				if (federationProfile.getCboKYCDetailsList() != null
						&& federationProfile.getCboKYCDetailsList().size() > 0) {
					List<CboKYCDetailsEntity> cboKYCDetailsEntityList = new ArrayList<CboKYCDetailsEntity>();
					for (CboKYCDetails cboKYCDetails : federationProfile.getCboKYCDetailsList()) {

						CboKYCDetailsEntity cboKYCDetailsEntity = null;
						BigInteger cboKYCDocId = null;
						if (cboKYCDetails.getCbo_kyc_details_id() != null) {
							cboKYCDetailsEntity = cboKYCDetailsDao.findOne(cboKYCDetails.getCbo_kyc_details_id());
						}  if (cboKYCDetails.getKyc_guid() != null) {
							cboKYCDetailsEntity = cboKYCDetailsDao.fetchByGUID(cboKYCDetails.getKyc_guid(),
									Boolean.TRUE, federationProfile.getCbo_type());
							if (cboKYCDetailsEntity != null) {
								cboKYCDetails.setCbo_kyc_details_id(cboKYCDetailsEntity.getCboKYCDetailsId());
								cboKYCDocId = cboKYCDetailsEntity.getDocumentId();
							}
						}

						cboKYCDetails.setCbo_id(cboCode);

						cboKYCDetails.setCreated_by(federationProfile.getCreated_by());
						if (federationProfile.getUpdated_by() != null)
							cboKYCDetails.setUpdated_by(federationProfile.getUpdated_by());
						cboKYCDetailsEntity = GroupMapper.map(cboKYCDetails);
						cboKYCDetailsEntity.setDocumentId(cboKYCDocId);
						if (cboKYCPhotoDocId != null && cboKYCPhotoDocId.size() > 0) {
							if (cboKYCDetails.getKyc_type().equals(CboKYCDetailsEntity.kycRegistrationNo)) {
								for (Map<String, BigInteger> cboKYCPhotoDocIdTemp : cboKYCPhotoDocId) {
									for (String keys : cboKYCPhotoDocIdTemp.keySet()) {
										if (keys.equals(ServiceConstants.cboKYCRegNoPhoto)) {
											cboKYCDetailsEntity.setDocumentId(cboKYCPhotoDocIdTemp.get(keys));
										}
									}
								}
							}
							if (cboKYCDetails.getKyc_type().equals(CboKYCDetailsEntity.kycTANNo)) {
								for (Map<String, BigInteger> cboKYCPhotoDocIdTemp : cboKYCPhotoDocId) {
									for (String keys : cboKYCPhotoDocIdTemp.keySet()) {
										if (keys.equals(ServiceConstants.cboKYCTANNoPhoto)) {
											cboKYCDetailsEntity.setDocumentId(cboKYCPhotoDocIdTemp.get(keys));
										}
									}
								}
							}
							if (cboKYCDetails.getKyc_type().equals(CboKYCDetailsEntity.kycPANNo)) {
								for (Map<String, BigInteger> cboKYCPhotoDocIdTemp : cboKYCPhotoDocId) {
									for (String keys : cboKYCPhotoDocIdTemp.keySet()) {
										if (keys.equals(ServiceConstants.cboKYCPANNoPhoto)) {
											cboKYCDetailsEntity.setDocumentId(cboKYCPhotoDocIdTemp.get(keys));
										}
									}
								}
							}

						}
						cboKYCDetailsEntityList.add(cboKYCDetailsEntity);
					}
					cboKYCDetailsDao.save(cboKYCDetailsEntityList);
				}
			} else {
				returnString = "error";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			returnString = "error";

		}
		return returnString;
	}

	@Transactional
	public TransactionStatusEntity insertIntoTransaction(String transactionId,BigInteger processingId, String userId, String role) {
		TransactionStatusEntity transactionStatusEntity1 = new TransactionStatusEntity();
		if(transactionId!=null && !transactionId.isEmpty()) {
			transactionStatusEntity1=transactionStatusDao.fetchByTransactionId(transactionId);
		}else {
			transactionStatusEntity1=transactionStatusDao.fetchByProcessingId(processingId);
		}


		if(transactionStatusEntity1==null){
			TransactionStatusEntity transactionStatusEntity = new TransactionStatusEntity();
			transactionStatusEntity.setTransactionId(transactionId);
			transactionStatusEntity.setUserId(userId);
			transactionStatusEntity.setReadFlag(Boolean.FALSE);
			transactionStatusEntity.setProcessingId(processingId);
			transactionStatusEntity.setRole(role);
			return transactionStatusEntity;
		}
		transactionStatusEntity1.setUserId(userId);
		transactionStatusEntity1.setReadFlag(Boolean.FALSE);
		transactionStatusEntity1.setProcessingId(processingId);
		transactionStatusEntity1.setRole(role);
		return transactionStatusEntity1;
	}

	@Transactional
	public void saveTransactionStatus(TransactionStatusEntity transactionStatusEntity) {
		transactionStatusDao.saveAndFlush(transactionStatusEntity);
	}

	// Meeting

	@Transactional(transactionManager = "tenantTransactionManager",rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public String createMeetingProfileUpload(String role, UploadShgMeeting uploadShgMeeting) throws Exception{
		String returnString = "Success";

		Boolean dataToBeInserted=Boolean.TRUE;
		try {
			//TEST STARTS
			// shg meeting

			/*  System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

			TestEntity testEntity = new TestEntity();
			testEntity.setTest("cbwjhdcjwehcjwkh");
			testDao.save(testEntity);
						throw new Exception();*/


			//TEST ENDS

			ShgMtg shgMeeting = uploadShgMeeting.getShgMeeting();
			Integer shgActivated = shgProfileDao.getActiveShg(new BigInteger(shgMeeting.getCboId().toString()), Boolean.TRUE);
			if(shgActivated.equals(0)) {
				dataToBeInserted=Boolean.FALSE;
				returnString = "Shg doesnot exists or not activated";
				TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
						,uploadShgMeeting.getProcessingId(),
						uploadShgMeeting.getUserId(),role);
				transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
				transactionStatusEntity.setRemarks("Shg doesnot exists or not activated");
				if(uploadShgMeeting.getTransactionId()!=null) {
					transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
				}
				else
					transactionStatusEntity.setTransactionId("unknown");
				transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
				saveTransactionStatus(transactionStatusEntity);
				throw new Exception();
			}
			ShgMtgEntity shgMtgEntityValidation = shgMtgDao.getLastMeetingByCboId(shgMeeting.getCboId());
			//VALIDATION ON MEETING NO
			Boolean deleteFlag=Boolean.FALSE;
			BigInteger lastMtgUid=new BigInteger("0");
			if (shgMtgEntityValidation!=null) {
				lastMtgUid=shgMtgEntityValidation.getUid();
			}

			Integer meetingNoExists = shgMtgDao.countByMeetingNo(shgMeeting.getMtgNo(),shgMeeting.getCboId());
			if(meetingNoExists>0) {
				if(shgMtgEntityValidation.getMtgNo().equals(shgMeeting.getMtgNo())) {
					deleteFlag=Boolean.TRUE;
					//deleteMeeting(shgMtgEntityValidation.getUid());
					if(shgMeeting.getMtgNo()==1) {
						shgMtgEntityValidation=null;
					}else {
						shgMtgEntityValidation = shgMtgDao.getPreviousMtg(shgMeeting.getMtgNo()-1, shgMeeting.getCboId());
						if(shgMtgEntityValidation!=null && shgMtgEntityValidation.getApprovalStatus()==3) {
							dataToBeInserted=Boolean.FALSE;
							returnString = "Please delete rejected Meeting";
							TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
									,uploadShgMeeting.getProcessingId(),
									uploadShgMeeting.getUserId(),role);
							transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
							transactionStatusEntity.setRemarks("Meeting No Already Exists");
							if(uploadShgMeeting.getTransactionId()!=null) {
								transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
							}
							else
								transactionStatusEntity.setTransactionId("unknown");
							transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
							saveTransactionStatus(transactionStatusEntity);
							throw new Exception();
						}
					}
				}
				else {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Already Exists";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
							,uploadShgMeeting.getProcessingId(),
							uploadShgMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Already Exists");
					if(uploadShgMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}
			//MEETING NO SHOULD BE NEXT TO MAX MEETING NO
			if(shgMeeting.getMtgType()==ShgMtgEntity.zeroMeeting) {
				ShgMtgEntity shgMtgEntityPrv = shgMtgDao.getPreviousMtg(shgMeeting.getMtgNo()-1, shgMeeting.getCboId());
				if(shgMeeting.getMtgNo()>1 && (shgMtgEntityPrv==null)) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Sequence not correct";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
							,uploadShgMeeting.getProcessingId(),
							uploadShgMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Sequence not correct");
					if(uploadShgMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}else {
				ShgMtgEntity shgMtgLast = shgMtgDao.getLastMeetingByCboId(shgMeeting.getCboId());
				Integer mtgDiff = 12;
				if(shgMtgLast!=null) {
					mtgDiff = shgMtgLast.getMtgNo()+12;
				}
				if(!deleteFlag && shgMeeting.getMtgNo()<mtgDiff) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Sequence not correct for cutoff";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
							,uploadShgMeeting.getProcessingId(),
							uploadShgMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Sequence not correct for cutoff");
					if(uploadShgMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}

			//VALIDATION ON OPENING CLOSING BALANCE

			if(shgMtgEntityValidation!=null) {
				//cutoff meeting check
				Boolean normalMtg=Boolean.TRUE;
				if(shgMeeting.getMtgType()==ShgMtgEntity.cutOffMeeting1 || shgMeeting.getMtgType()==ShgMtgEntity.cutOffMeeting2) {
					normalMtg=Boolean.FALSE;
				}
				if(normalMtg && shgMtgEntityValidation.getClosingBalance()!=null && shgMeeting.getOpeningBalance()!=null &&
						!shgMtgEntityValidation.getClosingBalance().equals(shgMeeting.getOpeningBalance())) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Opening Balance doesnot match with Closing balance of last meeting";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
							,uploadShgMeeting.getProcessingId(),
							uploadShgMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Opening Balance doesnot match with Closing balance of last meeting");
					if(uploadShgMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);
					throw new Exception();
				}

				//VALIDATION ON OPENING CLOSING BALANCE CASH
				if(normalMtg && shgMtgEntityValidation.getClosingBalanceCash()!=null && shgMeeting.getOpeningBalanceCash()!=null &&
						!shgMtgEntityValidation.getClosingBalanceCash().equals(shgMeeting.getOpeningBalanceCash())) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Opening Balance Cash doesnot match with Closing balance Cash of last meeting";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
							,uploadShgMeeting.getProcessingId(),
							uploadShgMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Opening Balance Cash doesnot match with Closing balance Cash of last meeting");
					if(uploadShgMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);
					throw new Exception();
				}

			}

			if(deleteFlag) {
				deleteMeeting(lastMtgUid);
			}

			// shg meeting
			ShgMtgEntity mtg = new ShgMtgEntity();
			if(dataToBeInserted.equals(Boolean.TRUE)) {
				ShgMtgEntity shgMtgEntity = MeetingMapper.map(shgMeeting);
				shgMtgEntity.setReadFlag(Boolean.FALSE);
				mtg =  shgMtgDao.save(shgMtgEntity);

			}

			// shg Finance Transation Voucher @anshul
			List<ShgFinTxnVouchers> shgFintxnVouchersList = shgMeeting.getShgFinanceTransactionVouchersList();
			if (shgFintxnVouchersList != null && shgFintxnVouchersList.size() > 0) {
				for (ShgFinTxnVouchers shgFinTxnVouchers : shgFintxnVouchersList) {
					ShgFinTxnVouchersEntity shgFinTxnVouchersEntity = MeetingMapper.map(shgFinTxnVouchers);
					shgFinTxnVouchersEntity.setCboId(mtg.getCboId());
					shgFinTxnVouchersEntity.setShgMtgUid(mtg.getUid());
					shgFinTxnVouchersEntity.setMtgNo(mtg.getMtgNo());
					shgFinTxnVouchersDao.save(shgFinTxnVouchersEntity);
				}
			}

			// shg meeting details
			List<ShgMtgDet> shgMeetingDetailsList = shgMeeting.getShgMeetingDetailsList();
			if(shgMeetingDetailsList!=null && shgMeetingDetailsList.size()>0) {
				for (ShgMtgDet shgMtgDet : shgMeetingDetailsList) {
					BigInteger memberId = new BigInteger(shgMtgDet.getMemId().toString());
					Integer memberActivated = memberProfileDao.getAcivatedMember(memberId, Boolean.TRUE);
					if(memberActivated.equals(0)) {
						dataToBeInserted=Boolean.FALSE;
						returnString = "Member doesnot exists or not activated";
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadShgMeeting.getTransactionId()
								,uploadShgMeeting.getProcessingId(),
								uploadShgMeeting.getUserId(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Member doesnot exists or not activated");
						if(uploadShgMeeting.getTransactionId()!=null) {
							transactionStatusEntity.setTransactionId(uploadShgMeeting.getTransactionId());
						}
						else
							transactionStatusEntity.setTransactionId("unknown");
						transactionStatusEntity.setUserId(uploadShgMeeting.getUserId());
						saveTransactionStatus(transactionStatusEntity);
						throw new Exception();
					}
					if(dataToBeInserted.equals(Boolean.TRUE)) {
						ShgMtgDetEntity shgMtgDetEntity = MeetingMapper.map(shgMtgDet);
						shgMtgDetEntity.setCboId(mtg.getCboId());
						shgMtgDetEntity.setShgMtgUid(mtg.getUid());
						shgMtgDetEntity.setMtgGuid(mtg.getMtgGuid());
						shgMtgDetEntity.setMtgNo(mtg.getMtgNo());
						shgMtgDetEntity.setMtgDate1(mtg.getMtgDate1());
						ShgMtgDetEntity shgMtgDetEntityAfterSave = shgMtgDetDao.save(shgMtgDetEntity);

						// shg member loan transaction
						List<ShgMemLoanTxn> shgMemLoanTxnList = shgMtgDet.getShgMemberLoanTransactionList();
						if (shgMemLoanTxnList != null && shgMemLoanTxnList.size() > 0) {
							for (ShgMemLoanTxn shgMemLoanTxn : shgMemLoanTxnList) {
								ShgMemLoanTxnEntity shgMemLoanTxnEntity = MeetingMapper.map(shgMemLoanTxn);
								shgMemLoanTxnEntity.setCboId(shgMeeting.getCboId());
								shgMemLoanTxnEntity.setShgMtgDetUid(shgMtgDetEntityAfterSave.getUid());
								shgMemLoanTxnEntity.setShgMtgUid(mtg.getUid());
								shgMemLoanTxnEntity.setMemId(shgMtgDetEntityAfterSave.getMemId());
								shgMemLoanTxnEntity.setMtgGuid(mtg.getMtgGuid());
								shgMemLoanTxnEntity.setMtgNo(mtg.getMtgNo());
								shgMemLoanTxnEntity.setMtgDate1(shgMtgDetEntityAfterSave.getMtgDate1());
								shgMemLoanTxnDao.save(shgMemLoanTxnEntity);
							}
						}

						// shg member settlement @mohit
						List<ShgMemSettlement> shgMemSettlementList = shgMtgDet.getShgMemberSettlementList();
						if (shgMemSettlementList != null && shgMemSettlementList.size() > 0) {
							for (ShgMemSettlement shgMemSettlement : shgMemSettlementList) {
								ShgMemSettlementEntity shgMemSettlementEntity = MeetingMapper.map(shgMemSettlement);
								shgMemSettlementEntity.setCboId(shgMeeting.getCboId());
								shgMemSettlementEntity.setShgMtgDetUid(shgMtgDetEntityAfterSave.getUid());
								shgMemSettlementEntity.setShgMtgUid(mtg.getUid());
								shgMemSettlementEntity.setMemId(shgMtgDetEntityAfterSave.getMemId());
								shgMemSettlementEntity.setMtgGuid(mtg.getMtgGuid());
								shgMemSettlementEntity.setMtgNo(mtg.getMtgNo());
								shgMemSettlementEntity.setMtgDate1(shgMtgDetEntityAfterSave.getMtgDate1());
								shgMemSettlementDao.save(shgMemSettlementEntity);
							}
						}



						// shg financial transaction detail member
						List<ShgFinTxnDetMem> shgFinTxnDetMemList = shgMtgDet.getShgFinanceTransactionDetailMemberList();
						if (shgFinTxnDetMemList != null && shgFinTxnDetMemList.size() > 0) {
							for (ShgFinTxnDetMem shgFinTxnDetMem : shgFinTxnDetMemList) {
								ShgFinTxnDetMemEntity shgFinTxnDetMemEntity = MeetingMapper.map(shgFinTxnDetMem);
								shgFinTxnDetMemEntity.setCboId(mtg.getCboId());
								shgFinTxnDetMemEntity.setShgMtgDetUid(shgMtgDetEntityAfterSave.getUid());
								shgFinTxnDetMemEntity.setMtgGuid(mtg.getMtgGuid());
								shgFinTxnDetMemEntity.setShgMtgUid(mtg.getUid());
								shgFinTxnDetMemEntity.setMemId(shgMtgDetEntityAfterSave.getMemId());
								shgFinTxnDetMemEntity.setMtgNo(mtg.getMtgNo());
								shgFinTxnDetMemDao.save(shgFinTxnDetMemEntity);
							}
						}


					}
				}
			}
			if(dataToBeInserted.equals(Boolean.TRUE)) {
				// shg financial transaction

				List<ShgFinTxn> shgFinxnList = shgMeeting.getShgFinanceTransactionList();
				if (shgFinxnList != null && shgFinxnList.size() > 0) {
					for (ShgFinTxn shgFinxn : shgFinxnList) {
						ShgFinTxnEntity shgFinTxnEntity = MeetingMapper.map(shgFinxn);
						shgFinTxnEntity.setCboId(mtg.getCboId());
						shgFinTxnEntity.setShgMtgUid(mtg.getUid());
						shgFinTxnEntity.setMtgNo(mtg.getMtgNo());
						shgFinTxnEntity.setMtgGuid(mtg.getMtgGuid());
						shgFinTxnDao.save(shgFinTxnEntity);
					}
				}

				// shg financial transaction group
				List<ShgFinTxnDetGrp> shgFinTxnDetGrpList = shgMeeting.getShgFinanceTransactionDetailGroupList();
				if (shgFinTxnDetGrpList != null && shgFinTxnDetGrpList.size() > 0) {
					for (ShgFinTxnDetGrp shgFinTxnDetGrp : shgFinTxnDetGrpList) {
						ShgFinTxnDetGrpEntity shgFinTxnDetGrpEntity = MeetingMapper.map(shgFinTxnDetGrp);
						shgFinTxnDetGrpEntity.setCboId(mtg.getCboId());
						shgFinTxnDetGrpEntity.setLinkGuid(shgFinTxnDetGrp.getLinkGuid());
						shgFinTxnDetGrpEntity.setShgMtgUid(mtg.getUid());
						shgFinTxnDetGrpEntity.setMtgNo(mtg.getMtgNo());
						shgFinTxnDetGrpEntity.setMtgGuid(mtg.getMtgGuid());
						shgFinTxnDetGrpDao.save(shgFinTxnDetGrpEntity);
					}
				}
				// shg group loan transaction
				List<ShgGroupLoanTxn> shgGroupLoanTxnList = shgMeeting.getShgGroupLoanTransactionList();
				if (shgGroupLoanTxnList != null && shgGroupLoanTxnList.size() > 0) {
					for (ShgGroupLoanTxn shgGroupLoanTxn : shgGroupLoanTxnList) {
						ShgGroupLoanTxnEntity shgGroupLoanTxnEntity = MeetingMapper.map(shgGroupLoanTxn);
						shgGroupLoanTxnEntity.setCboId(shgMeeting.getCboId());
						shgGroupLoanTxnEntity.setShgMtgUid(mtg.getUid());
						shgGroupLoanTxnEntity.setMtgGuid(mtg.getMtgGuid());
						shgGroupLoanTxnEntity.setMtgNo(mtg.getMtgNo());
						shgGroupLoanTxnEntity.setMtgDate1(mtg.getMtgDate1());
						shgGroupLoanTxnDao.save(shgGroupLoanTxnEntity);
					}
				}


				// shg mcp
				List<ShgMcp> shgMcpList = uploadShgMeeting.getShgMcpList();
				if (shgMcpList != null && shgMcpList.size()>0) {
					for(ShgMcp shgMcp : shgMcpList) {
						ShgMcpEntity shgMcpEntity = MeetingMapper.map(shgMcp);
						shgMcpEntity.setShgMtgUid(mtg.getUid());
						shgMcpDao.save(shgMcpEntity);
					}

				}

				// shg loan application
				List<ShgLoanApplication> shgLoanApplicationList = uploadShgMeeting.getShgLoanApplicationList();
				if (shgLoanApplicationList != null && shgLoanApplicationList.size() > 0) {
					for (ShgLoanApplication shgLoanApplication : shgLoanApplicationList) {
						ShgLoanApplicationEntity shgLoanApplicationEntity = MeetingMapper.map(shgLoanApplication);
						shgLoanApplicationEntity.setCboId(shgMeeting.getCboId());
						shgLoanApplicationEntity.setShgMtgUid(mtg.getUid());
						shgLoanApplicationDao.save(shgLoanApplicationEntity);
					}
				}

				// shg group loan
				//BigInteger zeroBigInteger = new BigInteger("0");
				List<ShgGroupLoan> shgGroupLoanList = uploadShgMeeting.getShgGroupLoanList();
				if (shgGroupLoanList != null && shgGroupLoanList.size() > 0) {
					for (ShgGroupLoan shgGroupLoan : shgGroupLoanList) {
						//	if(shgGroupLoan.getLoanApplicationId().equals(zeroBigInteger)) {
						//	shgGroupLoan.setLoanApplicationId(null);
						//	} cbo_id +loan_no
						ShgGroupLoanEntity shgGroupLoanEntity1 = shgGroupLoanDao.
								findLoanByCboIdLoanNo(mtg.getCboId(),shgGroupLoan.getLoanNo(),shgGroupLoan.getInstallmentNo());
						ShgGroupLoanEntity shgGroupLoanEntity = MeetingMapper.map(shgGroupLoan);
						if(shgGroupLoanEntity1 !=null) {
							shgGroupLoanEntity.setUid(shgGroupLoanEntity1.getUid());
							shgGroupLoanEntity.setCboId(mtg.getCboId());

						}else {
							shgGroupLoanEntity.setCboId(mtg.getCboId());
						}
						if(shgGroupLoanEntity.getMtgNo().equals(mtg.getMtgNo())) {
							shgGroupLoanEntity.setShgMtgUid(mtg.getUid());
						}else if(shgGroupLoanEntity.getMtgNo()>mtg.getMtgNo()) {
							shgGroupLoanEntity.setShgMtgUid(null);
						}else if(shgGroupLoanEntity.getMtgNo()<mtg.getMtgNo()) {
							ShgMtgEntity shgMtgEntity = shgMtgDao.getPreviousMtg(shgGroupLoanEntity.getMtgNo(), shgGroupLoanEntity.getCboId());
							if(shgMtgEntity!=null) {
								shgGroupLoanEntity.setShgMtgUid(shgMtgEntity.getUid());
							}
						}
						ShgGroupLoanEntity shgGroupLoanEntityAfterSave = shgGroupLoanDao.save(shgGroupLoanEntity);
						// shg group loan schedule cbo_id+loan_no+inst no+ sub inst no
						// add two field in upload   check in db
						List<ShgGroupLoanSchedule> shgGroupLoanScheduleList = shgGroupLoan.getShgGroupLoanScheduleList();
						if (shgGroupLoanScheduleList != null && shgGroupLoanScheduleList.size() > 0) {
							for (ShgGroupLoanSchedule shgGroupLoanSchedule : shgGroupLoanScheduleList) {
								ShgGroupLoanScheduleEntity shgGroupLoanScheduleEntity = MeetingMapper.map(shgGroupLoanSchedule);
								ShgGroupLoanScheduleEntity shgGroupLoanScheduleEntity1 = shgGroupLoanScheduleDao.
										findByParam(mtg.getCboId(), shgGroupLoanSchedule.getLoanNo(),
												shgGroupLoanSchedule.getInstallmentNo(),shgGroupLoanSchedule.getSubInstallmentNo(),shgGroupLoanSchedule.getOrgInstallmentNo(),shgGroupLoanSchedule.getStatus());
								if(shgGroupLoanScheduleEntity1!=null) {
									shgGroupLoanScheduleEntity.setUid(shgGroupLoanScheduleEntity1.getUid());
									shgGroupLoanScheduleEntity.setShgGroupLoanUid
											(shgGroupLoanScheduleEntity1.getShgGroupLoanUid());
									shgGroupLoanScheduleEntity.setShgMtgUid(shgGroupLoanScheduleEntity1.getShgMtgUid());
								}else {
									shgGroupLoanScheduleEntity.setUid(null);
									shgGroupLoanScheduleEntity.setShgGroupLoanUid
											(shgGroupLoanEntityAfterSave.getUid());
									shgGroupLoanScheduleEntity.setShgMtgUid(mtg.getUid());
								}
								shgGroupLoanScheduleEntity.setCboId(mtg.getCboId());

								/*
								 * shgGroupLoanScheduleEntity.setMtgGuid(mtg.getMtgGuid());
								 * shgGroupLoanScheduleEntity.setMtgNo(mtg.getMtgNo());
								 */
								shgGroupLoanScheduleDao.save(shgGroupLoanScheduleEntity);
							}
						}

					}
				}

				// shg member loan
				List<ShgMemLoan> shgMemberLoanList = uploadShgMeeting.getShgMemberLoanList();
				if (shgMemberLoanList != null && shgMemberLoanList.size() > 0) {
					for (ShgMemLoan shgMemLoan : shgMemberLoanList) {

						//if(shgMemLoan.getLoanApplicationId().equals(zeroBigInteger)) {
						//	shgMemLoan.setLoanApplicationId(null);
						//	}
						ShgMemLoanEntity shgMemLoanEntity1 = shgMemLoanDao.
								findLoanByCboIdLoanNo(mtg.getCboId(),shgMemLoan.getLoanNo());
						ShgMemLoanEntity shgMemLoanEntity = MeetingMapper.map(shgMemLoan);
						if(shgMemLoanEntity1 !=null) {
							shgMemLoanEntity.setUid(shgMemLoanEntity1.getUid());
							shgMemLoanEntity.setCboId(mtg.getCboId());
						}else {
							shgMemLoanEntity.setCboId(mtg.getCboId());
						}
						if(shgMemLoanEntity.getMtgNo().equals(mtg.getMtgNo())) {
							shgMemLoanEntity.setShgMtgUid(mtg.getUid());
						}else if(shgMemLoanEntity.getMtgNo()>mtg.getMtgNo()) {
							shgMemLoanEntity.setShgMtgUid(null);
						}else if(shgMemLoanEntity.getMtgNo()<mtg.getMtgNo()) {
							ShgMtgEntity shgMtgEntity = shgMtgDao.getPreviousMtg(shgMemLoanEntity.getMtgNo(), shgMemLoanEntity.getCboId());
							if(shgMtgEntity!=null) {
								shgMemLoanEntity.setShgMtgUid(shgMtgEntity.getUid());
							}
						}
						ShgMemLoanEntity shgMemLoanEntityAfterSave = shgMemLoanDao.save(shgMemLoanEntity);
						// shg member loan schedule
						List<ShgMemLoanSchedule> shgMemLoanScheduleList = shgMemLoan.getShgMemberLoanScheduleList();
						if (shgMemLoanScheduleList != null && shgMemLoanScheduleList.size() > 0) {
							for (ShgMemLoanSchedule shgMemLoanSchedule : shgMemLoanScheduleList) {
								ShgMemLoanScheduleEntity shgMemLoanScheduleEntity = MeetingMapper.map(shgMemLoanSchedule);
								ShgMemLoanScheduleEntity shgMemLoanScheduleEntity1 = shgMemLoanScheduleDao.
										findByParam(mtg.getCboId(), shgMemLoanSchedule.getLoanNo(),
												shgMemLoanSchedule.getInstallmentNo(),shgMemLoanSchedule.getSubInstallmentNo(),shgMemLoanSchedule.getOrgInstallmentNo(),shgMemLoanSchedule.getStatus());
								if(shgMemLoanScheduleEntity1!=null) {
									shgMemLoanScheduleEntity.setUid(shgMemLoanScheduleEntity1.getUid());
									shgMemLoanScheduleEntity.setShgMtgUid(shgMemLoanScheduleEntity1.getShgMtgUid());
									shgMemLoanScheduleEntity.setShgMemberLoanUid(shgMemLoanScheduleEntity1.getShgMemberLoanUid());
								}else {
									shgMemLoanScheduleEntity.setUid(null);
									shgMemLoanScheduleEntity.setShgMtgUid(mtg.getUid());
									shgMemLoanScheduleEntity.setShgMemberLoanUid(shgMemLoanEntityAfterSave.getUid());
								}
								shgMemLoanScheduleEntity.setCboId(mtg.getCboId());

								/*
								 * shgMemLoanScheduleEntity.setMtgGuid(mtg.getMtgGuid());
								 * shgMemLoanScheduleEntity.setMtgNo(mtg.getMtgNo());
								 */

								shgMemLoanScheduleDao.save(shgMemLoanScheduleEntity);
							}
						}
					}
				}
				//prepare meeting summary--

				//  Boolean resp= createMeetingSummary(mtg.getUid());

				//  System.out.println("meeting summary response - " + resp);


			}
			/*
			 * try { pgFunctionProcedureService.update_meeting_summary(mtg.getUid());
			 * shgMtgDao.updateSummaryFlag(mtg.getUid(), Boolean.TRUE); }catch (SQLException
			 * e){ System.out.println("Calculate summary failed!!"); }
			 */
		} catch (Exception e) {


			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			if(returnString.equals("Success")) {
				String transactionId = "unknown";
				if(uploadShgMeeting.getTransactionId()!=null)
					transactionId = uploadShgMeeting.getTransactionId();
				TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,uploadShgMeeting.getProcessingId(),uploadShgMeeting.getUserId().toString(),role);
				transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
				transactionStatusEntity.setRemarks(e.toString());

				saveTransactionStatus(transactionStatusEntity);
			}

			returnString = "error";
			e.printStackTrace();
			// throw e;
		}

		return returnString;

	}
	@Transactional(transactionManager = "tenantTransactionManager",rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public String createVoMeetingProfileUpload(String role, UploadVoMeeting uploadVoMeeting){
		String returnString = "Success";

		Boolean dataToBeInserted=Boolean.TRUE;
		try {
			//TEST STARTS
			// shg meeting

			/*  System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

			TestEntity testEntity = new TestEntity();
			testEntity.setTest("cbwjhdcjwehcjwkh");
			testDao.save(testEntity);
						throw new Exception();*/


			//TEST ENDS

			VoMtg voMeeting = uploadVoMeeting.getVoMeeting();
			Integer voActivated = federationProfileDao.getActiveVo(voMeeting.getCboId(), Boolean.TRUE);
			if(voActivated.equals(0)) {
				dataToBeInserted=Boolean.FALSE;
				returnString = "Vo does not exists or not activated";
				TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
						,uploadVoMeeting.getProcessingId(),
						uploadVoMeeting.getUserId(),role);
				transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
				transactionStatusEntity.setRemarks("Vo does not exists or not activated");
				if(uploadVoMeeting.getTransactionId()!=null) {
					transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
				}
				else
					transactionStatusEntity.setTransactionId("unknown");
				transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
				saveTransactionStatus(transactionStatusEntity);
				throw new Exception();
			}
			VoMtgEntity voMtgEntityValidation = voMtgDao.getLastMeetingByCboId(voMeeting.getCboId());
			//VALIDATION ON MEETING NO
			Boolean deleteFlag=Boolean.FALSE;
			BigInteger lastMtgUid=new BigInteger("0");
			if (voMtgEntityValidation!=null) {
				lastMtgUid=voMtgEntityValidation.getUid();
			}

			Integer meetingNoExists = voMtgDao.countByMeetingNo(voMeeting.getMtgNo(),voMeeting.getCboId());
			if(meetingNoExists>0) {
				if(voMtgEntityValidation.getMtgNo().equals(voMeeting.getMtgNo())) {
					deleteFlag=Boolean.TRUE;
					//deleteMeeting(shgMtgEntityValidation.getUid());
					if(voMeeting.getMtgNo()==1) {
						voMtgEntityValidation=null;
					}else {
						voMtgEntityValidation = voMtgDao.getPreviousMtg(voMeeting.getMtgNo()-1, voMeeting.getCboId());
					}
				}
				else {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Already Exists";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
							,uploadVoMeeting.getProcessingId(),
							uploadVoMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Already Exists");
					if(uploadVoMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}
			//MEETING NO SHOULD BE NEXT TO MAX MEETING NO
			//MEETING NO SHOULD BE NEXT TO MAX MEETING NO
			//if(voMeeting.getMtgType().equals(VoMtgEntity.zeroMeeting)) {
			if(voMeeting.getMtgType() == VoMtgEntity.zeroMeeting) {
				VoMtgEntity voMtgEntityPrv = voMtgDao.getPreviousMtg(voMeeting.getMtgNo()-1, voMeeting.getCboId());
				if(voMeeting.getMtgNo()>1 && (voMtgEntityPrv==null)) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Sequence not correct";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
							,uploadVoMeeting.getProcessingId(),
							uploadVoMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Sequence not correct");
					if(uploadVoMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}else {
				VoMtgEntity voMtgLast = voMtgDao.getLastMeetingByCboId(voMeeting.getCboId());
				Integer mtgDiff = 12;
				if(voMtgLast!=null) {
					mtgDiff = voMtgLast.getMtgNo()+12;
				}
				if(!deleteFlag && voMeeting.getMtgNo()<mtgDiff) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Meeting No Sequence not correct for cutoff";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
							,uploadVoMeeting.getProcessingId(),
							uploadVoMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Meeting No Sequence not correct for cutoff");
					if(uploadVoMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);

					throw new Exception();
				}
			}


			//VALIDATION ON OPENING CLOSING BALANCE

			if(voMtgEntityValidation!=null) {
				//cutoff meeting check
				Boolean normalMtg=Boolean.TRUE;
				if(voMeeting.getMtgType()==VoMtgEntity.voCutOffMeeting1 || voMeeting.getMtgType()==VoMtgEntity.voCutOffMeeting2) {
					normalMtg=Boolean.FALSE;
				}
				if(normalMtg && voMtgEntityValidation.getClosingBalance()!=null && voMeeting.getOpeningBalance()!=null &&
						!voMtgEntityValidation.getClosingBalance().equals(voMeeting.getOpeningBalance())) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Opening Balance doesnot match with Closing balance of last meeting";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
							,uploadVoMeeting.getProcessingId(),
							uploadVoMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Opening Balance doesnot match with Closing balance of last meeting");
					if(uploadVoMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);
					throw new Exception();
				}

				//VALIDATION ON OPENING CLOSING BALANCE CASH
				if(normalMtg && voMtgEntityValidation.getClosingBalanceCash()!=null && voMeeting.getOpeningBalanceCash()!=null &&
						!voMtgEntityValidation.getClosingBalanceCash().equals(voMeeting.getOpeningBalanceCash())) {
					dataToBeInserted=Boolean.FALSE;
					returnString = "Opening Balance Cash doesnot match with Closing balance Cash of last meeting";
					TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
							,uploadVoMeeting.getProcessingId(),
							uploadVoMeeting.getUserId(),role);
					transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
					transactionStatusEntity.setRemarks("Opening Balance Cash doesnot match with Closing balance Cash of last meeting");
					if(uploadVoMeeting.getTransactionId()!=null) {
						transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
					}
					else
						transactionStatusEntity.setTransactionId("unknown");
					transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
					saveTransactionStatus(transactionStatusEntity);
					throw new Exception();
				}

			}

			if(deleteFlag) {
				voDeleteMeeting(lastMtgUid);
			}

			// Vo meeting
			VoMtgEntity mtg = new VoMtgEntity();
			if(dataToBeInserted.equals(Boolean.TRUE)) {
				VoMtgEntity voMtgEntity = VoMeetingMapper.map(voMeeting);
				voMtgEntity.setReadFlag(Boolean.FALSE);
				mtg =  voMtgDao.save(voMtgEntity);

			}
			// Vo Finance Transation Voucher @anshul
			List<VoFinTxnVouchers> voFinTxnVouchersList = voMeeting.getVoFinanceTransactionVouchersList();
			if (voFinTxnVouchersList != null && voFinTxnVouchersList.size() > 0) {
				for (VoFinTxnVouchers voFinTxnVouchers : voFinTxnVouchersList) {
					VoFinTxnVouchersEntity voFinTxnVouchersEntity = VoMeetingMapper.map(voFinTxnVouchers);
					voFinTxnVouchersEntity.setCboId(mtg.getCboId());
					voFinTxnVouchersEntity.setVoMtgUid(mtg.getUid());
					voFinTxnVouchersEntity.setMtgNo(mtg.getMtgNo());
					voFinTxnVouchersDao.save(voFinTxnVouchersEntity);
				}
			}
			// VO meeting details
			List<VoMtgDet> voMeetingDetailsList = voMeeting.getVoMeetingDetailsList();
			if(voMeetingDetailsList!=null && voMeetingDetailsList.size()>0) {
				for (VoMtgDet voMtgDet : voMeetingDetailsList) {
					BigInteger shgId = new BigInteger(voMtgDet.getMemId().toString());
					Integer memberActivated = shgProfileDao.getActiveShg(shgId , Boolean.TRUE);
					if(memberActivated.equals(0)) {
						dataToBeInserted=Boolean.FALSE;
						returnString = "Member does not exists or not activated";
						TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(uploadVoMeeting.getTransactionId()
								,uploadVoMeeting.getProcessingId(),
								uploadVoMeeting.getUserId(),role);
						transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
						transactionStatusEntity.setRemarks("Member does not exists or not activated");
						if(uploadVoMeeting.getTransactionId()!=null) {
							transactionStatusEntity.setTransactionId(uploadVoMeeting.getTransactionId());
						}
						else
							transactionStatusEntity.setTransactionId("unknown");
						transactionStatusEntity.setUserId(uploadVoMeeting.getUserId());
						saveTransactionStatus(transactionStatusEntity);
						throw new Exception();
					}
					if(dataToBeInserted.equals(Boolean.TRUE)) {
						VoMtgDetEntity voMtgDetEntity = VoMeetingMapper.map(voMtgDet);
						voMtgDetEntity.setCboId(mtg.getCboId());
						voMtgDetEntity.setVoMtgUid(mtg.getUid());
						voMtgDetEntity.setMtgGuid(mtg.getMtgGuid());
						voMtgDetEntity.setMtgNo(mtg.getMtgNo());
						voMtgDetEntity.setMtgDate1(mtg.getMtgDate1());
						VoMtgDetEntity voMtgDetEntityAfterSave = voMtgDetDao.save(voMtgDetEntity);

						// Vo member loan transaction
						List<VoMemLoanTxn> voMemLoanTxnList = voMtgDet.getVoMemberLoanTransactionList();
						if (voMemLoanTxnList != null && voMemLoanTxnList.size() > 0) {
							for (VoMemLoanTxn voMemLoanTxn : voMemLoanTxnList) {
								VoMemLoanTxnEntity voMemLoanTxnEntity = VoMeetingMapper.map(voMemLoanTxn);
								voMemLoanTxnEntity.setCboId(voMeeting.getCboId());
								voMemLoanTxnEntity.setVoMtgDetUid(voMtgDetEntityAfterSave.getUid());
								voMemLoanTxnEntity.setVoMtgUid(mtg.getUid());
								voMemLoanTxnEntity.setMemId(voMtgDetEntityAfterSave.getMemId());
								voMemLoanTxnEntity.setMtgGuid(mtg.getMtgGuid());
								voMemLoanTxnEntity.setMtgNo(mtg.getMtgNo());
								voMemLoanTxnEntity.setMtgDate1(voMtgDetEntityAfterSave.getMtgDate1());
								voMemLoanTxnDao.save(voMemLoanTxnEntity);
							}
						}

						// VO member settlement @mohit
						List<VoMemSettlement> voMemSettlementList = voMtgDet.getVoMemberSettlementList();
						if (voMemSettlementList != null && voMemSettlementList.size() > 0) {
							for (VoMemSettlement voMemSettlement : voMemSettlementList) {
								VoMemSettlementEntity voMemSettlementEntity = VoMeetingMapper.map(voMemSettlement);
								voMemSettlementEntity.setCboId(voMeeting.getCboId());
								voMemSettlementEntity.setVoMtgDetUid(voMtgDetEntityAfterSave.getUid());
								voMemSettlementEntity.setVoMtgUid(mtg.getUid());
								voMemSettlementEntity.setMemId(voMtgDetEntityAfterSave.getMemId());
								voMemSettlementEntity.setMtgGuid(mtg.getMtgGuid());
								voMemSettlementEntity.setMtgNo(mtg.getMtgNo());
								voMemSettlementEntity.setMtgDate1(voMtgDetEntityAfterSave.getMtgDate1());
								voMemSettlementDao.save(voMemSettlementEntity);
							}
						}
/*
						// shg Finance Transation Voucher @anshul
						List<ShgFinTxnVouchers> shgFintxnVouchersList = shgMeeting.getShgFinanceTransactionVouchersList();
						if (shgFintxnVouchersList != null && shgFintxnVouchersList.size() > 0) {
							for (ShgFinTxnVouchers shgFinTxnVouchers : shgFintxnVouchersList) {
								ShgFinTxnVouchersEntity shgFinTxnVouchersEntity = MeetingMapper.map(shgFinTxnVouchers);
								shgFinTxnVouchersEntity.setCboId(shgMeeting.getCboId());
								//shgFinTxnVouchersEntity.setShgMtgDetUid(shgMtgDetEntityAfterSave.getUid());
								shgFinTxnVouchersEntity.setShgMtgUid(mtg.getUid());
								//shgFinTxnVouchersEntity.setMemId(shgMtgDetEntityAfterSave.getMemId());
								//shgFinTxnVouchersEntity.setMtgGuid(mtg.getMtgGuid());
								shgFinTxnVouchersEntity.setMtgNo(mtg.getMtgNo());
								//shgFinTxnVouchersEntity.setMtgDate1(shgMtgDetEntityAfterSave.getMtgDate1());
								shgFinTxnVouchersDao.save(shgFinTxnVouchersEntity);
							}
						}*/

						// Vo financial transaction detail member
						List<VoFinTxnDetMem> voFinTxnDetMemList = voMtgDet.getVoFinanceTransactionDetailMemberList();
						if (voFinTxnDetMemList != null && voFinTxnDetMemList.size() > 0) {
							for (VoFinTxnDetMem voFinTxnDetMem : voFinTxnDetMemList) {
								VoFinTxnDetMemEntity voFinTxnDetMemEntity = VoMeetingMapper.map(voFinTxnDetMem);
								voFinTxnDetMemEntity.setCboId(mtg.getCboId());
								voFinTxnDetMemEntity.setVoMtgDetUid(voMtgDetEntityAfterSave.getUid());
								voFinTxnDetMemEntity.setMtgGuid(mtg.getMtgGuid());
								voFinTxnDetMemEntity.setVoMtgUid(mtg.getUid());
								voFinTxnDetMemEntity.setMemId(voMtgDetEntityAfterSave.getMemId());
								voFinTxnDetMemEntity.setMtgNo(mtg.getMtgNo());
								voFinTxnDetMemDao.save(voFinTxnDetMemEntity);
							}
						}


					}
				}
			}
			if(dataToBeInserted.equals(Boolean.TRUE)) {
				// Vo financial transaction

				List<VoFinTxn> voFinxnList = voMeeting.getVoFinanceTransactionList();
				if (voFinxnList != null && voFinxnList.size() > 0) {
					for (VoFinTxn voFinxn : voFinxnList) {
						VoFinTxnEntity voFinTxnEntity = VoMeetingMapper.map(voFinxn);
						voFinTxnEntity.setCboId(mtg.getCboId());
						voFinTxnEntity.setVoMtgUid(mtg.getUid());
						voFinTxnEntity.setMtgNo(mtg.getMtgNo());
						voFinTxnEntity.setMtgGuid(mtg.getMtgGuid());
						voFinTxnDao.save(voFinTxnEntity);
					}
				}

				// Vo financial transaction group
				List<VoFinTxnDetGrp> voFinTxnDetGrpList = voMeeting.getVoFinanceTransactionDetailGroupList();
				if (voFinTxnDetGrpList != null && voFinTxnDetGrpList.size() > 0) {
					for (VoFinTxnDetGrp voFinTxnDetGrp : voFinTxnDetGrpList) {
						VoFinTxnDetGrpEntity voFinTxnDetGrpEntity = VoMeetingMapper.map(voFinTxnDetGrp);
						voFinTxnDetGrpEntity.setCboId(mtg.getCboId());
						voFinTxnDetGrpEntity.setVoMtgUid(mtg.getUid());
						voFinTxnDetGrpEntity.setMtgNo(mtg.getMtgNo());
						voFinTxnDetGrpEntity.setMtgGuid(mtg.getMtgGuid());
						voFinTxnDetGrpDao.save(voFinTxnDetGrpEntity);
					}
				}



				// Vo group loan transaction
				List<VoGroupLoanTxn> voGroupLoanTxnList = voMeeting.getVoGroupLoanTransactionList();
				if (voGroupLoanTxnList != null && voGroupLoanTxnList.size() > 0) {
					for (VoGroupLoanTxn voGroupLoanTxn : voGroupLoanTxnList) {
						VoGroupLoanTxnEntity voGroupLoanTxnEntity = VoMeetingMapper.map(voGroupLoanTxn);
						voGroupLoanTxnEntity.setCboId(voMeeting.getCboId());
						voGroupLoanTxnEntity.setVoMtgUid(mtg.getUid());
						voGroupLoanTxnEntity.setMtgGuid(mtg.getMtgGuid());
						voGroupLoanTxnEntity.setMtgNo(mtg.getMtgNo());
						voGroupLoanTxnEntity.setMtgDate1(mtg.getMtgDate1());
						voGroupLoanTxnDao.save(voGroupLoanTxnEntity);
					}
				}


				// shg mcp
				/*List<ShgMcp> shgMcpList = uploadShgMeeting.getShgMcpList();
				if (shgMcpList != null && shgMcpList.size()>0) {
					for(ShgMcp shgMcp : shgMcpList) {
						ShgMcpEntity shgMcpEntity = MeetingMapper.map(shgMcp);
						shgMcpEntity.setShgMtgUid(mtg.getUid());
						shgMcpDao.save(shgMcpEntity);
					}

				}*/

				// vo loan application
				List<VoLoanApplication> voLoanApplicationList = uploadVoMeeting.getVoLoanApplicationList();
				if (voLoanApplicationList != null && voLoanApplicationList.size() > 0) {
					for (VoLoanApplication voLoanApplication : voLoanApplicationList) {
						VoLoanApplicationEntity voLoanApplicationEntity = VoMeetingMapper.map(voLoanApplication);
						voLoanApplicationEntity.setCboId(voMeeting.getCboId());
						voLoanApplicationEntity.setVoMtgUid(mtg.getUid());
						voLoanApplicationDao.save(voLoanApplicationEntity);
					}
				}

				// vo group loan
				//BigInteger zeroBigInteger = new BigInteger("0");
				List<VoGroupLoan> voGroupLoanList = uploadVoMeeting.getVoGroupLoanList();
				if (voGroupLoanList != null && voGroupLoanList.size() > 0) {
					for (VoGroupLoan voGroupLoan : voGroupLoanList) {
						//	if(shgGroupLoan.getLoanApplicationId().equals(zeroBigInteger)) {
						//	shgGroupLoan.setLoanApplicationId(null);
						//	}

						VoGroupLoanEntity voGroupLoanEntity1 = voGroupLoanDao.
								findLoanByCboIdLoanNo(mtg.getCboId(),voGroupLoan.getLoanNo());
						VoGroupLoanEntity voGroupLoanEntity = VoMeetingMapper.map(voGroupLoan);
						if(voGroupLoanEntity1 !=null) {
							voGroupLoanEntity.setUid(voGroupLoanEntity1.getUid());
							voGroupLoanEntity.setCboId(mtg.getCboId());

						}else {
							voGroupLoanEntity.setCboId(mtg.getCboId());
						}
						if(voGroupLoanEntity.getMtgNo().equals(mtg.getMtgNo())) {
							voGroupLoanEntity.setVoMtgUid(mtg.getUid());
						}else if(voGroupLoanEntity.getMtgNo()>mtg.getMtgNo()) {
							voGroupLoanEntity.setVoMtgUid(null);
						}else if(voGroupLoanEntity.getMtgNo()<mtg.getMtgNo()) {
							VoMtgEntity voMtgEntity = voMtgDao.getPreviousMtg(voGroupLoanEntity.getMtgNo(), voGroupLoanEntity.getCboId());
							if(voMtgEntity!=null) {
								voGroupLoanEntity.setVoMtgUid(voMtgEntity.getUid());
							}
						}
						VoGroupLoanEntity voGroupLoanEntityAfterSave = voGroupLoanDao.save(voGroupLoanEntity);

						// Vo group loan schedule
						List<VoGroupLoanSchedule> voGroupLoanScheduleList = voGroupLoan.getVoGroupLoanScheduleList();
						if (voGroupLoanScheduleList != null && voGroupLoanScheduleList.size() > 0) {
							for (VoGroupLoanSchedule voGroupLoanSchedule : voGroupLoanScheduleList) {
								VoGroupLoanScheduleEntity voGroupLoanScheduleEntity = VoMeetingMapper.map(voGroupLoanSchedule);
								VoGroupLoanScheduleEntity voGroupLoanScheduleEntity1 = voGroupLoanScheduleDao.
										findByParam(mtg.getCboId(), voGroupLoanSchedule.getLoanNo(),
												voGroupLoanSchedule.getInstallmentNo(),voGroupLoanSchedule.getSubInstallmentNo(),voGroupLoanSchedule.getOrgInstallmentNo(),voGroupLoanSchedule.getStatus());
								if(voGroupLoanScheduleEntity1!=null) {
									voGroupLoanScheduleEntity.setUid(voGroupLoanScheduleEntity1.getUid());
									voGroupLoanScheduleEntity.setVoGroupLoanUid(voGroupLoanScheduleEntity1.getVoGroupLoanUid());
									voGroupLoanScheduleEntity.setVoMtgUid(voGroupLoanScheduleEntity1.getVoMtgUid());
								}else {
									voGroupLoanScheduleEntity.setUid(null);
									voGroupLoanScheduleEntity.setVoGroupLoanUid(voGroupLoanEntityAfterSave.getUid());
									voGroupLoanScheduleEntity.setVoMtgUid(mtg.getUid());
								}
								voGroupLoanScheduleEntity.setCboId(mtg.getCboId());
								voGroupLoanScheduleDao.save(voGroupLoanScheduleEntity);
							}
						}

					}
				}

				// Vo member loan
				List<VoMemLoan> voMemberLoanList = uploadVoMeeting.getVoMemberLoanList();
				if (voMemberLoanList != null && voMemberLoanList.size() > 0) {
					for (VoMemLoan voMemLoan : voMemberLoanList) {

						//if(shgMemLoan.getLoanApplicationId().equals(zeroBigInteger)) {
						//	shgMemLoan.setLoanApplicationId(null);
						//	}

						VoMemLoanEntity voMemLoanEntity1 = voMemLoanDao.
								findLoanByCboIdLoanNo(mtg.getCboId(),voMemLoan.getLoanNo());
						VoMemLoanEntity voMemLoanEntity = VoMeetingMapper.map(voMemLoan);
						if(voMemLoanEntity1 !=null) {
							voMemLoanEntity.setUid(voMemLoanEntity1.getUid());
							voMemLoanEntity.setCboId(mtg.getCboId());
						}else {
							voMemLoanEntity.setCboId(mtg.getCboId());
						}
						if(voMemLoanEntity.getMtgNo().equals(mtg.getMtgNo())) {
							voMemLoanEntity.setVoMtgUid(mtg.getUid());
						}else if(voMemLoanEntity.getMtgNo()>mtg.getMtgNo()) {
							voMemLoanEntity.setVoMtgUid(null);
						}else if(voMemLoanEntity.getMtgNo()<mtg.getMtgNo()) {
							VoMtgEntity voMtgEntity = voMtgDao.getPreviousMtg(voMemLoanEntity.getMtgNo(), voMemLoanEntity.getCboId());
							if(voMtgEntity!=null) {
								voMemLoanEntity.setVoMtgUid(voMtgEntity.getUid());
							}
						}
						VoMemLoanEntity voMemLoanEntityAfterSave = voMemLoanDao.save(voMemLoanEntity);


						// vo member loan schedule
						List<VoMemLoanSchedule> voMemLoanScheduleList = voMemLoan.getVoMemberLoanScheduleList();
						if (voMemLoanScheduleList != null && voMemLoanScheduleList.size() > 0) {
							for (VoMemLoanSchedule voMemLoanSchedule : voMemLoanScheduleList) {
								VoMemLoanScheduleEntity voMemLoanScheduleEntity = VoMeetingMapper.map(voMemLoanSchedule);
								VoMemLoanScheduleEntity voMemLoanScheduleEntity1 = voMemLoanScheduleDao.
										findByParam(mtg.getCboId(), voMemLoanSchedule.getLoanNo(),
												voMemLoanSchedule.getInstallmentNo(),voMemLoanSchedule.getSubInstallmentNo(),voMemLoanSchedule.getOrgInstallmentNo(),voMemLoanSchedule.getStatus());
								if(voMemLoanScheduleEntity1!=null) {
									voMemLoanScheduleEntity.setUid(voMemLoanScheduleEntity1.getUid());
									voMemLoanScheduleEntity.setVoMtgUid(voMemLoanScheduleEntity1.getVoMtgUid());
									voMemLoanScheduleEntity.setVoMemberLoanUid(voMemLoanScheduleEntity1.getVoMemberLoanUid());
								}else {
									voMemLoanScheduleEntity.setUid(null);
									voMemLoanScheduleEntity.setVoMtgUid(mtg.getUid());
									voMemLoanScheduleEntity.setVoMemberLoanUid(voMemLoanEntityAfterSave.getUid());
								}
								voMemLoanScheduleEntity.setCboId(mtg.getCboId());
								voMemLoanScheduleDao.save(voMemLoanScheduleEntity);
							}
						}
					}
				}
				//prepare meeting summary--

				//  Boolean resp= createMeetingSummary(mtg.getUid());

				//  System.out.println("meeting summary response - " + resp);


			}
//			try {
//				pgFunctionProcedureService.update_vo_meeting_summary(mtg.getUid());
//				voMtgDao.updateSummaryFlag(mtg.getUid(), Boolean.TRUE);
//			}catch (SQLException e){
//				System.out.println("Calculate summary failed!!");
//			}
		} catch (Exception e) {


			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			if(returnString.equals("Success")) {
				String transactionId = "unknown";
				if(uploadVoMeeting.getTransactionId()!=null)
					transactionId = uploadVoMeeting.getTransactionId();
				TransactionStatusEntity transactionStatusEntity = insertIntoTransaction(transactionId,uploadVoMeeting.getProcessingId(),uploadVoMeeting.getUserId().toString(),role);
				transactionStatusEntity.setStatus(TransactionStatusEntity.failure);
				transactionStatusEntity.setRemarks(e.toString());

				saveTransactionStatus(transactionStatusEntity);
			}

			returnString = "error";
			e.printStackTrace();
			// throw e;
		}

		return returnString;

	}

	private void deleteMeeting(BigInteger uid) {
		ShgMtgEntity shgMtgEntity = shgMtgDao.findOne(uid);
		if(shgMtgEntity!=null) {
			shgMemLoanDao.updateShgMemLoan(shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgMemLoanDao.updateShgMemLoan1(shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgGroupLoanDao.updateShgGroupLoan(shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgGroupLoanDao.updateShgGroupLoan1(shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgMemLoanScheduleDao.updateShgMemLoanSchedule(uid,shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgMemLoanScheduleDao.deleteShgMemLoanSchedule(uid);
			shgGroupLoanScheduleDao.updateShgGroupLoanSchedule(uid,shgMtgEntity.getCboId(), shgMtgEntity.getMtgNo());
			shgGroupLoanScheduleDao.deleteShgGroupLoanSchedule(uid);
			shgMtgDao.deleteShgMtg(uid);
		}
	}

	private void voDeleteMeeting(BigInteger uid) {
		VoMtgEntity voMtgEntity = voMtgDao.findOne(uid);
		if(voMtgEntity!=null) {
			voMemLoanDao.updateVoMemLoan(voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voMemLoanDao.updateVoMemLoan1(voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voGroupLoanDao.updateVoGroupLoan(voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voGroupLoanDao.updateVoGroupLoan1(voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voMemLoanScheduleDao.updateVoMemLoanSchedule(uid,voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voMemLoanScheduleDao.deleteVoMemLoanSchedule(uid);
			voGroupLoanScheduleDao.updateVoGroupLoanSchedule(uid,voMtgEntity.getCboId(), voMtgEntity.getMtgNo());
			voGroupLoanScheduleDao.deleteVoGroupLoanSchedule(uid);
			voMtgDao.deleteVoMtg(uid);
		}
	}
	public Boolean createMeetingSummary() {
		Boolean res = Boolean.TRUE;
		try{
			List<BigInteger> shgMtgIds = shgMtgDao.getMtgIdsForSummary();
			for (BigInteger uid : shgMtgIds){
				pgFunctionProcedureService.update_meeting_summary(uid);
				shgMtgDao.updateSummaryFlag(uid, Boolean.TRUE);
			}

			List<BigInteger> voMtgIds = voMtgDao.getMtgIdsForSummary();
			for (BigInteger uid : voMtgIds){
				pgFunctionProcedureService.update_vo_meeting_summary(uid);
				voMtgDao.updateSummaryFlag(uid, Boolean.TRUE);
			}
		}catch (Exception e) {
			res = Boolean.FALSE;
			e.printStackTrace();
		}
		return res;
	}

	private List<ClfMemLoanScheduleEntity> getFutureMemLoanInstallments(List<ClfMemLoanScheduleEntity> scheduleList){
		List<ClfMemLoanScheduleEntity> futureItems = scheduleList.stream().filter((item)->{
			return  item.getLastPaidDate1() == null;
		}).collect(Collectors.toList());
		return  futureItems;
	}

	private List<ClfGroupLoanScheduleEntity> getFutureGrpLoanInstallments(List<ClfGroupLoanScheduleEntity> scheduleList){
		List<ClfGroupLoanScheduleEntity> futureItems = scheduleList.stream().filter((item)->{
			return  item.getLastPaidDate1() == null;
		}).collect(Collectors.toList());
		return  futureItems;
	}

	private Integer getTotalInstallmentPay(List<ClfMemLoanScheduleEntity> scheduleList,Integer installmentNo){
		Integer loanRepaid = 0;
		for(ClfMemLoanScheduleEntity item: scheduleList){
			if(item.getInstallmentNo() == installmentNo && item.getLastPaidDate1() != null && item.getLoanRePaid() != null){
				loanRepaid = loanRepaid + item.getLoanRePaid();
			}
		}
		return  loanRepaid;
	}

	private Integer getTotalGrpInstallmentPay(List<ClfGroupLoanScheduleEntity> scheduleList,Integer installmentNo){
		Integer loanRepaid = 0;
		for(ClfGroupLoanScheduleEntity item: scheduleList){
			if(item.getInstallmentNo() == installmentNo && item.getLastPaidDate1() != null && item.getLoanRepaid() != null){
				loanRepaid = loanRepaid + item.getLoanRepaid();
			}
		}
		return  loanRepaid;
	}

	private ClfMemLoanScheduleEntity getLastPaidInstallment(List<ClfMemLoanScheduleEntity> scheduleList, ClfMemLoanEntity clfMemLoan){
		List<ClfMemLoanScheduleEntity> onlyPaidInstls = scheduleList.stream().filter((item)->{
			return  item.getLastPaidDate1()!= null && (clfMemLoan.getRescheduleDate() == null || item.getInstallmentDate1().compareTo(clfMemLoan.getRescheduleDate()) >= 0);
		}).collect(Collectors.toList());
		if(onlyPaidInstls.size()>0){
			return onlyPaidInstls.get(onlyPaidInstls.size()-1);
		}
		return  null;
	}

	private ClfGroupLoanScheduleEntity getLastPaidGrpInstallment(List<ClfGroupLoanScheduleEntity> scheduleList, ClfGroupLoanEntity clfGroupLoan){
		List<ClfGroupLoanScheduleEntity> onlyPaidInstls = scheduleList.stream().filter((item)->{
			return  item.getLastPaidDate1()!= null && (clfGroupLoan.getRescheduleDate() == null || item.getInstallmentDate1().compareTo(clfGroupLoan.getRescheduleDate()) >= 0);
		}).collect(Collectors.toList());
		if(onlyPaidInstls.size()>0){
			return onlyPaidInstls.get(onlyPaidInstls.size()-1);
		}
		return  null;
	}

//	@@@
	public void processLoanPaymentVouchers(){
       List<ClfFinTxnDetMemEntity> clfFinTxnDetMemEntityList = clfFinTxnDetMemDao.getUnProcessedPayments();
       List<ClfMemLoanScheduleEntity> updatedInstallments = new ArrayList<>();
	   Boolean loanFullyRepaid = false;
	   for(ClfFinTxnDetMemEntity clfFinTxnDetMemEntity:clfFinTxnDetMemEntityList) {
		    Integer paidAmount = clfFinTxnDetMemEntity.getAmount();
			Date txnDate = clfFinTxnDetMemEntity.getTxnDate1();
		   List<ClfMemLoanScheduleEntity> clfMemLoanScheduleEntityList = clfMemLoanScheduleDao.findByLoanNo(clfFinTxnDetMemEntity.getLoanNo(),clfFinTxnDetMemEntity.getCboId());
		   ClfMemLoanScheduleEntity lastScheduleEntity = clfMemLoanScheduleEntityList.size()>0?clfMemLoanScheduleEntityList.get(clfMemLoanScheduleEntityList.size()-1):null;
		   //System.out.println(clfMemLoanScheduleEntityList.size());
		   List<ClfMemLoanScheduleEntity> futureInsts = this.getFutureMemLoanInstallments(clfMemLoanScheduleEntityList);
		    ClfMemLoanEntity clfMemLoanEntity = clfMemLoanDao.findByLoanNo(clfFinTxnDetMemEntity.getLoanNo(),clfFinTxnDetMemEntity.getCboId());
		 if(clfMemLoanEntity != null) {
			 for (ClfMemLoanScheduleEntity clfMemLoanScheduleEntity : futureInsts) {
				 //fixed principal
				 //   if (clfMemLoanScheduleEntity.getInstallmentType() == 1) {
				 ClfMemLoanScheduleEntity lastPaidInstallment = this.getLastPaidInstallment(clfMemLoanScheduleEntityList, clfMemLoanEntity);

				 Calendar cal = Calendar.getInstance();
				 BigInteger loanOsActual;
				 Integer osIntrest = 0;
				 if (lastPaidInstallment != null) {
					 loanOsActual = lastPaidInstallment.getLoanOsActual()!=null?lastPaidInstallment.getLoanOsActual():lastPaidInstallment.getLoanOsSchedule();
					 cal.setTime(lastPaidInstallment.getLastPaidDate1());

					 if (lastPaidInstallment.getInterestDemandActual() != null) {
						 Integer intrestRepaid = lastPaidInstallment.getInterestRePaid() == null ? 0 : lastPaidInstallment.getInterestRePaid();
						 //if any partially paid intrest in last payment
						 osIntrest = lastPaidInstallment.getInterestDemandActual() - intrestRepaid;
					 }
				 } else {
					 //if not installment paid then disbursed date of loan --> for first installment
					 ClfMtgDetailsEntity mtgDetails  = clfMtgDetailsDao.findMtgDetailsByCboIdAndMtgNo(clfMemLoanEntity.getCboId(), clfMemLoanEntity.getMtgNo());

					 loanOsActual = BigInteger.valueOf(clfMemLoanEntity.getAmount()); //clfMemLoanScheduleEntity.getLoanOsSchedule();
					 /*
					  * If there is no repayment calculating loanOs actual by adding principal demand and loanOs Scheadule
					  * As for cutoff over due amount is added for the first installment prinicpal demand.
					  */
					 loanOsActual = clfMemLoanScheduleEntityList.get(0).getLoanOsSchedule().add(BigInteger.valueOf(clfMemLoanScheduleEntityList.get(0).getPrincipalDemand())); //clfMemLoanScheduleEntity.getLoanOsSchedule();

					 if(mtgDetails != null && mtgDetails.getMtgType() == ServiceConstants.cutOffMtgType){
							cal.setTime(mtgDetails.getMtgDate1());
					 }

					 else if(clfMemLoanEntity.getRescheduleDate() == null){
						 cal.setTime(clfMemLoanEntity.getEffectiveDate());
					 }else{
						 cal.setTime(clfMemLoanEntity.getRescheduleDate());
						 ClfMemLoanScheduleEntity scheduleEntity = clfMemLoanScheduleEntityList.stream().filter((el) -> {
							 return el.getLastPaidDate1() == null;
						 }).collect(Collectors.toList()).get(0);

						 loanOsActual = scheduleEntity.getLoanOsSchedule().add(BigInteger.valueOf(scheduleEntity.getPrincipalDemand())); //clfMemLoanScheduleEntity.getLoanOsSchedule();
					 }
				 }

				 Date lastMonthInstlDate = cal.getTime();
				 Long days = 0L;
				 Long diffInMillies2 = Math.abs(txnDate.getTime() - lastMonthInstlDate.getTime());
				 if(diffInMillies2 > 0){
					 days = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS);
				 }

				 Integer currentPrincipal = clfMemLoanScheduleEntity.getPrincipalDemand();

				 //if subInstallment then adjust principal from previous payments
				 if (clfMemLoanScheduleEntity.getSubInstallmentNo() > 1) {
					 Integer loanrepaid = this.getTotalInstallmentPay(clfMemLoanScheduleEntityList, clfMemLoanScheduleEntity.getInstallmentNo());
					 currentPrincipal = currentPrincipal - loanrepaid;
				 }
				 Integer currentInterest = Math.round(loanOsActual.intValue() * clfMemLoanEntity.getInterestRate() * (Float.valueOf(days) / 365) / 100) + osIntrest;
				 if(lastPaidInstallment == null && (clfMemLoanEntity.getInterestOverdue() != null || clfMemLoanEntity.getRescheduleDate() != null)){
					 currentInterest += clfMemLoanEntity.getInterestOverdue();
				 }
				 Integer totalCurDemand = currentPrincipal + currentInterest;

				 clfMemLoanScheduleEntity.setGapDaysActual(days.intValue());
				 clfMemLoanScheduleEntity.setLastPaidDate1(new Timestamp(txnDate.getTime()));
				 clfMemLoanScheduleEntity.setBankCode(clfFinTxnDetMemEntity.getBankCode());
				 clfMemLoanScheduleEntity.setLoanRePaid(currentPrincipal);
				 clfMemLoanScheduleEntity.setInterestRePaid(currentInterest);
				 clfMemLoanScheduleEntity.setRepaid(Short.valueOf("1"));
				 clfMemLoanScheduleEntity.setInterestDemandActual(currentInterest);
				 clfMemLoanScheduleEntity.setTxnMtgNo(clfFinTxnDetMemEntity.getMtgNo());
				 clfMemLoanScheduleEntity.setTransactionNo(clfFinTxnDetMemEntity.getTransactionNo());
				 clfMemLoanScheduleEntity.setModePayment(clfFinTxnDetMemEntity.getModePayment().intValue());
				 clfMemLoanScheduleEntity.setUpdatedOn1(new Timestamp(txnDate.getTime()));
				 clfMemLoanScheduleEntity.setInterestDemandActual(currentInterest);
				 Integer loanRepaid = 0;

				 if(paidAmount >= totalCurDemand){
					loanRepaid = currentPrincipal;
				 } else if(paidAmount > currentInterest){
					 loanRepaid = paidAmount - currentInterest;
				 }

				 loanOsActual = loanOsActual.subtract(new BigInteger(loanRepaid.toString()));
				 clfMemLoanScheduleEntity.setLoanOsActual(loanOsActual);
				 clfMemLoanEntity.setPrincipalRepaid(clfMemLoanEntity.getAmount()-loanOsActual.intValue());

				 //if paid amount is same as demand(emi)
				 if (paidAmount.equals(totalCurDemand)) {
					 updatedInstallments.add(clfMemLoanScheduleEntity);
					 break;
				 } else if (paidAmount > totalCurDemand) {
					 //if paidAmount is excess then deduct current demand value and continue to update next installments
					 paidAmount = paidAmount - totalCurDemand;
					 updatedInstallments.add(clfMemLoanScheduleEntity);
				 } else if (paidAmount < totalCurDemand) {
					 //if paidAmount is lesser than current demand then adjust intrest first and add subinstallment for remaining
					  //loanRepaid = paidAmount - currentInterest;
					 clfMemLoanScheduleEntity.setRepaid(Short.valueOf("0"));

					 clfMemLoanScheduleEntity.setLoanRePaid(loanRepaid);
					// clfMemLoanScheduleEntity.setLoanOsActual(loanOsActual.subtract(new BigInteger(loanRepaid.toString())));

					// clfMemLoanEntity.setPrincipalRepaid(loanRepaid);
					// clfMemLoanEntity.setPrincipalRepaid(clfMemLoanEntity.getAmount()-loanOsActual.intValue());
					 /**
					  * as principalOverDue is calculated in the get request while getting the data.
					  * **/
//					 clfMemLoanEntity.setPrincipalOverdue(clfMemLoanScheduleEntity.getLoanOsActual().intValue());

					 if (clfMemLoanScheduleEntity.getLoanOsActual().intValue() <= 0) {
						 clfMemLoanEntity.setCompletionFlag(1);
					 }

					 // Serializes `ClfMemLoanScheduleEntity(currentDemand)` object to a `byte[]` array
					 byte[] bytes = SerializationUtils.serialize(clfMemLoanScheduleEntity);
					 ClfMemLoanScheduleEntity subinstlEntity = (ClfMemLoanScheduleEntity) SerializationUtils.deserialize(bytes);
					 if (currentInterest < paidAmount) {
						 clfMemLoanScheduleEntity.setInterestRePaid(currentInterest);
					 } else {
						 clfMemLoanScheduleEntity.setInterestRePaid(paidAmount);

					 }
					 updatedInstallments.add(clfMemLoanScheduleEntity);
                     subinstlEntity.setGapDaysSchedule(clfMemLoanScheduleEntity.getGapDaysSchedule());

					 subinstlEntity.setSubInstallmentNo(clfMemLoanScheduleEntity.getSubInstallmentNo() + 1);
					 subinstlEntity.setRepaid(Short.valueOf("0"));
					 subinstlEntity.setLoanRePaid(null);
					 subinstlEntity.setInterestRePaid(null);
					 subinstlEntity.setLastPaidDate1(null);
					 //subinstlEntity.setLoanOsActual(null);
					 subinstlEntity.setUid(null);
					 updatedInstallments.add(subinstlEntity);
					 break;
				 }
				 if(lastScheduleEntity!=null && clfMemLoanScheduleEntity.getUid().equals(lastScheduleEntity.getUid()) && clfMemLoanScheduleEntity.getRepaid().equals(new Short("1"))){
				 clfMemLoanEntity.setCompletionFlag(1);
				}
				 // }
//			   else {
//				   //TODO emi
//			   }

			 }
			 if((clfMemLoanEntity.getAmount() - clfMemLoanEntity.getPrincipalRepaid()) <= 0){
				 clfMemLoanEntity.setCompletionFlag(1);
			 }
			 clfFinTxnDetMemEntity.setIsProcessed(1);
			 this.clfMemLoanScheduleDao.save(updatedInstallments);
			 this.clfMemLoanDao.save(clfMemLoanEntity);
			 updatedInstallments.clear();
		 }
	   }
	   //
	   this.clfFinTxnDetMemDao.save(clfFinTxnDetMemEntityList);
	   System.out.println(clfFinTxnDetMemEntityList.size());
	}

	public void processGroupLoanPaymentVouchers(){
		List<ClfFinTxnDetGrpEntity> clfFinTxnDetGrpEntityList = clfFinTxnDetGrpDao.getUnProcessedPayments();
		List<ClfGroupLoanScheduleEntity> updatedInstallments = new ArrayList<>();
		for(ClfFinTxnDetGrpEntity clfFinTxnDetGrpEntity:clfFinTxnDetGrpEntityList) {
			Integer paidAmount = clfFinTxnDetGrpEntity.getAmount();
			Date txnDate = clfFinTxnDetGrpEntity.getTxnDate1();
			List<ClfGroupLoanScheduleEntity> clfGroupLoanScheduleEntityList = clfGroupLoanScheduleDao.findByLoanNo(clfFinTxnDetGrpEntity.getLoanNo(),clfFinTxnDetGrpEntity.getCboId());
			ClfGroupLoanScheduleEntity lastScheduleEntity = clfGroupLoanScheduleEntityList.size()>0?clfGroupLoanScheduleEntityList.get(clfGroupLoanScheduleEntityList.size()-1):null;

			//System.out.println(clfMemLoanScheduleEntityList.size());
			List<ClfGroupLoanScheduleEntity> futureInsts = this.getFutureGrpLoanInstallments(clfGroupLoanScheduleEntityList);
			ClfGroupLoanEntity clfGroupLoanEntity = clfGroupLoanDao.findByLoanNo(clfFinTxnDetGrpEntity.getLoanNo(),clfFinTxnDetGrpEntity.getCboId());
			if(clfGroupLoanEntity != null) {
				for (ClfGroupLoanScheduleEntity clfGroupLoanScheduleEntity : futureInsts) {

					//fixed principal
					//   if (clfMemLoanScheduleEntity.getInstallmentType() == 1) {
					ClfGroupLoanScheduleEntity lastPaidInstallment = this.getLastPaidGrpInstallment(clfGroupLoanScheduleEntityList, clfGroupLoanEntity);

					Calendar cal = Calendar.getInstance();
					BigInteger loanOsActual;
					Integer osIntrest = 0;
					if (lastPaidInstallment != null) {
						loanOsActual = lastPaidInstallment.getLoanOsActual()!=null?lastPaidInstallment.getLoanOsActual():lastPaidInstallment.getLoanOsSchedule();
						cal.setTime(lastPaidInstallment.getLastPaidDate1());
						if (lastPaidInstallment.getInterestDemandActual() != null) {
							Integer intrestRepaid = lastPaidInstallment.getInterestPaid() == null ? 0 : lastPaidInstallment.getInterestPaid();
							//if any partially paid intrest in last payment
							osIntrest = lastPaidInstallment.getInterestDemandActual() - intrestRepaid;
						}
					} else {
						ClfMtgDetailsEntity mtgDetails = clfMtgDetailsDao.findMtgDetailsByCboIdAndMtgNo(clfGroupLoanEntity.getCboId(), clfGroupLoanEntity.getMtgNo());
						
						if(mtgDetails != null && mtgDetails.getMtgType() == ServiceConstants.cutOffMtgType){
							cal.setTime(mtgDetails.getMtgDate1());
						}

						else{
							if(clfGroupLoanEntity.getRescheduleDate() == null){
								cal.setTime(clfGroupLoanEntity.getEffectiveDate());
							}else{
								cal.setTime(clfGroupLoanEntity.getRescheduleDate());
								ClfGroupLoanScheduleEntity scheduleEntity = clfGroupLoanScheduleEntityList.stream().filter(el -> {
									return el.getLastPaidDate1() == null;
								}).collect(Collectors.toList()).get(0);
								//						loanOsActual = BigInteger.valueOf(clfGroupLoanEntity.getAmount()); //clfMemLoanScheduleEntity.getLoanOsSchedule();
								/*
								 * If there is no repayment calculating loanOs actual by adding principal demand and loanOs Scheadule
								 * As for cutoff over due amount is added for the first installment prinicpal demand.
								 */
								loanOsActual = scheduleEntity.getLoanOsSchedule().add(BigInteger.valueOf(scheduleEntity.getPrincipalDemand())); //clfMemLoanScheduleEntity.getLoanOsSchedule();
							}
						}
						loanOsActual = clfGroupLoanScheduleEntityList.get(0).getLoanOsSchedule().add(BigInteger.valueOf(clfGroupLoanScheduleEntityList.get(0).getPrincipalDemand())); //clfMemLoanScheduleEntity.getLoanOsSchedule();
					}

					Long days = 0L;
					Date lastMonthInstlDate = cal.getTime();
					Long diffInMillies2 = Math.abs(txnDate.getTime() - lastMonthInstlDate.getTime());
					if(diffInMillies2 > 0){
						days = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS);
					}

					Integer currentPrincipal = clfGroupLoanScheduleEntity.getPrincipalDemand();

					//if subInstallment then adjust principal from previous payments
					if (clfGroupLoanScheduleEntity.getSubInstallmentNo() > 1) {
						Integer loanrepaid = this.getTotalGrpInstallmentPay(clfGroupLoanScheduleEntityList, clfGroupLoanScheduleEntity.getInstallmentNo());
						currentPrincipal = currentPrincipal - loanrepaid;
					}
					Integer currentInterest = Math.round(loanOsActual.intValue() * clfGroupLoanEntity.getInterestRate() * (Float.valueOf(days) / 365) / 100) + osIntrest;
					if(lastPaidInstallment == null && (clfGroupLoanEntity.getInterestOverdue() != null || clfGroupLoanEntity.getRescheduleDate() != null) ){
						currentInterest += clfGroupLoanEntity.getInterestOverdue();
					}
					Integer totalCurDemand = currentPrincipal + currentInterest;

					clfGroupLoanScheduleEntity.setGapDaysActual(days.intValue());
					clfGroupLoanScheduleEntity.setLastPaidDate1(new Timestamp(txnDate.getTime()));
					clfGroupLoanScheduleEntity.setBankCode(clfFinTxnDetGrpEntity.getBankCode());
					clfGroupLoanScheduleEntity.setLoanRepaid(currentPrincipal);
					clfGroupLoanScheduleEntity.setInterestPaid(currentInterest);
					clfGroupLoanScheduleEntity.setRepaid(Short.valueOf("1"));
					clfGroupLoanScheduleEntity.setInterestDemandActual(currentInterest);
					clfGroupLoanScheduleEntity.setTxnMtgNo(clfFinTxnDetGrpEntity.getMtgNo());
					clfGroupLoanScheduleEntity.setTransactionNo(clfFinTxnDetGrpEntity.getTransactionNo());
					clfGroupLoanScheduleEntity.setModePayment(clfFinTxnDetGrpEntity.getModePayment().intValue());
					clfGroupLoanScheduleEntity.setUpdatedOn1(new Timestamp(txnDate.getTime()));
					clfGroupLoanScheduleEntity.setInterestDemandActual(currentInterest);
					Integer loanRepaid = 0;

					if(paidAmount >= totalCurDemand){
						loanRepaid = currentPrincipal;
					} else if(paidAmount > currentInterest){
						loanRepaid = paidAmount - currentInterest;
					}

					loanOsActual = loanOsActual.subtract(new BigInteger(loanRepaid.toString()));

					clfGroupLoanScheduleEntity.setLoanOsActual(loanOsActual);
					clfGroupLoanEntity.setPrincipalRepaid(clfGroupLoanEntity.getAmount()-loanOsActual.intValue());

					//if paid amount is same as demand(emi)
					if (paidAmount.equals(totalCurDemand)) {
						updatedInstallments.add(clfGroupLoanScheduleEntity);
						break;
					} else if (paidAmount > totalCurDemand) {
						//if paidAmount is excess then deduct current demand value and continue to update next installments
						paidAmount = paidAmount - totalCurDemand;
						updatedInstallments.add(clfGroupLoanScheduleEntity);
					} else if (paidAmount < totalCurDemand) {
						//if paidAmount is lesser than current demand then adjust intrest first and add subinstallment for remaining
						//Integer loanRepaid = paidAmount - currentInterest;
						clfGroupLoanScheduleEntity.setRepaid(Short.valueOf("0"));

						clfGroupLoanScheduleEntity.setLoanRepaid(loanRepaid);
						//	clfGroupLoanScheduleEntity.setLoanOsActual(loanOsActual.subtract(new BigInteger(loanRepaid.toString())));
						//clfGroupLoanEntity.setPrincipalRepaid(loanRepaid);
						/**
						* as principalOverDue is calculated in the get request while getting the data.
						* **/
						// clfGroupLoanEntity.setPrincipalOverdue(clfGroupLoanScheduleEntity.getLoanOsActual().intValue());
						if (clfGroupLoanScheduleEntity.getLoanOsActual().intValue() <= 0) {
							clfGroupLoanEntity.setCompletionFlag((short) 1);
						}

						// Serializes `ClfMemLoanScheduleEntity(currentDemand)` object to a `byte[]` array
						byte[] bytes = SerializationUtils.serialize(clfGroupLoanScheduleEntity);
						ClfGroupLoanScheduleEntity subinstlEntity = (ClfGroupLoanScheduleEntity) SerializationUtils.deserialize(bytes);
						if (currentInterest < paidAmount) {
							clfGroupLoanScheduleEntity.setInterestPaid(currentInterest);
						} else {
							clfGroupLoanScheduleEntity.setInterestPaid(paidAmount);

						}
						updatedInstallments.add(clfGroupLoanScheduleEntity);
						subinstlEntity.setGapDaysSchedule(clfGroupLoanScheduleEntity.getGapDaysSchedule());

						subinstlEntity.setSubInstallmentNo(clfGroupLoanScheduleEntity.getSubInstallmentNo() + 1);
						subinstlEntity.setRepaid(Short.valueOf("0"));
						subinstlEntity.setLoanRepaid(null);
						subinstlEntity.setInterestPaid(null);
						subinstlEntity.setLastPaidDate1(null);
						//subinstlEntity.setLoanOsActual(null);
						subinstlEntity.setUid(null);
						updatedInstallments.add(subinstlEntity);
						break;
					}


					// }
//			   else {
//				   //TODO emi
//			   }
					if(lastScheduleEntity!=null && clfGroupLoanScheduleEntity.getUid().equals(lastScheduleEntity.getUid()) && clfGroupLoanScheduleEntity.getRepaid().equals(new Short("1"))){
						clfGroupLoanEntity.setCompletionFlag(new Short("1"));
					}
				}
				if((clfGroupLoanEntity.getAmount() - clfGroupLoanEntity.getPrincipalRepaid()) <= 0){
					clfGroupLoanEntity.setCompletionFlag(new Short("1"));
				}
				clfFinTxnDetGrpEntity.setIsProcessed(1);
				this.clfGroupLoanScheduleDao.save(updatedInstallments);
				this.clfGroupLoanDao.save(clfGroupLoanEntity);
				updatedInstallments.clear();
			}
		}
		//
		this.clfFinTxnDetGrpDao.save(clfFinTxnDetGrpEntityList);
		System.out.println(clfFinTxnDetGrpEntityList.size());
	}


	//Json creation code starting //
	public String jsonCreationAtInsertion(BigInteger shgId){
		String res = "processing failed!!";
			System.out.println("Inside ShgApiService->fetchByShgId()");
			SHGProfile shgProfile = new SHGProfile();
			ShgProfileEntity shgProfileEntity = shgProfileDao.findOne(shgId);
			if(shgProfileEntity.getActive().equals(Boolean.TRUE)) {
			shgProfile = GroupMapper.map(shgProfileEntity);
			//MAX MEETING NUMBER
			shgProfile.setMaxMtgNo(shgProfileDao.getMaxMtgNo(shgProfileEntity.getShgId()));
			if(shgProfileEntity.getParentCboId()!=null) {
				FederationProfileEntity federationProfileEntity =
						federationProfileDao.findOne(BigInteger.valueOf(shgProfileEntity.getParentCboId().intValue()));
				if(federationProfileEntity!=null) {
					shgProfile.setFederation_name(federationProfileEntity.getFederationName());
					shgProfile.setFederation_code(federationProfileEntity.getFederation_code());
					shgProfile.setFederation_name_local(federationProfileEntity.getFederationNameLocal());
				}
			}
			List<CBOPhoneNoDetails> cboPhoneNoDetailsList = fetchPhoneNumberByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
			shgProfile.setCboPhoneNoDetailsList(cboPhoneNoDetailsList);
			List<CBOAddresses> cboAddressesList = fetchAddressByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
			shgProfile.setCboAddressesList(cboAddressesList);
			List<CBOBankDetails> cboBankDetailsList = fetchByBankDetailsByCboId(shgProfileEntity.getShgId(),LookUpMasterEntity.shgLookupVal);
			shgProfile.setCboBankDetailsList(cboBankDetailsList);
			List<SystemTags> cboSystemTagsList = fetchSystemTagsByCboId(shgProfileEntity.getShgId());
			shgProfile.setCboSystemTagsList(cboSystemTagsList);
            /*List<MemberInsurance> memberInsuranceList = fetchMemberInsuranceByCboId(shgProfileEntity.getShgId());
            shgProfile.setMemberInsuranceList(memberInsuranceList);*/
			List<SHGDesignation> shgDesignationList = fetchSHGDesignationByCboId(shgProfileEntity.getShgId());
			shgProfile.setShgDesignationList(shgDesignationList);

			try {
				List<MemberProfile> memberProfileList = fetchMemberProfileByCboId(shgProfileEntity.getShgId()); //working on this line (Tushar)
				shgProfile.setMemberProfileList(memberProfileList);

					/*Long m2Started = System.currentTimeMillis();
					List<MemberProfile> memberProfileListConsolidate = fetchMemberProfileByCboIdConsolidated(shgProfileEntity.getShgId());
					Long m2Ended = System.currentTimeMillis();
					System.out.println("fetchMemberProfileByCboIdConsolidated Total Time Taken ::: " + (m2Ended - m2Started));
					shgProfile.setMemberProfileList(memberProfileListConsolidate);*/
			} catch (Exception e) {
				System.out.println("Exception is: " +e);
				e.printStackTrace();
			}
		}
		saveShgFullJson(shgId,shgProfile);
		return shgProfile.toString();
	}

	public void saveShgFullJson(BigInteger shgId, SHGProfile shgProfile){
		String json = null;
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,SHGProfile> data = new HashMap<>();
		data.put("shgProfile",shgProfile);
		try {
			 json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		ProfileMasterDataEntity profileMasterDataEntity =  profileMasterDataDao.findByCboIdType(shgId,(short)0);

		if(profileMasterDataEntity!=null){
			profileMasterDataEntity.setData(json);
			profileMasterDataEntity.setUpdatedBy("SYSTEM_QUEUE");
			profileMasterDataEntity.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
			profileMasterDataDao.saveAndFlush(profileMasterDataEntity);
		}else {
			ProfileMasterDataEntity profileMasterDataEntity1 = new ProfileMasterDataEntity();
			profileMasterDataEntity1.setCboId(shgId);
			profileMasterDataEntity1.setCboType((short)0);
			profileMasterDataEntity1.setData(json);
			profileMasterDataEntity1.setCreatedBy("SYSTEM_QUEUE");
			profileMasterDataEntity1.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			profileMasterDataDao.saveAndFlush(profileMasterDataEntity1);
		}
	}

	public List<CBOAddresses> fetchAddressByCboId(BigInteger cboId,Short cboType){
		List<CBOAddresses> cboAddressesList = new ArrayList<CBOAddresses>();
		List<CboAddressesDetailsEntity> cboAddressesDetailsEntityList = cboAddressesDetailsDao.fetchByCboId(cboId,Boolean.TRUE,cboType);
		for (CboAddressesDetailsEntity cboAddressesDetailsEntity : cboAddressesDetailsEntityList) {
			CBOAddresses cboAddresses = GroupMapper.map(cboAddressesDetailsEntity);
			cboAddressesList.add(cboAddresses);
		}
		return cboAddressesList;
	}
	public List<CBOPhoneNoDetails> fetchPhoneNumberByCboId(BigInteger cboCode,Short cboType){
		List<CBOPhoneNoDetails> cboPhoneNoDetailsList = new ArrayList<CBOPhoneNoDetails>();
		List<CboPhoneNoDetailsEntity> cboPhoneNoDetailsEntityList =
				cboPhoneNoDetailsDao.fetchByCboId(cboCode,Boolean.TRUE,cboType);
		for (CboPhoneNoDetailsEntity cboPhoneNoDetailsEntity : cboPhoneNoDetailsEntityList) {
			CBOPhoneNoDetails cboPhoneNoDetails = GroupMapper.map(cboPhoneNoDetailsEntity);
			if(cboPhoneNoDetailsEntity.getMemberGuid()!=null){
				MemberProfileEntity memberProfileEntity =
						memberProfileDao.fetchByGUID(cboPhoneNoDetailsEntity.getMemberGuid(),Boolean.TRUE);
				if(memberProfileEntity!=null)
					cboPhoneNoDetails.setMember_name(memberProfileEntity.getMemberName());
			}
			cboPhoneNoDetailsList.add(cboPhoneNoDetails);
		}
		return cboPhoneNoDetailsList;
	}

	public List<CBOBankDetails> fetchByBankDetailsByCboId(BigInteger cboId,Short cboType){
		BigInteger bigInteger = new BigInteger("0");
		List<CBOBankDetails> cboBankDetailsList = new ArrayList<CBOBankDetails>();
		List<CboBankDetailsEntity> cboBankDetailsEntityList =
				cboBankDetailsDao.fetchByCboId(cboId,Boolean.TRUE,cboType);
		for (CboBankDetailsEntity cboBankDetailsEntity : cboBankDetailsEntityList) {
			CBOBankDetails cboBankDetails = GroupMapper.map(cboBankDetailsEntity);
			if(cboBankDetailsEntity.getBankDocumentId()!=null &&
					cboBankDetailsEntity.getBankDocumentId()!=bigInteger){
				DocumentDetailsEntity documentDetailsEntity =
						documentDetailsDao.findOne(cboBankDetailsEntity.getBankDocumentId());
				if(documentDetailsEntity!= null && documentDetailsEntity.getDocPath() !=null &&
						!documentDetailsEntity.getDocPath().isEmpty() &&
						documentDetailsEntity.getFrontDocModifiedName() != null &&
						!documentDetailsEntity.getFrontDocModifiedName().isEmpty()) {
					cboBankDetails.setBank_document(
							documentDetailsEntity.getDocPath()+File.separator
									+ documentDetailsEntity.getFrontDocModifiedName());
				}

			}
			cboBankDetailsList.add(cboBankDetails);
		}
		return cboBankDetailsList;
	}

	public List<CboKYCDetails> fetchByKycDetailsByCboId(BigInteger cboId,Short cboType){
		BigInteger bigInteger = new BigInteger("0");
		List<CboKYCDetails> cboKycDetailsList = new ArrayList<CboKYCDetails>();
		List<CboKYCDetailsEntity> cboKycDetailsEntityList =
				cboKYCDetailsDao.fetchByCboId(cboId,Boolean.TRUE);
		if(cboKycDetailsEntityList  != null){
			for (CboKYCDetailsEntity cboKycDetailsEntity : cboKycDetailsEntityList) {
				CboKYCDetails cboKYCDetails = GroupMapper.map(cboKycDetailsEntity);
				if(cboKycDetailsEntity.getDocumentId()!=null &&
						cboKycDetailsEntity.getDocumentId()!=bigInteger){
					DocumentDetailsEntity documentDetailsEntity =
							documentDetailsDao.findOne(cboKycDetailsEntity.getDocumentId());
					if(documentDetailsEntity!= null && documentDetailsEntity.getDocPath() !=null &&
							!documentDetailsEntity.getDocPath().isEmpty() &&
							documentDetailsEntity.getFrontDocModifiedName() != null &&
							!documentDetailsEntity.getFrontDocModifiedName().isEmpty()) {
						cboKYCDetails.setKyc_document(
								documentDetailsEntity.getDocPath()+File.separator
										+ documentDetailsEntity.getFrontDocModifiedName());
					}

				}
				cboKycDetailsList.add(cboKYCDetails);
			}
		}
		return cboKycDetailsList;
	}

	public List<SystemTags> fetchSystemTagsByCboId(BigInteger cboId){
		List<SystemTags> systemTagsList = new ArrayList<SystemTags>();
		List<SystemTagsEntity> systemTagsEntityList =
				systemTagsDao.fetchByCboId(cboId,Boolean.TRUE);
		for (SystemTagsEntity systemTagsEntity : systemTagsEntityList) {
			SystemTags systemTags = GroupMapper.map(systemTagsEntity);
			systemTagsList.add(systemTags);
		}
		return systemTagsList;
	}

	public List<SHGDesignation> fetchSHGDesignationByCboId(BigInteger cboId){
		List<SHGDesignation> shgDesignationList = new ArrayList<SHGDesignation>();
		List<SHGDesignationEntity> shgDesignationEntityList =
				shgDesignationDao.fetchByCboId(cboId,Boolean.TRUE);
		for (SHGDesignationEntity shgDesignationEntity : shgDesignationEntityList) {
			SHGDesignation shgDesignation = GroupMapper.map(shgDesignationEntity);

			//30-3-2021 mohit
			MemberProfileEntity memberProfileEntity = memberProfileDao.fetchByGUID(shgDesignation.getMember_guid(),Boolean.TRUE);
			if(memberProfileEntity != null && memberProfileEntity.getMemberName() !=null){
				shgDesignation.setMember_name(memberProfileEntity.getMemberName());
				List<MemberPhoneNoDetailsEntity> memberPhoneNoDetailsEntityList =
						memberPhoneNoDetailsDao.fetchPhoneNoByMemberCode(memberProfileEntity.getCboId(),memberProfileEntity.getMemberId(),
								Boolean.TRUE);
				if(memberPhoneNoDetailsEntityList != null && memberPhoneNoDetailsEntityList.size() > 0){
					shgDesignation.setPhone_no(memberPhoneNoDetailsEntityList.get(0).getPhoneNo());
				}
			}
			shgDesignationList.add(shgDesignation);
		}
		return shgDesignationList;
	}

	public List<MemberProfile> fetchMemberProfileByCboId(BigInteger cboId) throws ParseException {
		System.out.println("Inside ShgApiService->fetchMemberProfileByCboId()");
		List<MemberProfile> memberProfileList = new ArrayList<MemberProfile>();
		Long q1Start = System.currentTimeMillis();
		List<MemberProfileEntity> memberProfileEntityList = memberProfileDao.fetchByCboId(cboId,Boolean.TRUE);
		Long q1Stop = System.currentTimeMillis();
		System.out.println("## Total Time take by memberProfileRepository.fetchByCboId Query = " + (q1Stop - q1Start));
//        System.out.println("memberProfileRepository.fetchByCboId Total Time Taken ::" + stopWatch.getTotalTimeMillis());
		for (MemberProfileEntity memberProfileEntity :memberProfileEntityList) {
			MemberProfile  memberProfile = null;
			memberProfile = MemberMapper.map(memberProfileEntity);
			BigInteger bigInteger = new BigInteger("0");
			if(memberProfileEntity.getMemberProfileDocumentId()!=null
					&& memberProfileEntity.getMemberProfileDocumentId()!=bigInteger) {
				Long q2Start = System.currentTimeMillis();
				DocumentDetailsEntity documentDetailsEntity =
						documentDetailsDao.findOne(memberProfileEntity.getMemberProfileDocumentId());
				Long q2Stop = System.currentTimeMillis();
				System.out.println("## Total Time take by documentDetailsRepository.findOne(memberProfileEntity.getMemberProfileDocumentId()) Query = " + (q2Stop - q2Start));
//                System.out.println("documentDetailsRepository.findOne(memberProfileEntity.getMemberProfileDocumentId()) Total Time Taken ::" + stopWatch.getTotalTimeMillis());
				if (documentDetailsEntity != null && documentDetailsEntity.getDocPath() != null &&
						!documentDetailsEntity.getDocPath().isEmpty() &&
						documentDetailsEntity.getFrontDocModifiedName() != null &&
						!documentDetailsEntity.getFrontDocModifiedName().isEmpty()) {
					memberProfile.setMember_document(
							documentDetailsEntity.getDocPath() + File.separator
									+ documentDetailsEntity.getFrontDocModifiedName());
				}
			}
			//consent form
			if(memberProfileEntity.getConsentFormId()!=null
					&& memberProfileEntity.getConsentFormId()!=bigInteger) {
				Long q3Start = System.currentTimeMillis();
				DocumentDetailsEntity documentDetailsEntity1 =
						documentDetailsDao.findOne(memberProfileEntity.getConsentFormId());
				Long q3Stop = System.currentTimeMillis();
				System.out.println("## Total Time take by documentDetailsRepository.findOne(memberProfileEntity.getConsentFormId()) Query = " + (q3Stop - q3Start));
//                System.out.println("documentDetailsRepository.findOne(memberProfileEntity.getConsentFormId()) Total Time Taken ::" + stopWatch.getTotalTimeMillis());
				if (documentDetailsEntity1 != null && documentDetailsEntity1.getDocPath() != null &&
						!documentDetailsEntity1.getDocPath().isEmpty() &&
						documentDetailsEntity1.getFrontDocModifiedName() != null &&
						!documentDetailsEntity1.getFrontDocModifiedName().isEmpty()) {
					memberProfile.setConsent_form(
							documentDetailsEntity1.getDocPath() + File.separator
									+ documentDetailsEntity1.getFrontDocModifiedName());
				}
			}


			Long q4Start = System.currentTimeMillis();
			List<MemberAddressesDetailsEntity> memberAddressesDetailsEntityList =
					memberAddressesDetailsDao.findListByMemberCodeCboId(memberProfile.getCbo_id(),memberProfile.getMember_id());
			Long q4Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberAddressesDetailsRepository.findListByMemberCodeCboId Query = " + (q4Stop - q4Start));
			if(memberAddressesDetailsEntityList != null) {
				List<MemberAddresses> memberAddressesList = new ArrayList<>();
				for(MemberAddressesDetailsEntity ma : memberAddressesDetailsEntityList) {
					if (ma.getActive().equals(Boolean.TRUE)) {
						memberAddressesList.add(MemberMapper.map(ma));
					}
				}
				memberProfile.setMemberAddressesList(memberAddressesList);
			}
			//@adish 15092021
			Long q5Start = System.currentTimeMillis();
			List<CadreShgMembersEntity> cadreShgMembersEntityList =
					cadreShgMembersDao.findListByMemberCodeCboId(memberProfile.getCbo_id(),memberProfile.getMember_id());
			Long q5Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by cadreShgMembersRepository.findListByMemberCodeCboId Query = " + (q5Stop - q5Start));
			if(cadreShgMembersEntityList != null) {
				List<CadreShgMembersModel> cadreShgMembersModels = new ArrayList<>();
				for(CadreShgMembersEntity ma : cadreShgMembersEntityList) {
					if (ma.getIsActive().equals(Boolean.TRUE)) {
						cadreShgMembersModels.add(MemberMapper.map(ma));
					}

				}
				memberProfile.setCadreShgMembersModeslList(cadreShgMembersModels);
			}
            /*
            CadreNonMembersEntity cadreNonMembers = null;
            List<CadreNonMembersEntity> cadreNonMembersEntities = cadreNonMembersRepository.findListByCadreNonMemberUid(cadreNonMembers.getUid());
            if(cadreNonMembersEntities != null) {
                List<CadreNonMembersModel> cadreNonMembersModelList = new ArrayList<>();
                for(CadreNonMembersEntity ma : cadreNonMembersEntities) {
                    if (ma.getUid().equals(Boolean.TRUE)) {
                        cadreNonMembersModelList.add(MemberMapper.map(ma));
                    }
                }
                memberProfile.setCadreNonMembersModeslList(cadreNonMembersModelList);
            }

             */
			//@adish

			Long q6Start = System.currentTimeMillis();
			List<MemberBankDetailsEntity> memberBankDetailsEntityList =
					memberBankDetailsDao.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
			Long q6Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberBankDetailsRepository.findListByMemberCodeCboId Query = " + (q6Stop - q6Start));
			if(memberBankDetailsEntityList != null) {
				List<MemberBank> memberBankList = new ArrayList<>();
				for(MemberBankDetailsEntity ma : memberBankDetailsEntityList) {
					if (ma.getActive().equals(Boolean.TRUE)) {
						try {
							memberBankList.add(MemberMapper.map(ma));
						} catch (ParseException e) {
							System.out.println("Exception is: " +e);
							e.printStackTrace();
						}
					}
				}
				memberProfile.setMemberBankList(memberBankList);
			}

			Long q7Start = System.currentTimeMillis();
			List<MemberKYCDetailsEntity> memberKYCDetailsEntityList =
					memberKYCDetailsDao.findByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
			Long q7Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberKYCDetailsRepository.findByMemberCodeCboId Query = " + (q7Stop - q7Start));
			if(memberKYCDetailsEntityList != null) {
				List<MemberKYCDetails> memberKYCDetailsList = new ArrayList<>();
				for(MemberKYCDetailsEntity ma : memberKYCDetailsEntityList) {
					if (ma.getActive().equals(Boolean.TRUE)) {
						memberKYCDetailsList.add(MemberMapper.map(ma));
					}
				}
				memberProfile.setMemberKYCDetailsList(memberKYCDetailsList);
			}

			Long q8Start = System.currentTimeMillis();
			List<MemberPhoneNoDetailsEntity> memberPhoneNoDetailsEntityList =
					memberPhoneNoDetailsDao.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
			Long q8Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberKYCDetailsRepository.findByMemberCodeCboId Query = " + (q8Stop - q8Start));
			if(memberPhoneNoDetailsEntityList != null) {
				List<MemberPhoneNoDetails> memberPhoneNoDetailsList = new ArrayList<>();
				for(MemberPhoneNoDetailsEntity ma : memberPhoneNoDetailsEntityList) {
					if (ma.getActive().equals(Boolean.TRUE)) {
						try {
							memberPhoneNoDetailsList.add(MemberMapper.map(ma));
						} catch (ParseException e) {
							System.out.println("Exception is: " +e);
							e.printStackTrace();
						}
					}
				}
				memberProfile.setMemberPhoneNoDetailsList(memberPhoneNoDetailsList);
			}

			Long q9Start = System.currentTimeMillis();
			List<MemberSystemTagsEntity> memberSystemTagsEntityList =
					memberSystemTagsDao.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
			Long q9Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberSystemTagsRepository.findListByMemberCodeCboId Query = " + (q9Stop - q9Start));
			if(memberSystemTagsEntityList != null) {
				List<MemberSystemTags> memberSystemTagsList = new ArrayList<>();
				for(MemberSystemTagsEntity ma : memberSystemTagsEntityList) {
					if (ma.getActive().equals(Boolean.TRUE)) {
						memberSystemTagsList.add(MemberMapper.map(ma));
					}
				}
				memberProfile.setMemberSystemTagsList(memberSystemTagsList);
			}

			Long q10Start = System.currentTimeMillis();
			List<MemberInsuranceEntity> memberInsuranceEntityList =
					memberInsuranceDao.findListByMemberCodeCboId(memberProfile.getMember_id(),memberProfile.getCbo_id());
			Long q10Stop = System.currentTimeMillis();
			System.out.println("## Total Time take by memberInsuranceRepository.findListByMemberCodeCboId Query = " + (q10Stop - q10Start));
			System.out.println("** Total Time taken by all query = " + (q10Stop - q1Start));
			if(memberInsuranceEntityList != null) {
				List<MemberInsurance> memberInsuranceList = new ArrayList<>();
				for(MemberInsuranceEntity mi : memberInsuranceEntityList) {
					if (mi.getActive().equals(Boolean.TRUE)) {
						memberInsuranceList.add(MemberMapper.map(mi));
					}
				}
				memberProfile.setMemberInsuranceList(memberInsuranceList);
			}
			memberProfileList.add(memberProfile);
			saveMemberFullJson(memberProfile);
		}
		return memberProfileList;
	}
	public void saveMemberFullJson(MemberProfile memberProfile){
		String json = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(memberProfile);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		MemberProfileMasterDataEntity memberProfileMasterDataEntity =  memberProfileMasterDataDao.
				findByCboIdMemberId(memberProfile.getCbo_id(),memberProfile.getMember_id());
		if(memberProfileMasterDataEntity!=null){
			memberProfileMasterDataEntity.setData(json);
			memberProfileMasterDataEntity.setUpdatedBy("SYSTEM_QUEUE");
			memberProfileMasterDataEntity.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
			memberProfileMasterDataDao.saveAndFlush(memberProfileMasterDataEntity);
		}else {
			MemberProfileMasterDataEntity memberProfileMasterDataEntity1 = new MemberProfileMasterDataEntity();
			memberProfileMasterDataEntity1.setCboId(memberProfile.getCbo_id());
			memberProfileMasterDataEntity1.setMemberId(memberProfile.getMember_id());
			memberProfileMasterDataEntity1.setData(json);
			memberProfileMasterDataEntity1.setCreatedBy("SYSTEM_QUEUE");
			memberProfileMasterDataEntity1.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			memberProfileMasterDataDao.saveAndFlush(memberProfileMasterDataEntity1);
		}
	}

	public String decryptEncryptAadhaar(String kycNumber,String guid) {
		System.out.println("starting of decryptEncryptAadhaar(String kycNumber,String guid)");
		SecretKey secretKey = AESPasswordEncoder.secureKeyGeneration(guid);
		IvParameterSpec iv = AESPasswordEncoder.generateIv();
		String plainText = null;
		String result = null;
		try {
			plainText = AESPasswordEncoder.decrypt("AES/CBC/PKCS5Padding", kycNumber, secretKey, iv);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		}
		String orgAadhaarNo =AESPasswordEncoder.removeSaltFromPlainText(plainText);
		System.out.println("x : "+orgAadhaarNo);
		result= EncryptionAadhaarNrlm.finalEncryption(orgAadhaarNo);
		System.out.println("y : "+result);
		System.out.println("ending of decryptEncryptAadhaar(String kycNumber,String guid)");
		return result;
	}
}




