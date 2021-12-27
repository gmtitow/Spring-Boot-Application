package com.example.demo.maven.controller;

import com.example.demo.maven.model.AbstractEntity;
import com.example.demo.maven.service.ACrudServiceImpl;
import com.example.demo.maven.service.CrudService;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class ACrudController<
        Entity extends AbstractEntity,
        Repository extends JpaRepository<Entity,Long>, 
        Service extends CrudService<Entity>> {


    private final Service service;

    @Autowired
    public ACrudController(Service service) {
        this.service = service;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Entity entity) {
        service.create(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> read() {
        final List<Entity> entities = service.readAll();
        return entities != null && !entities.isEmpty()
                ? new ResponseEntity<>(entities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Entity> read(@PathVariable(name = "id") Long id) {
        final Entity entity = service.read(id);

        return entity != null
                ? new ResponseEntity<>(entity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Entity entity) {
        final Entity changedEntity = service.update(entity, id);

        return changedEntity != null
                ? new ResponseEntity<>(changedEntity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
