package com.bcc.projeto.controller;


import com.bcc.projeto.dtos.*;
import com.bcc.projeto.entities.User;
import com.bcc.projeto.services.AuthService;
import com.bcc.projeto.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        var role = String.valueOf(((User) auth.getPrincipal()).getRole());
        var id = String.valueOf(((User) auth.getPrincipal()).getId());
        return ResponseEntity.ok(new TokenDTO(token, role, id));
    }

    @PostMapping("/candidate-register")
    public ResponseEntity<Void> candidateRegister(@RequestBody CandidateDTO data) {
        if (authService.loadUserByUsername(data.email()) != null) return ResponseEntity.badRequest().build();
        authService.candidateSignUp(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/company-register")
    public ResponseEntity<Void> companyRegister(@RequestBody CompanyDTO data) {
        if (authService.loadUserByUsername(data.email()) != null) return ResponseEntity.badRequest().build();
        authService.companySignUp(data);
        return ResponseEntity.ok().build();
    }
}