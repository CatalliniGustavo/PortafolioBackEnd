package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Experiencia;
import com.catallinigustavo.pgc.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catallinigustavo.pgc.Interface.IExperienciaService;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class ImpExperienciaService implements IExperienciaService {

    @Autowired
    IExperienciaRepository iExperienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencia = iExperienciaRepository.findAll();
        return experiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    @Override
    public Optional<Experiencia> getOne(long id) {
        return iExperienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombre(String nombre) {
        return iExperienciaRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iExperienciaRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iExperienciaRepository.existsByNombre(nombre);
    }

    @Override
    public void deletExperiencia(Long id) {
        iExperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = iExperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }

}
