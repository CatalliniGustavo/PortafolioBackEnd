package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Proyectos;
import com.catallinigustavo.pgc.Interface.IProyectosService;
import com.catallinigustavo.pgc.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectosService implements IProyectosService{
    
@Autowired
    IProyectosRepository iProyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> proyectos = iProyectosRepository.findAll();
        return proyectos;
    }

    @Override
    public void saveProyectos(Proyectos proyectos) {
        iProyectosRepository.save(proyectos);
    }

    @Override
    public Optional<Proyectos> getOne(long id) {
        return iProyectosRepository.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre) {
        return iProyectosRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iProyectosRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iProyectosRepository.existsByNombre(nombre);
    }

    @Override
    public void deletProyectos(Long id) {
        iProyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos findProyectos(Long id) {
        Proyectos proyectos = iProyectosRepository.findById(id).orElse(null);
        return proyectos;
    }
}
