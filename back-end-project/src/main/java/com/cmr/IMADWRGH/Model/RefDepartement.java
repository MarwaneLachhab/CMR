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
@Table(name = "ref_departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefDepartement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dep_id")
	private Long depID;
	
	@Column(name = "dep_code",length = 2)
	private String depCode;
	
	@Column(name = "dep_libelle",length = 50)
	private String depLibelle;
	
	
	
	////////Relation with RefOrganisme
	@OneToMany(mappedBy = "refDepartement", cascade = CascadeType.ALL)
    private List<RefOrganisme> refOrganismes;
	
	@Column(name = "deleted")
	private boolean deleted;

}
