package com.devglan.domain;

import javax.validation.Valid;

import java.math.BigInteger;
import java.util.List;

public class UploadVoMeeting {

    @Valid
    private VoMtg voMeeting;
    @Valid
    private List<VoLoanApplication> voLoanApplicationList;
    @Valid
    private List<VoMemLoan> voMemberLoanList;


    @Valid
    private List<VoGroupLoan> voGroupLoanList;
    //@Valid
    //private List<ShgMcpUpload> shgMcpList;
    
    private String userId;
    private BigInteger processingId;
    

    private String transactionId;

    public VoMtg getVoMeeting() {
        return voMeeting;
    }

    public void setVoMeeting(VoMtg voMeeting) {
        this.voMeeting = voMeeting;
    }

    public List<VoLoanApplication> getVoLoanApplicationList() {
        return voLoanApplicationList;
    }

    public void setVoLoanApplicationList(List<VoLoanApplication> voLoanApplicationList) {
        this.voLoanApplicationList = voLoanApplicationList;
    }

    public List<VoMemLoan> getVoMemberLoanList() {
        return voMemberLoanList;
    }

    public void setVoMemberLoanList(List<VoMemLoan> voMemberLoanList) {
        this.voMemberLoanList = voMemberLoanList;
    }

    public List<VoGroupLoan> getVoGroupLoanList() {
        return voGroupLoanList;
    }

    public void setVoGroupLoanList(List<VoGroupLoan> voGroupLoanList) {
        this.voGroupLoanList = voGroupLoanList;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigInteger getProcessingId() {
		return processingId;
	}

	public void setProcessingId(BigInteger processingId) {
		this.processingId = processingId;
	}
    
    
}
