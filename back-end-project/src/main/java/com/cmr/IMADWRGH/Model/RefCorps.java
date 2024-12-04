package com.cmr.IMADWRGH.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ref_corps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefCorps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crp_id")
	private Long crpId;
	
	@Column(name = "crp_code" ,length = 10)
	private String crpCode;
	
	@Column(name = "crp_designation" ,length = 100)
	private String crpDesignation;
	
	@Column(name = "crp_limite_age")
	private byte crpLimiteAge;
	
	@Column(name = "crp_grade_min")
	private int crpGradeMin;
	
	@Column(name = "crp_grade_max")
	private int crpGradeMax;
	
	@Column(name = "deleted")
	private boolean deleted;

}
