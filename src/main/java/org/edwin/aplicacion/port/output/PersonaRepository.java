package org.edwin.aplicacion.port.output;

import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.vo.Sexo;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    Persona guardarPersona(Persona persona);
    Optional<Persona> buscarPersonaPorId(Long id);
    Persona actualizarPersona(Persona persona);
    List<Persona> buscarTodasLasPersonas();
    List<Persona> buscarPersonaPorSexo(Sexo sexo);
    boolean eliminarPersona(Long id);
}
