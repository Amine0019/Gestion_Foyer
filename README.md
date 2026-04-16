# Gestion Foyer

Application Spring Boot pour la gestion des foyers universitaires: universites, foyers, blocs, chambres, etudiants et reservations.

## Sommaire

1. Presentation
2. Stack technique
3. Architecture du projet
4. Prerequis
5. Configuration
6. Lancement du projet
7. Documentation API (Swagger)
8. Endpoints REST
9. Exemples JSON
10. Taches planifiees
11. Tests
12. Points d attention

## 1) Presentation

Ce projet expose une API REST pour:

- gerer les entites principales (CRUD)
- affecter un bloc a un foyer
- rechercher des blocs selon des criteres metier
- retrouver la chambre d un etudiant a partir de son CIN
- executer des taches planifiees de monitoring des chambres

## 2) Stack technique

- Java 17
- Spring Boot 3.5.6
- Spring Web
- Spring Data JPA
- MySQL (driver mysql-connector-j)
- Lombok
- Springdoc OpenAPI (Swagger UI)
- MapStruct (dependance presente)
- Maven Wrapper

## 3) Architecture du projet

- src/main/java/tn/esprit/gestion_foyer/entities: modeles JPA
- src/main/java/tn/esprit/gestion_foyer/repositories: acces base de donnees
- src/main/java/tn/esprit/gestion_foyer/services: logique metier
- src/main/java/tn/esprit/gestion_foyer/controllers: API REST
- src/main/resources/application.properties: config runtime
- src/test/resources/application.properties: config tests

Entites principales:

- Universite
- Foyer
- Bloc
- Chambre
- Etudiant
- Reservation

## 4) Prerequis

- JDK 17 installe
- MySQL demarre en local
- utilisateur MySQL configure (par defaut root dans ce projet)

## 5) Configuration

Configuration principale actuelle (src/main/resources/application.properties):

- URL: jdbc:mysql://localhost:3306/GestionFoyerDb?createDatabaseIfNotExist=true
- User: root
- Password: (vide)
- Port serveur: 8089
- Context path: /GestionFoyer

Si besoin, adapte ces valeurs selon ton environnement local.

## 6) Lancement du projet

### Sous Windows (PowerShell)

```powershell
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

### Sous Linux / macOS

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Base URL de l application:

- http://localhost:8089/GestionFoyer

## 7) Documentation API (Swagger)

Une fois l application demarree:

- Swagger UI: http://localhost:8089/GestionFoyer/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8089/GestionFoyer/v3/api-docs

## 8) Endpoints REST

Les chemins ci-dessous sont relatifs a:

- http://localhost:8089/GestionFoyer

### BlocController (/blocController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /blocController/addBloc | Ajouter un bloc |
| PUT | /blocController/updateBloc | Mettre a jour un bloc |
| DELETE | /blocController/deleteBloc?idBloc={id} | Supprimer un bloc |
| GET | /blocController/findAllBloc | Liste des blocs |
| GET | /blocController/findProject?idBloc={id} | Bloc par id |
| POST | /blocController/addBlocAndAssignFoyer/{idFoyer} | Ajouter un bloc et l affecter a un foyer |
| PUT | /blocController/assignBlocToFoyer/{idBloc}/{idFoyer} | Affecter un bloc a un foyer |
| PUT | /blocController/unassignBlocFromFoyer/{idBloc} | Retirer l affectation d un bloc |
| GET | /blocController/sansFoyer | Blocs non affectes a un foyer |
| GET | /blocController/capaciteSup30 | Blocs avec capacite > 30 |
| GET | /blocController/nomCommencePar?lettre=A | Blocs dont le nom commence par une lettre |
| GET | /blocController/nomCommenceParEtCap?lettre=A&capacite=30 | Filtre combine nom + capacite |

### ChambreController (/chambreController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /chambreController/addChambre | Ajouter une chambre |
| PUT | /chambreController/updateChambre | Mettre a jour une chambre |
| DELETE | /chambreController/deleteChambre?idChambre={id} | Supprimer une chambre |
| GET | /chambreController/findAllChambre | Liste des chambres |
| GET | /chambreController/findChambre?idChambre={id} | Chambre par id |
| GET | /chambreController/byType?type=DOUBLE | Chambres par type |
| GET | /chambreController/byNumero?numero=101 | Chambre par numero |

### EtudiantController (/etudiantController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /etudiantController/addEtudiant | Ajouter un etudiant |
| PUT | /etudiantController/updateEtudiant | Mettre a jour un etudiant |
| DELETE | /etudiantController/deleteEtudiant?idEtudiant={id} | Supprimer un etudiant |
| GET | /etudiantController/findAllEtudiant | Liste des etudiants |
| GET | /etudiantController/findEtudiant?idEtudiant={id} | Etudiant par id |

### FoyerController (/foyerController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /foyerController/addFoyer | Ajouter un foyer |
| PUT | /foyerController/updateFoyer | Mettre a jour un foyer |
| DELETE | /foyerController/deleteFoyer?idFoyer={id} | Supprimer un foyer |
| GET | /foyerController/findAllFoyer | Liste des foyers |
| GET | /foyerController/findFoyer?idFoyer={id} | Foyer par id |

### ReservationController (/reservationController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /reservationController/addReservation | Ajouter une reservation |
| PUT | /reservationController/updateReservation | Mettre a jour une reservation |
| DELETE | /reservationController/deleteReservation?idReservation={id} | Supprimer une reservation |
| GET | /reservationController/findAllReservation | Liste des reservations |
| GET | /reservationController/findReservation?idReservation={id} | Reservation par id |

### UniversiteController (/universiteController)

| Methode | Endpoint | Description |
|---|---|---|
| POST | /universiteController/addUniversite | Ajouter une universite |
| PUT | /universiteController/updateUniversite | Mettre a jour une universite |
| DELETE | /universiteController/deleteUniversite?idUniversite={id} | Supprimer une universite |
| GET | /universiteController/findAllUniversite | Liste des universites |
| GET | /universiteController/findUniversite?idUniversite={id} | Universite par id |

### EtudiantChambreController (/etudiant)

| Methode | Endpoint | Description |
|---|---|---|
| GET | /etudiant/chambre?cin={cin} | Retourne la chambre associee a un etudiant |

## 9) Exemples JSON

### Exemple Bloc

```json
{
  "nomBloc": "A1",
  "capaciteBloc": 120
}
```

### Exemple Chambre

```json
{
  "numeroChambre": 101,
  "typeChambre": "DOUBLE"
}
```

### Exemple Etudiant

```json
{
  "nomEtudiant": "Ali",
  "prenomEtudiant": "Ben Salah",
  "cin": 12345678,
  "ecole": "ESPRIT",
  "dateNaissance": "2001-05-10T00:00:00.000+00:00"
}
```

### Exemple Reservation

```json
{
  "idReservation": "RES-2026-001",
  "anneeUniversitaire": "2026-09-01T00:00:00.000+00:00",
  "estValide": true
}
```

## 10) Taches planifiees

Le projet active le scheduling et execute periodiquement des taches metier:

- liste des chambres par bloc (toutes les 30 secondes)
- pourcentage des types de chambres (toutes les 40 secondes)
- nombre de places disponibles par chambre (toutes les 50 secondes)

## 11) Tests

Lancer les tests:

```powershell
.\mvnw.cmd test
```

Les tests utilisent aussi MySQL via src/test/resources/application.properties.

## 12) Points d attention

- Le projet est actuellement configure pour MySQL local.
- Si MySQL n est pas demarre, les tests Spring Boot echoueront.
- Une version MySQL recente (8+) est recommandee pour une meilleure compatibilite Hibernate.

---


