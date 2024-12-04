package com.cmr.IMADWRGH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.IMADWRGH.Model.RefTypeOrganisme;

@Repository
public interface RefTypeOrganismeRepository extends JpaRepository<RefTypeOrganisme, Long> {

}
