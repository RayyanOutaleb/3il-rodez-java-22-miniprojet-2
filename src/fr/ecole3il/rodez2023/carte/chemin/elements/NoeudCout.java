package fr.ecole3il.rodez2023.carte.chemin.elements;

/**
 * Représente un nœud avec un coût associé.
 *
 * @param <E> le type de valeur associé au nœud
 */
public class NoeudCout<E> {

    private Noeud<E> noeud;
    private double cout;

    /**
     * Initialise un nœud avec un coût associé.
     *
     * @param noeud le nœud associé
     * @param cout  le coût associé au nœud
     */
    public NoeudCout(Noeud<E> noeud, double cout) {
        this.noeud = noeud;
        this.cout = cout;
    }

    /**
     * Récupère le nœud associé.
     *
     * @return le nœud associé
     */
    public Noeud<E> getNoeud() {
        return noeud;
    }

    /**
     * Récupère le coût associé au nœud.
     *
     * @return le coût associé au nœud
     */
    public double getCout() {
        return cout;
    }
}
