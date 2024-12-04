package com.cmr.IMADWRGH.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefTauxAnnuiteDTO {
	 private Long regID;
	    private Date regDateDebut;
	    private Date regDateFin;
	    private Date regDateEffet;
	    private double regTaux;
	    private Long refRegimeId;
	    private Long refMotifRadiationId;
	    private Long refNatureServiceId;
	    private boolean deleted;
}
