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
@Table(name = "ref_organisme")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefOrganisme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "org_id")
	private Long orgId;
	
	@Column(name = "org_code",length = 5)
	private String orgCode;
	
	@Column(name = "org_libelle",length = 100)
	private String orgLibelle;
	
	@Column(name = "org_date_creation")
	private Date orgDateCreation;
	
	@Column(name = "org_date_fermeture")
	private Date orgDateFermeture;
	
	@Column(name = "org_adresse",length = 200)
	private String orgAdresse;
	
	@Column(name = "org_imputation",length = 30)
	private String orgImputation;
	
	@Column(name = "org_imputation_g",length = 20)
	private String orgImputationG;
	
	@Column(name = "org_payeur",length = 5)
	private String orgPayeur;
	
	
	
	
	////////////////Relation with refTypeOrganisme/////////
	@ManyToOne
	@JoinColumn(name = "tor_id")
	private RefTypeOrganisme refTypeOrganisme;
	
	////////////////Relation with refDepartement/////////
	@ManyToOne
	@JoinColumn(name = "dep_id")
   private RefDepartement refDepartement;
	
	
	
	@Column(name = "deleted")
	private boolean deleted;
	
	
	
	

}
