# Car Rent

## Kelompok

- Levi Indrajaya Sutantio
- Randy

## Nice Feature to add

- validate if user have enough money to rent
- validate if rent is already completed
- validate if car is already rented
- delete all cars if related brand is deleted
- set related user rent to null if user is deleted
- set related car rent to null if car is deleted

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

# JPA Config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Docs

### Users

- CREATE
  ![user-create.png](images%2Fuser-create.png)

- READ ALL
  ![user-getall.png](images%2Fuser-getall.png)

- READ ALL BY NAME
  ![user-get-all-by-name.png](images%2Fuser-get-all-by-name.png)

- READ
  ![user-get-by-id.png](images%2Fuser-get-by-id.png)

- UPDATE
  ![user-update-by-id.png](images%2Fuser-update-by-id.png)

- DELETE
  ![user-delete.png](images%2Fuser-delete.png)

- TOPUP
  ![user-topup.png](images%2Fuser-topup.png)

### Brand

- CREATE
  ![brand-create.png](images%2Fbrand-create.png)

- READ ALL
  ![brand-getall.png](images%2Fbrand-getall.png)

- READ
  ![brand-get-by-id.png](images%2Fbrand-get-by-id.png)

- READ ALL BY NAME
  ![brand-get-all-by-name.png](images%2Fbrand-get-all-by-name.png)

- UPDATE
  ![brand-update-by-id.png](images%2Fbrand-update-by-id.png)

- DELETE
  ![brand-delete-by-id.png](images%2Fbrand-delete-by-id.png)

### Car

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

### Rent

- CREATE
  ![rent-create.png](images%2Frent-create.png)

- READ ALL
  ![rent-getall.png](images%2Frent-getall.png)

- READ ALL BY NAME AND AVAILABILITY
  ![car-get-all-by-name-and-availability.png](images%2Fcar-get-all-by-name-and-availability.png)

- READ
  ![rent-get-by-id.png](images%2Frent-get-by-id.png)

- UPDATE
  ![rent-update-by-id.png](images%2Frent-update-by-id.png)

- DELETE
  ![rent-delete-by-id.png](images%2Frent-delete-by-id.png)

- RETURN CAR
  ![rent-return-car.png](images%2Frent-return-car.png)
  