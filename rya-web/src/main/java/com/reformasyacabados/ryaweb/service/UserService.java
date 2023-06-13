package com.reformasyacabados.ryaweb.service;

import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.repository.IRolRepository;
import com.reformasyacabados.ryaweb.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {



    @Autowired
    private IUsuarioRepository iusuarioRepository;



    public List<Usuario> listarUsuarios(){
        return iusuarioRepository.findAll();
    }

    public void guardarUsuario(Usuario usuario){
        iusuarioRepository.save(usuario);
    }




}
