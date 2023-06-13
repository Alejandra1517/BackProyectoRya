package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.models.Rol;
import com.reformasyacabados.ryaweb.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class RolesController {

    @Autowired
    private RolService rolService;


    @GetMapping("/getRoles")
    public List<Rol> getRoles() {
        return rolService.listarRoles();
    }


    @PostMapping("/postRol")
    public void saveRol(@RequestBody Rol rol) {
        rolService.guardarRol(rol);
    }


}
