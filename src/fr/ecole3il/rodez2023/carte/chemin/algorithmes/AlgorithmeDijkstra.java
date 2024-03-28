package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.chemin.elements.NoeudCout;

import java.util.*;

/**
 * Implémentation de l'algorithme de Dijkstra pour trouver le chemin le plus court dans un graphe pondéré.
 *
 * @param <E> le type des éléments du graphe
 */
public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    /**
     * Trouve le chemin le plus court entre deux nœuds dans un graphe pondéré en utilisant l'algorithme de Dijkstra.
     *
     * @param graphe   le graphe dans lequel chercher le chemin
     * @param depart   le nœud de départ
     * @param arrivee  le nœud d'arrivée
     * @return le chemin le plus court sous forme de liste de nœuds, ou null s'il n'y a aucun chemin
     */
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        // Initialisation des structures de données
        Map<Noeud<E>, Double> couts = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
        PriorityQueue<NoeudCout<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(NoeudCout::getCout));

        for (Noeud<E> noeud : graphe.getNoeuds()) {
            couts.put(noeud, Double.POSITIVE_INFINITY);
            predecesseurs.put(noeud, null);
        }
        couts.put(depart, 0.0);
        filePriorite.add(new NoeudCout<>(depart, 0.0));

        // Exploration des nœuds
        while (!filePriorite.isEmpty()) {
            Noeud<E> noeudActuel = filePriorite.poll().getNoeud();
            if (noeudActuel.equals(arrivee)) {
                break; // Sortir de la boucle si le nœud d'arrivée est atteint
            }
            for (NoeudCout<E> voisinCout : graphe.getVoisins(noeudActuel)) {
                Noeud<E> voisin = voisinCout.getNoeud();
                double nouveauCout = couts.get(noeudActuel) + voisinCout.getCout();
                if (nouveauCout < couts.get(voisin)) {
                    couts.put(voisin, nouveauCout);
                    predecesseurs.put(voisin, noeudActuel);
                    filePriorite.add(new NoeudCout<>(voisin, nouveauCout));
                }
            }
        }

        // Reconstruction du chemin le plus court
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeud = arrivee;
        while (noeud != null) {
            chemin.add(noeud);
            noeud = predecesseurs.get(noeud);
        }
        Collections.reverse(chemin);
        return chemin;
    }
}
