package fr.esgi.musique.maxime.buisness;

import java.util.ArrayList;

/**
 * Classe représentant un groupe de musique.
 */
public class Groupe {
    private Long id;
    private String name;
    private Long compteur;
    private ArrayList<Genre> genres;

    /**
     * Constructeur par défaut.
     */
    public Groupe() {
        id = ++compteur;
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param id     L'identifiant du groupe.
     * @param name   Le nom du groupe.
     * @param genres La liste des genres associés à ce groupe.
     */
    public Groupe(Long id, String name, ArrayList<Genre> genres) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompteur() {
        return compteur;
    }

    public void setCompteur(Long compteur) {
        this.compteur = compteur;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Groupe [id=" + id + ", name=" + name + ", compteur=" + compteur + ", genres=" + genres + "]";
    }
}
