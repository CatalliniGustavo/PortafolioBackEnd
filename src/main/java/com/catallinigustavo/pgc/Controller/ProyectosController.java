package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Proyectos;
import com.catallinigustavo.pgc.Interface.IProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class ProyectosController {
    @Autowired
    IProyectosService iProyectosService;
    
    @GetMapping("/traer")
    public List<Proyectos> getProyectos() {
        return iProyectosService.getProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearProyectos(@RequestBody Proyectos proyectos) {
        if (proyectos.getNombre() == null)
            return new ResponseEntity(new Mensaje("Debe colocar el título"), HttpStatus.BAD_REQUEST);
        iProyectosService.saveProyectos(proyectos);
        return new ResponseEntity(new Mensaje("El Proyectos fue guardado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Proyectos proyectos) {
        if (proyectos.getNombre() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el título"), HttpStatus.BAD_REQUEST);
        Proyectos proAnt = iProyectosService.findProyectos(id);
        proAnt.setDescripcion(proyectos.getDescripcion());
        proAnt.setGithub(proyectos.getGithub());
        proAnt.setImgIcono(proyectos.getImgIcono());
        proAnt.setNombre(proyectos.getNombre());
        proAnt.setLinkProy(proyectos.getLinkProy());
        iProyectosService.saveProyectos(proAnt);
        return new ResponseEntity(new Mensaje("El Proyecto fue actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iProyectosService.deletProyectos(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") long id) {
        Proyectos proyectos = iProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
