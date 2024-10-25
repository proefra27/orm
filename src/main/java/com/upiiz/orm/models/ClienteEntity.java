package com.upiiz.orm.models;

//Base de datos o persistencia
import jakarta.persistence.*;

//Validacion antes de ingresar a la base de datos
import jakarta.validation.constraints.*;

//Ahorrar codigo
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Generar los setter y getteres
@Data
//Constructor con parametros
@AllArgsConstructor
//Constructor sin argumentos
@NoArgsConstructor
//Mapear esta Clase -> Tabla de la base de datos
@Entity
//ClientEntity -> cliente
@Table(name = "cliente")
public class ClienteEntity {
    //Esta es la llave primaria y que MySQL genere id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //En caso de requerir un nombre diferente al de la clase
    @NotBlank
    @Size(min = 3, message = "El nombre de cliente debe tener minimo 3 letras")
    @Column(name = "nombre_cliente")
    private String nombre;

    //Se pueden personalizar los mensajes
    @NotBlank(message = "Se debe de ingresar un apellido")
    private String apellido;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    //@Pattern(regexp = "")
    private String telefono;

    @NotBlank
    private String direccion;

    @Min(18)
    private int edad;

    @NotBlank
    //@Pattern(regexp = "")
    private String rfc;
}
