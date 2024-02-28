package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe<E> {
    private Map<Noeud<E>, List<NoeudCout<E>>> adjacence; // Utilisation d'une liste d'adjacence

    public Graphe() {
        this.adjacence = new HashMap<>();
    }

    public void ajouterNoeud(Noeud<E> noeud) {
        adjacence.putIfAbsent(noeud, new ArrayList<>());
    }

    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        ajouterNoeud(depart);
        ajouterNoeud(arrivee);
        adjacence.get(depart).add(new NoeudCout<>(arrivee, cout));
        // Si le graphe est non orienté, ajouter aussi l'arête de arrivee à depart.
        // adjacence.get(arrivee).add(new NoeudCout<>(depart, cout));
    }

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

    public List<Noeud<E>> getNoeuds() {
        return new ArrayList<>(adjacence.keySet());
    }

    public List<NoeudCout<E>> getVoisins(Noeud<E> noeud) {
        return adjacence.getOrDefault(noeud, new ArrayList<>());
    }
}

public class NoeudCout<E> {
    private Noeud<E> noeud;
    private double cout;

    public NoeudCout(Noeud<E> noeud, double cout) {
        this.noeud = noeud;
        this.cout = cout;
    }

    public Noeud<E> getNoeud() {
        return noeud;
    }

    public double getCout() {
        return cout;
    }
}
