package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;

import com.cmr.IMADWRGH.DTO.RefDepartementDTO;
import com.cmr.IMADWRGH.Model.RefDepartement;

@Mapper(componentModel = "spring", uses = {RefOrganismeMapper.class})
public interface RefDepartementMapper {

	
	RefDepartementDTO toDTO(RefDepartement entity);
	
	RefDepartement toEntiyt(RefDepartementDTO dto);
}
