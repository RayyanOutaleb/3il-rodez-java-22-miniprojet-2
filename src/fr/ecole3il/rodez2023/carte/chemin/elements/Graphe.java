package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Représente un graphe générique avec des nœuds et des arêtes pondérées.
 *
 * @param <E> le type des éléments des nœuds
 */
public class Graphe<E> {

    private Map<Noeud<E>, List<NoeudCout<E>>> adjacence; // Utilisation d'une liste d'adjacence

    /**
     * Initialise un graphe vide.
     */
    public Graphe() {
        this.adjacence = new HashMap<>();
    }

    /**
     * Ajoute un nœud au graphe.
     *
     * @param noeud le nœud à ajouter
     */
    public void ajouterNoeud(Noeud<E> noeud) {
        adjacence.putIfAbsent(noeud, new ArrayList<>());
    }

    /**
     * Ajoute une arête pondérée entre deux nœuds.
     *
     * @param depart  le nœud de départ
     * @param arrivee le nœud d'arrivée
     * @param cout    le coût de l'arête
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        ajouterNoeud(depart);
        ajouterNoeud(arrivee);
        adjacence.get(depart).add(new NoeudCout<>(arrivee, cout));
        // Si le graphe est non orienté, ajouter aussi l'arête de arrivee à depart.
        // adjacence.get(arrivee).add(new NoeudCout<>(depart, cout));
    }

    /**
     * Récupère le coût de l'arête entre deux nœuds.
     *
     * @param depart   le nœud de départ
     * @param arrivee  le nœud d'arrivée
     * @return le coût de l'arête entre les deux nœuds, ou Double.POSITIVE_INFINITY si l'arête n'existe pas
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        List<NoeudCout<E>> voisins = adjacence.get(depart);
        if (voisins != null) {
            for (NoeudCout<E> voisinCout : voisins) {
                if (voisinCout.getNoeud().equals(arrivee)) {
                    return voisinCout.getCout();
                }
            }
        }
        return Double.POSITIVE_INFINITY; // ou une autre valeur par défaut si l'arête n'existe pas
    }

    /**
     * Récupère la liste de tous les nœuds du graphe.
     *
     * @return une liste contenant tous les nœuds du graphe
     */
    public List<Noeud<E>> getNoeuds() {
        return new ArrayList<>(adjacence.keySet());
    }

    /**
     * Récupère la liste des nœuds voisins d'un nœud donné.
     *
     * @param noeud le nœud dont on veut récupérer les voisins
     * @return la liste des nœuds voisins du nœud donné, ou une liste vide si le nœud n'a pas de voisins
     */
    public List<NoeudCout<E>> getVoisins(Noeud<E> noeud) {
        return adjacence.getOrDefault(noeud, new ArrayList<>());
    }
}
