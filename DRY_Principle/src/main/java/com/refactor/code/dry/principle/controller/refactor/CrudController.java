package com.refactor.code.dry.principle.controller.refactor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

public abstract class CrudController<T, ID> {
    
    @Autowired
    private CrudRepository<T, ID> repository;
    
    @GetMapping("/")
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }
    
    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isPresent()) {
            return optionalT.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }
    
    @PostMapping("/")
    public T create(@RequestBody T entity) {
        return repository.save(entity);
    }
    
    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isPresent()) {
            T existingEntity = optionalT.get();
            BeanUtils.copyProperties(entity, existingEntity);
            return repository.save(existingEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

