package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
   @Autowired
   private MovieService movieService;
   @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie)
   {
       movieService.addMovie(movie);
       return new ResponseEntity("Movie added successfully", HttpStatus.FOUND);
   }
   @PostMapping("/add-director")
   public ResponseEntity addDirector(@RequestBody Director director)
   {
      movieService.addDirector(director);
      return new ResponseEntity("Director added successfully", HttpStatus.FOUND);

   }
   @PutMapping("/add-movie-director-pair")
   public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename") String moviename, @RequestParam("directorname") String directorname) {
      movieService.addMovieDirectorPair(moviename, directorname);
      return ResponseEntity.status(HttpStatus.CREATED).body("Movie-Director pair added successfully");
   }
   @GetMapping("/get-movie-by-name/{name}")
   public ResponseEntity getMovieByName(@PathVariable("name") String name)
   {
      return movieService.getMovieByName(name);
   }
   @GetMapping("/get-director-by-name/{name}")
   public ResponseEntity getDirectorByName(@PathVariable("name") String name)
   {
      return movieService.getDirectorByName(name);
   }
   @GetMapping("/get-movies-by-director-name/{director}")
   public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String name)
   {
      return movieService.getMoviesByDirectorName(name);
   }

   @GetMapping("/get-all-movies")
   public ResponseEntity findAllMovies()
   {
      List<String>movielist=movieService.findAllMovies();
      return new ResponseEntity(movielist,HttpStatus.FOUND);
   }
   @DeleteMapping("/delete-director-by-name")
   public ResponseEntity deleteDirectorByName(@RequestParam("directorname") String directorname)
   {
      return movieService.deleteDirectorByName(directorname);

   }
   @DeleteMapping("/delete-all-directors")
   public ResponseEntity deleteAllDirectors()
   {
      return movieService.deleteAllDirectors();
   }


}
