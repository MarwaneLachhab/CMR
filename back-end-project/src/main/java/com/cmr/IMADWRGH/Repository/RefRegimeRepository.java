package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefRegime;

@Repository
public interface RefRegimeRepository  extends JpaRepository<RefRegime, Long>{

}