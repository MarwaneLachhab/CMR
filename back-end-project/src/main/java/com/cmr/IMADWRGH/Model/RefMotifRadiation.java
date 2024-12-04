package com.cmr.IMADWRGH.Model;

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
@Table(name = "ref_motif_radiation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefMotifRadiation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rmr_id")
	private Long rmrId;
	
	@Column(name = "rmr_code",length = 10)
	private String rmrCode;
	
	@Column(name = "rmr_libelle",length = 100)
	private String rmrLibelle;
	
	/////Relation with RefTauxAnnuite 
	@OneToMany(mappedBy = "refMotifRadiation", cascade = CascadeType.ALL)
	private List<RefTauxAnnuite> refTauxAnnuites;	
	
	@Column(name = "deleted")
	private boolean deleted;
	
	
	
	
}
