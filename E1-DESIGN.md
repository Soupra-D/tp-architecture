Design
========

Ce document décrit comment nous avons/allons implémenter la solution ultra-simplifiée de réservation de billet d'avion.

========

Schéma de données (MCD) : 

![UML](https://cdn.discordapp.com/attachments/763035147363680298/784472095505645628/unknown.png)

========

Modèle d'architecture :

![MODEL](https://cdn.discordapp.com/attachments/763035147363680298/784479790647607356/unknown.png)

le document .html utilise AJAX pour raffrachir ses composants sans avoir besoin de recharger la page

le document .html lance des actions à un code php

Le php questionne la base de données MySQL ou l'API

========

Connexion :
- L'utilisateur entre son pseudo, si l'utilisateur existe ça le connecte, sinon ça lui créé un compte
- Mot de passe facultatif ? Connexion juste par nom d'utilisateur suffisante ?

-> Prévoir un système de session (cookie suffisant ?)

Page principale : 
- Tableau qui liste tous les vols disponibles avec un bouton "réserver"

Page reservations
- Tableau qui liste mes vols réservés avec un bouton "déreservés"

========
Questions pour le professeur:

-> Besoin de prévoir un système qui tous les X temps (ici 24h) raffraichis la liste des vols ?

-> Besoin de passer par une API ou on peut directement questionner la base de données ?
