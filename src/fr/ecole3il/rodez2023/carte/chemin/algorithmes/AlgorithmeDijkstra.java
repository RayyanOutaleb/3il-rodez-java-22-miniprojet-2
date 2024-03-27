package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.chemin.elements.NoeudCout;
import fr.ecole3il.rodez2023.carte.elements.Carte;

import java.util.*;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        Map<Noeud<E>, Double> couts = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
        PriorityQueue<NoeudCout<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(NoeudCout::getCout));

        // Initialisation des structures de données
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

    @Override
    public Object trouverChemin(Carte carte, int x, int y, int x1, int y1) {
        return null;
    }
}
