package fr.esgi.musique.maxime.utils;

import fr.esgi.musique.maxime.buisness.Groupe;
import java.util.Comparator;

/**
 * Comparator pour trier les groupes par nom.
 */
public class GroupeComparator implements Comparator<Groupe> {
    @Override
    public int compare(Groupe g1, Groupe g2) {
        return g1.getName().compareTo(g2.getName());
    }
}
