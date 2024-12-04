package com.cmr.IMADWRGH.Model;

import java.sql.Date;


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
@Table(name = "ref_taux_annuite")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefTauxAnnuite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rta_id")
	private Long rtaID;
	
	@Column(name = "rta_date_debut")
	private Date rtaDateDebut;
	
	@Column(name = "rta_date_fin")
	private Date rtaDateFin;
	
	@Column(name = "rta_date_effet")
	private Date rtaDateEffet;
	
	@Column(name = "rta_taux")
	private double rtaTaux;
	
	
	////////////Relation with  RefRegime
	@ManyToOne
	@JoinColumn(name = "reg_id", insertable = false, updatable = false)///column twice in your entity class
	private RefRegime refRegime;
	
	////////////Relation with RefMotifRadiation
	@ManyToOne
	@JoinColumn(name = "rmr_id")
	private RefMotifRadiation refMotifRadiation;
	
	////////////Relation with RefNatureService
	@ManyToOne
	@JoinColumn(name = "rns_id") 
	private RefNatureService refNatureService;
	
	@Column(name = "deleted")
	private boolean deleted;
}
