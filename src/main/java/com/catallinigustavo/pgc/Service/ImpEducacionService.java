package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Educacion;
import com.catallinigustavo.pgc.Interface.IEducacionService;
import com.catallinigustavo.pgc.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ImpEducacionService implements IEducacionService {

    @Autowired
    IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = iEducacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public Optional<Educacion> getOne(long id) {
        return iEducacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombre(String nombre) {
        return iEducacionRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iEducacionRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iEducacionRepository.existsByNombre(nombre);
    }

    @Override
    public void deletEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion experiencia = iEducacionRepository.findById(id).orElse(null);
        return experiencia;
    }

}
