package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.dominio.modelo.Persona;

import java.util.List;

public class BuscarPersonaUseCase {

    private final PersonaRepository personaRepository;

    public BuscarPersonaUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> ejecutar(){

        return personaRepository.buscarTodasLasPersonas();

    }
}
