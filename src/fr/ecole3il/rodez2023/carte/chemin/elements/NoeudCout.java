package fr.ecole3il.rodez2023.carte.chemin.elements;

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
