package com.catallinigustavo.pgc.Security.Service;


import com.catallinigustavo.pgc.Security.Entity.Usuario;
import com.catallinigustavo.pgc.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     Usuario usuario = usuarioService.getByEmail(email).get();
     return UsuarioPrincipal.build(usuario);
    }
    
}
