package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefOrganisme;

@Repository
public interface RefOrganismeRepository  extends JpaRepository<RefOrganisme, Long>{

}
