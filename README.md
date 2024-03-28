# Photograph Collection Management

[Le projet en cours de développement est visible sur la branche dev]

## Genèse du projet
L'étude des ateliers de photographie de Cherbourg au XIXe siècle a permis de constituer une collection de tirages variés et en accroissement constant. En parallèle, une documentation historique est venue s'ajouter, au fil des recherches dans les archives. Depuis 2008, cette collection est inventoriée dans un fichier Excel, mis à jour manuellement au fur et à mesure des acquisitions. Les photographies sont scannées et enregistrées localement, sur un PC et un disque dur de sauvegarde.
## Objectif du projet
L'état initial de gestion du corpus constitue un frein à plusieurs niveaux :

_ Ressources stockées de manière locale limitant son accès ;

_ Enregistrement de chaque photographie de manière succincte et sans lien les unes des autres ;

_ Difficulté à faire ressortir des statistiques, tendances, chiffres sur les photos et leurs auteurs.

Le minimum viable product (MVP) de ce projet s'attache au développement d'un programme permettant à la fois de gérer une collection iconographique (ajout, recherche, valorisation) tout en proposant des outils d'analyse à des fins de recherches historiques (étude du mobilier, des fonds, de la clientèle...).

## Spécifications techniques
API Rest développée en Java version 17, utilisation du framework SpringBoot, de l'API JPA et de l'ORM Hibernate. Connexion à une base de données relationnelle MySQL (MCD disponible dans le dossier "doc"). Les images sont stockées sur Cloudinary, service de stockage de vidéos et d'image sur le Cloud.

## Développements futurs
_ Création d'une interface graphique d'administrateur en JavaFX, permettant l'ajout, la modification et la suppression de données.

_ Création d'une interface web de présentation des photographies et de notices biographiques au public. 
