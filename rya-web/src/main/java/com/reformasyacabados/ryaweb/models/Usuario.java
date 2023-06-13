package com.reformasyacabados.ryaweb.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "id_usuario")
    private int id_usuario;

    private String username;
    private String password;
    private int estado;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // Retorna la contraseña del usuario
        return password;
    }

    @Override
    public String getUsername() {
        // Retorna el nombre de usuario del usuario
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
