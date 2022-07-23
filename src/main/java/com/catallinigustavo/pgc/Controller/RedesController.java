package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Redes;
import com.catallinigustavo.pgc.Interface.IRedesService;
import com.catallinigustavo.pgc.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redes")
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class RedesController {

    @Autowired
    IRedesService iRedesService;

    @GetMapping("/traer")
    public List<Redes> getRedes() {
        return iRedesService.getRedes();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearRedes(@RequestBody Redes redes) {
        if(redes.getLinkIcono().isEmpty() || redes.getNombre().isEmpty())
            return new ResponseEntity(new Mensaje("Campos vacíos o erroneos"), HttpStatus.BAD_REQUEST);
        
        iRedesService.saveRedes(redes);
        return new ResponseEntity(new Mensaje("La Red fue guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Redes redes) {
        Redes redAnt = iRedesService.findRedes(id);
        redAnt.setImgIcono(redes.getImgIcono());
        redAnt.setLinkIcono(redes.getLinkIcono());
        redAnt.setNombre(redes.getNombre());
        iRedesService.saveRedes(redAnt);
        return new ResponseEntity(new Mensaje("La Red fue actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iRedesService.deletRedes(id);
        return new ResponseEntity(new Mensaje("Red eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") long id) {
        Redes redes = iRedesService.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
}
