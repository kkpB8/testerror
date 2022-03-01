package com.devglan.tenant.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devglan.model.TransactionStatusEntity;

@Repository
public interface TransactionStatusDao  extends JpaRepository<TransactionStatusEntity, BigInteger> {

    @Query("FROM TransactionStatusEntity c WHERE c.userId = :userId AND c.readFlag= :readFlag")
    List<TransactionStatusEntity> fetchByUserIdAndReadFlag(@Param("userId") final String userId, @Param("readFlag") final Boolean readFlag
    );
    
    @Query(nativeQuery = true,value = "select * from transaction_status c WHERE c.transaction_id = :transactionId ORDER BY id desc LIMIT 1")
    TransactionStatusEntity fetchByTransactionId(@Param("transactionId") final String transactionId
    );
    
    @Query(nativeQuery = true,value = "select * from transaction_status c WHERE c.processing_id = :processing_id ORDER BY id desc LIMIT 1")
    TransactionStatusEntity fetchByProcessingId(@Param("processing_id") final BigInteger processing_id
    );
    


}
