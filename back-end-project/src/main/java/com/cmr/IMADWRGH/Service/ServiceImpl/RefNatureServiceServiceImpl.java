package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefNatureService;
import com.cmr.IMADWRGH.Repository.RefNatureServiceRepository;
import com.cmr.IMADWRGH.Service.RefNatureServiceService;

@Service
public class RefNatureServiceServiceImpl implements RefNatureServiceService {
	
	private final RefNatureServiceRepository refNatureServiceRepository;
	
	public RefNatureServiceServiceImpl(RefNatureServiceRepository refNatureServiceRepository) {
		this.refNatureServiceRepository = refNatureServiceRepository;
	}

	@Override
	public RefNatureService create(RefNatureService refNatureService) {
		return refNatureServiceRepository.save(refNatureService);
	}

	@Override
	public void delete(Long id) {
		RefNatureService refNatureService =refNatureServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("RefNatureService not found with id"+id) );
		refNatureService.setDeleted(!refNatureService.isDeleted());
		 refNatureServiceRepository.save(refNatureService);
	}

	@Override
	public RefNatureService updateRefNatureService(Long id, RefNatureService updateRefNatureService) {
		refNatureServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("RefNatureService not found with id"+id) );
		return refNatureServiceRepository.save(updateRefNatureService);
	}

	@Override
	public RefNatureService getRefNatureService(Long id) {
		return refNatureServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("RefNatureService not found with id"+id) );
	}

	@Override
	public List<RefNatureService> getAllRefNatureService() {
		return refNatureServiceRepository.findAll();
	}

	@Override
	public Page<RefNatureService> getRefNatureServicePage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refNatureServiceRepository.findAll(pageable);
	}

}
