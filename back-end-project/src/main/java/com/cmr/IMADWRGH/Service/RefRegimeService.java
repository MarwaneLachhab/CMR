package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefRegime;

public interface RefRegimeService {

	 RefRegime create( RefRegime refRegime    );
	
	void delete (Long id);
	
	 RefRegime updateRefRegime  (Long id, RefRegime updateRefRegime   );
	
	 RefRegime getRefRegime (Long id);
	
	List< RefRegime> getAll  ();
	
	Page<RefRegime> getRefRegimePage(int page, int size) ;

}
