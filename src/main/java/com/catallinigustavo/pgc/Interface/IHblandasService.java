package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Hblandas;
import java.util.List;
import java.util.Optional;

public interface IHblandasService {

    public List<Hblandas> getHblandas();

    public void saveHblandas(Hblandas hblandas);

    public void deletHblandas(Long id);

    public Hblandas findHblandas(Long id);
    
    public Optional<Hblandas> getOne(long id);
}
