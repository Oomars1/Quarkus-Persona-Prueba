package org.edwin.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.util.Objects.requireNonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Animal {
    private Long id;
    private String nombre;
    private String especie;
    private int edad;

    public static Animal crear(String nombre, String especie, int edad) {
        return Animal.builder()
                .nombre(nombre)
                .especie(especie)
                .edad(edad)
                .build();
    }

    public void actualizar(String nombre, String especie, int edad){
        this.nombre = requireNonNull(nombre, "Nombre no puede ser null");
        this.especie = requireNonNull(especie, "Nombre no puede ser null");
        this.edad = edad;
    }
}
