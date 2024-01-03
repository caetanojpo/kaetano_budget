//package com.br.kaetano.budget.controller.users;
//
//import com.br.kaetano.budget.domain.users.entity.User;
//import com.br.kaetano.budget.dtos.users.AuthDTO;
//import com.br.kaetano.budget.dtos.users.JWTDTO;
//import com.br.kaetano.budget.infra.security.TokenService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthenticationController {
//
//    @Autowired
//    private AuthenticationManager manager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid AuthDTO auth) {
//        var token = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
//        var authentication = manager.authenticate(token);
//
//        var jwt = tokenService.generateToken((User) authentication.getPrincipal());
//
//        return ResponseEntity.ok(new JWTDTO(jwt));
//    }
//}
