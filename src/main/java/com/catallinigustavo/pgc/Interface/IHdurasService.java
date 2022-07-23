package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Hduras;
import java.util.List;
import java.util.Optional;

public interface IHdurasService {

    public List<Hduras> getHduras();

    public void saveHduras(Hduras hduras);

    public void deletHduras(Long id);

    public Hduras findHduras(Long id);

    public Optional<Hduras> getOne(long id);
}
