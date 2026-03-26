package com.example.PlayerFinder.services.securityServices;

import com.example.PlayerFinder.DTO.login.LoginRequest;
import com.example.PlayerFinder.DTO.login.LoginResponse;
import com.example.PlayerFinder.DTO.user.UserCreateDTO;
import com.example.PlayerFinder.models.User;
import com.example.PlayerFinder.repositories.UserRepository;
import com.example.PlayerFinder.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public void register(UserCreateDTO dto) {

        User user = new User();

        user.setEmail(dto.email());
        user.setRole(dto.role());

        String encodedPassword = passwordEncoder.encode(dto.password());

        user.setPassword(encodedPassword);
        user.setActive(true);

        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = userRepository.findByEmail(request.email()).orElseThrow(()->new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
