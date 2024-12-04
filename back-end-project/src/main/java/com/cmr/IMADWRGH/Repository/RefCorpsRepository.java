package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefCorps;

@Repository
public interface RefCorpsRepository  extends JpaRepository<RefCorps, Long>{

}
