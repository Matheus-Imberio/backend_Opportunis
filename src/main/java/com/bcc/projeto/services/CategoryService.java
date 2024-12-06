package com.bcc.projeto.services;

import com.bcc.projeto.entities.Category;
import com.bcc.projeto.exceptions.DatabaseException;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Category not found for ID: " + id));
    }

    @Transactional
    public Category insert(Category obj) {
        return repository.save(obj);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found for ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Category not found for ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation while deleting category");
        }
    }

    @Transactional
    public Category update(Long id, Category obj) {
        try {
            Category entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Category not found for ID: " + id);
        }
    }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }

}
