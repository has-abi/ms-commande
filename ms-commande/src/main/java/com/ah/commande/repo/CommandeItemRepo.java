package com.ah.commande.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ah.commande.bean.CommandeItem;

@Repository
public interface CommandeItemRepo extends JpaRepository<CommandeItem, Long> {

	List<CommandeItem> findByCommandeRef(String ref);

	List<CommandeItem> findByProduitId(Long produitId);

	CommandeItem findByRef(String ref);
}
