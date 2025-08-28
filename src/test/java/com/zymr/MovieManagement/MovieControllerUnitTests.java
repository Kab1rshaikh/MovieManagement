package com.zymr.MovieManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zymr.MovieManagement.entity.Movie;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled
public class MovieControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("SampleMovie");
        movie.setDirector("xyz");
        movie.setReleaseYear(2012);
        movie.setGenre("thriller");
        movie.setRating(9.0);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetMovieById() throws Exception {
        mockMvc.perform(get("/movies/12345"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Movie2");
        movie.setDirector("anony");
        movie.setReleaseYear(2022);
        movie.setGenre("Drama");
        movie.setRating(8.0);

        mockMvc.perform(put("/movies/12345")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isOk());
    }
}
