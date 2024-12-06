Voici le fichier README.md pour le backend Java Spring Boot :

# Backend (Java Spring Boot)

Compilez et lancez l'application Spring Boot :

```
mvn clean install
mvn spring-boot:run
```

Le backend sera accessible à l'adresse `http://localhost:8080`.

## Configuration

Le backend utilise les variables d'environnement suivantes :

- `SPRING_DATASOURCE_URL` : URL de la base de données
- `SPRING_DATASOURCE_USERNAME` : Nom d'utilisateur de la base de données
- `SPRING_DATASOURCE_PASSWORD` : Mot de passe de la base de données
- `SWAGGER` : http://localhost:8080/swagger-ui/index.html



## Structure du projet

- `src/main/java/com/example/xarala` : Contient les classes Java du backend
- `src/main/resources` : Contient les fichiers de configuration et les ressources
- `pom.xml` : Fichier de configuration Maven

## Dépendances

Le projet backend utilise les dépendances suivantes :

- `spring-boot-starter-data-jpa` : Pour la gestion des données et la persistance
- `spring-boot-starter-validation` : Pour la validation des données
- `spring-boot-starter-web` : Pour la création d'API REST
- `postgresql` : Pilote JDBC pour la base de données PostgreSQL
- `springdoc-openapi-starter-webmvc-ui` : Pour générer la documentation de l'API
- `lombok` : Pour simplifier l'écriture du code
- `modelmapper` : Pour mapper les DTO et les entités
- `spring-boot-devtools` : Pour le développement
- `h2` : Base de données embarquée pour les tests
