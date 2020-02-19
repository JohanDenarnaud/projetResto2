package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.plats") // @Table(name="plats")
public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	/**
	 * Le nom du plat
	 */
	@Column(name = "nom")
	private String nom;
	/**
	 * Le prix du plat
	 */
	@Column(name = "prixDeVente")
	private Integer prixDeVente;
	/**
	 * Le prix de fabrication du plat
	 */
	@Column(name = "prixDeReviens")
	private Integer prixDeReviens;
	/**
	 * Le type de plat
	 */
	@Column(name = "categorie")
	private String categorie;
	/**
	 * Le nombre restant
	 */
	@Column(name = "stock")
	private Integer stock;

	public Plat() {

	}

	public Plat(Integer id, String nom, Integer prixDeVente, Integer prixDeReviens, String categorie, Integer stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prixDeVente = prixDeVente;
		this.prixDeReviens = prixDeReviens;
		this.categorie = categorie;
		this.stock = stock;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPrixDeVente() {
		return prixDeVente;
	}

	public void setPrixDeVente(Integer prixDeVente) {
		this.prixDeVente = prixDeVente;
	}

	public Integer getPrixDeReviens() {
		return prixDeReviens;
	}

	public void setPrixDeReviens(Integer prixDeReviens) {
		this.prixDeReviens = prixDeReviens;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
