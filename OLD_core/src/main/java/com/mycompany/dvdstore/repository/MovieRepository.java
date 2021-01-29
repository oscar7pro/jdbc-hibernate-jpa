/*
package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository  implements  MovieRepositoryInterface{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Movie add(Movie movie) {
        KeyHolder keyHolder =new  GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO MOVIE(TITLE, GENRE, DESCRIPTION) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, movie.getTitle());
                    preparedStatement.setString(2, movie.getGenre());
                    preparedStatement.setString(3, movie.getDescription());
                    return  preparedStatement;
        }, keyHolder);
            movie.setId(keyHolder.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbc.query("SELECT ID, TITLE,GENRE FROM MOVIE",
                (resultSet,rowNum) -> new Movie(
                        resultSet.getLong("ID"),
                        resultSet.getString("TITLE"),
                        resultSet.getString("GENRE")));
    }

    @Override
    public Movie getById(long id) {
        return jdbc.queryForObject("SELECT ID, TITLE,GENRE, DESCRIPTION FROM MOVIE WHERE ID = ?",
                new Object[] {id},
                ((resultSet, rowNum) -> new Movie(
                        resultSet.getLong("ID"),
                        resultSet.getString("TITLE"),
                        resultSet.getString("GENRE"),
                        resultSet.getString("DESCRIPTION"))));
    }

}
*/
