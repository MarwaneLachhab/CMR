package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmr.IMADWRGH.DTO.RefTauxAnnuiteDTO;
import com.cmr.IMADWRGH.Model.RefTauxAnnuite;

@Mapper(componentModel = "spring")
public interface RefTauxAnnuiteMapper {
	
	@Mapping(source = "refMotifRadiation.rmrId", target = "refMotifRadiationId")
	@Mapping(source = "refRegime.regId", target = "refRegimeId")
	@Mapping(source = "refNatureService.rnsId", target = "refNatureServiceId")
	RefTauxAnnuiteDTO toDTO(RefTauxAnnuite entity);
	
	@Mapping(source = "refMotifRadiationId", target = "refMotifRadiation.rmrId")
	@Mapping(source = "refRegimeId", target = "refRegime.regId")
	@Mapping(source = "refNatureServiceId", target = "refNatureService.rnsId")
	RefTauxAnnuite toEntity(RefTauxAnnuiteDTO dto);
}
