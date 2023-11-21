package com.example.librarysystemcapstone.controller;

import com.example.librarysystemcapstone.model.Genre;
import com.example.librarysystemcapstone.model.Movie;
import com.example.librarysystemcapstone.model.StarRating;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@Slf4j
public class MovieControllerMockMvcTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper;

    ResultActions resultActions;

    Movie movie;

    @BeforeEach
    public void setUp(){
        movie = new Movie();
        movie.setDirector("Ridley Scott");
        movie.setRating(StarRating.ONE);
        movie.setGenre(Genre.COMPSCI);
        movie.setTitle("Alien");

        mapper = new ObjectMapper();
    }

    @Test
    public void postRequestMovieTest() throws Exception{
        movie = postMovie(movie);

        Assertions.assertEquals(1, movie.getId());
    }

    @Test
    public void deleteRequestMovieTest() throws Exception{

        movie = postMovie(movie);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/movies/" + movie.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //could refactor this into its own method.

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        log.debug(contentAsString);

        Assertions.assertTrue(contentAsString.equals("[]"));
    }

    private Movie postMovie(Movie movie) throws Exception {
        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        movie = mapper.readValue(contentAsString, Movie.class);

        return movie;
    }
}
