package com.catallinigustavo.pgc.Security.Controller;

import com.catallinigustavo.pgc.Security.Dto.JwtDto;
import com.catallinigustavo.pgc.Security.Dto.LoginUsuario;
import com.catallinigustavo.pgc.Security.Dto.NuevoUsuario;
import com.catallinigustavo.pgc.Security.Entity.Rol;
import com.catallinigustavo.pgc.Security.Entity.Usuario;
import com.catallinigustavo.pgc.Security.Enums.RolNombre;
import com.catallinigustavo.pgc.Security.Service.RolService;
import com.catallinigustavo.pgc.Security.Service.UsuarioService;
import com.catallinigustavo.pgc.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        if (nuevoUsuario.getPassword().length() != 8 )
            return new ResponseEntity(new Mensaje("La contraseña tiene que tener 8 caracteres"), HttpStatus.BAD_REQUEST);
        if (nuevoUsuario.getApellido() == null || nuevoUsuario.getNombre() == null)
            return new ResponseEntity(new Mensaje("Falta nombre 0/y apellido"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese Email ya esta relacionado a otra cuenta"), HttpStatus.BAD_REQUEST);
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        
//        if (usuarioService.existsByNombre(nuevoUsuario.getNombre())) ***Para ortros Valores****
//            return new ResponseEntity(new Mensaje("Ese Nombre ya esta relacionado a otra cuenta"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario (
                nuevoUsuario.getNombre(), 
                nuevoUsuario.getEmail(), 
                nuevoUsuario.getApellido(), 
                passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        //copio esta parte del login para que ingrese con el toquen
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        nuevoUsuario.getEmail(), nuevoUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        //retorna jwtDto para entrar logueado y quito new Mensaje("Usuario Guardado") para que entre jwtDto
        return new ResponseEntity(jwtDto, HttpStatus.CREATED);
        
    }
    
    @PostMapping("/login")
    public  ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
   
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getEmail(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
