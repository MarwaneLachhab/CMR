package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;

import com.cmr.IMADWRGH.DTO.RefRegimeDTO;
import com.cmr.IMADWRGH.Model.RefRegime;

@Mapper(componentModel = "spring", uses = {RefParametersTauxMapper.class, RefTauxAnnuiteMapper.class})
public interface RefRegimeMapper {
	
	RefRegimeDTO toDTO(RefRegime entity);
	
	RefRegime toEntity(RefRegimeDTO dto);

}
