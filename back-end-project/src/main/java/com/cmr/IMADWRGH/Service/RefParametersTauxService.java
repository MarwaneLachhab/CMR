package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefParametersTaux;

public interface RefParametersTauxService {

	RefParametersTaux create(RefParametersTaux refParametersTaux    );
	
	void delete (Long id);
	
	RefParametersTaux updateRefParametersTaux  (Long id, RefParametersTaux updaParametersTaux   );
	
	RefParametersTaux getRefParametersTaux (Long id);
	
	List<RefParametersTaux> getAll  ();
	
	Page<RefParametersTaux> getRefParametersTauxPage(int page, int size) ;

}
