[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Gilberto-Mascena/dslist)
[![license](https://img.shields.io/github/license/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/blob/main/LICENSE.md)
[![GitHub stars](https://img.shields.io/github/stars/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/Gilberto-Mascena/dslist)](https://github.com/Gilberto-Mascena/dslist/issues)
[![tag](https://img.shields.io/github/v/release/Gilberto-Mascena/dslist?include_prereleases)](https://github.com/Gilberto-Mascena/dslist/releases)
![release](https://img.shields.io/github/release-date/Gilberto-Mascena/dslist)
![size](https://img.shields.io/github/repo-size/Gilberto-Mascena/dslist)

[Português Brasileiro](https://github.com/Gilberto-Mascena/dslist/blob/main/README-pt_br.md) |
[English](https://github.com/Gilberto-Mascena/dslist/blob/main/README.md) 
## *🚀 Sobre o projeto*

#### Intensivão Java e Spring Boot, formação de desenvolvedor back-end java.

Criar um aplicação back-end com banco de dados para lista de jogos.
Projeto desenvolvido em Java, utilizando o framework Spring Boot, na linha de comando

### Diagrama de classes
![UML](assets/uml.png)

### *Tecnologias usadas*
- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Postgres](https://www.postgresql.org/)
- [UML](https://www.uml.org/)
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)

### Pré requisitos

- [Java 17 ou superior](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Postgres](https://www.postgresql.org/) para usar no perfil de desenvolvimento.
- [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/download) para testar a API no perfil de  desenvolvimento.
- [Git](https://git-scm.com/)

### Como executar o projeto:

- Clone o projeto:
- *Logado no GitHub*.
```
    git clone git@github.com:Gilberto-Mascena/dslist.git     
```
- *Sem estar logado no GitHub*.
```
    git clone https://github.com/Gilberto-Mascena/dslist.git
``` 

### *Com H2 Database*
- Abra um terminal ou prompt na pasta do projeto e execute o comando:

```
    mvn spring-boot:run
```
- Acesse o endereço: http://localhost:8080/h2-console
- Preencha o campo "JDBC URL" com o valor "jdbc:h2:mem:testdb, username "sa" e clique em "Connect".


### *Com Postgres*
- Abra o projeto em uma IDE de sua preferência.
- Na raíz do projeto, renomeie o arquivo chamado sample.env para .env e adicione os dados nas variáveis criadas, salve o arquivo!.
    - Exemplo de arquivo .env:
```
    DB_URL=jdbc:postgresql://localhost:5432/"your-database name!"
    DB_USER=postgres
    DB_PASSWORD=123456
```
- Carregue o arquivo .env no Sistema Operacional ou IDE.
- Crie um banco de dados no Postgres com o nome que você definiu no arquivo .env.
- Execute o script de criação de tabelas que está na pasta resources do projeto, "import.sql".
- Mudar o perfil no arquivo application.yml para "prod".
- Execute o projeto.

### *Acessando o banco de dados com testador de API*
- Com o projeto em execução.
- [Postman](https://www.postman.com/)
- [Insomnia](https://insomnia.rest/download)
- [Importe collection imsomnia](assets/Insomnia_2024-12-13.json)

### *Documentação da API*
- Com o projeto em execução.
- Acesse o endereço: http://localhost:8080/swagger-ui.html

### *Licença*

[*Licença MIT*](LICENSE.md) (*MIT*)

### Gilberto | Dev _2023_