package com.projet.pStock.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.pStock.exception.ResourceNotFoundException;
import com.projet.pStock.model.SousCategorie;
import com.projet.pStock.repositorie.SousCategorieRepositorie;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SousCategorieController {
	
	@Autowired
	 SousCategorieRepositorie repositorie;
	
	@GetMapping("/SousCategories")
	public List<SousCategorie> getALLSousCategorie(){
		List<SousCategorie> SousCategorie=new ArrayList<SousCategorie>();
		repositorie.findAll().forEach(SousCategorie ::add);
		return SousCategorie;
	}
	@DeleteMapping("/SousCategories/{id}")
	public ResponseEntity<SousCategorie> getSousCategorieById(@PathVariable(value="id") long SousCategorieId) throws ResourceNotFoundException{
		SousCategorie SousCategorie=repositorie.findById(SousCategorieId).orElseThrow(()-> new ResourceNotFoundException("SousCategorie not fount"));
		return ResponseEntity.ok().body(SousCategorie);
	}
	@PostMapping("/SousCategories")
	public SousCategorie createSousCategorie(@Validated @RequestBody SousCategorie SousCategorie) {
		return repositorie.save(SousCategorie);
	}
	/*@DeleteMapping("/SousCategories/{id}")
	public Map<String,Boolean> deleteSousCategorie(@PathVariable(value="id") Long SousCategorieId)throws
	ResourceNotFoundException {
		SousCategorie SousCategorie= repositorie.findById(SousCategorieId).orElseThrow(()-> new ResourceNotFoundException("SousCategorie n'on trouvé "+ SousCategorieId));
		repositorie.delete(SousCategorie);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}*/
	@DeleteMapping("/SousCategories/delete")
	public ResponseEntity<String> deleteAllSousCategories(){
		repositorie.deleteAll();
		
		return new ResponseEntity<String>("Tous les SousCategories sont supprimés",HttpStatus.OK);
	}
	@PutMapping("SousCategories/{id}")
	public ResponseEntity<SousCategorie> updateSousCategorie(@PathVariable("id") long id,@RequestBody SousCategorie SousCategorie){
		
	
	Optional<SousCategorie> SousCategorieInfo=repositorie.findById(id);
	if(SousCategorieInfo.isPresent()) {
		SousCategorie sousCategorie=SousCategorieInfo.get();
		sousCategorie.setCode(SousCategorie.getCode());
		sousCategorie.setLibelle(SousCategorie.getLibelle());
		sousCategorie.setCodecategorie(SousCategorie.getCodecategorie());
		//sousCategorie.setId_cat(SousCategorie.getId_cat());
		return new ResponseEntity<>(repositorie.save(SousCategorie), HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
}
