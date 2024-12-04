package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefCorps;

public interface RefCorpsService {
	
	RefCorps create(RefCorps refCorps);
	
	void delete (Long id);
	
	RefCorps updateRefCorps(Long id,RefCorps updateCorps);
	
	RefCorps getRefCorps(Long id);
	
	List<RefCorps> getAllRefCorps();
	
	Page<RefCorps> getRefCorpsPage(int page, int size) ;
	
}
