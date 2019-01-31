package com.example.demo;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public interface MovieService {

  MovieDb oneMovie(Integer Movieid);
  MovieResultsPage similar(Integer movieId, Integer page);
  MovieResultsPage byTitlePage(String title, Integer page);
  MovieDb getCredits(Integer movieid);
}
