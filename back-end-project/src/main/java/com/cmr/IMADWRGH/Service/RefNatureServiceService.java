package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefNatureService;

public interface RefNatureServiceService {
	
	RefNatureService create(RefNatureService refNatureService);
	
	void delete (Long id);
	
	RefNatureService updateRefNatureService(Long id,RefNatureService updateRefNatureService);
	
	RefNatureService getRefNatureService(Long id);
	
	List<RefNatureService> getAllRefNatureService();
	
	Page<RefNatureService> getRefNatureServicePage(int page, int size) ;

	
}
