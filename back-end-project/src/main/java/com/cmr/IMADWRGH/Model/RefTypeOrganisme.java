package com.cmr.IMADWRGH.Model;

import java.util.List;

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
@Table(name = "ref_type_organisme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefTypeOrganisme {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tor_id")
	private Long torID;
	
	@Column(name = "tor_code",length = 10)
	private String torCode;
	
	@Column(name = "tor_designation",length = 100)
	private String torDesignation;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	
	////////Relation with RefOrganisme
	@OneToMany(mappedBy = "refTypeOrganisme")
    private List<RefOrganisme> refOrganismes;
	
}
