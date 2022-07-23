package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Hduras;
import com.catallinigustavo.pgc.Interface.IHdurasService;
import com.catallinigustavo.pgc.Repository.IHdurasRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHdurasService implements IHdurasService{
    
    @Autowired
    IHdurasRepository iHdurasRepository;

    @Override
    public List<Hduras> getHduras() {
        List<Hduras> hduras = iHdurasRepository.findAll();
        return hduras;
    }

    @Override
    public void saveHduras(Hduras hduras) {
        iHdurasRepository.save(hduras);
    }

    @Override
    public Optional<Hduras> getOne(long id) {
        return iHdurasRepository.findById(id);
    }

    public Optional<Hduras> getByNombre(String nombre) {
        return iHdurasRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iHdurasRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iHdurasRepository.existsByNombre(nombre);
    }

    @Override
    public void deletHduras(Long id) {
        iHdurasRepository.deleteById(id);
    }

    @Override
    public Hduras findHduras(Long id) {
        Hduras hduras = iHdurasRepository.findById(id).orElse(null);
        return hduras;
    }
}
