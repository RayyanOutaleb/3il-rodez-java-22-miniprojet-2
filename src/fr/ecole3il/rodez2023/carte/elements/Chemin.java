package fr.ecole3il.rodez2023.carte.elements;

import java.util.List;

/**
 * La classe Chemin représente un chemin sur une carte, composé d'une liste de cases.
 * Elle fournit des méthodes pour accéder aux cases du chemin et afficher le chemin.
 *
 * <p>
 * Un chemin est composé d'une liste ordonnée de cases, chacune représentant une position sur la carte.
 * La classe fournit des méthodes pour accéder à la liste des cases composant le chemin et pour afficher
 * le chemin sur la console avec les coordonnées et les tuiles de chaque case.
 * </p>
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>{@code
 * List<Case> cases = new ArrayList<>();
 * // Ajouter des cases au chemin...
 * Chemin chemin = new Chemin(cases);
 * chemin.afficherChemin();
 * }</pre>
 * </p>
 *
 * <p>
 * La classe ne fournit pas de méthode pour modifier la liste des cases après sa création. Une fois le chemin
 * créé, ses cases ne peuvent pas être modifiées.
 * </p>
 *
 * @see Case
 * @author proussille
 */
public class Chemin {
    private List<Case> cases; // Liste des cases composant le chemin

    /**
     * Construit un nouveau chemin avec la liste de cases spécifiée.
     *
     * @param cases La liste de cases composant le chemin.
     */
    public Chemin(List<Case> cases) {
        this.cases = cases;
    }

    /**
     * Récupère la liste des cases composant le chemin.
     *
     * @return La liste des cases composant le chemin.
     */
    public List<Case> getCases() {
        return cases;
    }

    /**
     * Affiche le chemin sur la console en affichant les coordonnées et les tuiles de chaque case.
     */
    public void afficherChemin() {
        System.out.println("Chemin :");
        for (Case c : cases) {
            System.out.println("[" + c.getX() + ", " + c.getY() + "] : " + c.getTuile());
        }
    }
}
