package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;


import com.cmr.IMADWRGH.DTO.RefTypeOrganismeDTO;
import com.cmr.IMADWRGH.Model.RefTypeOrganisme;

@Mapper(componentModel = "spring",uses = {RefOrganismeMapper.class})
public interface RefTypeOrganismeMapper {
  
	
	RefTypeOrganismeDTO toDTO(RefTypeOrganisme entity);
	
	RefTypeOrganisme toEntity(RefTypeOrganismeDTO dto);
	
}
