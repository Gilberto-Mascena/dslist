
[Português Brasileiro](https://github.com/Gilberto-Mascena/dslist/blob/main/README-pt_br.md) |
[English](https://github.com/Gilberto-Mascena/dslist/blob/main/README.md)

![Status de Manutenção](https://img.shields.io/badge/Maintained-Yes-brightgreen?style=for-the-badge)
[![GitHub Actions Status](https://img.shields.io/github/actions/workflow/status/Gilberto-Mascena/dslist/build.yml?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/actions)
[![Licença](https://img.shields.io/github/license/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/blob/main/LICENSE.md)
[![Estrelas no GitHub](https://img.shields.io/github/stars/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/stargazers)
[![Problemas no GitHub](https://img.shields.io/github/issues/Gilberto-Mascena/dslist?style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/issues)
[![Versão do Repositório](https://img.shields.io/github/v/release/Gilberto-Mascena/dslist?include_prereleases&style=for-the-badge)](https://github.com/Gilberto-Mascena/dslist/releases)
![Data de Lançamento](https://img.shields.io/github/release-date/Gilberto-Mascena/dslist?style=for-the-badge)
![Tamanho do Repositório](https://img.shields.io/github/repo-size/Gilberto-Mascena/dslist?style=for-the-badge)

## Sobre o Projeto

### Este projeto faz parte do _Curso Intensivo Java e Spring Boot_, com foco no desenvolvimento back-end Java. O objetivo é construir uma aplicação back-end com um banco de dados para gerenciar uma lista de jogos, utilizando Java e o framework Spring Boot.

## Recursos

- **Operações CRUD para gerenciar dados de jogos**
- **Suporte a banco de dados H2 e PostgreSQL**
- **Configuração baseada em ambiente**
- **Teste de API com Postman ou Insomnia**
- **Integração Docker**

## Diagrama de Classe
![UML](assets/uml.png)

## Imagens do Front-end
![home](assets/dslist-home.png)
---
![page-1](assets/dslist-page-1.png)
---
![page-2](assets/dslist-page-2.png)

## Funcionalidades
- **Listar todos os jogos**
- **Buscar jogo por ID**
- **Mover jogo na lista**
- **Listar jogos na categoria**
- **Listar por categoria**

## Tecnologias utilizadas
- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Postgres](https://www.postgresql.org/)
- [UML](https://www.uml.org/)
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)

## Pré-requisitos

- [Java 17 ou superior](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/download) para testar a API.
- [Git](https://git-scm.com/)

## Executando o Projeto

- Clonando o Repositório

```bash
    git clone git@github.com:Gilberto-Mascena/dslist.git
    cd dslist
```

```bash
    mvn clean install
```

```bash
    mvn spring-boot:run
```

- Acesse o banco de dados em: http://localhost:8080/h2-console

- Configure a URL do JDBC com ``jdbc:h2:mem:devdb``, nome de usuário ``sa`` e clique em Conectar.

- Execute o script SQL:

```sql
INSERT INTO tb_game_list (name) VALUES ('Aventura e RPG');
INSERT INTO tb_game_list (name) VALUES ('Jogos de plataforma');

INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Mass Effect Trilogy', 4.8, 2012, 'Role-playing (RPG), Shooter', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Red Dead Redemption 2', 4.7, 2018, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('The Witcher 3: Wild Hunt', 4.7, 2014, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sekiro: Shadows Die Twice', 3.8, 2019, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ghost of Tsushima', 4.6, 2012, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Super Mario World', 4.7, 1990, 'Platform', 'Super Ness, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Hollow Knight', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ori and the Blind Forest', 4, 2015, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Cuphead', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sonic CD', 4, 1993, 'Platform', 'Sega CD, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 2, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 3, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 4, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 5, 4);

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 6, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 7, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 8, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 9, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 10, 4);
```

## Teste de API

- Com o projeto em execução.
- Importe a [Collection-postman](/assets/DSList%20API.postman_collection.json)
- Direto no navegador.
  http://localhost:8080/games

## Documentação da API
- Com o projeto em execução.
- Acesse o endereço: http://localhost:8080/swagger-ui.html

## 📜 *Licença*

*Este projeto é licenciado sob a Licença MIT. Veja mais detalhes em:* [_LICENSE.md_](./LICENSE.md)

### Gilberto | Dev _2023_