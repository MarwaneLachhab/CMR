package com.cmr.IMADWRGH.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefParametersTauxDTO {
		private Long rptId;
	    private Date rptDateEffet;
	    private double rptAchat;
	    private double rptLiquidation;
	    private double rptPlanfondLiquidation;
	    private double rptPourcentageRevalorisation;
	    private double rptPlafondCotisation;
	    private double rptTauxCotisationPs;
	    private double rptTauxCotisationPp;
	    private double rptValeurDebut;
	    private Long refRegimeId;
	    private boolean deleted;
}
