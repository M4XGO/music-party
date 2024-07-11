package fr.esgi.musique.maxime;

import fr.esgi.musique.maxime.buisness.*;
import fr.esgi.musique.maxime.utils.GroupeComparator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe principale de l'application Fête de la musique.
 */
public class App {
    private static ArrayList<Lieu> lieux = new ArrayList<>();
    private static ArrayList<Genre> genres = new ArrayList<>();
    private static ArrayList<Groupe> groupes = new ArrayList<>();
    private static ArrayList<Concert> concerts = new ArrayList<>();

    /**
     * Méthode principale pour démarrer l'application.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        initialiserDonnees();
        afficherMenu();
    }

    /**
     * Initialise les données de l'application.
     */
    private static void initialiserDonnees() {
        lieux.add(new Lieu(1L, "Péniche Le Sonic"));
        lieux.add(new Lieu(2L, "Pentes de la Croix-Rousse"));

        genres.add(new Genre(1L, "electro", new ArrayList<Groupe>()));
        genres.add(new Genre(2L, "pop", new ArrayList<Groupe>()));
        genres.add(new Genre(3L, "rock", new ArrayList<Groupe>()));
        genres.add(new Genre(4L, "heavy metal", new ArrayList<Groupe>()));
        genres.add(new Genre(5L, "rap", new ArrayList<Groupe>()));
        genres.add(new Genre(6L, "reggae", new ArrayList<Groupe>()));

        // Ajouter la logique pour importer les groupes depuis le fichier CSV
        importerGroupesDepuisCSV("https://www.clelia.fr/groupes.csv");
    }

    /**
     * Importe les groupes depuis un fichier CSV accessible via une URL.
     *
     * @param urlStr L'URL du fichier CSV.
     */
    private static void importerGroupesDepuisCSV(String urlStr) {
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                // Supprimer les guillemets autour du nom du groupe, s'il y en a
                String nom = parts[0].replaceAll("^\"|\"$", "").trim();

                String[] genresArray = parts[1].split("\\|");
                ArrayList<Genre> groupeGenres = new ArrayList<>();
                for (String genreStr : genresArray) {
                    //Supprimer les "" sur les genres dans le csv
                    genreStr = genreStr.replaceAll("^\"|\"$", "").trim();
                    for (Genre genre : genres) {
                        if (genre.getNom().equalsIgnoreCase(genreStr.trim())) {
                            groupeGenres.add(genre);
                            break;
                        }
                    }
                }
                Groupe groupe = new Groupe((long) (groupes.size() + 1), nom, groupeGenres);
                groupes.add(groupe);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Affiche le menu principal et gère les interactions avec l'utilisateur.
     */
    private static void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenue sur Fête de la musique !");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 : ajouter un groupe");
            System.out.println("2 : voir les groupes triés alphabétiquement");
            System.out.println("3 : ajouter un concert");
            System.out.println("4 : voir tous les concerts");
            System.out.println("5 : quitter");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    ajouterGroupe(scanner);
                    break;
                case 2:
                    voirGroupesTries();
                    break;
                case 3:
                    ajouterConcert(scanner);
                    break;
                case 4:
                    voirTousConcerts();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    /**
     * Ajoute un groupe en demandant les informations à l'utilisateur.
     *
     * @param scanner L'objet Scanner pour lire les entrées de l'utilisateur.
     */
    private static void ajouterGroupe(Scanner scanner) {
        System.out.println("Ajout d’un groupe");
        System.out.print("Entrez le nom de l’adhérent : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le(s) genre(s) du groupe (séparés par des virgules) : ");
        String genresStr = scanner.nextLine();
        String[] genresArray = genresStr.split(",");
        ArrayList<Genre> groupeGenres = new ArrayList<>();
        for (String genre : genresArray) {
            for (Genre g : genres) {
                if (g.getNom().equalsIgnoreCase(genre.trim())) {
                    groupeGenres.add(g);
                    break;
                }
            }
        }
        Groupe groupe = new Groupe((long) (groupes.size() + 1), nom, groupeGenres);
        groupes.add(groupe);
        System.out.println("Le groupe a bien été ajouté, il porte l'id " + groupe.getId());
    }

    /**
     * Affiche les groupes triés alphabétiquement par nom.
     */
    private static void voirGroupesTries() {
        Collections.sort(groupes, new GroupeComparator());
        for (Groupe groupe : groupes) {
            System.out.println(groupe.getName());
        }
    }

    /**
     * Ajoute un concert en demandant les informations à l'utilisateur.
     *
     * @param scanner L'objet Scanner pour lire les entrées de l'utilisateur.
     */
    private static void ajouterConcert(Scanner scanner) {
        System.out.println("Ajout d’un concert");
        System.out.println("Choisissez le lieu du concert :");
        for (int i = 0; i < lieux.size(); i++) {
            System.out.println((i + 1) + ". " + lieux.get(i).getNom());
        }
        System.out.println("Entrez votre choix :");
        int choixLieu = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Lieu lieu = lieux.get(choixLieu - 1);

        System.out.println("Choisissez le groupe :");
        for (int i = 0; i < groupes.size(); i++) {
            System.out.println((i + 1) + ". " + groupes.get(i).getName());
        }
        System.out.println("Entrez votre choix :");
        int choixGroupe = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Groupe groupe = groupes.get(choixGroupe - 1);
        ArrayList<Groupe> concertGroupes = new ArrayList<>();
        concertGroupes.add(groupe);

        System.out.print("Entrez l’heure de début (HH:mm) : ");
        String heureDebut = scanner.nextLine();
        System.out.print("Entrez l’heure de fin (HH:mm) : ");
        String heureFin = scanner.nextLine();

        Concert concert = new Concert((long) (concerts.size() + 1), lieu, concertGroupes, heureDebut, heureFin);
        concerts.add(concert);
        System.out.println("Le concert a bien été ajouté, il porte l'id " + concert.getId());
    }

    /**
     * Affiche tous les concerts enregistrés.
     */
    private static void voirTousConcerts() {
        for (Concert concert : concerts) {
            System.out.println(concert.getGroupes().get(0).getName() + " va jouer à " + concert.getLieu().getNom() + " de " + concert.getHeureDebut() + " à " + concert.getHeureFin());
        }
    }
}
