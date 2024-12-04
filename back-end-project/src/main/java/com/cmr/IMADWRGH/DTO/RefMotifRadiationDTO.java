package com.cmr.IMADWRGH.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefMotifRadiationDTO {

	 private Long rmrId;
	    private String rmrCode;
	    private String rmrLibelle;
	    private boolean deleted;
	    private List<RefTauxAnnuiteDTO> refTauxAnnuites;
}
