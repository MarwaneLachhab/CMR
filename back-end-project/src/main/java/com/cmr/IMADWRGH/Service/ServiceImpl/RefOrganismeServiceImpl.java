package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefOrganisme;
import com.cmr.IMADWRGH.Repository.RefOrganismeRepository;
import com.cmr.IMADWRGH.Service.RefOrganismeService;

@Service
public class RefOrganismeServiceImpl implements RefOrganismeService{
	
	private final RefOrganismeRepository refOrganismeRepository ;
	
	public RefOrganismeServiceImpl(RefOrganismeRepository refOrganismeRepository) {
		this.refOrganismeRepository = refOrganismeRepository;
	}

	@Override
	public RefOrganisme create(RefOrganisme refOrganisme) {
		return refOrganismeRepository.save(refOrganisme);
	}

	@Override
	public void delete(Long id) {
		RefOrganisme refOrganisme= refOrganismeRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("RefOrganisme not found with id "+id) );
		refOrganisme.setDeleted(!refOrganisme.isDeleted());
		refOrganismeRepository.save(refOrganisme);
	}

	@Override
	public RefOrganisme updateRefOrganisme(Long id, RefOrganisme updateRefOrganisme) {
		refOrganismeRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("RefOrganisme not found with id "+id) );
		return refOrganismeRepository.save(updateRefOrganisme);
	}

	@Override
	public RefOrganisme getRefOrganisme(Long id) {
		return refOrganismeRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("RefOrganisme not found with id "+id) );
	}

	@Override
	public List<RefOrganisme> getAllRefOrganisme() {
		return refOrganismeRepository.findAll();
	}

	@Override
	public Page<RefOrganisme> getRefOrganismePage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refOrganismeRepository.findAll(pageable);
	}

}
