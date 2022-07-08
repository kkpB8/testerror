package com.devglan.tenant.dao;

import com.devglan.model.ShgMtgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface ReportDao extends JpaRepository<ShgMtgEntity, BigInteger> {
    @Query(value="select * from get_location_master(?1,?2)",nativeQuery=true)
    List<Object[]> getLocationMasterByLocationTypeAndId(String locationType,int parentLocationId);

    @Query(value="select * from shg_meeting(?1,?2)",nativeQuery=true)
    List<Object[]> getShgMeetingData(String locationType, int locationId);

    @Query(value="select * from clf_meeting(?1,?2)",nativeQuery=true)
    List<Object[]> getClfMeetingData(String locationType, int locationId);

    @Query(value="select * from vo_meeting(?1,?2)",nativeQuery=true)
    List<Object[]> getVoMeetingData(String locationType, int locationId);
}
