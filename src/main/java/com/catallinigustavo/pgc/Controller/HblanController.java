package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Hblandas;
import com.catallinigustavo.pgc.Interface.IHblandasService;
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
@RequestMapping("/hblandas")
@CrossOrigin(origins = "http://localhost:4200/")
public class HblanController {

    @Autowired
    IHblandasService iHblandasService;
    
    @GetMapping("/traer")
    public List<Hblandas> getHblandas() {
        return iHblandasService.getHblandas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearHblandas(@RequestBody Hblandas hblandas) {
       
        if (hblandas.getNombre() == null)
            return new ResponseEntity(new Mensaje("Campos vacíos o erroneos"), HttpStatus.BAD_REQUEST);
        iHblandasService.saveHblandas(hblandas);
        return new ResponseEntity(new Mensaje("La Hblandas fue guardada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Hblandas hblandas) {
        
        if (hblandas.getNombre() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el título"), HttpStatus.BAD_REQUEST);
        Hblandas hbAnt = iHblandasService.findHblandas(id);
        hbAnt.setProgreso(hblandas.getProgreso());
        hbAnt.setTiempoexpe(hblandas.getTiempoexpe());
        hbAnt.setImgIcono(hblandas.getImgIcono());
        hbAnt.setNombre(hblandas.getNombre());
        iHblandasService.saveHblandas(hbAnt);
        return new ResponseEntity(new Mensaje("La Hblandas fue actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iHblandasService.deletHblandas(id);
        return new ResponseEntity(new Mensaje("Hblandas eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hblandas> getById(@PathVariable("id") long id) {
        Hblandas hblandas = iHblandasService.getOne(id).get();
        return new ResponseEntity(hblandas, HttpStatus.OK);
    }
}
