package com.zymr.MovieManagement.controller;

import com.zymr.MovieManagement.entity.Movie;
import com.zymr.MovieManagement.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Component
public class MovieController {

//    GET /movies — List all movies
//● GET /movies/{id} — Get movie by ID
//● POST /movies — Create a new movie
//● PUT /movies/{id} — Update existing movie
//● DELETE /movies/{id} — Delete movie by ID

    @Autowired
    private MovieService movieService;


    @GetMapping()
    public List<Movie> getAllMovies(){
         return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id){
        return movieService.getMovieById(id);
    }


    @PostMapping()
    public boolean createNewMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return true;
    }



    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie updatedMovie){
         return movieService.update(id,updatedMovie);
    }


    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable String id){
        return movieService.delete(id);
    }








}
