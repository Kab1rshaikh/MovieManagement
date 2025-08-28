package com.zymr.MovieManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zymr.MovieManagement.entity.Movie;
import com.zymr.MovieManagement.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled
public class MovieControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MovieRepository movieRepository;

    private Movie testMovie;

    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
        testMovie = new Movie();
        testMovie.setTitle("Movie1");
        testMovie.setDirector("Director1");
        testMovie.setReleaseYear(2020);
        testMovie.setGenre("Sci-Fi");
        testMovie.setRating(9.0);
        testMovie = movieRepository.save(testMovie);
    }

    @Test
    void testCreateMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Movie2");
        movie.setDirector("Director2");
        movie.setReleaseYear(2014);
        movie.setGenre("Sci-Fi");
        movie.setRating(8.6);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    void testGetAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Movie1"));
    }

    @Test
    void testGetMovieById() throws Exception {
        mockMvc.perform(get("/movies/" + testMovie.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Movie1"));
    }

    @Test
    void testUpdateMovie() throws Exception {
        testMovie.setTitle("NewMovie1");

        mockMvc.perform(put("/movies/" + testMovie.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testMovie)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("NewMovie1"));

        assertThat(movieRepository.findById(testMovie.getId()).get().getTitle())
                .isEqualTo("NewMovie1");
    }

    @Test
    void testDeleteMovie() throws Exception {
        mockMvc.perform(delete("/movies/" + testMovie.getId()))
                .andExpect(status().isOk());

        assertThat(movieRepository.findById(testMovie.getId())).isEmpty();
    }
}
