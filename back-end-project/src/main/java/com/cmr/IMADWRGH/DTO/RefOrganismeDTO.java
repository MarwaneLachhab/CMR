package com.cmr.IMADWRGH.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefOrganismeDTO {
	 private Long orgId;
	    private String orgCode;
	    private String orgLibelle;
	    private Date orgDateCreation;
	    private Date orgDateFermeture;
	    private String orgAdresse;
	    private String orgImputation;
	    private String orgImputationG;
	    private String orgPayeur;
	    private Long refTypeOrganismeId;
	    private Long refDepartementId;
	    private boolean deleted;
}
