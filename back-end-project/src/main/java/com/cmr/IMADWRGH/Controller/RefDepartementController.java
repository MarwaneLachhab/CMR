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
import com.cmr.IMADWRGH.Model.RefDepartement;
import com.cmr.IMADWRGH.Service.RefDepartementService;

@RestController
@RequestMapping(path = "api/v1/refDepartement")
public class RefDepartementController {
	
	private final RefDepartementService refDepartementService;
	

	public RefDepartementController(RefDepartementService refDepartementService) {
		this.refDepartementService = refDepartementService;
	}

	@PostMapping("/add")
    public ResponseEntity<RefDepartement> create(@RequestBody RefDepartement refDepartement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refDepartementService.create(refDepartement));
    }
	
	@GetMapping("/list")
	public ResponseEntity<List<RefDepartement>> getAllRefDepartements() {
	    List<RefDepartement> refDepartements= refDepartementService.getAllRefDepartements();
	    if (refDepartements.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new  ResponseEntity<>(refDepartements,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefDepartement>> getAllRefDepartementsPagination(
			 @RequestParam(defaultValue = "0") int page, 
		        @RequestParam(defaultValue = "5") int size) {
	    Page<RefDepartement> refDepartements= refDepartementService.getRefDepartementPage(page, size);
	    if (refDepartements.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new  ResponseEntity<>(refDepartements,HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefDepartement getRefDepartement(@PathVariable Long id) {
	        return refDepartementService.getRefDepartement(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefDepartement updateRefDepartement(@PathVariable Long id, @RequestBody RefDepartement updateRefDepartement) {
	        return refDepartementService.updateRefDepartement(id, updateRefDepartement);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefDepartement(@PathVariable Long id) {
		  refDepartementService.delete(id);
	    }

	
	

}
