package com.catallinigustavo.pgc.Interface;

import com.catallinigustavo.pgc.Entity.Redes;
import java.util.List;
import java.util.Optional;

public interface IRedesService {

    public List<Redes> getRedes();

    public void saveRedes(Redes redes);

    public void deletRedes(Long id);

    public Redes findRedes(Long id);

    public Optional<Redes> getOne(long id);
}
