package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefDepartement;

public interface RefDepartementService {
	
	RefDepartement create(RefDepartement refDepartement);
	
	void delete (Long id);
	
	RefDepartement updateRefDepartement(Long id,RefDepartement updateRefDepartement);
	
	RefDepartement getRefDepartement(Long id);
	
	List<RefDepartement> getAllRefDepartements();
	
	Page<RefDepartement> getRefDepartementPage(int page, int size) ;
	


}
