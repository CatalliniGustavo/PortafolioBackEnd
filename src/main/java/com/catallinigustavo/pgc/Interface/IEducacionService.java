package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    // Traer una Educacion
    public List<Educacion> getEducacion();
    // Guardar una Educacion
    public void saveEducacion(Educacion educacion);
    // Eliminar una Educacion por ID
    public void deletEducacion(Long id);
    // Buscar una Educacion por ID
    public Educacion findEducacion(Long id);
    
    public Optional<Educacion> getOne(long id);
}
