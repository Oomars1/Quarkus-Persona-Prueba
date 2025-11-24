package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.dominio.modelo.Persona;

public class CrearPersonaUseCase {

    private final PersonaRepository personaRepository;

    public CrearPersonaUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona ejecutar(Persona persona){
        persona.validar();
        return personaRepository.guardarPersona(persona);

    }
}
