package fr.esgi.musique.maxime.buisness;

import java.util.ArrayList;

/**
 * Classe représentant un concert.
 */
public class Concert {
    private Long id;
    private Lieu lieu;
    private ArrayList<Groupe> groupes;
    private String heureDebut;
    private String heureFin;
    private Long compteur;

    /**
     * Constructeur par défaut.
     */
    public Concert() {
        id = ++compteur;
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param id        L'identifiant du concert.
     * @param lieu      Le lieu du concert.
     * @param groupes   La liste des groupes jouant lors du concert.
     * @param heureDebut L'heure de début du concert.
     * @param heureFin  L'heure de fin du concert.
     */
    public Concert(Long id, Lieu lieu, ArrayList<Groupe> groupes, String heureDebut, String heureFin) {
        this.id = id;
        this.lieu = lieu;
        this.groupes = groupes;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(ArrayList<Groupe> groupes) {
        this.groupes = groupes;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Long getCompteur() {
        return compteur;
    }

    public void setCompteur(Long compteur) {
        this.compteur = compteur;
    }

    @Override
    public String toString() {
        return "Concert [id=" + id + ", lieu=" + lieu + ", groupes=" + groupes + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + ", compteur=" + compteur + "]";
    }
}
