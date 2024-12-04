package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefMotifRadiation;

public interface RefMotifRadiationService {

	
	RefMotifRadiation create(RefMotifRadiation refMotifRadiation);
	
	void delete (Long id);
	
	RefMotifRadiation updateRefMotifRadiation(Long id,RefMotifRadiation updateRefMotifRadiation);
	
	RefMotifRadiation getRefMotifRadiation(Long id);
	
	List<RefMotifRadiation> getAllRefMotifRadiations();
	
	Page<RefMotifRadiation> getRefMotifRadiationPage(int page, int size) ;

	
	
}
