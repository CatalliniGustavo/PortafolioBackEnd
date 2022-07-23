package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Redes;
import com.catallinigustavo.pgc.Interface.IRedesService;
import com.catallinigustavo.pgc.Repository.IRedesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpRedesService implements IRedesService {

    @Autowired
    IRedesRepository iRedesRepository;

    @Override
    public List<Redes> getRedes() {
        List<Redes> redes = iRedesRepository.findAll();
        return redes;
    }

    @Override
    public void saveRedes(Redes redes) {
        iRedesRepository.save(redes);
    }

    @Override
    public Optional<Redes> getOne(long id) {
        return iRedesRepository.findById(id);
    }

    public Optional<Redes> getByNombre(String nombre) {
        return iRedesRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iRedesRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iRedesRepository.existsByNombre(nombre);
    }

    @Override
    public void deletRedes(Long id) {
        iRedesRepository.deleteById(id);
    }

    @Override
    public Redes findRedes(Long id) {
        Redes redes = iRedesRepository.findById(id).orElse(null);
        return redes;
    }
}
