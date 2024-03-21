package ru.netology.jdbc_task.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryJdbc {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptTitle = "getProductName.sql";
    private final String requestLine = readSqlScript(scriptTitle);


    public RepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String readSqlScript(String scriptFileName) {
        try (InputStream stream = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForList(requestLine, parameters, String.class);
    }
}
