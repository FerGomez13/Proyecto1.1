package com.uabc.edu.examen.service;

import com.uabc.edu.examen.model.Usuario;
import com.uabc.edu.examen.repository.UsuarioRepositorio;
import com.uabc.edu.examen.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepositorio.findUsersByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No encontrado" + username));
        return user.map(MyUserDetails::new).get();
    }
}
