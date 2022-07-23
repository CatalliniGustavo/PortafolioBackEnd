package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesRepository extends JpaRepository<Redes, Long> {

    public Optional<Redes> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
