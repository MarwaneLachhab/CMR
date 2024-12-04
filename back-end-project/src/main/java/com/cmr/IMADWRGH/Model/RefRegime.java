package com.cmr.IMADWRGH.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ref_regime")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefRegime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id")
	private Long regId;

	@Column(name = "reg_code",length = 3)
	private String  regCode;

	@Column(name = "reg_libelle",length = 50)
	private String regLibelle;

	@Column(name = "reg_date_effet")
	private Date regDateEffet;

	@Column(name = "reg_pension_invalidite",length = 1)
	private String regPensionInvalidite;

	@Column(name = "reg_af",length = 1)
	private String regAf;

	@Column(name = "reg_ir",length = 1)
	private String regIr;

	@Column(name = "reg_amo",length = 1)
	private String regAmo;

	@Column(name = "reg_revalorise",length = 1)
	private String regRevalorise;

	@Column(name = "reg_rachat_cotisation",length = 1)
	private String regRachatCotisation;
	
	@Column(name = "reg_rachat_service",length = 1)
	private String regRachatService;

	@Column(name = "reg_age_eligibilite_min")
	private int regAgeEligibiliteMin;

	@Column(name = "reg_age_eligibilite_max")
	private int regAgeEligibiliteMax;

	@Column(name = "reg_derogation_age_eligibilite_max",length = 1)
	private String regDerogationAgeEligibiliteMax;

	@Column(name = "reg_personnel_etranger",length = 1)
	private String regPersonnelEtranger;
	
	
	///// Relation with RefParametersTaux
	@OneToMany(mappedBy = "refRegime", cascade = CascadeType.ALL)
  	private List<RefParametersTaux> refParametersTauxs;
	
	//////Relation with RefTauxAnnuite
	@OneToMany(mappedBy = "refRegime", cascade = CascadeType.ALL)
	private List<RefTauxAnnuite> refTauxAnnuites;

	@Column(name = "deleted")
	private boolean deleted;
	
}
