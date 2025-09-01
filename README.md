# 🚀 Projet CRUD avec Spring Boot

## 📌 Description
Ce projet est une API REST CRUD développée avec **Spring Boot 3** et **MySQL**.  
Il permet de gérer une liste de personnes avec les informations suivantes :
- `id` (identifiant auto-généré)
- `name` (nom de la personne) 
- `city` (ville de résidence)
- `phoneNumber` (numéro de téléphone)

## ⚙️ Technologies utilisées
- Java 17
- Spring Boot 3 (Spring Web, Spring Data JPA)
- MySQL
- Maven
- Postman (pour tester l'API)

## 🚀 Comment démarrer
1. Cloner le projet
2. Configurer la base de données MySQL
3. Lancer l'application avec `mvn spring-boot:run`
4. Tester les endpoints avec Postman

## 📋 Endpoints API
- `GET /api/persons` - Liste toutes les personnes
- `GET /api/persons/{id}` - Récupère une personne par ID
- `POST /api/persons` - Crée une nouvelle personne
- `PUT /api/persons/{id}` - Met à jour une personne
- `DELETE /api/persons/{id}` - Supprime une personne

---
*Version initiale - CRUD de base*
