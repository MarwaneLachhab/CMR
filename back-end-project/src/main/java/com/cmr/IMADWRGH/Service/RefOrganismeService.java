package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefOrganisme;

public interface RefOrganismeService {

	RefOrganisme create(RefOrganisme rerfOrganisme    );
	
	void delete (Long id);
	
	RefOrganisme updateRefOrganisme  (Long id, RefOrganisme updateRefOrganisme  );
	
	RefOrganisme getRefOrganisme (Long id);
	
	List<RefOrganisme > getAllRefOrganisme();
	
	Page<RefOrganisme> getRefOrganismePage(int page, int size) ;

}
