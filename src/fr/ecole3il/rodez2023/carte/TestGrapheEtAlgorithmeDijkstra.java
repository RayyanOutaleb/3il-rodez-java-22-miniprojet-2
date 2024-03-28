package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeDijkstra;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TestGrapheEtAlgorithmeDijkstra {

    @Test
    public void testAjouterNoeud() {
        // Création d'un graphe
        Graphe<Integer> graphe = new Graphe<>();

        // Ajout d'un nœud au graphe
        Noeud<Integer> noeud = new Noeud<>(1);
        graphe.ajouterNoeud(noeud);

        // Vérification que le nœud a été ajouté avec succès
        assertTrue(graphe.getNoeuds().contains(noeud));
    }

    @Test
    public void testTrouverChemin() {
        // Création d'un graphe de test
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> depart = new Noeud<>(1);
        Noeud<Integer> arrivee = new Noeud<>(2);
        graphe.ajouterNoeud(depart);
        graphe.ajouterNoeud(arrivee);
        graphe.ajouterArete(depart, arrivee, 5); // Coût de l'arête de départ à arrivée

        // Création de l'algorithme de Dijkstra
        AlgorithmeDijkstra<Integer> dijkstra = new AlgorithmeDijkstra<>();

        // Recherche du chemin le plus court
        List<Noeud<Integer>> chemin = dijkstra.trouverChemin(graphe, depart, arrivee);

        // Vérification que le chemin est correct
        assertEquals(2, chemin.size()); // Le chemin doit contenir deux nœuds (départ et arrivée)
        assertEquals(depart, chemin.get(0)); // Le premier nœud doit être le nœud de départ
        assertEquals(arrivee, chemin.get(1)); // Le deuxième nœud doit être le nœud d'arrivée
    }
}
