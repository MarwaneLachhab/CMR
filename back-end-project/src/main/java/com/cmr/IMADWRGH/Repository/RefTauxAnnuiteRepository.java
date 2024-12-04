package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefTauxAnnuite;

@Repository
public interface RefTauxAnnuiteRepository  extends JpaRepository<RefTauxAnnuite, Long>{

}
