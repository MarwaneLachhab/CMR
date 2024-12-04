package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefTypeOrganisme;
import com.cmr.IMADWRGH.Repository.RefTypeOrganismeRepository;
import com.cmr.IMADWRGH.Service.RefTypeOrganismeService;


@Service
public class RefTypeOrganismeServiceImpl implements RefTypeOrganismeService{
	
	private final RefTypeOrganismeRepository refTypeOrganismeRepository;
	
	public RefTypeOrganismeServiceImpl(RefTypeOrganismeRepository refTypeOrganismeRepository) {
		this.refTypeOrganismeRepository = refTypeOrganismeRepository;
	}

	@Override
	public RefTypeOrganisme create(RefTypeOrganisme refTypeOrganisme) {
		return refTypeOrganismeRepository.save(refTypeOrganisme);
	}

	@Override
	public void delete(Long id) {
		RefTypeOrganisme refTypeOrganisme=refTypeOrganismeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("RefTypeOrganisme not found with "+id));
		refTypeOrganisme.setDeleted(!refTypeOrganisme.isDeleted());
		
	}

	@Override
	public RefTypeOrganisme updateRefTypeOrganisme(Long id, RefTypeOrganisme updateRefTypeOrganisme) {
		refTypeOrganismeRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("RefTypeOrganisme not found with "+id));
		return refTypeOrganismeRepository.save(updateRefTypeOrganisme);
	}

	@Override
	public RefTypeOrganisme getRefTypeOrganisme(Long id) {
		return refTypeOrganismeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("RefTypeOrganisme not found with "+id));
	}

	@Override
	public List<RefTypeOrganisme> getAll() {
		return refTypeOrganismeRepository.findAll();
	}

	@Override
	public Page<RefTypeOrganisme> getRefTypeOrganismePage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refTypeOrganismeRepository.findAll(pageable);
	}

}
