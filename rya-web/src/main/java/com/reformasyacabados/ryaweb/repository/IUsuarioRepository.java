package com.reformasyacabados.ryaweb.repository;

import com.reformasyacabados.ryaweb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}

