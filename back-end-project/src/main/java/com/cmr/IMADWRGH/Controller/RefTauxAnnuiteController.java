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
import com.cmr.IMADWRGH.Model.RefTauxAnnuite;
import com.cmr.IMADWRGH.Service.RefTauxAnnuiteService;

@RestController
@RequestMapping(path = "api/v1/refTauxAnnuite")
public class RefTauxAnnuiteController {
	
	private final RefTauxAnnuiteService refTauxAnnuiteService;

	public RefTauxAnnuiteController(RefTauxAnnuiteService refTauxAnnuiteService) {
		this.refTauxAnnuiteService = refTauxAnnuiteService;
	}
	
	
	@PostMapping("/add")
    public ResponseEntity<RefTauxAnnuite> create(@RequestBody RefTauxAnnuite refTauxAnnuite) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refTauxAnnuiteService.create(refTauxAnnuite));
    }
	
	@GetMapping("/list")
	public  ResponseEntity<List<RefTauxAnnuite>> getAllRefCorps() {
		List<RefTauxAnnuite> refTauxAnnuites= refTauxAnnuiteService.getAll();
		if (refTauxAnnuites.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new  ResponseEntity<>(refTauxAnnuites,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefTauxAnnuite>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefTauxAnnuite> refTauxAnnuitePage = refTauxAnnuiteService.getRefTauxAnnuitePage(page, size);
	    	    if (refTauxAnnuitePage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refTauxAnnuitePage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefTauxAnnuite getRefTauxAnnuite(@PathVariable Long id) {
	        return refTauxAnnuiteService.getRefTauxAnnuite(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefTauxAnnuite updateRefTauxAnnuite(@PathVariable Long id, @RequestBody RefTauxAnnuite updateRefTauxAnnuite) {
	        return refTauxAnnuiteService.updateRefTauxAnnuite(id, updateRefTauxAnnuite);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefTauxAnnuite(@PathVariable Long id) {
		  refTauxAnnuiteService.delete(id);
	    }
	

}
