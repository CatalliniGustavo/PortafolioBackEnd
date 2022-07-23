package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{
    public Optional<Experiencia> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
