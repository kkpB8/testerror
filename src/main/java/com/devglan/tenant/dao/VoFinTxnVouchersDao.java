package com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.VoFinTxnVouchersEntity;

public interface VoFinTxnVouchersDao  extends JpaRepository<VoFinTxnVouchersEntity, BigInteger>, JpaSpecificationExecutor<VoFinTxnVouchersEntity>{

}
