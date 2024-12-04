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


import com.cmr.IMADWRGH.Model.RefCorps;
import com.cmr.IMADWRGH.Service.RefCorpsService;

@RestController
@RequestMapping(path = "api/v1/refCorps")
public class RefCorpsController {
	
	private final RefCorpsService refCorpsService;

	public RefCorpsController(RefCorpsService refCorpsServices) {
		this.refCorpsService = refCorpsServices;
	}
	
	@PostMapping("/add")
    public ResponseEntity<RefCorps> create(@RequestBody RefCorps refCorps) {
		return ResponseEntity.status(HttpStatus.OK).body(refCorpsService.create(refCorps));
    }
	
	
	@GetMapping("/list")
	public ResponseEntity<List<RefCorps>> getAllRefCorps() {
	    List<RefCorps> refCorps = refCorpsService.getAllRefCorps();
	    
	    if (refCorps.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<>(refCorps, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefCorps>> getAllRefCorpsPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefCorps> refCorpsPage = refCorpsService.getRefCorpsPage(page, size);
	    	    if (refCorpsPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refCorpsPage, HttpStatus.OK);
	}


	
	 @GetMapping("/{id}")
	 public RefCorps getRefCorps(@PathVariable Long id) {
	        return refCorpsService.getRefCorps(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefCorps updateRefCorps(@PathVariable Long id, @RequestBody RefCorps updateRefCorps) {
	        return refCorpsService.updateRefCorps(id, updateRefCorps);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefCorps(@PathVariable Long id) {
		  refCorpsService.delete(id);
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
