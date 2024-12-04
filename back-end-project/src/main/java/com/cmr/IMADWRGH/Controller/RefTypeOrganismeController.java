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
import com.cmr.IMADWRGH.Model.RefTypeOrganisme;
import com.cmr.IMADWRGH.Service.RefTypeOrganismeService;

@RestController
@RequestMapping(path = "api/v1/refTypeOrganisme")
public class RefTypeOrganismeController {
	
	private final RefTypeOrganismeService refTypeOrganismeService;

	
	public RefTypeOrganismeController(RefTypeOrganismeService refTypeOrganismeService) {
		super();
		this.refTypeOrganismeService = refTypeOrganismeService;
	}

	@PostMapping("/add")
    public ResponseEntity<RefTypeOrganisme> createService(@RequestBody RefTypeOrganisme refTypeOrganisme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refTypeOrganismeService.create(refTypeOrganisme));
    }
	
	@GetMapping("/list")
	public ResponseEntity<List<RefTypeOrganisme>> getAllRefTypeOrganisme() {
		List<RefTypeOrganisme> refTypeOrganismes =refTypeOrganismeService.getAll();
		if (refTypeOrganismes.isEmpty()){
			   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
	    return new ResponseEntity<>(refTypeOrganismes, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefTypeOrganisme>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefTypeOrganisme> refTypeOrganismePage = refTypeOrganismeService.getRefTypeOrganismePage(page, size);
	    	    if (refTypeOrganismePage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refTypeOrganismePage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefTypeOrganisme getRefTypeOrganisme(@PathVariable Long id) {
	        return refTypeOrganismeService.getRefTypeOrganisme(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefTypeOrganisme updateRefTypeOrganisme(@PathVariable Long id, @RequestBody RefTypeOrganisme updateRefTypeOrganisme) {
	        return refTypeOrganismeService.updateRefTypeOrganisme(id, updateRefTypeOrganisme);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefTypeOrganisme(@PathVariable Long id) {
		  refTypeOrganismeService.delete(id);
	    }

}
