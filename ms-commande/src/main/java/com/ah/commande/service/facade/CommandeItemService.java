package com.ah.commande.service.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ah.commande.bean.CommandeItem;

public interface CommandeItemService {
	List<CommandeItem> findByCommandeRef(String ref);

	List<CommandeItem> findByProduitId(Long produitId);

	CommandeItem findByRef(String ref);

	ResponseEntity<CommandeItem> save(CommandeItem commandeItem);

	ResponseEntity<CommandeItem> update(CommandeItem commandeItem);

	ResponseEntity<CommandeItem> delete(String  ref);
	
	List<CommandeItem> findAll();
}
