package org.edwin.dominio.modelo;

import lombok.*;

import static java.util.Objects.requireNonNull;

/*
    * No hay ninguna importación de frameworks de infraestructura como jakarta.persistence.*(JPA),
    * io.quarkus.*, o clases específicas de Panache.
    * Esto asegura que el Dominio es agnóstico a la tecnología.
 */

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Persona { //Entidad de dominio puro
    private  Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;

    public static Persona crear(String nombre, String apellido, Integer edad, String sexo) {
        return Persona.builder()
                .nombre(nombre)
                .apellido(apellido)
                .edad(edad)
                .sexo(sexo)
                .build();
    }

    // Método de negocio para actualizar datos de la persona
    public void actualizar(String nombre, String apellido, Integer edad, String sexo) {
        this.nombre = requireNonNull(nombre, "Nombre no puede ser null");
        this.apellido = requireNonNull(apellido, "Apellido no puede ser null");
        this.edad = edad;
        this.sexo = requireNonNull(sexo, "Sexo no puede ser null");
    }

    // Bonus: métodos con intención (opcional pero recomendado)
    public void cumplirAnios() {
        if (this.edad != null) this.edad++;
    }
}