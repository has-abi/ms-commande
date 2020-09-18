package com.ah.commande.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@Column(unique = true,nullable = false)
	private String ref;
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	private double montant;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "commande")
	private List<CommandeItem> commandeItems;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public List<CommandeItem> getCommandeItems() {
		return commandeItems;
	}
	public void setCommandeItems(List<CommandeItem> commandeItems) {
		this.commandeItems = commandeItems;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Long id, String ref, Date dateCommande, double montant, List<CommandeItem> commandeItems) {
		super();
		this.id = id;
		this.ref = ref;
		this.dateCommande = dateCommande;
		this.montant = montant;
		this.commandeItems = commandeItems;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", ref=" + ref + ", dateCommande=" + dateCommande + ", montant=" + montant
				+ ", commandeItems=" + commandeItems + "]";
	}
	
	
	
}
