package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;



    @PostMapping("/postUser")
    public void saveUsuario(@RequestBody Usuario usuario) {
        userService.guardarUsuario(usuario);
    }



    @GetMapping("/getUsers")
    public List<Usuario> getUsuarios() {
        return userService.listarUsuarios();
    }





}
