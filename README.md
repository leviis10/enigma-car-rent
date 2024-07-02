# Car Rent

## Kelompok

- Levi Indrajaya Sutantio
- Randy

## How to run this project

Go to src/main/resources/application.properties and copy paste below replace {{something}} with your config in your
database

```text
# Spring Config
server.port=8080

# Database Config
spring.datasource.username={{dbUsername}}
spring.datasource.password={{dbPassword}}
spring.datasource.url=jdbc:postgresql://localhost:5432/{{dbName}}
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA Config
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Docs

### CRUD Users

- CREATE
  ![user-create.png](images%2Fuser-create.png)

- READ ALL
  ![user-getall.png](images%2Fuser-getall.png)

- READ
  ![user-get-by-id.png](images%2Fuser-get-by-id.png)

- UPDATE
  ![user-update-by-id.png](images%2Fuser-update-by-id.png)

- DELETE
  ![user-delete.png](images%2Fuser-delete.png)