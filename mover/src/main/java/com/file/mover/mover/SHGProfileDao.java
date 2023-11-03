package com.file.mover.mover;


import com.file.mover.mover.entity.ShgProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SHGProfileDao extends JpaRepository<ShgProfileEntity, BigInteger> {



}
