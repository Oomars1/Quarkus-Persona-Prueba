package org.edwin.aplicacion.port.input;

import org.edwin.dominio.modelo.Persona;

import java.util.List;

public interface PersonaInputPort {

    Persona crearPersona(Persona persona);
    Persona buscarPersona(Long id);
    Persona actualizarPersona(Long id, Persona persona);
    List<Persona> buscarPersonaPorSexo(String sexo);
    Persona buscarPersonaPorId(Long id);
    void eliminarPersona(Long id);
    List<Persona> buscarTodasLasPersonas();
}
