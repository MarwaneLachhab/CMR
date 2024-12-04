package com.cmr.IMADWRGH.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefNatureServiceDTO {
	private Long rnsId;
    private String rnsCode;
    private String rnsLibelle;
    private boolean deleted;
    private List<RefTauxAnnuiteDTO> refTauxAnnuites;
}
