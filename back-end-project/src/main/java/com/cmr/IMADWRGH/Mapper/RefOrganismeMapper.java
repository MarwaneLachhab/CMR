package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.cmr.IMADWRGH.DTO.RefOrganismeDTO;
import com.cmr.IMADWRGH.Model.RefOrganisme;

@Mapper(componentModel = "spring", uses = {RefDepartementMapper.class, RefTypeOrganismeMapper.class})
public interface RefOrganismeMapper {

	@Mapping(source = "refDepartement.depID", target = "refDepartementId")
	@Mapping(source = "refTypeOrganisme.torID", target = "refTypeOrganismeId")
    RefOrganismeDTO toDTO(RefOrganisme entity);

	@Mapping(source = "refDepartementId", target = "refDepartement.depID")
	@Mapping(source = "refTypeOrganismeId", target = "refTypeOrganisme.torID")
    RefOrganisme toEntity(RefOrganismeDTO dto);
}