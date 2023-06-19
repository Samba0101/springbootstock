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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.pStock.exception.ResourceNotFoundException;
import com.projet.pStock.model.Fournisseur;
import com.projet.pStock.repositorie.FournisseurRepositorie;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class FournisseurController {
	
	@Autowired
	 FournisseurRepositorie repositorie;
	
	@GetMapping("/Fournisseurs")
	public List<Fournisseur> getALLFournisseur(){
		List<Fournisseur> Fournisseur=new ArrayList<Fournisseur>();
		repositorie.findAll().forEach(Fournisseur ::add);
		return Fournisseur;
	}
	@DeleteMapping("/Fournisseurs/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value="id") Long FournisseurId) throws ResourceNotFoundException{
		Fournisseur Fournisseur=repositorie.findById(FournisseurId).orElseThrow(()-> new ResourceNotFoundException("Fournisseur not fount"));
		return ResponseEntity.ok().body(Fournisseur);
	}
	@PostMapping("/Fournisseurs")
	public Fournisseur createFournisseur(@Validated @RequestBody Fournisseur Fournisseur) {
		return repositorie.save(Fournisseur);
	}
	/*@DeleteMapping("/Fournisseurs/{id}")
	public Map<String,Boolean> deleteFournisseur(@PathVariable(value="id") Long FournisseurId)throws
	ResourceNotFoundException {
		Fournisseur Fournisseur= repositorie.findById(FournisseurId).orElseThrow(()-> new ResourceNotFoundException("Fournisseur n'on trouvé "+ FournisseurId));
		repositorie.delete(Fournisseur);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}*/
	@DeleteMapping("/Fournisseurs/delete")
	public ResponseEntity<String> deleteAllFournisseurs(){
		repositorie.deleteAll();
		
		return new ResponseEntity<String>("Tous les Fournisseurs sont supprimés",HttpStatus.OK);
	}
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id,@RequestBody Fournisseur Fournisseur){
		
	
	Optional<Fournisseur> FournisseurInfo=repositorie.findById(id);
	if(FournisseurInfo.isPresent()) {
		Fournisseur fournisseur=FournisseurInfo.get();
		fournisseur.setCode(Fournisseur.getCode());
		fournisseur.setLibelle(Fournisseur.getLibelle());
		fournisseur.setContact(Fournisseur.getContact());
		fournisseur.setAsuj(Fournisseur.getAsuj());
		fournisseur.setFax(Fournisseur.getEmail());
		fournisseur.setEmail(Fournisseur.getEmail());
		fournisseur.setMatfisc(Fournisseur.getMatfisc());
		fournisseur.setSolde(Fournisseur.getSolde());
		fournisseur.setSoldeInit(Fournisseur.getSoldeInit());
		fournisseur.setTel(Fournisseur.getTel());
		fournisseur.setTimbre(Fournisseur.getTimbre());
		return new ResponseEntity<>(repositorie.save(Fournisseur), HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
}
