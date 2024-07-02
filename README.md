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

### CRUD Brand

- CREATE
  ![brand-create.png](images%2Fbrand-create.png)

- READ ALL
  ![brand-getall.png](images%2Fbrand-getall.png)

- READ
  ![brand-get-by-id.png](images%2Fbrand-get-by-id.png)

- UPDATE
  ![brand-update-by-id.png](images%2Fbrand-update-by-id.png)

- DELETE
  ![brand-delete-by-id.png](images%2Fbrand-delete-by-id.png)

### CRUD Car

- CREATE
  ![car-create.png](images%2Fcar-create.png)

- READ ALL
  ![car-getall.png](images%2Fcar-getall.png)

- READ
  ![car-get-by-id.png](images%2Fcar-get-by-id.png)

- UPDATE
  ![car-update-by-id.png](images%2Fcar-update-by-id.png)

- DELETE
  ![car-delete.png](images%2Fcar-delete.png)
-

### CRUD Rent

- CREATE
  ![rent-create.png](images%2Frent-create.png)

- READ ALL
  ![rent-getall.png](images%2Frent-getall.png)

- READ
  ![rent-get-by-id.png](images%2Frent-get-by-id.png)

- UPDATE
  ![rent-update-by-id.png](images%2Frent-update-by-id.png)

- DELETE
- ![rent-delete-by-id.png](images%2Frent-delete-by-id.png)
  