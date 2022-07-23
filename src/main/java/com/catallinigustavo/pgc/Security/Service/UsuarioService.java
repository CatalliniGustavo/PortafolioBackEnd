package com.catallinigustavo.pgc.Security.Service;


import com.catallinigustavo.pgc.Security.Entity.Usuario;
import com.catallinigustavo.pgc.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusUsuarioRepository;
    
    public Optional<Usuario> getByEmail(String email){
        return iusUsuarioRepository.findByEmail(email);
    }
    
    public boolean existsByEmail (String email){
        return iusUsuarioRepository.existsByEmail(email);
    }
    
    public boolean existsByNombre (String nombre){
        return iusUsuarioRepository.existsByNombre(nombre);
    }
    
    public void save(Usuario usuario){
        iusUsuarioRepository.save(usuario);
    }
}
