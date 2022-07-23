package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.User;
import java.util.List;


public interface IUserService {
    // Traer un Usuario
    public List<User> getUser();
    // Guardar un Usuario
    public void saveUser(User user);
    // Eliminar un Usuario por ID
    public void deletUser(Long id);
    // Buscar un Usuario por ID
    public User findUser(Long id);
    
}
