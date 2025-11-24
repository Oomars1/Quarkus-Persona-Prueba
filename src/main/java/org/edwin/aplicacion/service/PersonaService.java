package org.edwin.aplicacion.service;

import org.edwin.aplicacion.port.input.PersonaInputPort;
import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.aplicacion.usecase.*;
import org.edwin.dominio.modelo.Persona;

import java.util.List;

public class PersonaService implements PersonaInputPort {
    private final CrearPersonaUseCase crearPersonaUseCase;
    private final ActualizarPersonaUseCase actualizarPersonaUseCase;
    private final BuscarPersonaPorIdUseCase buscarPersonaPorIdUseCase;
    private final BuscarPersonaUseCase buscarPersonaUseCase;
    private final BuscarPersonaPorSexoUseCase buscarPersonaPorSexoUseCase;
    private final EliminarPersonaUseCase eliminarPersonaUseCase;

    public PersonaService(PersonaRepository personaRepository){
        crearPersonaUseCase = new CrearPersonaUseCase(personaRepository);
        actualizarPersonaUseCase = new ActualizarPersonaUseCase(personaRepository);
        buscarPersonaPorIdUseCase = new BuscarPersonaPorIdUseCase(personaRepository);
        buscarPersonaUseCase = new BuscarPersonaUseCase(personaRepository);
        buscarPersonaPorSexoUseCase = new BuscarPersonaPorSexoUseCase(personaRepository);
        eliminarPersonaUseCase = new EliminarPersonaUseCase(personaRepository);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return crearPersonaUseCase.ejecutar(persona);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return (Persona) buscarPersonaUseCase.ejecutar();
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        return actualizarPersonaUseCase.ejecutar(id ,persona);
    }

    @Override
    public List<Persona> buscarPersonaPorSexo(String sexo) {
        return buscarPersonaPorSexoUseCase.ejecutar(sexo);
    }

    @Override
    public Persona buscarPersonaPorId(Long id) {
        return buscarPersonaPorIdUseCase.ejecutar(id);
    }

    @Override
    public void eliminarPersona(Long id) {
        return;
    }

    @Override
    public List<Persona> buscarTodasLasPersonas() {
        return buscarPersonaUseCase.ejecutar();
    }
}
