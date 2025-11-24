package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.dominio.modelo.Persona;

import java.util.Optional;

public class BuscarPersonaPorIdUseCase {

    private final PersonaRepository personaRepository;

    public BuscarPersonaPorIdUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona ejecutar(Long id){
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        return personaRepository.buscarPersonaPorId(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
    }
}
