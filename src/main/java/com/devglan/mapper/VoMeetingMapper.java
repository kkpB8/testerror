package com.devglan.mapper;

import com.devglan.domain.*;
import com.devglan.model.*;
import com.devglan.utils.DateUtils;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;

public class VoMeetingMapper {

    //VO MEETING
    public static VoMtgEntity map(final VoMtg voMtg) {
        ModelMapper modelMapper = new ModelMapper();
        VoMtgEntity voMtgEntity  =
                modelMapper.map(voMtg ,VoMtgEntity.class);
        voMtgEntity.setExpectedDate1(voMtg.getExpectedDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMtg.getExpectedDate()) : null);
        voMtgEntity.setActionOn1(voMtg.getActionOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMtg.getActionOn()) : null);
        voMtgEntity.setMtgDate1(voMtg.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMtg.getMtgDate()) : null);
        voMtgEntity.setCreatedOn1(voMtg.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMtg.getCreatedOn()) : null);
        voMtgEntity.setUpdatedOn1(voMtg.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMtg.getUpdatedOn()) : null);
        return voMtgEntity;
    }

    //VO MEETING DETAILS
    public static VoMtgDetEntity map(final VoMtgDet voMtgDet) {
        ModelMapper modelMapper = new ModelMapper();
        VoMtgDetEntity voMtgDetEntity  =
                modelMapper.map(voMtgDet,VoMtgDetEntity.class);
        voMtgDetEntity.setCreatedOn1(voMtgDet.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMtgDet.getCreatedOn()) : null);
        voMtgDetEntity.setUpdatedOn1(voMtgDet.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMtgDet.getUpdatedOn()) : null);
        
        return voMtgDetEntity;
    }

    //VO FINANCE Transaction
    public static VoFinTxnEntity map(final VoFinTxn voFinTxn) {
        ModelMapper modelMapper = new ModelMapper();
        VoFinTxnEntity voFinTxnEntity  =
                modelMapper.map(voFinTxn,VoFinTxnEntity.class);
        voFinTxnEntity.setCreatedOn1(voFinTxn.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxn.getCreatedOn()) : null);
        voFinTxnEntity.setUpdatedOn1(voFinTxn.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxn.getUpdatedOn()) : null);
        return voFinTxnEntity;
    }

    //VO FINANCE Transaction Detail Group
    public static VoFinTxnDetGrpEntity map(final VoFinTxnDetGrp voFinTxnDetGrp) {
        ModelMapper modelMapper = new ModelMapper();
        VoFinTxnDetGrpEntity voFinTxnDetGrpEntity  =
                modelMapper.map(voFinTxnDetGrp,VoFinTxnDetGrpEntity.class);
        voFinTxnDetGrpEntity.setVoucherDate1(voFinTxnDetGrp.getVoucherDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getVoucherDate()) : null);
        voFinTxnDetGrpEntity.setMtgDate1(voFinTxnDetGrp.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getMtgDate()) : null);
        voFinTxnDetGrpEntity.setDateRealisation1(voFinTxnDetGrp.getDateRealisation()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getDateRealisation()) : null);
        voFinTxnDetGrpEntity.setAddlRefDate1(voFinTxnDetGrp.getAddlRefDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getAddlRefDate()) : null);
        voFinTxnDetGrpEntity.setCreatedOn1(voFinTxnDetGrp.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getCreatedOn()) : null);
        voFinTxnDetGrpEntity.setUpdatedOn1(voFinTxnDetGrp.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetGrp.getUpdatedOn()) : null);
        return voFinTxnDetGrpEntity;
    }

    //VO GROUP LOAN
    public static VoGroupLoanEntity map(final VoGroupLoan voGroupLoan) {
        ModelMapper modelMapper = new ModelMapper();
        VoGroupLoanEntity voGroupLoanEntity  =
                modelMapper.map(voGroupLoan,VoGroupLoanEntity.class);
        voGroupLoanEntity.setInstallmentDate1(voGroupLoan.getInstallmentDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getInstallmentDate()) : null);
        voGroupLoanEntity.setDisbursementDate1(voGroupLoan.getDisbursementDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getDisbursementDate()) : null);
        voGroupLoanEntity.setActualTransactionDate1(voGroupLoan.getActualTransactionDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getActualTransactionDate()) : null);
        voGroupLoanEntity.setMtgDate1(voGroupLoan.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getMtgDate()) : null);
        voGroupLoanEntity.setCreatedOn1(voGroupLoan.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getCreatedOn()) : null);
        voGroupLoanEntity.setUpdatedOn1(voGroupLoan.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoan.getUpdatedOn()) : null);
        return voGroupLoanEntity;
    }
    
  //Vo MEMBER SETTLEMENT @anshul
    public static VoMemSettlementEntity map(final VoMemSettlement voMemSettlement ) {
        ModelMapper modelMapper = new ModelMapper();
        VoMemSettlementEntity voMemSettlementEntity  =
                modelMapper.map(voMemSettlement,VoMemSettlementEntity.class);

        voMemSettlementEntity.setPaymentDate1(voMemSettlement.getPaymentDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemSettlement.getPaymentDate()) : null);

        voMemSettlementEntity.setCreatedOn1(voMemSettlement.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemSettlement.getCreatedOn()) : null);
        voMemSettlementEntity.setUpdatedOn1(voMemSettlement.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemSettlement.getUpdatedOn()) : null);
        voMemSettlementEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return voMemSettlementEntity;
    }

    //VO GROUP LOAN TRANSACTION
    public static VoGroupLoanTxnEntity map(final VoGroupLoanTxn voGroupLoanTxn) {
        ModelMapper modelMapper = new ModelMapper();
        VoGroupLoanTxnEntity voGroupLoanTxnEntity  =
                modelMapper.map(voGroupLoanTxn,VoGroupLoanTxnEntity.class);
        voGroupLoanTxnEntity.setMtgDate1(voGroupLoanTxn.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanTxn.getMtgDate()) : null);
        voGroupLoanTxnEntity.setCreatedOn1(voGroupLoanTxn.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanTxn.getCreatedOn()) : null);
        voGroupLoanTxnEntity.setUpdatedOn1(voGroupLoanTxn.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanTxn.getUpdatedOn()) : null);
        return voGroupLoanTxnEntity;
    }

    //VO LOAN APPLICATION
    public static VoLoanApplicationEntity map(final VoLoanApplication voLoanApplication) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        VoLoanApplicationEntity voLoanApplicationEntity  =
                modelMapper.map(voLoanApplication, VoLoanApplicationEntity.class);
        voLoanApplicationEntity.setRequestDate1(voLoanApplication.getRequestDate()!=null ?
                DateUtils.secondsToTimestampConverter(voLoanApplication.getRequestDate()) : null);
        voLoanApplicationEntity.setApprovalDate1(voLoanApplication.getApprovalDate()!=null ?
                DateUtils.secondsToTimestampConverter(voLoanApplication.getApprovalDate()) : null);
        voLoanApplicationEntity.setTentativeDate1(voLoanApplication.getTentativeDate()!=null ?
                DateUtils.secondsToTimestampConverter(voLoanApplication.getTentativeDate()) : null);
        voLoanApplicationEntity.setCreatedOn1(voLoanApplication.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voLoanApplication.getCreatedOn()) : null);
        voLoanApplicationEntity.setUpdatedOn1(voLoanApplication.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voLoanApplication.getUpdatedOn()) : null);
        return voLoanApplicationEntity;
    }

    //VO MEMBER LOAN
    public static VoMemLoanEntity map(final VoMemLoan voMemLoan) {
        ModelMapper modelMapper = new ModelMapper();
        VoMemLoanEntity voMemLoanEntity  =
                modelMapper.map(voMemLoan,VoMemLoanEntity.class);
        voMemLoanEntity.setInstallmentDate1(voMemLoan.getInstallmentDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoan.getInstallmentDate()) : null);
        voMemLoanEntity.setDisbursementDate1(voMemLoan.getDisbursementDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoan.getDisbursementDate()) : null);
        voMemLoanEntity.setMtgDate1(voMemLoan.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoan.getMtgDate()) : null);
        voMemLoanEntity.setCreatedOn1(voMemLoan.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoan.getCreatedOn()) : null);
        voMemLoanEntity.setUpdatedOn1(voMemLoan.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoan.getUpdatedOn()) : null);
        return voMemLoanEntity;
    }

    //VO MEMBER LOAN TRANSACTION
    public static VoMemLoanTxnEntity map(final VoMemLoanTxn voMemLoanTxn) {
        ModelMapper modelMapper = new ModelMapper();
        VoMemLoanTxnEntity voMemLoanTxnEntity  =
                modelMapper.map(voMemLoanTxn,VoMemLoanTxnEntity.class);
        voMemLoanTxnEntity.setMtgDate1(voMemLoanTxn.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanTxn.getMtgDate()) : null);
        voMemLoanTxnEntity.setCreatedOn1(voMemLoanTxn.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanTxn.getCreatedOn()) : null);
        voMemLoanTxnEntity.setUpdatedOn1(voMemLoanTxn.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanTxn.getUpdatedOn()) : null);
        return voMemLoanTxnEntity;
    }

    //Vo FINANCE TRANSACTION DETAIL MEMEBER
    public static VoFinTxnDetMemEntity map(final VoFinTxnDetMem voFinTxnDetMem) {
        ModelMapper modelMapper = new ModelMapper();
        VoFinTxnDetMemEntity voFinTxnDetMemEntity  =
                modelMapper.map(voFinTxnDetMem,VoFinTxnDetMemEntity.class);
        voFinTxnDetMemEntity.setVoucherDate1(voFinTxnDetMem.getVoucherDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getVoucherDate()) : null);
        voFinTxnDetMemEntity.setDateRealisation1(voFinTxnDetMem.getDateRealisation()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getDateRealisation()) : null);
        voFinTxnDetMemEntity.setMtgDate1(voFinTxnDetMem.getMtgDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getMtgDate()) : null);
        voFinTxnDetMemEntity.setAddlRefDate1(voFinTxnDetMem.getAddlRefDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getAddlRefDate()) : null);
        voFinTxnDetMemEntity.setCreatedOn1(voFinTxnDetMem.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getCreatedOn()) : null);
        voFinTxnDetMemEntity.setUpdatedOn1(voFinTxnDetMem.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnDetMem.getUpdatedOn()) : null);
        return voFinTxnDetMemEntity;
    }

    //VO MEMBER LOAN SCHEDULE
    public static VoMemLoanScheduleEntity map(final VoMemLoanSchedule voMemLoanSchedule) {
        ModelMapper modelMapper = new ModelMapper();
        VoMemLoanScheduleEntity voMemLoanScheduleEntity  =
                modelMapper.map(voMemLoanSchedule,VoMemLoanScheduleEntity.class);
        voMemLoanScheduleEntity.setInstallmentDate1(voMemLoanSchedule.getInstallmentDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanSchedule.getInstallmentDate()) : null);
        voMemLoanScheduleEntity.setLastPaidDate1(voMemLoanSchedule.getLastPaidDate()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanSchedule.getLastPaidDate()) : null);
        voMemLoanScheduleEntity.setCreatedOn1(voMemLoanSchedule.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanSchedule.getCreatedOn()) : null);
        voMemLoanScheduleEntity.setUpdatedOn1(voMemLoanSchedule.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voMemLoanSchedule.getUpdatedOn()) : null);

        return voMemLoanScheduleEntity;
    }

    //VO GROUP LOAN SCHEDULE
    public static VoGroupLoanScheduleEntity map(final VoGroupLoanSchedule voGroupLoanSchedule) {
        ModelMapper modelMapper = new ModelMapper();
        VoGroupLoanScheduleEntity voGroupLoanScheduleEntity  =
                modelMapper.map(voGroupLoanSchedule,VoGroupLoanScheduleEntity.class);
        voGroupLoanScheduleEntity.setInstallmentDate1(voGroupLoanSchedule.getInstallmentDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanSchedule.getInstallmentDate()) : null);
        voGroupLoanScheduleEntity.setLastPaidDate1(voGroupLoanSchedule.getLastPaidDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanSchedule.getLastPaidDate()) : null);
        voGroupLoanScheduleEntity.setLoanDate1(voGroupLoanSchedule.getLoanDate()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanSchedule.getLoanDate()) : null);
        voGroupLoanScheduleEntity.setCreatedOn1(voGroupLoanSchedule.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanSchedule.getCreatedOn()) : null);
        voGroupLoanScheduleEntity.setUpdatedOn1(voGroupLoanSchedule.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voGroupLoanSchedule.getUpdatedOn()) : null);

        return voGroupLoanScheduleEntity;
    }

    public static VoFinTxnVouchersEntity map(final VoFinTxnVouchers voFinTxnVouchers ) {
        ModelMapper modelMapper = new ModelMapper();
        VoFinTxnVouchersEntity voFinTxnVouchersEntity  =
                modelMapper.map(voFinTxnVouchers,VoFinTxnVouchersEntity.class);

        voFinTxnVouchersEntity.setDateRealisation1(voFinTxnVouchers.getDateRealisation()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnVouchers.getDateRealisation()) : null);
        voFinTxnVouchersEntity.setVoucherDate1(voFinTxnVouchers.getVoucherDate()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnVouchers.getVoucherDate()) : null);
        voFinTxnVouchersEntity.setCreatedOn1(voFinTxnVouchers.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnVouchers.getCreatedOn()) : null);
        voFinTxnVouchersEntity.setUpdatedOn1(voFinTxnVouchers.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(voFinTxnVouchers.getUpdatedOn()) : null);
        voFinTxnVouchersEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return voFinTxnVouchersEntity;
    }
    //SHG MCP
    /*public static ShgMcp map(final ShgMcpEntity shgMcpEntity) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMcp shgMcp  =
                modelMapper.map(shgMcpEntity,ShgMcp.class);
        shgMcp.setTentativeDate(shgMcpEntity.getTentativeDate1()!=null ?
                DateUtils.TimestampToSecondsConverterLong(shgMcpEntity.getTentativeDate1()) : null);
        shgMcp.setRequestDate(shgMcpEntity.getRequestDate1()!=null ?
                DateUtils.TimestampToSecondsConverterLong(shgMcpEntity.getRequestDate1()) : null);
        return shgMcp;
    }*/


    // SHG MTG STATUS --- @Author Mohit
    /*public static VoMeetingStatus mapMtgStatus(final VoMtgEntity voMtgEntity) {
        ModelMapper modelMapper = new ModelMapper();
        VoMeetingStatus voMeetingStatus  =
                modelMapper.map(voMtgEntity,VoMeetingStatus.class);

        return voMeetingStatus;
    }

    public static VoMeetingSummary mapSummary(final VoMtgEntity voMtgEntity) {
        ModelMapper modelMapper = new ModelMapper();
        VoMeetingSummary voMeetingSummary  =
                modelMapper.map(voMtgEntity,VoMeetingSummary.class);
        return voMeetingSummary;
    }*/

}
