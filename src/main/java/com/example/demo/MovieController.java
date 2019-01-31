package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

  private MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }


  @GetMapping("/movie/id")
  public String yourMovie(@RequestParam(value = "movieId") Integer id, Model model) {
    model.addAttribute("yourMovie", movieService.oneMovie(id));
    return "movie";
  }

  @GetMapping("/")
  public String getMovieTitle(Model model, @RequestParam(name = "movieTitle", required = false) String movieTitle,
                              @RequestParam(defaultValue = "1", required = false) Integer page) {
    if (movieTitle != null && !movieTitle.isEmpty()) {
      model.addAttribute("movies", movieService.byTitlePage(movieTitle, page));
      model.addAttribute("search", movieTitle);
      model.addAttribute("currentPage", page);
    }
    return "title";
  }

  @GetMapping("/similar")
  public String similarMovies(Model model, @RequestParam(value = "id", required = false) Integer id,
                              @RequestParam(defaultValue = "1", required = false) Integer page) {
    if (id != null) {
      model.addAttribute("movies", movieService.similar(id, page));
      model.addAttribute("search", id);
      model.addAttribute("currentPage", page);
    }
    return "similar";
  }
}
