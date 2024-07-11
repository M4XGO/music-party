package fr.esgi.musique.maxime.buisness;

/**
 * Classe représentant un lieu de concert.
 */
public class Lieu {
    private Long id;
    private String nom;
    private Long compteur;

    /**
     * Constructeur par défaut.
     */
    public Lieu() {
        id = ++compteur;
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param id   L'identifiant du lieu.
     * @param nom  Le nom du lieu.
     */
    public Lieu(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getCompteur() {
        return compteur;
    }

    public void setCompteur(Long compteur) {
        this.compteur = compteur;
    }

    @Override
    public String toString() {
        return "Lieu [id=" + id + ", nom=" + nom + ", compteur=" + compteur + "]";
    }
}
