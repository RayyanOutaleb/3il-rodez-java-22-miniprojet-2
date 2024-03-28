package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un nœud dans un graphe.
 *
 * @param <E> le type de valeur associé au nœud
 */
public class Noeud<E> {

    private E valeur;
    private List<Noeud<E>> voisins;

    /**
     * Initialise un nœud avec une valeur spécifiée.
     *
     * @param valeur la valeur associée au nœud
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<>();
    }

    /**
     * Récupère la valeur associée au nœud.
     *
     * @return la valeur associée au nœud
     */
    public E getValeur() {
        return valeur;
    }

    /**
     * Récupère la liste des voisins du nœud.
     *
     * @return la liste des voisins du nœud
     */
    public List<Noeud<E>> getVoisins() {
        return voisins;
    }

    /**
     * Ajoute un nœud voisin à ce nœud.
     *
     * @param voisin le nœud voisin à ajouter
     */
    public void ajouterVoisin(Noeud<E> voisin) {
        voisins.add(voisin);
    }
}
