package com.cmr.IMADWRGH.Service.ServiceImpl;


import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.cmr.IMADWRGH.Exception.ResourceNotFoundException;
import com.cmr.IMADWRGH.Mapper.RefCorpsMapper;
import com.cmr.IMADWRGH.Model.RefCorps;
import com.cmr.IMADWRGH.Repository.RefCorpsRepository;
import com.cmr.IMADWRGH.Service.RefCorpsService;



@Service
public class RefCorpsServiceImpl implements RefCorpsService{
	
	private final RefCorpsRepository refCorpsRepository;
	
	private final RefCorpsMapper refCorpsMapper;


	public RefCorpsServiceImpl(RefCorpsRepository refCorpsRepository, RefCorpsMapper refCorpsMapper) {
		this.refCorpsRepository = refCorpsRepository;
		this.refCorpsMapper = refCorpsMapper;
	}

//	@Override
//	public RefCorpsDTO create(RefCorpsDTO refCorpsDTO) {
//		RefCorps refCorps =refCorpsMapper.toEntity(refCorpsDTO);
//		refCorpsRepository.save(refCorps);
//	return refCorpsMapper.toDTO(refCorps);
//	}
	
	@Override
	public RefCorps create(RefCorps refCorps) {
	return refCorpsRepository.save(refCorps);
	}

	@Override
	public void delete(Long id) {
		RefCorps refCorps=refCorpsRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("RefCorps not found with id : "+id));
		refCorps.setDeleted(!refCorps.isDeleted());
	    refCorpsRepository.save(refCorps);
		
	}

	@Override
	public RefCorps updateRefCorps(Long id, RefCorps updateCorps) {
		refCorpsRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("RefCorps not found with id : "+id));
		return refCorpsRepository.save(updateCorps);
	}

	@Override
	public RefCorps getRefCorps(Long id) {
		return refCorpsRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("RefCorps not found with id : "+id));
	}

	@Override
	public List<RefCorps> getAllRefCorps() {
		return refCorpsRepository.findAll();
	}

	@Override
	public Page<RefCorps> getRefCorpsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return refCorpsRepository.findAll(pageable);
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
