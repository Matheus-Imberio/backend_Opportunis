package com.bcc.projeto.services;

import com.bcc.projeto.dtos.CandidateDTO;
import com.bcc.projeto.dtos.CompanyDTO;
import com.bcc.projeto.dtos.ResponseDTO;
import com.bcc.projeto.dtos.UserDTO;
import com.bcc.projeto.entities.User;
import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.exceptions.ResourceExistsException;
import com.bcc.projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CandidateService candidateService;
    @Autowired
    CompanyService companyService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailEquals(username);
    }
    public User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public ResponseDTO getAuthenticatedName() {
        User user = getAuthenticatedUser();
        if (user.getRole() == Roles.CANDIDATE) return new ResponseDTO(candidateService.findByEmail(user.getEmail()).email());
        else if (user.getRole() == Roles.ENTERPRISE) return new ResponseDTO(companyService.findByEmail(user.getEmail()).email());
        else return new ResponseDTO("admin");
    }

    public void candidateSignUp(CandidateDTO candidateDTO) {
            if (loadUserByUsername(candidateDTO.email()) != null) throw new ResourceExistsException();
            String encryptedPassword = new BCryptPasswordEncoder().encode(candidateDTO.password());
            candidateService.insert(candidateDTO, encryptedPassword);
    }

    public void companySignUp(CompanyDTO companyDTO) {
        if (loadUserByUsername(companyDTO.email()) != null) throw new ResourceExistsException();
        String encryptedPassword = new BCryptPasswordEncoder().encode(companyDTO.password());
        companyService.insert(companyDTO, encryptedPassword);
    }
}