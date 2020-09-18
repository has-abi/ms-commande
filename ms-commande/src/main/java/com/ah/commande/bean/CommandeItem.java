package com.ah.commande.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommandeItem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true,nullable = true)
	private String ref;
	
	@ManyToOne
	private Commande commande;
	private Long produitId;
	private int quantite;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Long getProduitId() {
		return produitId;
	}
	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public CommandeItem(Long id, Commande commande, Long produitId, int quantite) {
		super();
		this.id = id;
		this.commande = commande;
		this.produitId = produitId;
		this.quantite = quantite;
	}
	
	public CommandeItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CommandeItem [id=" + id + ", commande=" + commande + ", produitId=" + produitId + ", quantite="
				+ quantite + "]";
	}
	
}
