package com.tts.stream.service;

import java.util.ArrayList;
import java.util.List;

import com.tts.stream.model.Movie;
import com.tts.stream.model.MovieDisplay;
import com.tts.stream.model.MovieResponse;
import com.tts.stream.model.TVResponse;
import com.tts.stream.model.User;
import com.tts.stream.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDisplay> findAll(User user) {
        List<Movie> movies = movieRepository.findAllByUser(user);
        return formatMovie(movies);
    }

    private List<MovieDisplay> formatMovie(List<Movie> movies) {

        List<MovieDisplay> displayMovies = formatMovieList(movies);
        return displayMovies;

    }

    private List<MovieDisplay> formatMovieList(List<Movie> movies) {
        List<MovieDisplay> response = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDisplay movieDisplay = new MovieDisplay();
            movie.setId(movie.getId());
            response.add(movieDisplay);
        }
        return response;
    }
}