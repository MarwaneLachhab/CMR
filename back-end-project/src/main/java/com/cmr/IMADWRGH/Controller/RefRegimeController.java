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
import com.cmr.IMADWRGH.Model.RefRegime;
import com.cmr.IMADWRGH.Service.RefRegimeService;

@RestController
@RequestMapping(path = "api/v1/refRegime")
public class RefRegimeController {
	
	private final RefRegimeService refRegimeService;

	public RefRegimeController(RefRegimeService refRegimeService) {
		this.refRegimeService = refRegimeService;
	}
	 
	
	@PostMapping("/add")
    public ResponseEntity<RefRegime> create(@RequestBody RefRegime refRegime) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refRegimeService.create(refRegime));
    }
	
	@GetMapping("/list")
	public  ResponseEntity<List<RefRegime>> getAllRefRegime() {
	    List<RefRegime> refRegimes= refRegimeService.getAll();
	    if (refRegimes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<>(refRegimes,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefRegime>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefRegime> refRegimePage = refRegimeService.getRefRegimePage(page, size);
	    	    if (refRegimePage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refRegimePage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefRegime getRefRegime(@PathVariable Long id) {
	        return refRegimeService.getRefRegime(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefRegime updateRefCorps(@PathVariable Long id, @RequestBody RefRegime updateRefRegime) {
	        return refRegimeService.updateRefRegime(id, updateRefRegime);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefRegime(@PathVariable Long id) {
		  refRegimeService.delete(id);
	    }
	

}
