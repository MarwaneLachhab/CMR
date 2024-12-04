package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefTauxAnnuite;
import com.cmr.IMADWRGH.Repository.RefTauxAnnuiteRepository;
import com.cmr.IMADWRGH.Service.RefTauxAnnuiteService;


@Service
public class RefTauxAnnuiteServiceImpl implements RefTauxAnnuiteService{
	private final RefTauxAnnuiteRepository refTauxAnnuiteRepository;
	
	public RefTauxAnnuiteServiceImpl(RefTauxAnnuiteRepository refTauxAnnuiteRepository) {
		this.refTauxAnnuiteRepository = refTauxAnnuiteRepository;
	}

	@Override
	public RefTauxAnnuite create(RefTauxAnnuite refTauxAnnuite) {
		return refTauxAnnuiteRepository.save(refTauxAnnuite);
	}

	@Override
	public void delete(Long id) {
		RefTauxAnnuite refTauxAnnuite= refTauxAnnuiteRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("RefTauxAnnuite not found with "+id));
		refTauxAnnuite.setDeleted(!refTauxAnnuite.isDeleted());
		refTauxAnnuiteRepository.save(refTauxAnnuite);
	}

	@Override
	public RefTauxAnnuite updateRefTauxAnnuite(Long id, RefTauxAnnuite updateRefTauxAnnuite) {
		refTauxAnnuiteRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("RefTauxAnnuite not found with "+id));
		return refTauxAnnuiteRepository.save(updateRefTauxAnnuite);
	}

	@Override
	public RefTauxAnnuite getRefTauxAnnuite(Long id) {
		return refTauxAnnuiteRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("RefTauxAnnuite not found with "+id));
	}

	@Override
	public List<RefTauxAnnuite> getAll() {
		return refTauxAnnuiteRepository.findAll();
	}

	@Override
	public Page<RefTauxAnnuite> getRefTauxAnnuitePage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refTauxAnnuiteRepository.findAll(pageable);
	}

	

}
