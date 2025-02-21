package com.bcc.projeto.services;

import com.bcc.projeto.entities.Category;
import com.bcc.projeto.entities.Vacancy;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.VacancyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    private final VacancyRepository repository;
    private final CategoryService service;

    public List<Vacancy> findTop4ByClicksDesc(){
        return repository.findTop4ByClicksDesc();
    }

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, CategoryService categoryService) {
        this.repository = vacancyRepository;
        this.service = categoryService;
    }

    public Page<Vacancy> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Vacancy findById(Long id) {
        Optional<Vacancy> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Vacancy insert(Vacancy obj){
        return repository.save(obj);
    }

    @Transactional
    public void delete(Long id) {
        Vacancy obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if (!obj.isActivate()) {
            throw new ResourceNotFoundException("Vaga já desativada.");
        }
        obj.setActivate(false);
    }

    @Transactional
    public Vacancy update(Long id, Vacancy obj) {
        Vacancy entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(entity, obj);
        return repository.save(entity);
    }

    @Transactional
    public Vacancy updateClicks(Long id) {
        Vacancy entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        entity.setClicks(entity.getClicks() + 1);
        return repository.save(entity);
    }

    public Page<Vacancy> findByCategory(Long categoryId, Pageable pageable) {
        Category category = service.findById(categoryId);
        return repository.findByCategory(category, pageable);
    }

    private void updateData(Vacancy entity, Vacancy obj) {
        entity.setGoal(obj.getGoal());
        entity.setRequirements(obj.getRequirements());
        entity.setDescription(obj.getDescription());
        entity.setWage(obj.getWage());
        entity.setQtdCandidate(obj.getQtdCandidate());
        entity.setActivate(obj.isActivate());
        entity.setCompany(obj.getCompany());
        entity.setClicks(obj.getClicks());
    }
}
