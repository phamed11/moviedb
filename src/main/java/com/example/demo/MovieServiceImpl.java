package com.example.demo;


import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import org.springframework.stereotype.Service;



@Service
public class MovieServiceImpl implements MovieService {

  public MovieDb oneMovie(Integer movieId) {
    if (movieId == null) {
      throw new NullPointerException("no id present");
    }
    TmdbMovies movies = new TmdbApi(ApiKey.APIKEY).getMovies();
    return movies.getMovie(movieId, "", TmdbMovies.MovieMethod.values());
  }

  public MovieResultsPage similar(Integer movieId, Integer page) {
    TmdbMovies movies = new TmdbApi(ApiKey.APIKEY).getMovies();
    return movies.getSimilarMovies(movieId,"", page);

  }

  public MovieResultsPage byTitlePage(String title, Integer page) {
    TmdbSearch movies = new TmdbApi(ApiKey.APIKEY).getSearch();
    return movies.searchMovie(title, 0, "", true, page);
  }

  public MovieDb getCredits(Integer movieid) {
    TmdbMovies movies = new TmdbApi(ApiKey.APIKEY).getMovies();
     return movies.getMovie(movieid, "", TmdbMovies.MovieMethod.credits);
  }
}
