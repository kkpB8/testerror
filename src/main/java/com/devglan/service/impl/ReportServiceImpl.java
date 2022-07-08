/*
 * package com.devglan.service.impl;
 * 
 * import com.devglan.domain.report.LocationMasterPojo; import
 * com.devglan.domain.report.MeetingPojo; import
 * com.devglan.service.ReportService; import com.devglan.tenant.dao.ReportDao;
 * import com.devglan.utils.ProfileTypeConstants; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import java.math.BigDecimal; import java.math.BigInteger; import
 * java.util.ArrayList; import java.util.LinkedList; import java.util.*;
 * 
 * @Service public class ReportServiceImpl implements ReportService { private
 * final ReportDao reportDao;
 * 
 * public ReportServiceImpl(ReportDao reportDao) { this.reportDao = reportDao; }
 * 
 * @Override public List<Map<String,Object>>getLocationByType(String
 * locationType, int locationId) { List<Map<String,Object>>
 * locationMasterPojoList=new LinkedList<>(); for(Object[]
 * locationData:reportDao.getLocationMasterByLocationTypeAndId(locationType,
 * locationId)){ Map<String,Object> data=new HashMap<>();
 * data.put("locationId",locationData[0]);
 * data.put("locationName",locationData[1]); locationMasterPojoList.add(data); }
 * return locationMasterPojoList ; }
 * 
 * 
 * @Override public List<MeetingPojo> getShgMeeting(String locationType, int
 * locationId) { List<MeetingPojo> meetingPojoList = new LinkedList<>(); for
 * (Object[] meetingData : reportDao.getShgMeetingData(locationType,
 * locationId)) { MeetingPojo meetingPojo = new MeetingPojo();
 * meetingPojo.setLocationType((String) meetingData[0]);
 * meetingPojo.setLocationId((Integer) meetingData[1]);
 * meetingPojo.setLocationName((String) meetingData[2]);
 * meetingPojo.setTotalProfile((BigInteger) meetingData[3]);
 * meetingPojo.setTotalMappedProfile((BigInteger) meetingData[4]);
 * meetingPojo.setProfileConductingMeeting((BigInteger) meetingData[5]);
 * meetingPojo.setProfileConductingMeetingPercent((BigDecimal) meetingData[6]);
 * meetingPojoList.add(meetingPojo); } return meetingPojoList; }
 * 
 * @Override public List<Object[]> getVoMeeting(String locationType, int
 * locationId) { return null; }
 * 
 * @Override public List<Object[]> getClfMeeting(String locationType, int
 * locationId) { return null; }
 * 
 * @Override public List<Map<String,Object>> getGenericMeetingData(String
 * profileType, String locationType, int locationId) { List<Map<String,Object>>
 * meetingPojoList=new LinkedList<>(); List<Object[]> meetingDataList=null;
 * switch (profileType){ case ProfileTypeConstants.SHG:
 * meetingDataList=reportDao.getShgMeetingData(locationType,locationId); break;
 * case ProfileTypeConstants.VO:
 * meetingDataList=reportDao.getVoMeetingData(locationType,locationId); break;
 * case ProfileTypeConstants.CLF:
 * meetingDataList=reportDao.getClfMeetingData(locationType,locationId); break;
 * default: throw new RuntimeException("Profile Type not valid"); } for(Object[]
 * meetingData:meetingDataList){ Map<String,Object> data=new HashMap<>();
 * data.put("locationType",meetingData[0]);
 * data.put("locationId",meetingData[1]);
 * data.put("locationName",meetingData[2]);
 * data.put("totalProfile",meetingData[3]);
 * data.put("totalMappedProfile",meetingData[4]);
 * data.put("profileConductingMeeting",meetingData[5]);
 * data.put("profileConductingMeetingPercent",meetingData[6]);
 * meetingPojoList.add(data); } return meetingPojoList ; } }
 */