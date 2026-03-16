package com.karthiklogs.blog.services.impl;


import com.karthiklogs.blog.entities.Role;
import com.karthiklogs.blog.entities.User;
import com.karthiklogs.blog.payloads.LoginDto;
import com.karthiklogs.blog.payloads.RegisterDto;
import com.karthiklogs.blog.repositories.RoleRepository;
import com.karthiklogs.blog.repositories.UserRepository;
import com.karthiklogs.blog.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl  implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public String Login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),
                loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "user logged in successfully";
    }

    @Override
    public String Register(RegisterDto registerDto) {
        //check email
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return "user exists with the username";
        }

        if(userRepository.existsByEmail(registerDto.getEmail())){
            return "user exists with that email";
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER").get();
        roles.add(role);
        user.setRole(roles);

        userRepository.save(user);
        return "user successfully registered";
    }
}
