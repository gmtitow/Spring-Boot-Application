package com.example.demo.maven.service;

import com.example.demo.maven.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ACrudServiceImpl<Entity extends AbstractEntity, Repository extends JpaRepository<Entity,Long>> implements CrudService<Entity>{

    @Autowired
    private Repository repository;

    @Override
    public Entity create(Entity entity) {
        repository.save(entity);

        return entity;
    }

    @Override
    public List<Entity> readAll() {
        return repository.findAll();
    }

    @Override
    public Entity read(Long id) {
        if(repository.existsById(id))
            return repository.getById(id);

        return null;
    }

    @Override
    public Entity update(Entity entity, Long id) {
        if (repository.existsById(id)) {
            entity.setId(id);
            repository.save(entity);
            return repository.getById(id);
        }

        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
