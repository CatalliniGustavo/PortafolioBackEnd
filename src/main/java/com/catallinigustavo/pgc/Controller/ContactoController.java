package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Contacto;
import com.catallinigustavo.pgc.Interface.IContactoService;
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
@RequestMapping("/contacto")
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class ContactoController {

    @Autowired
    IContactoService iContactoService;

    @GetMapping("/traer")
    public List<Contacto> getContacto() {
        return iContactoService.getContacto();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearContacto(@RequestBody Contacto contacto) {
        if(contacto.getLinkIcono().isEmpty() || contacto.getNombre().isEmpty())
            return new ResponseEntity(new Mensaje("Campos vacíos o erroneos"), HttpStatus.BAD_REQUEST);
        iContactoService.saveContacto(contacto);
        return new ResponseEntity(new Mensaje("El Contacto fue guardado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Contacto contacto) {
        Contacto conAnt = iContactoService.findContacto(id);
        conAnt.setImgIcono(contacto.getImgIcono());
        conAnt.setLinkIcono(contacto.getLinkIcono());
        conAnt.setNombre(contacto.getNombre());
        conAnt.setEnlace(contacto.getEnlace());
        iContactoService.saveContacto(conAnt);
        return new ResponseEntity(new Mensaje("El Contacto fue actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        iContactoService.deletContacto(id);
        return new ResponseEntity(new Mensaje("Contacto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id") long id) {
        Contacto contacto = iContactoService.getOne(id).get();
        return new ResponseEntity(contacto, HttpStatus.OK);
    }
}
