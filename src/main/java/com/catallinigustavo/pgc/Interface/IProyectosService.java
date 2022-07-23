package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Proyectos;
import java.util.List;
import java.util.Optional;

public interface IProyectosService {

    public List<Proyectos> getProyectos();

    public void saveProyectos(Proyectos proyectos);

    public void deletProyectos(Long id);

    public Proyectos findProyectos(Long id);

    public Optional<Proyectos> getOne(long id);
}
