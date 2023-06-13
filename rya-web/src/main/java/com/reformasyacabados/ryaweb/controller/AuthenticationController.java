package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.configuration.JwtUtils;
import com.reformasyacabados.ryaweb.models.JwtRequest;
import com.reformasyacabados.ryaweb.models.JwtResponse;
import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) {
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (Exception exception) {
            exception.printStackTrace();
            // Respuesta de error adecuada con un objeto JSON o un mensaje descriptivo
            String mensajeError = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // Valida credenciales de autenticacion
    private void autenticar(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exception) {
            throw new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public ResponseEntity<Usuario> obtenerUsuarioActual(Principal principal) {
        Usuario usuarioActual = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok(usuarioActual);
    }
}
