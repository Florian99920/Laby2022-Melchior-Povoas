# Laby2022-Melchior-Povoas
TP Laby en Qualité de Devs avec Melchior Damien et Povoas Florian

## Difficultés rencontrés au cours du TP

La chose qui nous a mis le plus en difficulté, c'est la méthode charger Labyrinthe puisqu'elle est très longue à réaliser car il y a beaucoup de vérifications comme pour gérer toutes les exceptions et en plus générales pour s'assurer du bon fonctionnement de la méthode. Mais à part ça, nous avons dû modifier plusieurs fois le MainLaby.java afin d'arriver au résultat voulut en gérant toutes les exceptions.

## Explications de nos choix de programmations



## Comment lancer notre application

Pour lancer notre application, il suffit de compiler tout notre programme puis l'exécuter en mettant le nom de fichier correspondant à un labyrinthe en argument comme ceci :

java MainLaby laby0.txt

Où laby0.txt correspond au labyrinthe choisis.

Une fois lancé, il affiche le labyrinthe choisi et il vous suffit de répondre à la question que le programme vous pose pour choisir une direction.
Pour finir le jeu, deux choix se porte à vous :
- terminer le jeu en amenant le personnage à la sortie, ce qui terminera le jeu automatiquement.
- Au lieu de donner une direction, marquer tout simplement "exit" qui terminera le jeu immédiatement.

## Résumé des résultats de nos tests

Nous avons en tout 30 tests permettant de tester toutes les méthodes de toutes les façons possibles.
Tout les tests sont réussis, il n'y a aucune erreur.

## Présentations de notre couverture de test

Notre couverture de test est de 100%, absolument toutes les situations sont testées pour toutes les méthodes et tous les tests fonctionnent.
- 8 tests différents pour la méthode getChar()
- 5 tests différents pour la méthodes getSuivant()
- 5 tests différents pour la méthodes deplacerPerso()
- 1 test pour la méthodes toString()
- 2 tests différents pour la méthode etreFinis()
- 10 tests différents pour la méthodes chargerLabyrinthe()