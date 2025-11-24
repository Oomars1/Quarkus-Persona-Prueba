package org.edwin.infraestructura.adaptador.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.edwin.aplicacion.port.output.PersonaRepository;

@ApplicationScoped
public class ApplicationConfig {
    private final PersonaRepository personaRepository;

    public ApplicationConfig(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }





    @Produces
}
