package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefNatureService;

@Repository
public interface RefNatureServiceRepository  extends JpaRepository<RefNatureService, Long>{

}