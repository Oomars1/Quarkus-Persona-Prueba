package org.edwin.dominio.repositorio;


import org.edwin.dominio.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    void guardar(Persona persona);
    Optional<Persona> porId(Long id);   // ← Long
    List<Persona> todas();
    List<Persona> porSexo(String sexo);
    void eliminar(Long id);             // ← Long
}