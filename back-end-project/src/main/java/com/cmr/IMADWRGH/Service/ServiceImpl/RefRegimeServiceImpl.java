package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefRegime;
import com.cmr.IMADWRGH.Repository.RefRegimeRepository;
import com.cmr.IMADWRGH.Service.RefRegimeService;


@Service
public class RefRegimeServiceImpl implements RefRegimeService{
	
	private final RefRegimeRepository refRegimeRepository;
	
	public RefRegimeServiceImpl(RefRegimeRepository refRegimeRepository) {
		this.refRegimeRepository = refRegimeRepository;
	}

	@Override
	public RefRegime create(RefRegime refRegime) {
	
		return refRegimeRepository.save(refRegime);
	}

	@Override
	public void delete(Long id) {
		RefRegime refRegime =refRegimeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("RefRegime not found with"+id));
		refRegime.setDeleted(!refRegime.isDeleted());
		refRegimeRepository.save(refRegime);
	}

	@Override
	public RefRegime updateRefRegime(Long id, RefRegime updateRefRegime) {
		refRegimeRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("RefRegime not found with"+id));
		return refRegimeRepository.save(updateRefRegime);
	}

	@Override
	public RefRegime getRefRegime(Long id) {
		return refRegimeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("RefRegime not found with"+id));
	}

	@Override
	public List<RefRegime> getAll() {
		return refRegimeRepository.findAll();
	}

	@Override
	public Page<RefRegime> getRefRegimePage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refRegimeRepository.findAll(pageable);
	}

}
