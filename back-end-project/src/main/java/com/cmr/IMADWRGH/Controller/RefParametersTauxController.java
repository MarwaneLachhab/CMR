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
import com.cmr.IMADWRGH.Model.RefParametersTaux;
import com.cmr.IMADWRGH.Service.RefParametersTauxService;

@RestController
@RequestMapping(path = "api/v1/refParametersTaux")
public class RefParametersTauxController {
	
	private final RefParametersTauxService refParametersTauxService;

	public RefParametersTauxController(RefParametersTauxService refParametersTauxService) {
		this.refParametersTauxService = refParametersTauxService;
	}
	
	
	@PostMapping("/add")
    public ResponseEntity<RefParametersTaux> create(@RequestBody RefParametersTaux refParametersTaux) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refParametersTauxService.create(refParametersTaux));
    }
	
	@GetMapping("/list")
	public ResponseEntity<List<RefParametersTaux>> getAllRefParametersTaux() {
	    List<RefParametersTaux> refParametersTauxs = refParametersTauxService.getAll();
	    if (refParametersTauxs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    return new ResponseEntity<>(refParametersTauxs,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<RefParametersTaux>> getAllPagination(
	        @RequestParam(defaultValue = "0") int page, 
	        @RequestParam(defaultValue = "5") int size) {
	    Page<RefParametersTaux> refParametersTauxPage = refParametersTauxService.getRefParametersTauxPage(page, size);
	    	    if (refParametersTauxPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(refParametersTauxPage, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	 public RefParametersTaux getRefParametersTaux(@PathVariable Long id) {
	        return refParametersTauxService.getRefParametersTaux(id);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	    public RefParametersTaux updateRefParametersTaux(@PathVariable Long id, @RequestBody RefParametersTaux updateRefParametersTaux) {
	        return refParametersTauxService.updateRefParametersTaux(id, updateRefParametersTaux);
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public void deleteRefParametersTaux(@PathVariable Long id) {
		  refParametersTauxService.delete(id);
	    }
	
	

}
