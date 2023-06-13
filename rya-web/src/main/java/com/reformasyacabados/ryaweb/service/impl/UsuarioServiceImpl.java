package com.reformasyacabados.ryaweb.service.impl;

import com.reformasyacabados.ryaweb.models.Cliente;
import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.models.Rol;
import com.reformasyacabados.ryaweb.repository.IUsuarioRepository;
import com.reformasyacabados.ryaweb.repository.IRolRepository;
import com.reformasyacabados.ryaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private IUsuarioRepository iusuarioRepository;

    @Autowired
    private IRolRepository irolRepository;



    @Override
    public Usuario guardarUsuario(Usuario usuario, Rol rol) throws Exception {
        Usuario usuarioLocal = iusuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        } else {
            rol = irolRepository.save(rol);
            usuario.setRol(rol);
            usuarioLocal = iusuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return iusuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long id_usuario) {
        iusuarioRepository.deleteById(id_usuario);
    }
}
