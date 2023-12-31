package com.devglan.tenant.dao;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devglan.model.CboAddressesDetailsEntity;
import com.devglan.model.TestEntity;


@Repository
public interface TestDao extends CrudRepository<TestEntity, BigInteger> {

   
}
