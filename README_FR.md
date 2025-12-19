# 🥗 EasyFoodManaging

[![fr](https://img.shields.io/badge/lang-fr-red.svg)](https://github.com/CacTt4ck/EasyFoodManaging/blob/master/README_FR.md)
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/CacTt4ck/EasyFoodManaging/blob/master/README.md)

![Build Status](https://img.shields.io/github/actions/workflow/status/CacTt4ck/EasyFoodManaging/ci.yml?branch=main&label=Build&logo=github)
![Java Version](https://img.shields.io/badge/Java-21-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?logo=docker)
![License](https://img.shields.io/github/license/CacTt4ck/EasyFoodManaging)

**EasyFoodManaging** est une application Backend complète conçue pour faciliter la gestion alimentaire. Elle permet de gérer des ingrédients, de composer des recettes et d'interagir avec des données nutritionnelles externes.

## 🚀 Fonctionnalités Principales

*   **Gestion des Ingrédients** : CRUD complet pour vos produits alimentaires.
*   **Gestion des Recettes** : Création et organisation de recettes culinaires.
*   **Intégration OpenFoodFacts** : Récupération automatique d'informations sur les produits via leur code-barres ou leur nom.
*   **Architecture Robuste** : Basée sur Spring Boot avec une séparation claire des couches (Controller, Service, Repository).
*   **Docker Ready** : Déploiement simplifié avec la base de données incluse via Docker Compose.

## 🛠 Stack Technique

*   **Langage** : Java 21
*   **Framework** : Spring Boot (Web, Data JPA)
*   **Base de données** : PostgreSQL
*   **Build Tool** : Gradle
*   **Conteneurisation** : Docker & Docker Compose
*   **CI/CD** : GitHub Actions

## 📋 Prérequis

Pour lancer ce projet localement, vous avez seulement besoin de :

*   [Docker Desktop](https://www.docker.com/products/docker-desktop/) installé et lancé.
*   Git.

*Note : Vous n'avez pas besoin d'installer Java ou PostgreSQL sur votre machine, Docker s'occupe de tout.*

## 🏁 Démarrage Rapide

Suivez ces étapes pour lancer l'application en quelques minutes :

### 1. Cloner le projet
```bash
git clone https://github.com/CacTt4ck/EasyFoodManaging.git
cd EasyFoodManaging
```

### 2. Configuration (Optionnel)
Le projet est fourni avec un fichier `.env` par défaut à la racine. Vous pouvez le modifier si vous souhaitez changer les mots de passe ou le port de l'application.
``` properties
# Exemple de contenu du fichier .env
POSTGRES_USER=postgres
POSTGRES_PASSWORD=secret
POSTGRES_DB=easyfooddb
APP_PORT=8080
```

### 3. Lancer l'application
Utilisez Docker Compose pour construire l'image et lancer la base de données et le backend simultanément :
``` bash
docker compose up --build
```

Une fois le démarrage terminé, l'application sera accessible sur : http://localhost:8080 (ou le port défini dans votre .env).

## 🧪 Utilisation de l'API
L'application expose plusieurs endpoints REST. Voici quelques exemples (à adapter selon vos contrôleurs exacts) :
Ingrédients : GET /api/ingredients
Recettes : GET /api/recipes
Conseil : Utilisez Postman ou curl pour tester les endpoints.

## 📦 Structure du Projet

``` text
src/main/java/com/tcaputi/back/easyfoodmanaging
├── common          # Configurations globales, gestion des exceptions, logs
├── ingredient      # Domaine "Ingrédient" (Model, Repo, Service, Controller)
├── recipe          # Domaine "Recette" (Model, Repo, Service, Controller)
└── EasyFoodManagingApplication.java  # Point d'entrée
```

## 🤝 Contribuer

Les contributions sont les bienvenues !
1. Forkez le projet.
2. Créez votre branche de fonctionnalité (git checkout -b feature/AmazingFeature).
3. Commitez vos changements (git commit -m 'Add some AmazingFeature').
4. Poussez vers la branche (git push origin feature/AmazingFeature).
5. Ouvrez une Pull Request.

## 📝 Licence
Distribué sous la licence MIT. Voir LICENSE pour plus d'informations.
