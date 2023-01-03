package com.stream.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.app.models.entities.User;
import com.stream.app.models.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
    return userRepository.save(user);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
      }

      public String login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
          // Login berhasil. Generate JWT token dan kembalikan ke klien.
          String doaibu = "bismillah";
          String token = Jwts.builder()
              .setSubject(user.getUsername())
              .claim("role", user.getRole())
              .signWith(SignatureAlgorithm.HS512, doaibu)
              .compact();
          return token;
        } else {
          // Login gagal
          return null;
        }

    }

  }

