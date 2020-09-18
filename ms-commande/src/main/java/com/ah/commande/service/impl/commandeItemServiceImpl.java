package com.ah.commande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ah.commande.bean.CommandeItem;
import com.ah.commande.exceptions.ItemAlreadyExist;
import com.ah.commande.exceptions.ItemCantBePersisted;
import com.ah.commande.exceptions.ItemNotFoundException;
import com.ah.commande.repo.CommandeItemRepo;
import com.ah.commande.service.facade.CommandeItemService;

@Service
public class commandeItemServiceImpl implements CommandeItemService{

	@Autowired
	private CommandeItemRepo commandeItemRepo;
	
	@Override
	public ResponseEntity<CommandeItem> save(CommandeItem commandeItem) {
		CommandeItem foundedCommandeItem  = commandeItemRepo.findByRef(commandeItem.getRef());
		if(foundedCommandeItem != null) throw new  ItemAlreadyExist(foundedCommandeItem.getRef()+" already exist");
		else {
			CommandeItem inserted = commandeItemRepo.save(commandeItem);
			if(inserted == null)  throw new ItemCantBePersisted("comment item can't be persisted!");
			else return new ResponseEntity<CommandeItem>(inserted,HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<CommandeItem> update(CommandeItem commandeItem) {
		CommandeItem foundedCommandeItem = findByRef(commandeItem.getRef());
		if(foundedCommandeItem == null) throw new  ItemNotFoundException("commande item n'existe pas!");
		else {
			CommandeItem updated = commandeItemRepo.save(commandeItem);
			if(updated == null) throw new ItemCantBePersisted("commande item ne peut pas être modifié!");
			else return new ResponseEntity<CommandeItem>(updated,HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<CommandeItem> delete(String  ref) {
		CommandeItem foundCommandeItem = commandeItemRepo.findByRef(ref);
		if(foundCommandeItem == null) throw new ItemNotFoundException("Commande item introuvable!");
		else {
			commandeItemRepo.delete(foundCommandeItem);
			return new ResponseEntity<CommandeItem>(foundCommandeItem,HttpStatus.OK);
		}
	}


	@Override
	public CommandeItem findByRef(String ref) {
		return commandeItemRepo.findByRef(ref);
	}
	
	@Override
	public List<CommandeItem> findByCommandeRef(String ref) {
		return commandeItemRepo.findByCommandeRef(ref);
	}

	@Override
	public List<CommandeItem> findByProduitId(Long produitId) {
		return commandeItemRepo.findByProduitId(produitId);
	}

	@Override
	public List<CommandeItem> findAll() {
		return commandeItemRepo.findAll();
	}

	
}
