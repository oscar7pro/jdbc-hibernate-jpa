package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepositoryInterface extends CrudRepository<Movie,Long> {


}
