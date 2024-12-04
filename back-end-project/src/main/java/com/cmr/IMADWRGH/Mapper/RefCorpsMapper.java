package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;

import com.cmr.IMADWRGH.DTO.RefCorpsDTO;
import com.cmr.IMADWRGH.Model.RefCorps;

@Mapper(componentModel = "spring")
public interface RefCorpsMapper {
	
	RefCorpsDTO toDTO(RefCorps entity);
	
	RefCorps toEntity(RefCorpsDTO dto);

}
