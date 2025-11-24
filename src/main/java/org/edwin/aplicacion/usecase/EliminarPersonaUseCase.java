package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;

public class EliminarPersonaUseCase {
    private final PersonaRepository personaRepository;

    public EliminarPersonaUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public void ejecutar(Long id){
        boolean existe = personaRepository.buscarPersonaPorId(id).isPresent();
        if(!existe){
            throw new IllegalArgumentException("La persona con id " + id + " no existe.");
        }
        personaRepository.eliminarPersona(id);
    }
}
