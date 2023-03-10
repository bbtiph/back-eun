package kz.dara.cameralcontrol.controller;

import kz.dara.cameralcontrol.model.User;
import kz.dara.cameralcontrol.model.dto.JwtResponse;
import kz.dara.cameralcontrol.model.dto.LoginRequest;
import kz.dara.cameralcontrol.model.dto.UserDto;
import kz.dara.cameralcontrol.repository.primaryDataSourse.LocalUserRepository;
import kz.dara.cameralcontrol.security.jwt.JwtUtils;
import kz.dara.cameralcontrol.security.services.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    LocalUserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Set<String> roles = new HashSet<>(Collections.emptySet());

        userDetails.getAuthorities().forEach(item -> {
            roles.add(item.getAuthority());
        });

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getFirstName(),
                userDetails.getSurname(),
                userDetails.getMiddleName(),
                roles
        ));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody UserDto signupRequest
    ) {

        try {
            User user = new User();
            user.setUsername(signupRequest.getUsername());
            user.setFirstName(signupRequest.getFirstName());
            user.setLastName(signupRequest.getLastName());
            user.setMiddleName(signupRequest.getMiddleName());
            user.setPassword(encoder.encode(signupRequest.getPassword()));
            user.setEmailAddress(signupRequest.getEmailAddress());
            userRepository.saveAndFlush(user);

        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok("");
    }


}

