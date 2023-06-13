package com.reformasyacabados.ryaweb.service;

import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.models.Rol;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Rol rol) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long id_usuario);

}
