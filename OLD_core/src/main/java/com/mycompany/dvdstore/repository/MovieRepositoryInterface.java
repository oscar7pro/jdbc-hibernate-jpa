package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
   /*
    Movie add(Movie movie);
    List<Movie> list();
    Movie getById(long id);
    */
}