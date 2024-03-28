package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.List;

/**
 * Interface représentant un algorithme de recherche de chemin dans un graphe.
 *
 * @param <E> le type des éléments du graphe
 */
public interface AlgorithmeChemin<E> {

    /**
     * Trouve le chemin le plus court entre deux nœuds dans un graphe.
     *
     * @param graphe   le graphe dans lequel chercher le chemin
     * @param depart   le nœud de départ
     * @param arrivee  le nœud d'arrivée
     * @return le chemin trouvé sous forme de liste de nœuds, ou null si aucun chemin n'a été trouvé
     */
    List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}
