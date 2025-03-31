
[English](https://github.com/Gilberto-Mascena/dslist/blob/main/README.md) |
[Português Brasileiro](https://github.com/Gilberto-Mascena/dslist/blob/main/README-pt_br.md)

![Status de Manutenção](https://img.shields.io/badge/Maintained-Yes-brightgreen?style=for-the-badge)
[![GitHub Actions Status](https://img.shields.io/github/actions/workflow/status/Gilberto-Mascena/dslist/build.yml?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/actions)
[![Licença](https://img.shields.io/github/license/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/blob/main/LICENSE.md)
[![Estrelas no GitHub](https://img.shields.io/github/stars/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/stargazers)
[![Problemas no GitHub](https://img.shields.io/github/issues/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/issues)
[![Versão do Repositório](https://img.shields.io/github/v/release/Gilberto-Mascena/dslist?include_prereleases&style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/releases)
![Data de Lançamento](https://img.shields.io/github/release-date/Gilberto-Mascena/dslist?style=for-the-badge)
![Tamanho do Repositório](https://img.shields.io/github/repo-size/Gilberto-Mascena/dslist?style=for-the-badge)

## 🚀 About the Project

### This project is part of the _Java and Spring Boot Intensive Course_, focusing on Java back-end development. The goal is to build a back-end application with a database to manage a list of games, utilizing Java and the Spring Boot framework.

## 📌 Features

✅ CRUD operations for managing game data\
✅ RESTful API design\
✅ H2 and PostgreSQL database support\
✅ Environment-based configuration\
✅ API testing with Postman/Insomnia\
✅ Docker integration

## 📌 Class Diagram


![UML](assets/uml.png)

## 🛠️ Technologies used
- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/) 
- [H2 Database](https://www.h2database.com/html/main.html)
- [Postgres](https://www.postgresql.org/)
- [UML](https://www.uml.org/)
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)
## ⚙️ Prerequisites

- [Java 17 or higher](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Postgres](https://www.postgresql.org) (for production profile)
- [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/download) (for API testing)
- [Git](https://git-scm.com/)

## 🚀 Running the Project

🔹 Cloning the Repository

✅ If logged into GitHub:
```
git clone git@github.com:Gilberto-Mascena/dslist.git
```

❌ If not logged into GitHub:
```
git clone https://github.com/Gilberto-Mascena/dslist.git
```

🔹 Running with H2 Database

Open a terminal in the project folder and execute:

```
mvn spring-boot:run
```

Access the database at: http://localhost:8080/h2-console

Configure the JDBC URL with ``jdbc:h2:mem:testdb``, username ``sa``, and click Connect.

🔹 Running with PostgreSQL

Open the project in your IDE.

Rename ``sample.env`` to ``.env`` in the root folder and configure the database variables:

``DB_URL=jdbc:postgresql://localhost:5432/your_database_name``\
``DB_USER=postgres``\
``DB_PASSWORD=your_password``

Load the .env file in your OS or IDE.

Create the database in PostgreSQL with the same name as defined in .env.

Run the table creation script located in ``resources/import.sql``.

Set the profile in application.yml to prod.

Start the application.

## 🔎 API Testing
- With the project running execution.
- [Postman](https://www.postman.com/)
- [Insomnia](https://insomnia.rest/download)
- [Import collection Insomnia](assets/Insomnia_2024-12-13.json)

## 📃 API Documentation
- With the project running. 
- Access the address: http://localhost:8080/swagger-ui.html

## 📜 *License*

*This project is licensed under the MIT License. See more details at:* [_LICENSE.md_](./LICENSE.md)


### Gilberto | Dev _2023_