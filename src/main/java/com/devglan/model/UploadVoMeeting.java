package com.devglan.model;

import com.devglan.domain.VoGroupLoan;
import com.devglan.domain.VoLoanApplication;
import com.devglan.domain.VoMemLoan;
import com.devglan.domain.VoMtg;

import javax.validation.Valid;
import java.util.List;

public class UploadVoMeeting {

    @Valid
    private com.devglan.domain.VoMtg voMeeting;
    @Valid
    private List<com.devglan.domain.VoLoanApplication> voLoanApplicationList;
    @Valid
    private List<com.devglan.domain.VoMemLoan> voMemberLoanList;


    @Valid
    private List<com.devglan.domain.VoGroupLoan> voGroupLoanList;
    //@Valid
    //private List<ShgMcpUpload> shgMcpList;

    private String transactionId;

    public com.devglan.domain.VoMtg getVoMeeting() {
        return voMeeting;
    }

    public void setVoMeeting(VoMtg voMeeting) {
        this.voMeeting = voMeeting;
    }

    public List<com.devglan.domain.VoLoanApplication> getVoLoanApplicationList() {
        return voLoanApplicationList;
    }

    public void setVoLoanApplicationList(List<VoLoanApplication> voLoanApplicationList) {
        this.voLoanApplicationList = voLoanApplicationList;
    }

    public List<com.devglan.domain.VoMemLoan> getVoMemberLoanList() {
        return voMemberLoanList;
    }

    public void setVoMemberLoanList(List<VoMemLoan> voMemberLoanList) {
        this.voMemberLoanList = voMemberLoanList;
    }

    public List<com.devglan.domain.VoGroupLoan> getVoGroupLoanList() {
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
}
