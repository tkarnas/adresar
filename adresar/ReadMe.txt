# Getting Started

### How to run application
Chose one of the following

1)
* To run application open up console and navigate to "target" directory of project.
* Execute code: java -jar job-2.5.2.jar

2)
* Open project with IDE
* Run application

### H2 database

* In browser open localhost:8080/h2-console
* Server settings: Generic H2 (Embedded)
* Driver class: org.h2.Driver
* JDBC URL: jdbc:h2:~/adresar
* Username: sa
* Password: 

# Postman routes

##To get all users
* GET - localhost:8080/adresar/users

##To get one user
* GET - localhost:8080/adresar/users/{id} (for example 1)

##To create new user
* POST - localhost:8080/adresar/users
* In body as raw - JSON execute - 

{
  "firstName": "Nikola",
  "lastName": "Karnas",
  "address": "Zagrebačka 3",
  "dateOfBirth": "1992-05-12",
  "email": "nido@gmail.com",
  "phoneNumber": "0957369847"
}

##To update user
* PUT - localhost:8080/adresar/update/{id} 
* only address, email and phone number can be updated
* you can execute one of the following as json or all at once

{
"address": "Ulica Slavka Kolara 3",
"email": "ninoslav@gmail.com",
"phoneNumber": "1327369866"
}

##To delete user
* DELETE - localhost:8080/adresar/delete/{id}

##Search by phone number

* POST - localhost:8080/adresar/searchByPhoneNumber

{
"phoneNumber": "0977369847"
}

##Search by phone number

* POST - localhost:8080/adresar/searchByEmail

{
"email": "markec@gmail.com"
}


