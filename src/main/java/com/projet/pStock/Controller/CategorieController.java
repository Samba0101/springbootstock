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
import com.projet.pStock.model.Categorie;
import com.projet.pStock.repositorie.CategorieRepositorie;


//@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins ="http://localhost:4200")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CategorieController {
	
	 @Autowired
	 CategorieRepositorie repositorie;
	
	 
	@CrossOrigin(origins = {"localhost:4200"}, allowedHeaders={"Accept"})
	//@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/Categories")
	public List<Categorie> getALLCategorie(){
		List<Categorie> Categorie=new ArrayList<Categorie>();
		repositorie.findAll().forEach(Categorie ::add);
		return Categorie;
	}
	@CrossOrigin(origins = {"localhost:4200"}, allowedHeaders={"Accept"})
	//@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/Categories/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable(value="id") 
	Long CategorieId) throws ResourceNotFoundException{
		Categorie Categorie=repositorie.findById(CategorieId).orElseThrow(()-> 
		new ResourceNotFoundException("Categorie not fount"));
		return ResponseEntity.ok().body(Categorie);
	}
	@CrossOrigin(origins = {" localhost:4200"}, allowedHeaders={"Accept"})
	//@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/Categories")
	public Categorie createCategorie(@Validated @RequestBody Categorie Categorie) {
		return repositorie.save(Categorie);
	}

	
	  @CrossOrigin(origins = {" localhost:4200"}, allowedHeaders={"Accept"})
	  
	  @DeleteMapping(value="/Categories/{id}") public void
	  delete(@PathVariable(name="id") Long id) { repositorie.deleteById(id); }
	 
	
	  @CrossOrigin(origins = { "localhost:4200"}, allowedHeaders={"Accept"})
	  
	  @DeleteMapping("/Categories/delete") public ResponseEntity<String>
	  deleteAllCategories(){ repositorie.deleteAll();
	  
	  return new
	  ResponseEntity<String>("Tous les Categories sont supprimés",HttpStatus.OK); }
	 

	@CrossOrigin(origins = {"localhost:4200"}, allowedHeaders={"Accept"})
	@PutMapping("/Categories/{id}")
	public Categorie updateCategorie(@PathVariable(name="id") Long id,@RequestBody Categorie categorie) {
		Optional<Categorie> CategorieInfo=repositorie.findById(id);
		if(CategorieInfo.isPresent()) {
		Categorie categories=new Categorie();
		categories.setCode(categorie.getCode());
		categories.setLibelle(categorie.getLibelle());
		return repositorie.save(categories);
	}
		else {
			return null;
		}
	}

}

