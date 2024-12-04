package com.cmr.IMADWRGH.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cmr.IMADWRGH.Model.RefOrganisme;
import com.cmr.IMADWRGH.Service.RefOrganismeService;

@RestController
@RequestMapping(path = "api/v1/refOrganisme")
public class RefOrganismeController {

	private final RefOrganismeService refOrganismeService;

	public RefOrganismeController(RefOrganismeService refOrganismeService) {
		this.refOrganismeService = refOrganismeService;
	} 
	
	@PostMapping("/add")
    public ResponseEntity<RefOrganisme> create(@RequestBody RefOrganisme refOrganisme) {
        return  ResponseEntity.status(HttpStatus.OK).body(refOrganismeService.create(refOrganisme));
    }
	
	@GetMapping("/list")
	public ResponseEntity<List<RefOrganisme>> getAllRefOrganisme() {
	    List<RefOrganisme> refOrganismes= refOrganismeService.getAllRefOrganisme();
	    if (refOrganismes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<>(refOrganismes,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefOrganisme>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefOrganisme> refOPage = refOrganismeService.getRefOrganismePage(page, size);
	    	    if (refOPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refOPage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefOrganisme getRefOrganisme(@PathVariable Long id) {
	        return refOrganismeService.getRefOrganisme(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefOrganisme updateRefOrganisme(@PathVariable Long id, @RequestBody RefOrganisme updateRefOrganisme) {
	        return refOrganismeService.updateRefOrganisme(id, updateRefOrganisme);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefOrganisme(@PathVariable Long id) {
		  refOrganismeService.delete(id);
	    }
	
	
	
}
