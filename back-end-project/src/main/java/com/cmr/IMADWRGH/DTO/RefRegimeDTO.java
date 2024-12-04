package com.cmr.IMADWRGH.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefRegimeDTO {
	private Long regId;
    private char regCode;
    private char regLibelle;
    private Date regDateEffet;
    private char regPensionInvalidite;
    private char regAf;
    private char regIr;
    private char regAmo;
    private char regRevalorise;
    private char regRachatCotisation;
    private char regRachatService;
    private int regAgeEligibiliteMin;
    private int regAgeEligibiliteMax;
    private char regDerogationAgeEligibiliteMax;
    private char regPersonnelEtranger;
    private List<RefParametersTauxDTO> refParametersTauxs; 
    private List<RefTauxAnnuiteDTO> refTauxAnnuites;  
    private boolean deleted;
}
