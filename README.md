# 🥗 EasyFoodManaging

[![fr](https://img.shields.io/badge/lang-fr-red.svg)](https://github.com/CacTt4ck/EasyFoodManaging/blob/master/README_FR.md)
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/CacTt4ck/EasyFoodManaging/blob/master/README.md)

![Build Status](https://img.shields.io/github/actions/workflow/status/CacTt4ck/EasyFoodManaging/ci.yml?branch=master&label=Build&logo=github)
![Java Version](https://img.shields.io/badge/Java-21-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?logo=docker)
![License](https://img.shields.io/github/license/CacTt4ck/EasyFoodManaging)
![GitHub contributors](https://img.shields.io/github/contributors/CacTt4ck/EasyFoodManaging)

**EasyFoodManaging** is a comprehensive Backend application designed to streamline food management. It allows users to manage ingredients, compose recipes, and interact with external nutritional data sources.

## 🚀 Key Features

*   **Ingredient Management**: Full CRUD capabilities for food products.
*   **Recipe Management**: Create, organize, and manage culinary recipes.
*   **OpenFoodFacts Integration**: Automatically retrieve product information using barcodes or names.
*   **Robust Architecture**: Built on Spring Boot with a clear separation of concerns (Controller, Service, Repository).
*   **Docker Ready**: Simplified deployment with a pre-configured database via Docker Compose.

## 🛠 Tech Stack

*   **Language**: Java 21
*   **Framework**: Spring Boot (Web, Data JPA)
*   **Database**: PostgreSQL
*   **Build Tool**: Gradle
*   **Containerization**: Docker & Docker Compose
*   **CI/CD**: GitHub Actions

## 📋 Prerequisites

To run this project locally, you only need:

*   [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.
*   Git.

*Note: You do not need to install Java or PostgreSQL on your machine manually; Docker handles everything.*

## 🏁 Quick Start

Follow these steps to get the application running in minutes:

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/EasyFoodManaging.git
cd EasyFoodManaging
```

### 2. Configuration (Optional)
The project comes with a default file at the root. You can modify it if you wish to change the database credentials or the application port. `.env`
``` properties
# Example .env content
POSTGRES_USER=postgres
POSTGRES_PASSWORD=secret
POSTGRES_DB=easyfooddb
APP_PORT=8080
```

### 3. Run the application
Use Docker Compose to build the image and start both the database and the backend simultaneously:
``` bash
docker compose up --build
```

Once the startup is complete, the application will be accessible at: http://localhost:8080 (or the port defined in your .env file).

## 🧪 API Usage
The application exposes several REST endpoints. Here are a few examples (check your controllers for exact paths):
Ingredients: GET /api/ingredients
Recipes: GET /api/recipes
Tip: Use Postman or curl to test the endpoints.

## 📦 Project Structure
``` text
src/main/java/com/tcaputi/back/easyfoodmanaging
├── common          # Global configs, exception handling, logging
├── ingredient      # "Ingredient" domain (Model, Repo, Service, Controller)
├── recipe          # "Recipe" domain (Model, Repo, Service, Controller)
└── EasyFoodManagingApplication.java  # Entry point
```

## 🤝 Contributing
Contributions are welcome!
1. Fork the project.
2. Create your feature branch (git checkout -b feature/AmazingFeature).
3. Commit your changes (git commit -m 'Add some AmazingFeature').
4. Push to the branch (git push origin feature/AmazingFeature).
5. Open a Pull Request.

## 🛣️ Roadmap

- See the [Roadmap](https://github.com/users/CacTt4ck/projects/1) for a list of proposed features.
- See the [open issues](https://github.com/CacTt4ck/EasyFoodManaging/issues) for a list of issues.

## 📝 License
Distributed under the MIT License. See LICENSE for more information.