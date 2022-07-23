package com.catallinigustavo.pgc.Repository;

import com.catallinigustavo.pgc.Entity.Hblandas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHblandasRepository extends JpaRepository<Hblandas, Long> {

    public Optional<Hblandas> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
