package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefParametersTaux;

@Repository
public interface RefParametersTauxRepository  extends JpaRepository<RefParametersTaux, Long>{

}
