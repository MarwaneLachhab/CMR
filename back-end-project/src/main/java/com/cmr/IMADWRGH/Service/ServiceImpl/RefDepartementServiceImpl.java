package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefDepartement;
import com.cmr.IMADWRGH.Repository.RefDepartementRepository;
import com.cmr.IMADWRGH.Service.RefDepartementService;

@Service
public class RefDepartementServiceImpl implements RefDepartementService {
	
	private final RefDepartementRepository refDepartementRepository;

	public RefDepartementServiceImpl(RefDepartementRepository refDepartementRepository) {
		this.refDepartementRepository = refDepartementRepository;
	}

	@Override
	public RefDepartement create(RefDepartement refDepartement) {
		return refDepartementRepository.save(refDepartement);
	}

	@Override
	public void delete(Long id) {
		RefDepartement refDepartement =refDepartementRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("RefDepartement non trouver avec l'id : "+id));
		refDepartement.setDeleted(!refDepartement.isDeleted());
		refDepartementRepository.save(refDepartement);
	}

	@Override
	public RefDepartement updateRefDepartement(Long id, RefDepartement updateRefDepartement) {
		refDepartementRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("RefDepartement non trouver avec l'id : "+id));
		    return refDepartementRepository.save(updateRefDepartement);
	}

	@Override
	public RefDepartement getRefDepartement(Long id) {
		return refDepartementRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("RefDepartement non trouver avec l'id : "+id));
	}

	@Override
	public List<RefDepartement> getAllRefDepartements() {
		return refDepartementRepository.findAll();
	}

	@Override
	public Page<RefDepartement> getRefDepartementPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return refDepartementRepository.findAll(pageable);
    }

}
