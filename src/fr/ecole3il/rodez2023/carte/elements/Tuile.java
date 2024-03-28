package fr.ecole3il.rodez2023.carte.elements;

/**
 * L'énumération Tuile représente les différents types de tuiles pouvant être présents sur une carte.
 * Chaque type de tuile a une pénalité associée.
 *
 * <p>
 * Les types de tuiles disponibles sont : DESERT, MONTAGNES, PLAINE et FORET. Chaque type de tuile a une
 * pénalité de déplacement associée, indiquant la difficulté de traverser cette tuile.
 * </p>
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>{@code
 * // Accéder à la pénalité de déplacement d'une tuile
 * int penaliteMontagnes = Tuile.MONTAGNES.getPenalite();
 * }</pre>
 * </p>
 *
 * <p>
 * Les valeurs de pénalité associées à chaque type de tuile sont les suivantes :
 * <ul>
 *     <li>DESERT: 1</li>
 *     <li>MONTAGNES: 3</li>
 *     <li>PLAINE: 2</li>
 *     <li>FORET: 4</li>
 * </ul>
 * </p>
 *
 * <p>
 * Chaque valeur d'énumération est associée à une pénalité de déplacement fixe, qui peut être récupérée
 * à l'aide de la méthode {@link #getPenalite()}.
 * </p>
 *
 * @see Carte
 * @see Case
 * @author proussille
 */
public enum Tuile {
    DESERT(1), // Tuile désert avec une pénalité de déplacement de 1
    MONTAGNES(3), // Tuile montagnes avec une pénalité de déplacement de 3
    PLAINE(2), // Tuile plaine avec une pénalité de déplacement de 2
    FORET(4); // Tuile forêt avec une pénalité de déplacement de 4

    private final int penalite; // Pénalité de déplacement associée à la tuile

    /**
     * Construit une nouvelle tuile avec la pénalité spécifiée.
     *
     * @param penalite La pénalité de déplacement associée à la tuile.
     */
    Tuile(int penalite) {
        this.penalite = penalite;
    }

    /**
     * Récupère la pénalité de déplacement associée à la tuile.
     *
     * @return La pénalité de déplacement associée à la tuile.
     */
    public int getPenalite() {
        return penalite;
    }
}
