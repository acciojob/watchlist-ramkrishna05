package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String, Movie>moviedb=new HashMap<>();
    Map<String,Director>directordb=new HashMap<>();
    Map<String,List<String>>moviedirectordb=new HashMap<>();
    public  void  addMovie(Movie movie)
    {
        moviedb.put(movie.getName(),movie);
    }
    public void  addDirector(Director director)
    {
        directordb.put(director.getName(),director);
    }
    public void addMovieDirectorPair(String moviename,String directorname)
    {
        if(moviedirectordb.containsKey(directorname))
        {
         List<String>list=   moviedirectordb.get(directorname);
         list.add(moviename);
         moviedirectordb.put(directorname,list);
        }
        else
        {
            List<String>list=new ArrayList<>();
            list.add(moviename);
            moviedirectordb.put(directorname,list);
        }
    }
    public ResponseEntity getMovieByName(String name)
    {
        Movie movie=moviedb.getOrDefault(name,null);
        if(movie!=null)
        {
            return  new ResponseEntity(movie,HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity("Movie does not exist",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity getDirectorByName(String name)
    {
        Director director=directordb.getOrDefault(name,null);
        if(director!=null)
        {
            return new ResponseEntity(director,HttpStatus.FOUND);
        }
        else
        {
            return  new ResponseEntity("Director does Not ecist",HttpStatus.NOT_FOUND);

        }
    }
    public ResponseEntity getMoviesByDirectorName(String name)
    {
        List<String>movielist=moviedirectordb.getOrDefault(name,new ArrayList<>());
        if(movielist.isEmpty())
        {
            return new ResponseEntity("Director not made movie",HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(movielist,HttpStatus.FOUND);

        }
    }
    public List<String> findAllMovies()
    {
       return new ArrayList<>(moviedb.keySet());
    }
    public ResponseEntity deleteDirectorByName(String directorname)
    {
        if(moviedirectordb.containsKey(directorname))
        {
            moviedirectordb.remove(directorname);
            return new ResponseEntity("Director movie delet succsefully",HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity("Director name not found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity deleteAllDirectors()
    {
        if(moviedirectordb.isEmpty())
        {
            return new ResponseEntity("no director in watchlist",HttpStatus.NOT_FOUND);

        }
        else
        {
            moviedirectordb.clear();
            return new ResponseEntity("Director and all movie by them deleted succsefully",HttpStatus.FOUND);
        }
    }

}
