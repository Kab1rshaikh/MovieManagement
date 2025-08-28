View this README in code mode

Movie Management

Implementations:-
 1.REST Apis for CURD operations(createMovie,updateMovie,getMovieById,deleteMovieById,getAllMovies
 2.Used MongoDB as database
 3.Implemented unit and integration tests
 4.Dockerized the file using Dockerfile
 5.Used environment-based config with .env support
 6.Implemented swagger support (Link): localhost:8080/swagger-ui/index.html
 7.This project has been developed and configured on Ubuntu/linux

API Endpoints:-
  ● GET /movies — List all movies
  ● GET /movies/{id} — Get movie by ID
  ● POST /movies — Create a new movie
  ● PUT /movies/{id} — Update existing movie
  ● DELETE /movies/{id} — Delete movie by ID


Structure of Project:-

MovieManagement/-
Dockerfile
docker-composed.yml
  src-
    main-
      java-
        com.zymr.MovieManagement:-
          package Controller:-
            MovieController.java -> This class consists of all REST APIs and calls MovieService.java
          package Service:-
            MovieService.java -> This class consists of APIs business logic and calls MovieRepository.java
          package repository
            MovieRepository.java -> This class extends the MongoRepository.
        resources:-
          application.properties
  
  

Tech Stack Used :- 
  1.Language: Core and Advanced Java
  2.Framework: Spring Boot
  3.Database: MongoDB
  4.Other tools: Docker, Postman



How to run the project in Docker :-

step 1 :- Clone the repository:-
          COMMANDS:-
            git clone https://github.com/yourusername/MovieManagement.git
            cd MovieManagement

step 2 :- Build and Start the application:-
          COMMAND:- docker-compose up --build

step 3 :- To stop the application :-
          COMMAND:- docker-compose down



Note*:-
  1.Ensure port 27017 (MongoDB) and 8080 (app) are free on your machine.
  2.All endpoints are available under /movies.

          


