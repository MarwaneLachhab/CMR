package com.cmr.IMADWRGH.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cmr.IMADWRGH.Model.RefTauxAnnuite;

public interface RefTauxAnnuiteService {

	RefTauxAnnuite create(RefTauxAnnuite refTauxAnnuite   );
	
	void delete (Long id);
	
	RefTauxAnnuite updateRefTauxAnnuite  (Long id, RefTauxAnnuite updateRefTauxAnnuite  );
	
	RefTauxAnnuite getRefTauxAnnuite (Long id);
	
	List<RefTauxAnnuite> getAll  ();
	
	Page<RefTauxAnnuite> getRefTauxAnnuitePage(int page, int size) ;

}
