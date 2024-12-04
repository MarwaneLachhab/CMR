package com.cmr.IMADWRGH.DTO;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefDepartementDTO {
	private Long depID;
	private String depCode;
	private String depLibelle;
	private boolean deleted;
	private List<RefOrganismeDTO> refOrganismes;
}
