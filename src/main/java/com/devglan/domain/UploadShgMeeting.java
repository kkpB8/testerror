package com.devglan.domain;

import javax.validation.Valid;

import java.math.BigInteger;
import java.util.List;

public class UploadShgMeeting {

   
    private ShgMtg shgMeeting;
  
    private List<ShgLoanApplication> shgLoanApplicationList;
 
    private List<ShgMemLoan> shgMemberLoanList;



    private List<ShgGroupLoan> shgGroupLoanList;
  
    private List<ShgMcp> shgMcpList;
    
    private String userId;
    private BigInteger processingId;
    private String transactionId;

    public ShgMtg getShgMeeting() {
        return shgMeeting;
    }

    public void setShgMeeting(ShgMtg shgMeeting) {
        this.shgMeeting = shgMeeting;
    }

    

    public List<ShgLoanApplication> getShgLoanApplicationList() {
		return shgLoanApplicationList;
	}

	public void setShgLoanApplicationList(List<ShgLoanApplication> shgLoanApplicationList) {
		this.shgLoanApplicationList = shgLoanApplicationList;
	}

	public List<ShgMemLoan> getShgMemberLoanList() {
		return shgMemberLoanList;
	}

	public void setShgMemberLoanList(List<ShgMemLoan> shgMemberLoanList) {
		this.shgMemberLoanList = shgMemberLoanList;
	}

	public List<ShgGroupLoan> getShgGroupLoanList() {
		return shgGroupLoanList;
	}

	public void setShgGroupLoanList(List<ShgGroupLoan> shgGroupLoanList) {
		this.shgGroupLoanList = shgGroupLoanList;
	}

	public List<ShgMcp> getShgMcpList() {
        return shgMcpList;
    }

    public void setShgMcpList(List<ShgMcp> shgMcpList) {
        this.shgMcpList = shgMcpList;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
    
    
}
