package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Contacto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactoRepository extends JpaRepository<Contacto, Long> {

    public Optional<Contacto> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
