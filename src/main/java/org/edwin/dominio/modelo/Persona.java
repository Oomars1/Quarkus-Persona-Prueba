package org.edwin.dominio.modelo;

import lombok.*;
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Persona {
    private Long id;
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

    // Método para actualizar (opcional, pero recomendado)
    public void actualizar(String nombre, String apellido, Integer edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }
}