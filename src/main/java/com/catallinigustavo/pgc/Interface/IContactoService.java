package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Contacto;
import java.util.List;
import java.util.Optional;

public interface IContactoService {

    public List<Contacto> getContacto();

    public void saveContacto(Contacto contacto);

    public void deletContacto(Long id);

    public Contacto findContacto(Long id);

    public Optional<Contacto> getOne(long id);
}
