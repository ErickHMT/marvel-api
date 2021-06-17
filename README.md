# marvel-api

Aplicação back end responsável pela listagem de informações para o catálogo de super heróis, baseado na [API da Marvel](https://developer.marvel.com/docs#!/public).

## Endpoints
* `/v1/public/characters`
* `/v1/public/characters/{characterId}`
* `/v1/public/characters/{characterId}/comics`
* `/v1/public/characters/{characterId}/events`
* `/v1/public/characters/{characterId}/series`
* `/v1/public/characters/{characterId}/stories`

## Requisitos

Para realizar o build e executar a aplicação você irá precisar de:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org)

## Base de dados

Foi decidido utilizar a base de dados H2 em memória pela praticidade, em um ambiente produção o ideal seria optar por uma base de dados relacional.

Quando a aplicação for executada será automaticamente executado um script com as informações para a população da base, que está presente em resources/data.sql, 
você pode acessar uma interface para a manipulação dessa base no * `/v1/public/h2-console`.

## Executar a aplicação localmente

Há diversas maneiras de se executar uma aplicação Spring Boot localmente. Uma delas é executando o método `main` em `com.api.marvel.MarvelApplication` a partir da sua IDE.

Você também pode utilizar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) da seguinte maneira:

```shell
mvn spring-boot:run
```
