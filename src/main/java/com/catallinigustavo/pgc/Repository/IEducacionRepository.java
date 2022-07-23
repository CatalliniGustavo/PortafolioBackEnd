package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {

    public Optional<Educacion> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}

