package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    // Traer una Experiencia
    public List<Experiencia> getExperiencia();
    // Guardar una Experiencia
    public void saveExperiencia(Experiencia experiencia);
    // Eliminar una Experiencia por ID
    public void deletExperiencia(Long id);
    // Buscar una Experiencia por ID
    public Experiencia findExperiencia(Long id);
    
    public Optional<Experiencia> getOne(long id);
}