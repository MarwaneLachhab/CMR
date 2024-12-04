package com.cmr.IMADWRGH.Model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ref_parameters_taux")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefParametersTaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpt_id")
	private Long rptId;
	
	@Column(name = "rpt_date_effet")
	private Date rptDateEffet;
	
	@Column(name = "rpt_achat")
	private double rptAchat;
	
	@Column(name = "rpt_liquidation")
	private double rptLiquidation;
	
	@Column(name = "rpt_planfond_liquidation")
	private double rptPlanfondLiquidation;
	
	@Column(name = "rpt_pourcentage_revalorisation")
	private double rptPourcentageRevalorisation;
	
	@Column(name = "rpt_plafond_cotisation")
	private double rpt_plafond_cotisation;
	
	@Column(name = "rpt_taux_cotisation_ps")
	private double rptTauxCotisationPs;
	
	@Column(name = "rpt_taux_cotisation_pp")
	private double rptTauxCotisationPp;
	
	@Column(name = "rpt_valeur_debut")
	private double rptValeurDebut;
	
	//////////Relation with RefRegime
	@ManyToOne
	@JoinColumn(name = "reg_id")
	private RefRegime refRegime;
	
	
	
	@Column(name = "deleted")
	private boolean deleted;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
