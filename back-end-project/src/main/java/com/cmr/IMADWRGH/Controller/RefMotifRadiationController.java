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
import com.cmr.IMADWRGH.Model.RefMotifRadiation;
import com.cmr.IMADWRGH.Service.RefMotifRadiationService;

@RestController
@RequestMapping(path = "api/v1/RefMotifRadiation")
public class RefMotifRadiationController {
 
	private final RefMotifRadiationService refMotifRadiationService;

	public RefMotifRadiationController(RefMotifRadiationService refMotifRadiationService) {
		this.refMotifRadiationService = refMotifRadiationService;
	}
	

	@PostMapping("/add")
    public ResponseEntity<RefMotifRadiation> create(@RequestBody RefMotifRadiation refMotifRadiation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refMotifRadiationService.create(refMotifRadiation));
    }
	
	@GetMapping("/list")
	public  ResponseEntity<List<RefMotifRadiation>> getAllRefMotifRadiation() {
	    List<RefMotifRadiation> refMotifRadiations= refMotifRadiationService.getAllRefMotifRadiations();
	    if (refMotifRadiations.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<>(refMotifRadiations,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefMotifRadiation>> getAllRefMotifRadiationPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefMotifRadiation> refMPage = refMotifRadiationService.getRefMotifRadiationPage(page, size);
	    	    if (refMPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refMPage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefMotifRadiation getRefMotifRadiation(@PathVariable Long id) {
	        return refMotifRadiationService.getRefMotifRadiation(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefMotifRadiation updateRefDepartement(@PathVariable Long id, @RequestBody RefMotifRadiation updateRefMotifRadiation) {
	        return refMotifRadiationService.updateRefMotifRadiation(id, updateRefMotifRadiation);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefMotifRadiation(@PathVariable Long id) {
		  refMotifRadiationService.delete(id);
	    }
	
	
	
}
