package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.chemin.elements.NoeudCout;
import fr.ecole3il.rodez2023.carte.elements.Carte;

import java.util.*;

/**
 * Implémentation de l'algorithme A* pour trouver le chemin le plus court entre deux nœuds dans un graphe.
 *
 * @param <E> le type des éléments du graphe
 */
public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {

    /**
     * Trouve le chemin le plus court entre deux nœuds dans un graphe en utilisant l'algorithme A*.
     *
     * @param graphe   le graphe dans lequel chercher le chemin
     * @param depart   le nœud de départ
     * @param arrivee  le nœud d'arrivée
     * @return le chemin trouvé sous forme de liste de nœuds, ou null si aucun chemin n'a été trouvé
     */
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        PriorityQueue<NoeudCoutEstime<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(NoeudCoutEstime::getCoutEstime));
        Set<Noeud<E>> noeudsExplores = new HashSet<>();
        Map<Noeud<E>, Double> coutTotalEstime = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();

        // Initialisation des coûts
        for (Noeud<E> noeud : graphe.getNoeuds()) {
            coutTotalEstime.put(noeud, Double.POSITIVE_INFINITY);
        }
        coutTotalEstime.put(depart, 0.0);

        // Ajouter le nœud de départ à la file de priorité
        filePriorite.add(new NoeudCoutEstime<>(depart, 0.0));

        // Boucle principale
        while (!filePriorite.isEmpty()) {
            Noeud<E> noeudActuel = filePriorite.poll().getNoeud();
            if (noeudActuel.equals(arrivee)) {
                break; // Arrêter l'algorithme si le nœud d'arrivée est atteint
            }
            noeudsExplores.add(noeudActuel);

            // Examiner les voisins du nœud actuel
            for (NoeudCout<E> voisinCout : graphe.getVoisins(noeudActuel)) {
                Noeud<E> voisin = voisinCout.getNoeud();
                if (noeudsExplores.contains(voisin)) {
                    continue; // Passer au voisin suivant s'il a déjà été exploré
                }
                double nouveauCout = coutTotalEstime.get(noeudActuel) + voisinCout.getCout();
                if (nouveauCout < coutTotalEstime.get(voisin)) {
                    coutTotalEstime.put(voisin, nouveauCout);
                    predecesseurs.put(voisin, noeudActuel);
                    double coutEstime = nouveauCout + estimerCoutRestant(voisin, arrivee); // Estimation heuristique
                    filePriorite.add(new NoeudCoutEstime<>(voisin, coutEstime));
                }
            }
        }

        // Reconstruction du chemin
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeud = arrivee;
        while (noeud != null) {
            chemin.add(noeud);
            noeud = predecesseurs.get(noeud);
        }
        Collections.reverse(chemin);
        return chemin;
    }

    // Méthode pour estimer le coût restant jusqu'à l'arrivée (heuristique)
    private double estimerCoutRestant(Noeud<E> noeud, Noeud<E> arrivee) {
        // Implémentez votre heuristique ici
        // Par exemple, vous pouvez utiliser la distance à vol d'oiseau ou une autre estimation basée sur les caractéristiques du problème
        return 0.0; // Pour cet exemple, nous supposons une heuristique triviale qui retourne toujours 0
    }
}

/**
 * Classe auxiliaire représentant un nœud avec son coût estimé pour l'algorithme A*.
 *
 * @param <E> le type des éléments du nœud
 */
class NoeudCoutEstime<E> {
    private Noeud<E> noeud;
    private double coutEstime;

    /**
     * Constructeur de la classe NoeudCoutEstime.
     *
     * @param noeud      le nœud
     * @param coutEstime le coût estimé
     */
    public NoeudCoutEstime(Noeud<E> noeud, double coutEstime) {
        this.noeud = noeud;
        this.coutEstime = coutEstime;
    }

    /**
     * Récupère le nœud associé à cet objet.
     *
     * @return le nœud
     */
    public Noeud<E> getNoeud() {
        return noeud;
    }

    /**
     * Récupère le coût estimé associé à cet objet.
     *
     * @return le coût estimé
     */
    public double getCoutEstime() {
        return coutEstime;
    }
}
