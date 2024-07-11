package fr.esgi.musique.maxime.buisness;

import java.util.ArrayList;

/**
 * Classe représentant un genre musical.
 */
public class Genre {
    private Long id;
    private String nom;
    private Long compteur;
    private ArrayList<Groupe> groupes;

    /**
     * Constructeur par défaut.
     */
    public Genre() {
        id = ++compteur;
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param id      L'identifiant du genre.
     * @param nom     Le nom du genre.
     * @param groupes La liste des groupes associés à ce genre.
     */
    public Genre(Long id, String nom, ArrayList<Groupe> groupes) {
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

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(ArrayList<Groupe> groupes) {
        this.groupes = groupes;
    }

    @Override
    public String toString() {
        return "Genre [id=" + id + ", nom=" + nom + ", compteur=" + compteur + ", groupes=" + groupes + "]";
    }
}
