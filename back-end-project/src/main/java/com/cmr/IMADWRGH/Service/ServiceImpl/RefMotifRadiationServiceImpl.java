package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.cmr.IMADWRGH.Model.RefMotifRadiation;
import com.cmr.IMADWRGH.Repository.RefMotifRadiationRepository;
import com.cmr.IMADWRGH.Service.RefMotifRadiationService;
import com.cmr.IMADWRGH.Exception.*;


@Service
public class RefMotifRadiationServiceImpl implements RefMotifRadiationService{
	
	
	private final RefMotifRadiationRepository refMotifRadiationRepository;

	public RefMotifRadiationServiceImpl(RefMotifRadiationRepository refMotifRadiationRepository) {
		this.refMotifRadiationRepository = refMotifRadiationRepository;
	}

	@Override
	public RefMotifRadiation create(RefMotifRadiation refMotifRadiation) {
		return refMotifRadiationRepository.save(refMotifRadiation);
	}

	@Override
	public void delete(Long id) {
	RefMotifRadiation refMotifRadiation=	refMotifRadiationRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("RefMotifRadiation not found with id "+id) );
		refMotifRadiation.setDeleted(!refMotifRadiation.isDeleted());
		refMotifRadiationRepository.save(refMotifRadiation);
		
	}

	@Override
	public RefMotifRadiation updateRefMotifRadiation(Long id, RefMotifRadiation updateRefMotifRadiation) {
	refMotifRadiationRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("RefMotifRadiation not found with id"+id) );
	return refMotifRadiationRepository.save(updateRefMotifRadiation);
	}

	@Override
	public RefMotifRadiation getRefMotifRadiation(Long id) {
		return refMotifRadiationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("RefMotifRadiation not found with id"+id) );
	}

	@Override
	public List<RefMotifRadiation> getAllRefMotifRadiations() {
		return refMotifRadiationRepository.findAll();
	}

	@Override
	public Page<RefMotifRadiation> getRefMotifRadiationPage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refMotifRadiationRepository.findAll(pageable);
	}

	

}
