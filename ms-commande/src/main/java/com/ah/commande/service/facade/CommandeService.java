package com.ah.commande.service.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ah.commande.bean.Commande;
import com.ah.commande.bean.CommandeItem;

public interface CommandeService {
	Commande findByRef(String ref);

	ResponseEntity<Commande> save(Commande commande, List<CommandeItem> commandeItems);

	ResponseEntity<Commande> update(Commande commande);

	ResponseEntity<Commande> delete(int commandeId);
	
	List<Commande> findAll();
}
