package com.reformasyacabados.ryaweb.service.impl;

import com.reformasyacabados.ryaweb.models.Usuario;
import com.reformasyacabados.ryaweb.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iusuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.iusuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }

}
