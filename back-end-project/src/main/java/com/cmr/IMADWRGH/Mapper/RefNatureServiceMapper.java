package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;

import com.cmr.IMADWRGH.DTO.RefNatureServiceDTO;
import com.cmr.IMADWRGH.Model.RefNatureService;

@Mapper(componentModel = "spring",uses = {RefTauxAnnuiteMapper.class})
public interface RefNatureServiceMapper {

	
	RefNatureServiceDTO toDTO(RefNatureService entity);
	
	
	RefNatureService toEntity(RefNatureServiceDTO dto);
}
