package com.catallinigustavo.pgc.Security.Repository;

import com.catallinigustavo.pgc.Security.Entity.Rol;
import com.catallinigustavo.pgc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
