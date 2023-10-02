package com.example.movie_application;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> movieById(String id){
        return movieRepository.findMovieByImdbId(id);
    }

    public Optional<Movie> movieByTitle(String title){
        return movieRepository.findMovieByTitle(title);
    }

}
