package com.zymr.MovieManagement.service;

import com.zymr.MovieManagement.entity.Movie;
import com.zymr.MovieManagement.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElse(null);

    }

    public Movie update(String id, Movie newMovie) {
        try {

            Movie oldMovie = movieRepository.findById(id).orElse(null);

            if (oldMovie != null) {


                oldMovie.setTitle(newMovie.getTitle());
                oldMovie.setDirector(newMovie.getDirector());
                oldMovie.setGenre(newMovie.getGenre());
                oldMovie.setRating((newMovie.getRating()));
                oldMovie.setReleaseYear(newMovie.getReleaseYear());
                movieRepository.save(oldMovie);
                return oldMovie;


            } else {
                return null;
            }
        }catch (Exception e){
            System.out.println("Error in updating Movie");
            return null;
        }

    }


    public Boolean delete(String id) {
        try {

            Movie movieToDelete = movieRepository.findById(id).orElse(null);

            if (movieToDelete != null) {
                movieRepository.delete(movieToDelete);
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Error in updating Movie");
            return false;
        }

    }



}



