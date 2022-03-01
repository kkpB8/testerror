package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.DocumentDetailsEntity;

import java.math.BigInteger;

public interface DocumentDetailsDao extends JpaRepository<DocumentDetailsEntity, BigInteger> {

}
