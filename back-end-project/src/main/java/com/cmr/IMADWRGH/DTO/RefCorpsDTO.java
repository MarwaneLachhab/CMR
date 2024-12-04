package com.cmr.IMADWRGH.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefCorpsDTO {
	    private Long crpId;
	    private String crpCode;
	    private String crpDesignation;
	    private byte crpLimiteAge;
	    private int crpGradeMin;
	    private int crpGradeMax;
	    private boolean deleted;

	
}
