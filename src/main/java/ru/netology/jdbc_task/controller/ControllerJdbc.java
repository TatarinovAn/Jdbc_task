package ru.netology.jdbc_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc_task.repository.RepositoryJdbc;

import java.util.List;

@RestController

public class ControllerJdbc {

    private final RepositoryJdbc repositoryJdbc;

    public ControllerJdbc(RepositoryJdbc repository) {
        this.repositoryJdbc = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return repositoryJdbc.getProductName(name);
    }
}
