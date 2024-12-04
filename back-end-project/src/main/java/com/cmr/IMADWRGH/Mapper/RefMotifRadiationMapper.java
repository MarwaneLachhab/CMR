package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;

import com.cmr.IMADWRGH.DTO.RefMotifRadiationDTO;
import com.cmr.IMADWRGH.Model.RefMotifRadiation;

@Mapper(componentModel = "spring", uses = {RefTauxAnnuiteMapper.class})
public interface RefMotifRadiationMapper {
	
	RefMotifRadiationDTO toDTO(RefMotifRadiation entity);
	
	RefMotifRadiation toEntity(RefMotifRadiationDTO dto);
	
}
