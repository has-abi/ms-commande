package com.ah.commande.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ah.commande.bean.Commande;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long>{
	Commande findByRef(String ref);
}
