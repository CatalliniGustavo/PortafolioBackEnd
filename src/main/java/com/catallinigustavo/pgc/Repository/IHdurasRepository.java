package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Hduras;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHdurasRepository extends JpaRepository<Hduras, Long> {

    public Optional<Hduras> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
