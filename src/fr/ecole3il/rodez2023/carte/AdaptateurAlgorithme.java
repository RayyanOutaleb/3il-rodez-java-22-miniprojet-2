package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptateur pour l'utilisation des algorithmes de chemin sur une carte.
 * Cet adaptateur permet de trouver un chemin entre deux cases sur une carte en utilisant un algorithme de chemin spécifié.
 * Il fournit également des méthodes pour la création d'un graphe à partir d'une carte et pour le calcul du chemin le plus court.
 *
 * @author [Auteur]
 * @version [Numéro de version]
 * @since [Date de création]
 */
public class AdaptateurAlgorithme {

    /**
     * Trouve un chemin entre deux cases sur la carte en utilisant l'algorithme spécifié.
     *
     * @param algorithme l'algorithme à utiliser pour trouver le chemin
     * @param carte      la carte sur laquelle se trouve le chemin
     * @param xDepart    coordonnée x du point de départ
     * @param yDepart    coordonnée y du point de départ
     * @param xArrivee   coordonnée x du point d'arrivée
     * @param yArrivee   coordonnée y du point d'arrivée
     * @return le chemin trouvé entre les deux points spécifiés
     */
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> noeudDepart = obtenirNoeud(graphe, xDepart, yDepart);
        Noeud<Case> noeudArrivee = obtenirNoeud(graphe, xArrivee, yArrivee);
        List<Noeud<Case>> cheminNoeuds = algorithme.trouverChemin(graphe, noeudDepart, noeudArrivee);
        List<Case> cheminCases = new ArrayList<>();
        for (Noeud<Case> noeud : cheminNoeuds) {
            cheminCases.add(noeud.getValeur());
        }

        return new Chemin(cheminCases);
    }

    /**
     * Construit un graphe à partir de la carte spécifiée.
     *
     * @param carte la carte utilisée pour construire le graphe
     * @return un graphe représentant la carte spécifiée
     */
    static Graphe<Case> creerGraphe(Carte carte) {
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();

        // Ajout des nœuds
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Case caseActuelle = new Case(carte.getTuile(x, y), x, y);
                graphe.ajouterNoeud(new Noeud<>(caseActuelle));
            }
        }

        // Ajout des arêtes entre les nœuds voisins
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Case caseActuelle = new Case(carte.getTuile(x, y), x, y);
                ajouterAretesVoisines(graphe, caseActuelle, x, y, largeur, hauteur);
            }
        }

        return graphe;
    }

    /**
     * Ajoute les arêtes connectant les cases voisines dans le graphe.
     *
     * @param graphe       le graphe sur lequel travailler
     * @param caseCourante la case actuelle
     * @param x            coordonnée x de la case actuelle
     * @param y            coordonnée y de la case actuelle
     * @param largeur      la largeur de la carte
     * @param hauteur      la hauteur de la carte
     */
    static void ajouterAretesVoisines(Graphe<Case> graphe, Case caseCourante, int x, int y, int largeur, int hauteur) {
        Noeud<Case> noeudCourant = null;
        for (Noeud<Case> noeud : graphe.getNoeuds()) {
            Case c = noeud.getValeur();
            if (c.equals(caseCourante)) {
                noeudCourant = noeud;
                break;
            }
        }

        assert noeudCourant != null;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < largeur && newY >= 0 && newY < hauteur) {
                Noeud<Case> noeudVoisin = obtenirNoeud(graphe, newX, newY);
                if (noeudVoisin != null) {
                    Case caseVoisine = noeudVoisin.getValeur();
                    double cout = calculerCout(caseCourante, caseVoisine);
                    graphe.ajouterArete(noeudCourant, noeudVoisin, cout);
                    noeudCourant.ajouterVoisin(noeudVoisin);
                }
            }
        }
    }

    /**
     * Calcule le coût entre deux cases.
     *
     * @param depuis la case de départ
     * @param vers   la case de destination
     * @return le coût calculé entre les deux cases spécifiées
     */
    static double calculerCout(Case depuis, Case vers) {
        return Math.abs(depuis.getX() - vers.getX()) + Math.abs(depuis.getY() - vers.getY());
    }

    /**
     * Récupère le nœud correspondant à une position donnée.
     *
     * @param graphe le graphe à partir duquel récupérer le nœud
     * @param x      la coordonnée x de la position
     * @param y      la coordonnée y de la position
     * @return le nœud correspondant à la position spécifiée, ou null si aucun nœud n'a été trouvé pour les coordonnées spécifiées
     */
    private static Noeud<Case> obtenirNoeud(Graphe graphe, int x, int y) {
        for (Object noeud : graphe.getNoeuds()) {
            Case caseActuelle = (Case) ((Noeud) noeud).getValeur();
            if (caseActuelle.getX() == x && caseActuelle.getY() == y) {
                return (Noeud) noeud;
            }
        }
        return null;
    }

}
