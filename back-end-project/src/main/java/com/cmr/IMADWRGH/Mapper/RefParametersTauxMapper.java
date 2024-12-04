package com.cmr.IMADWRGH.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmr.IMADWRGH.DTO.RefParametersTauxDTO;
import com.cmr.IMADWRGH.Model.RefParametersTaux;

@Mapper(componentModel = "spring")
public interface RefParametersTauxMapper {
	
	
    @Mapping(source = "refRegime.regId", target = "refRegimeId")
    @Mapping(source = "rpt_plafond_cotisation", target = "rptPlafondCotisation")
	RefParametersTauxDTO toDTO(RefParametersTaux entity);
	
    @Mapping(source = "refRegimeId", target = "refRegime.regId")
    @Mapping(source = "rptPlafondCotisation", target = "rpt_plafond_cotisation")
	RefParametersTaux toEntity(RefParametersTauxDTO dto);
}
