package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.models.Rol;
import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Rol rol = new Rol();
        rol.setId_rol(2);
        rol.setNombre_rol("NORMAL");

        usuario.setRol(rol);

        return usuarioService.guardarUsuario(usuario, rol);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{id_usuario}")
    public void eliminarUsuario(@PathVariable("id_usuario") Long id_usuario) {
        usuarioService.eliminarUsuario(id_usuario);
    }
}
