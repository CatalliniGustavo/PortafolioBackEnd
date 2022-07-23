package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Hduras;
import com.catallinigustavo.pgc.Interface.IHdurasService;
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
@RequestMapping("/hduras")
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class HdurasController {
    @Autowired
    IHdurasService iHdurasService;
    
    @GetMapping("/traer")
    public List<Hduras> getHduras() {
        return iHdurasService.getHduras();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearHduras(@RequestBody Hduras hduras) {
        if (hduras.getNombre() == null)
            return new ResponseEntity(new Mensaje("Campos vacíos o erroneos"), HttpStatus.BAD_REQUEST);
        iHdurasService.saveHduras(hduras);
        return new ResponseEntity(new Mensaje("La Hduras fue guardada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Hduras hduras) {
        if (hduras.getNombre() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el título"), HttpStatus.BAD_REQUEST);
        Hduras hdAnt = iHdurasService.findHduras(id);
        hdAnt.setProgreso(hduras.getProgreso());
        hdAnt.setTiempoexpe(hduras.getTiempoexpe());
        hdAnt.setImgIcono(hduras.getImgIcono());
        hdAnt.setNombre(hduras.getNombre());
        iHdurasService.saveHduras(hdAnt);
        return new ResponseEntity(new Mensaje("La Hduras fue actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iHdurasService.deletHduras(id);
        return new ResponseEntity(new Mensaje("Hduras eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hduras> getById(@PathVariable("id") long id) {
        Hduras hduras = iHdurasService.getOne(id).get();
        return new ResponseEntity(hduras, HttpStatus.OK);
    }
}
