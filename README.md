# Superior Tasker Spring Boot Backend

## Description
This project is the backend for the Superior Tasker final project at the University of Zadar. It is the first part of a larger project that aims to compare Spring Boot with ExpressJs, using the same React
frontend and database.

## Database
For this project, I chose a free MongoDB cloud database and managed the data using Compass. The database has three entities: User, Project, and Task.

### Example of a User:
```json
{
    "_id": "6661e285d874a811525536a0",
    "firstName": "Šime",
    "lastName": "Rončević",
    "email": "sironcevic15@gmail.com",
    "password": "$2a$10$X20CMkQPdrDWo916OfejRuaUNNBWQtxMavbLkK37rcvE15tsvc/PC",
    "description": "Ovo je prvi korisnik",
    "image": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.novilist.hr%2Fta…"
}

### Example of a Project:
```json
{
    "_id": "6660880179f5030d2fba83df",
    "userId": "6661e285d874a811525536a0",
    "title": "Go to work",
    "description": "We have a lot of work to do.",
    "date": "05.06.2024",
    "completion": "0%"
}

### Example of a Task:
```json
{
    "_id": "666096d0760c410e8ff69282",
    "projectId": "6660880179f5030d2fba83df",
    "userId": "6661e285d874a811525536a0",
    "name": "Eat lunch",
    "done": false
}

## Code (Short Description)
Each user can have multiple projects, and each project can have multiple tasks, but one task can only belong to one project and one user. Similarly, a project can only belong to one user.

In our Spring Boot application, we have three controllers to manipulate data. We also have full logic for user login and registration. The login logic includes a token that the user acquires upon logging in.
Only with a valid token can the user access restricted routes.

## Additional Information
To clone this repository, you need to update your application.properties file to look something like this (for MongoDB):
spring.application.name=Superior_tasker_backend_springboot
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.9zf6fd5.mongodb.net/
spring.data.mongodb.database=your_database_name
jwt.secret=your_large_secret_code_base64_encoded_at_least_256_bits
jwt.expiration=86400000 // one day

