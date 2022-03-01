package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_mtg_det")
public class VoMtgDetEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

	@Column(name = "vo_mtg_uid", nullable = false)
    private BigInteger voMtgUid;
	
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mem_id", nullable = false)
    private BigInteger memId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "mtg_date")
    private Timestamp mtgDate1;

    @Column(name = "s_no", nullable = false)
    private Integer sNo;

    @Column(name = "child_cbo_name")
    private String childCboName;

    @Column(name = "attendance")
    private String attendance;

    @Column(name = "ec1")
    private String ec1;
	
	@Column(name = "ec2")
    private String ec2;
	
	@Column(name = "ec3")
    private String ec3;
	
	@Column(name = "ec4")
    private String ec4;
	
	@Column(name = "ec5")
    private String ec5;

    @Column(name = "attendance_other")
    private Integer attendanceOther;

    @Column(name = "attendance_external")
    private Integer attendanceExternal;

    @Column(name = "status")
    private String status;

    @Column(name = "zero_mtg_attn")
    private Integer zeroMtgAttn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn1;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn1;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    @Column(name = "uploaded_on")
    private Timestamp uploadedOn;
    
    @Column(name = "sav_comp_ob")
    private Integer savCompOb;

    @Column(name = "sav_comp_cb")
    private Integer savCompCb;

    @Column(name = "sav_comp")
    private Integer savComp;

    @Column(name = "sav_comp_withdrawal")
    private Integer savCompWithdrawal;

    @Column(name = "sav_vol_ob")
    private Integer savVolOb;

    @Column(name = "sav_vol")
    private Integer savVol;

    @Column(name = "sav_vol_cb")
    private Integer savVolCb;

    @Column(name = "sav_vol_withdrawal")
    private Integer savVolWithdrawal;

    @Column(name = "penalty")
    private Integer penalty;
    
    @Column(name = "settlement_status")
    private Short settlementStatus;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getVoMtgUid() {
        return voMtgUid;
    }

    public void setVoMtgUid(BigInteger voMtgUid) {
        this.voMtgUid = voMtgUid;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getMemId() {
        return memId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
    }

   

    public String getChildCboName() {
        return childCboName;
    }

    public void setChildCboName(String childCboName) {
        this.childCboName = childCboName;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

   

    public Integer getAttendanceOther() {
        return attendanceOther;
    }

    public void setAttendanceOther(Integer attendanceOther) {
        this.attendanceOther = attendanceOther;
    }

    public Integer getAttendanceExternal() {
        return attendanceExternal;
    }

    public void setAttendanceExternal(Integer attendanceExternal) {
        this.attendanceExternal = attendanceExternal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getZeroMtgAttn() {
        return zeroMtgAttn;
    }

    public void setZeroMtgAttn(Integer zeroMtgAttn) {
        this.zeroMtgAttn = zeroMtgAttn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Timestamp getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Timestamp uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    
    public Integer getSavCompOb() {
		return savCompOb;
	}

	public void setSavCompOb(Integer savCompOb) {
		this.savCompOb = savCompOb;
	}

	public Integer getSavCompCb() {
		return savCompCb;
	}

	public void setSavCompCb(Integer savCompCb) {
		this.savCompCb = savCompCb;
	}

	public Integer getSavComp() {
		return savComp;
	}

	public void setSavComp(Integer savComp) {
		this.savComp = savComp;
	}

	public Integer getSavCompWithdrawal() {
		return savCompWithdrawal;
	}

	public void setSavCompWithdrawal(Integer savCompWithdrawal) {
		this.savCompWithdrawal = savCompWithdrawal;
	}

	public Integer getSavVolOb() {
		return savVolOb;
	}

	public void setSavVolOb(Integer savVolOb) {
		this.savVolOb = savVolOb;
	}

	public Integer getSavVol() {
		return savVol;
	}

	public void setSavVol(Integer savVol) {
		this.savVol = savVol;
	}

	public Integer getSavVolCb() {
		return savVolCb;
	}

	public void setSavVolCb(Integer savVolCb) {
		this.savVolCb = savVolCb;
	}

	public Integer getSavVolWithdrawal() {
		return savVolWithdrawal;
	}

	public void setSavVolWithdrawal(Integer savVolWithdrawal) {
		this.savVolWithdrawal = savVolWithdrawal;
	}

	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	
	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	

	public String getEc1() {
		return ec1;
	}

	public void setEc1(String ec1) {
		this.ec1 = ec1;
	}

	public String getEc2() {
		return ec2;
	}

	public void setEc2(String ec2) {
		this.ec2 = ec2;
	}

	public String getEc3() {
		return ec3;
	}

	public void setEc3(String ec3) {
		this.ec3 = ec3;
	}

	public String getEc4() {
		return ec4;
	}

	public void setEc4(String ec4) {
		this.ec4 = ec4;
	}

	public String getEc5() {
		return ec5;
	}

	public void setEc5(String ec5) {
		this.ec5 = ec5;
	}
	
	

	public Short getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(Short settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	@Override
    public String toString() {
        return "ShgMtgDetEntity{" +
                "uid=" + uid + '\'' +
			    "voMtgUid=" + voMtgUid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
				"sNo=" + sNo + '\'' +
				"childCboName=" + childCboName + '\'' +
                "status=" + status + '\'' +
				"attendance=" + attendance + '\'' +
				"ec1=" + ec1 + '\'' +
				"ec2=" + ec2 + '\'' +
				"ec3=" + ec3 + '\'' +
				"ec4=" + ec4 + '\'' +
				"ec5=" + ec5 + '\'' +
				"attendanceOther=" + attendanceOther + '\'' +
				"attendanceExternal=" + attendanceExternal	 + '\'' +
                "zeroMtgAttn=" + zeroMtgAttn + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
    }

}