package com.reformasyacabados.ryaweb.service;

import com.reformasyacabados.ryaweb.models.Empleado;
import com.reformasyacabados.ryaweb.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {


    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    public List<Empleado> listarEmpleados(){
        return iEmpleadoRepository.findAll();
    }


    public Empleado obtenerEmpleadoId(Integer id_empleado){
        return iEmpleadoRepository.findById(id_empleado).get();
    }


    public void guardarEmpleado(Empleado empleado){
        iEmpleadoRepository.save(empleado);
    }


    public void eliminarEmpleado(Integer id_empleado){
        iEmpleadoRepository.deleteById(id_empleado);
    }


    public void eliminarTodosEmpleados() {
        iEmpleadoRepository.deleteAll();
    }





}
