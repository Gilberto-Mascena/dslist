[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Gilberto-Mascena/dslist)
[![license](https://img.shields.io/github/license/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/blob/main/LICENSE.md)
[![GitHub stars](https://img.shields.io/github/stars/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/issues)
[![tag](https://img.shields.io/github/v/release/Gilberto-Mascena/dslist?include_prereleases)](https://github.com/Gilberto-Mascena/dslist/releases)
![release](https://img.shields.io/github/release-date/Gilberto-Mascena/dslist)
![size](https://img.shields.io/github/repo-size/Gilberto-Mascena/dslist)

[English](https://github.com/Gilberto-Mascena/dslist/blob/main/README.md) |
[Português Brasileiro](https://github.com/Gilberto-Mascena/dslist/blob/main/README-pt_br.md)

## *🚀 About the project*

#### Java and Spring Boot Intensive Course , Java back-end developer training.

Create a back-end application with a database for a list of games. Project developed in Java, using the Spring Boot framework, on the command line

### Class diagram
![UML](assets/uml.png)

### *Technologies used*
- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/) 
- [H2 Database](https://www.h2database.com/html/main.html)
- [Postgres](https://www.postgresql.org/)
- [UML](https://www.uml.org/)
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)
### Prerequisites

- [Java 17 or higher](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Postgres](https://www.postgresql.org) to use in the development profile.
- [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/download) to test the API in the development profile development.
- [Git](https://git-scm.com/)

### How to run the project:

- Clone the project:
- *Logged into GitHub*.

```
git clone git@github.com: Gilberto-Mascena/dslist.git
```
- *Not logged into GitHub*. 

```
  git clone https://github.com/Gilberto-Mascena/dslist.git
```

### *With H2 Database*
- Open a terminal or prompt in the project folder and run the command:

```
mvn spring-boot:run
```
- Access the address: http://localhost:8080/h2-console
- Fill in the "JDBC URL" field with the value "jdbc:h2:mem:testdb, username "sa" and click in "Connect".

### *With Postgres*
- Open the project in an IDE of your choice.
- In the root of the project, rename the file called sample.env to .env and add the data to the variables created, save the file!.
- Example of .env file:

```
DB_URL=jdbc:postgresql://localhost:5432/"your-database name!"
DB_USER=postgres
DB_PASSWORD=123456
```
- Load the .env file into your Operating System or IDE.
- Create a database in Postgres with the name you defined in the .env file.
- Run the table creation script that is in the project's resources folder, "import.sql".
- Change the profile in the application.yml file to "prod".
- Run the project.

### *Accessing the database with API tester*
- With the project running execution.
- [Postman](https://www.postman.com/)
- [Insomnia](https://insomnia.rest/download)
- [Import collection Insomnia](assets/Insomnia_2024-12-13.json)

- ### *API Documentation*
- With the project running. 
- Access the address: http://localhost:8080/swagger-ui.html

### *License*

[*MIT License*](LICENSE.md) (*MIT*)

### Gilberto | Dev _2023_