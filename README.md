# TP Architecture Distribué

Ce TP fonctionne par groupe de 4 ou 5.
Nous allons réalisé une solution, ultra simplifié de reservation de billet d'avion.
Nous gérons 3 aéroports:
- New York qui porte le code JFK
- CDG Paris qui porte le code CDG
- Detroit qui porte le code DTW

Tout les jours, des billets d'avions sont disponible.
Un billet d'avion est consituté:
- D'un code depart
- D'un code destination
- D'un prix (en Euros)

__CDG-JFK 400__ represente donc un billet d'avion au départ de Paris et à destination de New York à 400 euros.

## Etape 0

- Forker ce [repository](https://github.com/ESIEA-Distributed-Architecture/tp-architecture)
- Ajouter les membres de votre groupe a ce repository pour les besoins de commit
- Creer une branche qui porte le nom de la façon constituer de la façon suivante: {code-promo}-{nom-de-votre-groupe}
- Creer le fichier MEMBERS.md, a l'interieur de ce fichier, rentrer le prénom et nom de chacune des personnes de votre groupe
- Votre projet devra se trouver dans le dossier ```projet``` a l'interieur de ce [repository](https://github.com/ESIEA-Distributed-Architecture/tp-architecture)
- Faites une Pull Request entre votre branche ```{code-promo}-{nom-de-votre-groupe}``` et la branche ```main``` de ce [repository](https://github.com/ESIEA-Distributed-Architecture/tp-architecture)

## Etape 1

Designer ce systeme de reservation de billet d'avion.

La solution doit permettre:
- de permettre à un utilisateur de voir la liste des voles disponible
- de reservations des billets d'avion 
- de voir ce qu'il a reservé

Vous présenterez votre design à tous, vous êtes attendu sur:
- L'architecture globale
- Le modele de donnée stocké
- La stack technique

Votre deisgn devra se trouver dans le fichier ```projet/E1-DESIGN.md```

## Etape 2

Implémentez votre solution, votre code devra se trouver dans le dossier ```project/code```
Lorsque vous avez terminé, venez me voir pour la suite...

## Etape 3

Surprise !

# Réalisation 

Le projet est une "single page application", on a donc une page unique qui permet d'effectuer toute les actions.
La page est réalisé avec Ajax, elle apelle une API Rest réalisé avec Springboot.
L'application garte tout en mémoire, il n'y a pas de base de donnée.
Rien n'est sauvegardé en cache du navigateur. L'utilisateur peux fermer son navigateur, sa réservation sera toujours présent.

Pour faciliter les tests et l'utilisation en démo, nous avons mis des menus déroualant pour la selection des emails.
Pour une application en production, nous pouvons remplacer ce menus par un boit de saisie.

La commande d'un billet se fait en 3 étape.

## Etape 1 :

Le clients s'identifie via son adresse email.
Un fois inscrit un message valide son inscription.
![Image 1](https://puu.sh/GX8On.png)

## Etape 2 :

Le client peut voir la liste des billets disponibles.
Il peut effectuer un achat. Pour cela il selectionne son email pui clic sur "Réserver".

![Image 2](https://puu.sh/GX8Si.png)

## Etape 3 :

Le clients peut visualier les billets qu'il a acheté. 
Il choisi son email dans le menu déroulant.


![Image 3](https://puu.sh/GX8Tp.png)

## Fix et Ajouts 

Certains éléments sont encore à modifier.
  - Décrémenter le nombre de place disponible apres une réservation d'un client.
