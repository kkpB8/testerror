package com.devglan.mapper;

import java.sql.Timestamp;

import com.devglan.domain.*;
import com.devglan.model.*;
import org.modelmapper.ModelMapper;

import com.devglan.utils.DateUtils;

public class MeetingMapper {

    //SHG MEETING
    public static ShgMtgEntity map(final ShgMtg shgMtg) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMtgEntity shgMtgEntity  =
                modelMapper.map(shgMtg,ShgMtgEntity.class);
        shgMtgEntity.setMtgDate1(shgMtg.getMtgDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getMtgDate()) : null);
        shgMtgEntity.setExpectedDate1(shgMtg.getExpectedDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getExpectedDate()) : null);
        shgMtgEntity.setActionOn1(shgMtg.getActionOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getActionOn()) : null);
        shgMtgEntity.setCreatedOn1(shgMtg.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getCreatedOn()) : null);
        shgMtgEntity.setUpdatedOn1(shgMtg.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getUpdatedOn()) : null);
        shgMtgEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        shgMtgEntity.setBalanceDate1(shgMtg.getBalanceDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtg.getBalanceDate()) : null);
        return shgMtgEntity;
    }

    //SHG MEETING DETAILS
    public static ShgMtgDetEntity map(final ShgMtgDet shgMtgDet  ) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        ShgMtgDetEntity shgMtgDetEntity  =
                modelMapper.map(shgMtgDet,ShgMtgDetEntity.class);
        shgMtgDetEntity.setCreatedOn1(shgMtgDet.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtgDet.getCreatedOn()) : null);
        shgMtgDetEntity.setUpdatedOn1(shgMtgDet.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMtgDet.getUpdatedOn()) : null);
        shgMtgDetEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMtgDetEntity;
    }

    //SHG FINANCE Transaction
    public static ShgFinTxnEntity map(final ShgFinTxn shgFinTxn ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgFinTxnEntity shgFinTxnEntity =
                modelMapper.map(shgFinTxn,ShgFinTxnEntity.class);
        shgFinTxnEntity.setCreatedOn1(shgFinTxn.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getCreatedOn()) : null);
        shgFinTxnEntity.setUpdatedOn1(shgFinTxn.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getUpdatedOn()) : null);
        shgFinTxnEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        shgFinTxnEntity.setBalanceDate1(shgFinTxn.getBalanceDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getBalanceDate()) : null);
        return shgFinTxnEntity;
    }

    //SHG FINANCE Transaction
    public static ShgFinTxnDetGrpEntity map(final ShgFinTxnDetGrp shgFinTxn) {
        ModelMapper modelMapper = new ModelMapper();
        ShgFinTxnDetGrpEntity shgFinTxnDetGrpEntity  =
                modelMapper.map(shgFinTxn,ShgFinTxnDetGrpEntity.class);
        shgFinTxnDetGrpEntity.setLink_guid(shgFinTxn.getLink_guid());
        shgFinTxnDetGrpEntity.setTransDate1(shgFinTxn.getTransDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getTransDate()) : null);
        shgFinTxnDetGrpEntity.setDateRealisation1(shgFinTxn.getDateRealisation()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getDateRealisation()) : null);
        shgFinTxnDetGrpEntity.setCreatedOn1(shgFinTxn.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getCreatedOn()) : null);
        shgFinTxnDetGrpEntity.setUpdatedOn1(shgFinTxn.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getUpdatedOn()) : null);
        shgFinTxnDetGrpEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        shgFinTxnDetGrpEntity.setEffectiveDate1(shgFinTxn.getEffectiveDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgFinTxn.getEffectiveDate()) : null);
        return shgFinTxnDetGrpEntity;
    }

    //SHG GROUP LOAN
    public static ShgGroupLoanEntity map(final ShgGroupLoan shgGroupLoan) {
        ModelMapper modelMapper = new ModelMapper();
        ShgGroupLoanEntity shgGroupLoanEntity  =
                modelMapper.map(shgGroupLoan,ShgGroupLoanEntity.class);
       
        shgGroupLoanEntity.setInstallmentDate1(shgGroupLoan.getInstallmentDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getInstallmentDate()) : null);
        shgGroupLoanEntity.setMtgDate1(shgGroupLoan.getMtgDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getMtgDate()) : null);
        shgGroupLoanEntity.setCreatedOn1(shgGroupLoan.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getCreatedOn()) : null);
        shgGroupLoanEntity.setActualTransactionDate1(shgGroupLoan.getActualTransactionDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getActualTransactionDate()) : null);
        shgGroupLoanEntity.setUpdatedOn1(shgGroupLoan.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getUpdatedOn()) : null);
        shgGroupLoanEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        shgGroupLoanEntity.setDisbursementDate1(shgGroupLoan.getDisbursementDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getDisbursementDate()) : null);
        shgGroupLoanEntity.setSanctionedDate1(shgGroupLoan.getSanctionedDate()!=null ?
        		DateUtils.secondsToTimestampConverter(shgGroupLoan.getSanctionedDate()) : null);
        return shgGroupLoanEntity;
    }

    //SHG GROUP LOAN TRANSACTION
    public static ShgGroupLoanTxnEntity map(final ShgGroupLoanTxn shgGroupLoanTxn  ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgGroupLoanTxnEntity shgGroupLoanTxnEntity =
                modelMapper.map(shgGroupLoanTxn,ShgGroupLoanTxnEntity.class);
     
        shgGroupLoanTxnEntity.setCreatedOn1(shgGroupLoanTxn.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanTxn.getCreatedOn()) : null);
        shgGroupLoanTxnEntity.setUpdatedOn1(shgGroupLoanTxn.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanTxn.getUpdatedOn()) : null);
        shgGroupLoanTxnEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgGroupLoanTxnEntity;
    }

    //SHG LOAN APPLICATION
    public static ShgLoanApplicationEntity map(final ShgLoanApplication shgLoanApplication ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgLoanApplicationEntity shgLoanApplicationEntity =
                modelMapper.map(shgLoanApplication,ShgLoanApplicationEntity.class);
        shgLoanApplicationEntity.setRequestDate1(shgLoanApplication.getRequestDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgLoanApplication.getRequestDate()) : null);
        shgLoanApplicationEntity.setTentativeDate1(shgLoanApplication.getTentativeDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgLoanApplication.getTentativeDate()) : null);
        shgLoanApplicationEntity.setCreatedOn1(shgLoanApplication.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgLoanApplication.getCreatedOn()) : null);
        shgLoanApplicationEntity.setUpdatedOn1(shgLoanApplication.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgLoanApplication.getUpdatedOn()) : null);
        shgLoanApplicationEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgLoanApplicationEntity;
    }

    //SHG MEMBER LOAN
    public static ShgMemLoanEntity map(final ShgMemLoan shgMemLoan  ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMemLoanEntity shgMemLoanEntity =
                modelMapper.map(shgMemLoan,ShgMemLoanEntity.class);
       
        shgMemLoanEntity.setInstallmentDate1(shgMemLoan.getInstallmentDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoan.getInstallmentDate()) : null);
        shgMemLoanEntity.setMtgDate1(shgMemLoan.getMtgDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoan.getMtgDate()) : null);
        shgMemLoanEntity.setDisbursementDate1(shgMemLoan.getDisbursementDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoan.getDisbursementDate()) : null);
        shgMemLoanEntity.setCreatedOn1(shgMemLoan.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoan.getCreatedOn()) : null);
        shgMemLoanEntity.setUpdatedOn1(shgMemLoan.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoan.getUpdatedOn()) : null);
        shgMemLoanEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMemLoanEntity;
    }

    //SHG MEMBER LOAN TRANSACTION
    public static ShgMemLoanTxnEntity map(final ShgMemLoanTxn shgMemLoanTxn ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMemLoanTxnEntity shgMemLoanTxnEntity  =
                modelMapper.map(shgMemLoanTxn,ShgMemLoanTxnEntity.class);
      
        
        shgMemLoanTxnEntity.setCreatedOn1(shgMemLoanTxn.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanTxn.getCreatedOn()) : null);
        shgMemLoanTxnEntity.setUpdatedOn1(shgMemLoanTxn.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanTxn.getUpdatedOn()) : null);
        shgMemLoanTxnEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMemLoanTxnEntity;
    }

    //SHG FINANCE TRANSACTION DETAIL MEMEBER
    public static ShgFinTxnDetMemEntity map(final ShgFinTxnDetMem shgFinTxnDetMem ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgFinTxnDetMemEntity shgFinTxnDetMemEntity =
                modelMapper.map(shgFinTxnDetMem,ShgFinTxnDetMemEntity.class);
        shgFinTxnDetMemEntity.setTransDate1(shgFinTxnDetMem.getTransDate()!=null ? 
                		DateUtils.secondsToTimestampConverter(shgFinTxnDetMem.getTransDate()) : null);
                shgFinTxnDetMemEntity.setDateRealisation1(shgFinTxnDetMem.getDateRealisation()!=null ? 
                		DateUtils.secondsToTimestampConverter(shgFinTxnDetMem.getDateRealisation()) : null);
                shgFinTxnDetMemEntity.setCreatedOn1(shgFinTxnDetMem.getCreatedOn()!=null ? 
                		DateUtils.secondsToTimestampConverter(shgFinTxnDetMem.getCreatedOn()) : null);
                shgFinTxnDetMemEntity.setUpdatedOn1(shgFinTxnDetMem.getUpdatedOn()!=null ? 
                		DateUtils.secondsToTimestampConverter(shgFinTxnDetMem.getUpdatedOn()) : null);
                shgFinTxnDetMemEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgFinTxnDetMemEntity;
    }

    //SHG MEMBER LOAN SCHEDULE
    public static ShgMemLoanScheduleEntity map(final ShgMemLoanSchedule shgMemLoanSchedule ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMemLoanScheduleEntity shgMemLoanScheduleEntity  =
                modelMapper.map(shgMemLoanSchedule,ShgMemLoanScheduleEntity.class);
        shgMemLoanScheduleEntity.setInstallmentDate1(shgMemLoanSchedule.getInstallmentDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanSchedule.getInstallmentDate()) : null);
        shgMemLoanScheduleEntity.setLastPaidDate1(shgMemLoanSchedule.getLastPaidDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanSchedule.getLastPaidDate()) : null);
        shgMemLoanScheduleEntity.setCreatedOn1(shgMemLoanSchedule.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanSchedule.getCreatedOn()) : null);
        shgMemLoanScheduleEntity.setUpdatedOn1(shgMemLoanSchedule.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMemLoanSchedule.getUpdatedOn()) : null);
        shgMemLoanScheduleEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMemLoanScheduleEntity;
    }

    //SHG GROUP LOAN SCHEDULE
    public static ShgGroupLoanScheduleEntity map(final ShgGroupLoanSchedule shgGroupLoanSchedule  ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgGroupLoanScheduleEntity shgGroupLoanScheduleEntity  =
                modelMapper.map(shgGroupLoanSchedule,ShgGroupLoanScheduleEntity.class);
        shgGroupLoanScheduleEntity.setInstallmentDate1(shgGroupLoanSchedule.getInstallmentDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanSchedule.getInstallmentDate()) : null);
        shgGroupLoanScheduleEntity.setLoanDate1(shgGroupLoanSchedule.getLoanDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanSchedule.getLoanDate()) : null);
        shgGroupLoanScheduleEntity.setLastPaidDate1(shgGroupLoanSchedule.getLastPaidDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanSchedule.getLastPaidDate()) : null);
        shgGroupLoanScheduleEntity.setCreatedOn1(shgGroupLoanSchedule.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanSchedule.getCreatedOn()) : null);
        shgGroupLoanScheduleEntity.setUpdatedOn1(shgGroupLoanSchedule.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgGroupLoanSchedule.getUpdatedOn()) : null);
        shgGroupLoanScheduleEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgGroupLoanScheduleEntity;
    }

    //SHG MCP
    public static ShgMcpEntity map(final ShgMcp shgMcp  ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMcpEntity shgMcpEntity  =
                modelMapper.map(shgMcp,ShgMcpEntity.class);
        
        shgMcpEntity.setTentativeDate1(shgMcp.getTentativeDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMcp.getTentativeDate()) : null);
        shgMcpEntity.setRequestDate1(shgMcp.getRequestDate()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMcp.getRequestDate()) : null);
        shgMcpEntity.setCreatedOn1(shgMcp.getCreatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMcp.getCreatedOn()) : null);
        shgMcpEntity.setUpdatedOn1(shgMcp.getUpdatedOn()!=null ? 
        		DateUtils.secondsToTimestampConverter(shgMcp.getUpdatedOn()) : null);
        shgMcpEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMcpEntity;
    }

  //SHG MEMBER SETTLEMENT @mohit
    public static ShgMemSettlementEntity map(final ShgMemSettlement shgMemSettlement ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgMemSettlementEntity shgMemSettlementEntity  =
                modelMapper.map(shgMemSettlement,ShgMemSettlementEntity.class);

        shgMemSettlementEntity.setPaymentDate1(shgMemSettlement.getPaymentDate()!=null ?
                DateUtils.secondsToTimestampConverter(shgMemSettlement.getPaymentDate()) : null);

        shgMemSettlementEntity.setCreatedOn1(shgMemSettlement.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(shgMemSettlement.getCreatedOn()) : null);
        shgMemSettlementEntity.setUpdatedOn1(shgMemSettlement.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(shgMemSettlement.getUpdatedOn()) : null);
        shgMemSettlementEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return shgMemSettlementEntity;
    }
    //SHG MEMBER SETTLEMENT @Anshul
    public static ShgFinTxnVouchersEntity map(final ShgFinTxnVouchers shgFinTxnVouchers ) {
        ModelMapper modelMapper = new ModelMapper();
        ShgFinTxnVouchersEntity ShgFinTxnVouchersEntity  =
                modelMapper.map(shgFinTxnVouchers,ShgFinTxnVouchersEntity.class);

        ShgFinTxnVouchersEntity.setDateRealisation1(shgFinTxnVouchers.getDateRealisation()!=null ?
                DateUtils.secondsToDateConverterLong(shgFinTxnVouchers.getDateRealisation()) : null);
        ShgFinTxnVouchersEntity.setVoucherDate1(shgFinTxnVouchers.getVoucherDate()!=null ?
                DateUtils.secondsToDateConverterLong(shgFinTxnVouchers.getVoucherDate()) : null);
        ShgFinTxnVouchersEntity.setCreatedOn1(shgFinTxnVouchers.getCreatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(shgFinTxnVouchers.getCreatedOn()) : null);
        ShgFinTxnVouchersEntity.setUpdatedOn1(shgFinTxnVouchers.getUpdatedOn()!=null ?
                DateUtils.secondsToTimestampConverter(shgFinTxnVouchers.getUpdatedOn()) : null);
        ShgFinTxnVouchersEntity.setUploadedOn(new Timestamp(System.currentTimeMillis()));
        return ShgFinTxnVouchersEntity;
    }
}

