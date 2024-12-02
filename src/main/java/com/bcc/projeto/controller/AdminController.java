package com.bcc.projeto.controller;

import com.bcc.projeto.entities.Administrator;
import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.exceptions.CPFAlreadyInUseException;
import com.bcc.projeto.exceptions.EmailAlreadyInUseException;
import com.bcc.projeto.exceptions.TelephoneAlreadyInUseException;
import com.bcc.projeto.services.AdministratorService;
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
@RequestMapping("/admins")
public class AdminController{
    private final AdministratorService service;

    @Autowired
    public AdminController(AdministratorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Administrator>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "4") Integer linesPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy) {
        try {
            Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
            Pageable pageRequest = PageRequest.of(page, linesPerPage, sortDirection, orderBy);

            return ResponseEntity.ok().body(service.findAll(pageRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Administrator> FindById(@PathVariable Long id) {
        Administrator obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Administrator> insert(@RequestBody Administrator obj) throws CPFAlreadyInUseException, EmailAlreadyInUseException, TelephoneAlreadyInUseException{
        obj.setRole(Roles.ADMIN);
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
    public ResponseEntity<Administrator> update(@PathVariable Long id,@RequestBody Administrator obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}