package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public void addMovie(Movie movie)
    {
        movieRepository.addMovie(movie);

    }
    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);

    }
    public void addMovieDirectorPair(String moviename,String directorname)
    {
        movieRepository.addMovieDirectorPair(moviename,directorname);
    }
    public ResponseEntity getMovieByName(String name)
    {
     return movieRepository.getMovieByName(name);
    }
    public ResponseEntity getDirectorByName(String name)
    {
        return movieRepository.getDirectorByName(name);

    }
    public ResponseEntity getMoviesByDirectorName(String name)
    {
        return movieRepository.getMoviesByDirectorName(name);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();

    }
    public  ResponseEntity deleteDirectorByName(String directorname)
    {
        return movieRepository.deleteDirectorByName(directorname);

    }
    public ResponseEntity deleteAllDirectors()
    {
        return movieRepository.deleteAllDirectors();
    }

}
