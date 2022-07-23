package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Hblandas;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.catallinigustavo.pgc.Interface.IHblandasService;
import com.catallinigustavo.pgc.Repository.IHblandasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ImpHblandasService implements IHblandasService{
    
    @Autowired
    IHblandasRepository iHblandasRepository;

    @Override
    public List<Hblandas> getHblandas() {
        List<Hblandas> hblandas = iHblandasRepository.findAll();
        return hblandas;
    }

    @Override
    public void saveHblandas(Hblandas hblandas) {
        iHblandasRepository.save(hblandas);
    }

    @Override
    public Optional<Hblandas> getOne(long id) {
        return iHblandasRepository.findById(id);
    }

    public Optional<Hblandas> getByNombre(String nombre) {
        return iHblandasRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iHblandasRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iHblandasRepository.existsByNombre(nombre);
    }

    @Override
    public void deletHblandas(Long id) {
        iHblandasRepository.deleteById(id);
    }

    @Override
    public Hblandas findHblandas(Long id) {
        Hblandas hblandas = iHblandasRepository.findById(id).orElse(null);
        return hblandas;
    }
}
