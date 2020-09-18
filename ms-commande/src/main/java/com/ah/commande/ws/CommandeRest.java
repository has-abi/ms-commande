package com.ah.commande.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ah.commande.bean.Commande;
import com.ah.commande.service.facade.CommandeService;

@RestController
@RequestMapping("commande-api/commande")
public class CommandeRest {
	@Autowired
	private CommandeService commandeService;
	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}
	@GetMapping("/ref/{ref}")
	public Commande findByRef(@PathVariable String ref) {
		return commandeService.findByRef(ref);
	}
	@PostMapping("/")
	public ResponseEntity<Commande> save(@RequestBody Commande commande) {
		System.out.println(commande);
		return commandeService.save(commande, commande.getCommandeItems());
	}
	@PutMapping("/")
	public ResponseEntity<Commande> update(@RequestBody Commande commande) {
		return commandeService.update(commande);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Commande> delete(@PathVariable int commandeId) {
		return commandeService.delete(commandeId);
	}
}
