package com.ah.commande.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ah.commande.bean.Commande;
import com.ah.commande.bean.CommandeItem;
import com.ah.commande.exceptions.ItemAlreadyExist;
import com.ah.commande.exceptions.ItemCantBePersisted;
import com.ah.commande.repo.CommandeRepo;
import com.ah.commande.service.facade.CommandeItemService;
import com.ah.commande.service.facade.CommandeService;
@Service
public class CommandeServiceImpl implements CommandeService{

	@Autowired
	private CommandeRepo commandeRepo;
	@Autowired
	private CommandeItemService commandeItemService;
	
	@Override
	public ResponseEntity<Commande> save(Commande commande, List<CommandeItem> commandeItems) {
		System.out.println(commande);
		System.out.println(commandeItems);
		Commande foundedCommande = commandeRepo.findByRef(commande.getRef());
		System.out.println("founded commande");
		System.out.println(foundedCommande);
		if(foundedCommande != null) throw new ItemAlreadyExist("commande dèjà existe!");
		else {
			Commande inserted = commandeRepo.save(commande);
			if(inserted == null) throw new ItemCantBePersisted("le commande ne peut pas être ajouter!");
			else {
				commandeItems.forEach(ci->{
					ci.setCommande(inserted);
					commandeItemService.save(ci);
				});
				return new ResponseEntity<Commande>(inserted,HttpStatus.CREATED);
			}
		}
		
	}
	@Override
	public ResponseEntity<Commande> update(Commande commande) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Commande> delete(int commandeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande findByRef(String ref) {
		return commandeRepo.findByRef(ref);
	}
	@Override
	public List<Commande> findAll() {
		return commandeRepo.findAll();
	}

	
}
