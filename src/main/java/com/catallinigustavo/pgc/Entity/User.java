package com.catallinigustavo.pgc.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "el nombre no cumple con la longitd")
    private String nombre;
    @Size(min = 1, max = 9, message = "el apellido no cumple con la longitd")
    private String apellido;
    @NotNull
    @Size(min = 1, max = 50, message = "el email no cumple con la longitd")
    private String email;
    private String titulo;
    private String img;
    private String banner;
    @Size(min = 1, max = 500, message = "el pass no cumple con la longitd")
    private String acerca;
    
    
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
//    private List<Experiencia> experiencia;
    
    
}
