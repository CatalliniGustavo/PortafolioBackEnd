package com.catallinigustavo.pgc.Controller;

import com.catallinigustavo.pgc.Entity.Experiencia;
import com.catallinigustavo.pgc.Entity.User;
import com.catallinigustavo.pgc.Interface.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.catallinigustavo.pgc.Interface.IUserService;
import com.catallinigustavo.pgc.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "https://portafoliocatallinigustavo.web.app")
public class UserController {

    @Autowired
    IUserService iusuarioService;
    @Autowired
    IExperienciaService iExperienciaService;
    
    @GetMapping("user/traer")
    public List<User> getUser(){
        return iusuarioService.getUser();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody User usuario) {
        iusuarioService.saveUser(usuario);
        return "El usuario fué creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuario/experiencia/crear")
    public String crearExperiencia(@RequestBody Experiencia experiencia){
        iExperienciaService.saveExperiencia(experiencia);
        return "La experiencia fue guardada";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuario/borrar/{id}")
    public String deletUsario(@PathVariable Long id) {
        iusuarioService.deletUser(id);
        return "El usario fué eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuario/experiencia/borrar/{id}")
    public String deletExperincia(@PathVariable Long id) {
        iExperienciaService.deletExperiencia(id);
        return "La Experiencia fué eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/update")
    public ResponseEntity<?> editUsario(@RequestBody User user) {
        long id = 1;
        if (user.getNombre() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el Nombre"), HttpStatus.BAD_REQUEST);
        if (user.getApellido() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el Apellido"), HttpStatus.BAD_REQUEST);
        if (user.getEmail() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el Email"), HttpStatus.BAD_REQUEST);
        if (user.getTitulo() == "")
            return new ResponseEntity(new Mensaje("Debe colocar el Título"), HttpStatus.BAD_REQUEST);
        if (user.getAcerca() == "")
            return new ResponseEntity(new Mensaje("Debe colocar un texto en Acerca de:"), HttpStatus.BAD_REQUEST);
        User userAnt = iusuarioService.findUser(id);
        userAnt.setNombre(user.getNombre());
        userAnt.setApellido(user.getApellido());
        userAnt.setEmail(user.getEmail());
        userAnt.setTitulo(user.getTitulo());
        userAnt.setImg(user.getImg());
        userAnt.setBanner(user.getBanner());
        userAnt.setAcerca(user.getAcerca());
        iusuarioService.saveUser(user);
        return new ResponseEntity(new Mensaje("El Perfil fue actualizado"), HttpStatus.OK);
    }

    @GetMapping("user/traer/perfil")
    public User findUser() {
        return iusuarioService.findUser((long) 1);
    }
}
