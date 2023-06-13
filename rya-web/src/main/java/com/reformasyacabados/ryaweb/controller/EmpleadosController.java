package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.models.Empleado;
import com.reformasyacabados.ryaweb.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;


    @GetMapping("/getEmpleados")
    public List<Empleado> getEmpleados() {
        return empleadoService.listarEmpleados();
    }


    @GetMapping("/getEmpleadoPorId/{id_empleado}")
    public ResponseEntity<Empleado> empleadoById(@PathVariable Integer id_empleado) {
        try {
            Empleado empleado = empleadoService.obtenerEmpleadoId(id_empleado);
            return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/postEmpleado")
    public void saveEmpleado(@RequestBody Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
    }

    @PutMapping("/putEmpleado/{id_empleado}")
    public ResponseEntity<?> updateEmpleado(@RequestBody Empleado empleado, @PathVariable Integer id_empleado) {
        try {
            Empleado empleadoExiste = empleadoService.obtenerEmpleadoId(id_empleado);
            empleadoExiste.setNombre(empleado.getNombre());
            empleadoExiste.setDocumento(empleado.getDocumento());
            empleadoExiste.setTelefono(empleado.getTelefono());
            empleadoExiste.setDireccion(empleado.getDireccion());
            empleadoExiste.setEstado(empleado.getEstado());
            empleadoService.guardarEmpleado(empleadoExiste);
            return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEmpleado/{id_empleado}")
    public void deleteEmpleado(@PathVariable int id_empleado){
        empleadoService.eliminarEmpleado(id_empleado);
    }

    @DeleteMapping("/deleteEmpleado/all")
    public void deleteAllEmpleados() {
        empleadoService.eliminarTodosEmpleados();
    }

}
