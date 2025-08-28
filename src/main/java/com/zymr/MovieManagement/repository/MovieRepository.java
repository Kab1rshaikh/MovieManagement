package com.zymr.MovieManagement.repository;

import com.zymr.MovieManagement.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
}
