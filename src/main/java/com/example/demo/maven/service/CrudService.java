package com.example.demo.maven.service;

import java.util.List;

public interface CrudService <Entity> {
    Entity create(Entity entity);

    List<Entity> readAll();

    Entity read(Long id);

    Entity update(Entity entity, Long id);

    boolean delete(Long id);
}
