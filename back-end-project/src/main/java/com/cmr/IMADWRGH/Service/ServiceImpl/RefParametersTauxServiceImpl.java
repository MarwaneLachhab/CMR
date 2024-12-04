package com.cmr.IMADWRGH.Service.ServiceImpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Model.RefParametersTaux;
import com.cmr.IMADWRGH.Repository.RefParametersTauxRepository;
import com.cmr.IMADWRGH.Service.RefParametersTauxService;


@Service
public class RefParametersTauxServiceImpl  implements RefParametersTauxService{
	
	
	private final RefParametersTauxRepository refParametersTauxRepository;
	
	public RefParametersTauxServiceImpl(RefParametersTauxRepository refParametersTauxRepository) {
		this.refParametersTauxRepository = refParametersTauxRepository;
	}

	@Override
	public RefParametersTaux create(RefParametersTaux refParametersTaux) {
		return refParametersTauxRepository.save(refParametersTaux);
	}

	@Override
	public void delete(Long id) {
		RefParametersTaux refParametersTaux=refParametersTauxRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("RefParametersTaux not found with id"+id) );
		refParametersTaux.setDeleted(!refParametersTaux.isDeleted());
	}

	@Override
	public RefParametersTaux updateRefParametersTaux(Long id, RefParametersTaux updaParametersTaux) {
		refParametersTauxRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("RefParametersTaux not found with id"+id) );
		return refParametersTauxRepository.save(updaParametersTaux);
	}

	@Override
	public RefParametersTaux getRefParametersTaux(Long id) {
		return refParametersTauxRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("RefParametersTaux not found with id"+id) );
	}

	@Override
	public List<RefParametersTaux> getAll() {
		return refParametersTauxRepository.findAll();
	}

	@Override
	public Page<RefParametersTaux> getRefParametersTauxPage(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return refParametersTauxRepository.findAll(pageable);
	}

}
