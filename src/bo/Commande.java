package bo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.commandes")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * Le numero de la table ou l'on � pass�e la commande
	 */
	@Column(name = "numero de table")
	private Integer numTable;

	@Column(name = "montant")
	private Integer montant;

	/**
	 * est ce que la commande � etait payer?
	 * 
	 */
	@Column(name = "reglement")
	private boolean reglement;
	/**
	 * L'heure de la prise de commande
	 */
	@Column(name = "heure de la commande")
	private LocalDateTime heureDeCommande;

	/**
	 * La liste des plats dans la commande
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "post_id")
	private List<Plat> plats;

	public Commande() {
		this.plats = new ArrayList<Plat>();
	}

	public Commande(Integer id, Integer numTable, Integer montant, boolean reglement, LocalTime heureDeCommande,
			List<Plat> plats) {
		super();
		this.id = id;
		this.numTable = numTable;
		this.montant = montant;
		this.reglement = reglement;
		this.heureDeCommande = heureDeCommande;
		this.plats = plats;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumTable() {
		return numTable;
	}

	public void setNumTable(Integer numTable) {
		this.numTable = numTable;
	}

	public boolean isReglement() {
		return reglement;
	}

	public void setReglement(boolean reglement) {
		this.reglement = reglement;
	}

	public LocalTime getHeureDeCommande() {
		return heureDeCommande;
	}

	public void setHeureDeCommande(LocalDateTime dateCommande) {
		this.heureDeCommande = dateCommande;
	}

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

	// recuperer le prix de chaque plat est faire le total

}
