package fr.ecole3il.rodez2023.carte.elements;

/**
 * La classe Carte représente une carte composée de tuiles disposées en une grille bidimensionnelle.
 *
 * <p>
 * Cette classe permet de manipuler une carte constituée de tuiles. Chaque tuile est située à des coordonnées spécifiques
 * sur la carte, formant ainsi une grille bidimensionnelle. La carte est représentée par une matrice de tuiles.
 * </p>
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>{@code
 * Tuile[][] tuiles = new Tuile[10][10];
 * // Initialisation des tuiles...
 * Carte carte = new Carte(tuiles);
 * Tuile tuile = carte.getTuile(3, 4);
 * }</pre>
 * </p>
 *
 * @author proussille
 */
public class Carte {
    private Tuile[][] tuiles; // Matrice de tuiles représentant la carte

    /**
     * Construit une nouvelle carte avec les tuiles spécifiées.
     *
     * @param tuiles La matrice de tuiles représentant la carte.
     */
    public Carte(Tuile[][] tuiles) {
        this.tuiles = tuiles;
    }

    /**
     * Récupère la tuile située aux coordonnées spécifiées.
     *
     * @param x La coordonnée x de la tuile.
     * @param y La coordonnée y de la tuile.
     * @return La tuile située aux coordonnées spécifiées.
     */
    public Tuile getTuile(int x, int y) {
        return tuiles[x][y];
    }

    /**
     * Récupère la largeur de la carte (nombre de colonnes).
     *
     * @return La largeur de la carte.
     */
    public int getLargeur() {
        return tuiles.length;
    }

    /**
     * Récupère la hauteur de la carte (nombre de lignes).
     *
     * @return La hauteur de la carte.
     */
    public int getHauteur() {
        return tuiles[0].length;
    }
}
