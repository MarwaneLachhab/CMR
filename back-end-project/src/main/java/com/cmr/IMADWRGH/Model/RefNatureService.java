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
@Table(name = "ref_nature_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefNatureService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rns_id")
	private Long rnsId;
	
	@Column(name = "rns_code",length = 10)
	private String rnsCode;
	
	@Column(name = "rns_libelle",length = 100)
	private String rnsLibelle;
	
	/////Relation with RefTauxAnnuite
	@OneToMany(mappedBy = "refNatureService", cascade = CascadeType.ALL)
   private List<RefTauxAnnuite> RefTauxAnnuites;
	
	@Column(name = "deleted")
	private boolean deleted;

}
