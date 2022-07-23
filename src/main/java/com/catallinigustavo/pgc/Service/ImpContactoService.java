package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.Contacto;
import com.catallinigustavo.pgc.Interface.IContactoService;
import com.catallinigustavo.pgc.Repository.IContactoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpContactoService implements IContactoService {

    @Autowired
    IContactoRepository iContactoRepository;

    @Override
    public List<Contacto> getContacto() {
        List<Contacto> contacto = iContactoRepository.findAll();
        return contacto;
    }

    @Override
    public void saveContacto(Contacto contacto) {
        iContactoRepository.save(contacto);
    }

    @Override
    public Optional<Contacto> getOne(long id) {
        return iContactoRepository.findById(id);
    }

    public Optional<Contacto> getByNombre(String nombre) {
        return iContactoRepository.findByNombre(nombre);
    }

    public boolean existById(long id) {
        return iContactoRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return iContactoRepository.existsByNombre(nombre);
    }

    @Override
    public void deletContacto(Long id) {
        iContactoRepository.deleteById(id);
    }

    @Override
    public Contacto findContacto(Long id) {
        Contacto contacto = iContactoRepository.findById(id).orElse(null);
        return contacto;
    }
}
