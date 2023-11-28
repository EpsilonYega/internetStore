package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.Main;
import org.internetStore.dto.SigninRequest;
import org.internetStore.dto.SignupRequest;
import org.internetStore.models.entities.User;
import org.internetStore.security.JwtCore;
import org.internetStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        String serviceResult = userService.newUser(signupRequest);
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        if (Objects.equals(serviceResult, "Выберите другую почту")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Победа)");
    }
    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
//        Authentication authentication = null;
//        try{
//            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUserName(), signinRequest.getPassword()));
//        }
//        catch (BadCredentialsException e) {
//            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtCore.generateToken(authentication);
//        return ResponseEntity.ok(jwt);

        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());

        if (!Objects.equals(user.getPassword(), signinRequest.getPassword())) {
            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String jwt = jwtCore.generateToken(user);
        Main.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        return ResponseEntity.ok(jwt);
    }
}
