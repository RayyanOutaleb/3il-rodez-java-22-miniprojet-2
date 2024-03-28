Question : Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe et les informations associées à ces relations, comme les coûts des arêtes ?
La structure de données qui pourrait être utilisée pour stocker les relations entre les nœuds du graphe et les informations associées à ces relations est une liste d'adjacence.



Question : Pourquoi pensez-vous que les classes Noeud et Graphe ont été définies avec des paramètres génériques ?
Les paramètres génériques permettent aux classes Noeud et Graphe d'être utilisées avec différents types d'objets, offrant ainsi une flexibilité et une réutilisabilité accrues du code.



Question : Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?
La création d'une interface permet de définir un modèle commun que chaque algorithme de chemin doit suivre, facilitant ainsi l'utilisation interchangeable de ces algorithmes tout en garantissant un niveau d'abstraction approprié. Cela rend le code plus flexible et maintenable.



Réalisé du projet :

Implémentation des classes Noeud et Graphe avec des paramètres génériques pour assurer une utilisation flexible des types de données.
Développement de l'interface AlgorithmeChemin<E> pour standardiser les algorithmes de recherche de chemins dans un graphe.
Réalisation des algorithmes de Dijkstra et A* dans les classes AlgorithmeDijkstra<E> et AlgorithmeAEtoile<E> respectivement, en suivant les spécifications de l'interface AlgorithmeChemin<E>.
Création de la classe AdaptateurAlgorithme pour faciliter l'intégration des algorithmes avec l'interface graphique existante de Philibert.
Écriture de tests unitaires pour garantir le bon fonctionnement du code et sa robustesse.
Génération d'une documentation Javadoc pour fournir des informations détaillées sur l'utilisation et le fonctionnement des différentes classes et méthodes.