package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefTypeOrganisme;

public interface RefTypeOrganismeService {

	RefTypeOrganisme create(RefTypeOrganisme refTypeOrganisme    );
	
	void delete (Long id);
	
	RefTypeOrganisme updateRefTypeOrganisme  (Long id, RefTypeOrganisme updateRefTypeOrganisme   );
	
	RefTypeOrganisme getRefTypeOrganisme (Long id);
	
	List<RefTypeOrganisme> getAll  ();
	
	Page<RefTypeOrganisme> getRefTypeOrganismePage(int page, int size) ;

}
