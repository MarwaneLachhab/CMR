package com.cmr.IMADWRGH.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefTypeOrganismeDTO {
	 	private Long torID;
	    private char torCode;
	    private char torDesignation;
	    private boolean deleted;
	    private List<RefOrganismeDTO> refOrganismes;
}
