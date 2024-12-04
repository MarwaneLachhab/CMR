package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefDepartement;

@Repository
public interface RefDepartementRepository extends JpaRepository<RefDepartement,Long> {

}
