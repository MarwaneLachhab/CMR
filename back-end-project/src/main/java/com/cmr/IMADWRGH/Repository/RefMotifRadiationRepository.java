package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefMotifRadiation;

@Repository
public interface RefMotifRadiationRepository  extends JpaRepository<RefMotifRadiation, Long>{

}
