package com.bcc.projeto.controller;

import com.bcc.projeto.entities.Vacancy;
import com.bcc.projeto.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService service;

    @Autowired
    public VacancyController(VacancyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Vacancy>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer linesPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "goal") String orderBy) {
        try {
            Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
            Pageable pageRequest = PageRequest.of(page, linesPerPage, sortDirection, orderBy);

            return ResponseEntity.ok().body(service.findAll(pageRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Vacancy> FindById(@PathVariable Long id) {
        Vacancy obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Vacancy> insert(@RequestBody Vacancy obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Vacancy> update(@PathVariable Long id,@RequestBody Vacancy obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
