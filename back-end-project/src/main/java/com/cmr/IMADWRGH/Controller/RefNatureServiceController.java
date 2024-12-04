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
import com.cmr.IMADWRGH.Model.RefNatureService;
import com.cmr.IMADWRGH.Service.RefNatureServiceService;

@RestController
@RequestMapping(path = "api/v1/refNatureService")
public class RefNatureServiceController {
	
	private final RefNatureServiceService refNatureServiceService;
	
	public RefNatureServiceController(RefNatureServiceService refNatureServiceService) {
		this.refNatureServiceService = refNatureServiceService;
	}


	
    @PostMapping(path="/add")
    public ResponseEntity<RefNatureService> create(@RequestBody RefNatureService refMotifRadiation){
        return ResponseEntity.status(HttpStatus.OK).body(refNatureServiceService.create(refMotifRadiation));
    }

	
	@GetMapping("/list")
	public ResponseEntity<List<RefNatureService>> getAllRefMotifRadiation() {
        List<RefNatureService> refNatureServices = refNatureServiceService.getAllRefNatureService();
        if (refNatureServices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(refNatureServices, HttpStatus.OK);
    }
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefNatureService>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefNatureService> refNPage= refNatureServiceService.getRefNatureServicePage(page, size);
	    	    if (refNPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refNPage, HttpStatus.OK);
	}

	
	 @GetMapping("/{id}")
	 public RefNatureService getRefMotifRadiation(@PathVariable Long id) {
	        return refNatureServiceService.getRefNatureService(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefNatureService updateRefDepartement(@PathVariable Long id, @RequestBody RefNatureService updateRefMotifRadiation) {
	        return refNatureServiceService.updateRefNatureService(id, updateRefMotifRadiation);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefNatureService(@PathVariable Long id) {
		  refNatureServiceService.delete(id);
	    }
	
	
	

}
