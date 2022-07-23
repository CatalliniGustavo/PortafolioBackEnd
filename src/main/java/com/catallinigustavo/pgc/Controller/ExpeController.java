package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Experiencia;
import com.catallinigustavo.pgc.Interface.IExperienciaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ExpeController {
    
    @Autowired
    IExperienciaService iExperienciaService;
    
    @GetMapping("experiencia/traer")
    public List<Experiencia> getExperiencia(){
        return iExperienciaService.getExperiencia();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/crear")
    public ResponseEntity<?> crearExperiencia(@RequestBody Experiencia experiencia){
        iExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("La experiencia fue guardada"), HttpStatus.OK);
    }
    
    @PutMapping("experiencia/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Experiencia experiencia){
        Experiencia expAnt = iExperienciaService.findExperiencia(id);
        expAnt.setDescripcion(experiencia.getDescripcion());
        expAnt.setFechafin(experiencia.getFechafin());
        expAnt.setFechainicio(experiencia.getFechainicio());
        expAnt.setImgIcono(experiencia.getImgIcono());
        expAnt.setLinkIcono(experiencia.getLinkIcono());
        expAnt.setLugar(experiencia.getLugar());
        expAnt.setNombre(experiencia.getNombre());
        expAnt.setTitulo(experiencia.getTitulo());
        iExperienciaService.saveExperiencia(expAnt);
        return new ResponseEntity(new Mensaje("La experiencia fue actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("experiencia/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iExperienciaService.deletExperiencia(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("experiencia/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id){
        Experiencia experiencia = iExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
}
