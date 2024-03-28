package fr.ecole3il.rodez2023.carte.elements;

import java.util.Objects;

/**
 * La classe Case représente une case sur une carte, caractérisée par une tuile et des coordonnées (x, y).
 * Elle permet de conserver la position (x, y) d'une tuile sur une carte.
 *
 * <p>
 * Chaque case est associée à une tuile spécifique et conserve ses coordonnées (x, y) sur la carte. Cette classe
 * fournit des méthodes pour accéder à la tuile associée ainsi qu'aux coordonnées de la case.
 * </p>
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>{@code
 * Tuile tuile = new Tuile(TypeTuile.DESERT);
 * Case caseDepart = new Case(tuile, 0, 0);
 * Tuile tuileAssociee = caseDepart.getTuile();
 * int x = caseDepart.getX();
 * int y = caseDepart.getY();
 * }</pre>
 * </p>
 *
 * <p>
 * La classe inclut également les méthodes equals, hashCode et toString pour une utilisation aisée des instances
 * de la classe dans les structures de données et pour l'affichage.
 * </p>
 *
 * @see Tuile
 * @author proussille
 */
public class Case {
    private Tuile tuile; // La tuile associée à cette case
    private int x; // Coordonnée x de la case sur la carte
    private int y; // Coordonnée y de la case sur la carte

    /**
     * Construit une nouvelle case avec la tuile spécifiée et les coordonnées (x, y) spécifiées.
     *
     * @param tuile La tuile associée à cette case.
     * @param x La coordonnée x de la case sur la carte.
     * @param y La coordonnée y de la case sur la carte.
     */
    public Case(Tuile tuile, int x, int y) {
        this.tuile = tuile;
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère la tuile associée à cette case.
     *
     * @return La tuile associée à cette case.
     */
    public Tuile getTuile() {
        return tuile;
    }

    /**
     * Récupère la coordonnée x de la case sur la carte.
     *
     * @return La coordonnée x de la case sur la carte.
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère la coordonnée y de la case sur la carte.
     *
     * @return La coordonnée y de la case sur la carte.
     */
    public int getY() {
        return y;
    }

    /**
     * Renvoie une représentation textuelle de la case sous forme de chaîne de caractères.
     *
     * @return Une chaîne de caractères représentant la case avec sa tuile et ses coordonnées.
     */
    @Override
    public String toString() {
        return "Case [tuile=" + tuile + ", x=" + x + ", y=" + y + "]";
    }

    /**
     * Indique si cette case est égale à un autre objet en comparant la tuile, les coordonnées x et y.
     *
     * @param o L'objet à comparer avec cette case.
     * @return true si l'objet spécifié est égal à cette case, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return x == aCase.x && y == aCase.y && Objects.equals(tuile, aCase.tuile);
    }

    /**
     * Calcule le code de hachage de cette case en utilisant sa tuile, ses coordonnées x et y.
     *
     * @return Le code de hachage de cette case.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tuile, x, y);
    }
}
