package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Educacion;
import com.catallinigustavo.pgc.Interface.IEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class EduController {

    @Autowired
    IEducacionService iEducacionService;

    @GetMapping("/traer")
    public List<Educacion> getEducacion() {
        return iEducacionService.getEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearEducacion(@RequestBody Educacion educacion) {
        iEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("La Educación fue guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Educacion educacion) {
        Educacion eduAnt = iEducacionService.findEducacion(id);
        eduAnt.setDescripcion(educacion.getDescripcion());
        eduAnt.setFechafin(educacion.getFechafin());
        eduAnt.setFechainicio(educacion.getFechainicio());
        eduAnt.setImgIcono(educacion.getImgIcono());
        eduAnt.setLinkIcono(educacion.getLinkIcono());
        eduAnt.setLugar(educacion.getLugar());
        eduAnt.setNombre(educacion.getNombre());
        eduAnt.setTitulo(educacion.getTitulo());
        iEducacionService.saveEducacion(eduAnt);
        
        return new ResponseEntity(new Mensaje("La Educacion fue actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iEducacionService.deletEducacion(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") long id) {
        Educacion educacion = iEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

}
