package com.reformasyacabados.ryaweb.service;

import com.reformasyacabados.ryaweb.models.Rol;
import com.reformasyacabados.ryaweb.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {


    @Autowired
    private IRolRepository iRolRepository;

    public List<Rol> listarRoles(){
        return iRolRepository.findAll();
    }


    public void guardarRol(Rol rol){
        iRolRepository.save(rol);
    }



}
