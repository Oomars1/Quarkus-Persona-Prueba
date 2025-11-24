package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.dominio.modelo.Persona;

public class ActualizarPersonaUseCase {
    private final PersonaRepository personaRepository;

    public ActualizarPersonaUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona ejecutar(Long id, Persona persona){
        Persona personaExistente = personaRepository.buscarPersonaPorId(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        personaExistente.actualizar(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                persona.getSexo()
        );

        personaExistente.validar();

        // Guardar y retornar
        return personaRepository.guardarPersona(personaExistente);
    }
}
s