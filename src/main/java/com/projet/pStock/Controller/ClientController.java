package com.projet.pStock.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.projet.pStock.model.Client;
import com.projet.pStock.repositorie.ClientRepositorie;


@CrossOrigin(origins = "*")
@RestController		
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientRepositorie repositorie;

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	  @GetMapping("/Clients")
	  public List<Client> getALLClient(){
		  List<Client> client=new ArrayList<Client>();
		  repositorie.findAll().forEach(client ::add);
	  return client; }
	 
	/*@CrossOrigin(origins = {"localhost:4200"}, allowedHeaders={"Accept"})
	@DeleteMapping("/Clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value="id") long clientId) throws ResourceNotFoundException{
		Client client=(Client) repositorie.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client not fount"));
		return ResponseEntity.ok().body(client);
	}*/
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	  @PostMapping("/Clients") 
	  public Client createClient(@Validated @RequestBody
	  Client client) { return repositorie.save(client); }
	 
	
	/*@DeleteMapping(value="/Clients/{id}")
	public Map<String,Boolean> deleteClient(@PathVariable(value="id") long ClientId)throws
	ResourceNotFoundException {
		Client Client= repositorie.findById(ClientId).orElseThrow(()-> new ResourceNotFoundException("Client n'on trouvé "+ ClientId));
		repositorie.delete(Client);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}*/
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	  @DeleteMapping(value="/Clients/{id}")
	public void delete(@PathVariable(name="id") Long id)
	{ repositorie.deleteById(id); }
	
	/*
	 * @CrossOrigin(origins = "*", allowedHeaders = "*")
	 * 
	 * @DeleteMapping("/Clients/{id}") public void delete(@PathVariable(name="id")
	 * Long id) { repositorie.deleteById(id); }
	 */
	  
	/*
	 * @CrossOrigin(origins = {" localhost:4200"}, allowedHeaders={"Accept"})
	 * 
	 * @DeleteMapping(value="/Clients/{id}") public void
	 * delete(@PathVariable(name="id") Long id) { repositorie.deleteById(id); }
	 */

	/*
	 * @DeleteMapping("/Clients/delete") public ResponseEntity<String>
	 * deleteAllClients(){ repositorie.deleteAll(); return new
	 * ResponseEntity<String>("Tous les Clients sont supprimés",HttpStatus.OK); }
	 */
/*	@DeleteMapping("/Clients/delete")
	public ResponseEntity<String> deleteAllClients(){
		repositorie.deleteAll();
		
		return new ResponseEntity<String>("Tous les Clients sont supprimés",HttpStatus.OK);
	}*/

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("Clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") long id,@RequestBody Client Client){
		
	Optional<Client> ClientInfo=repositorie.findById(id);
	if(ClientInfo.isPresent()) {
		Client client=ClientInfo.get();
		client.setLibelle(Client.getLibelle());
		client.setContact(Client.getContact());
		client.setEmail(Client.getEmail());
		client.setTel(Client.getTel());
		client.setLogin(Client.getLogin());
		client.setPwd(Client.getPwd());
		
		return new ResponseEntity<>(repositorie.save(Client), HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
}
