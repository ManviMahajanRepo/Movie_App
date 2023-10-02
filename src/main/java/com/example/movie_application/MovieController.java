package com.example.movie_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
       return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbID}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbID){
        return new ResponseEntity<Optional<Movie>>(movieService.movieById(imdbID), HttpStatus.OK);
    }

    @GetMapping("/getMovieTitle/{title}")
    public ResponseEntity<Optional<Movie>> getMovieTitle(@PathVariable String title){
        return new ResponseEntity<Optional<Movie>>(movieService.movieByTitle(title), HttpStatus.OK);
    }

}
