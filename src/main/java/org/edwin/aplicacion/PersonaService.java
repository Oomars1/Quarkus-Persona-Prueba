package org.edwin.aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.repositorio.PersonaRepository;

import java.util.List;

import static java.util.Objects.requireNonNull;

@ApplicationScoped
public class PersonaService { // Servicio de Aplicación (Ahora 100% puro)

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = requireNonNull(repository);
    }

    public List<Persona> buscarTodasLasPersonas() {
        return repository.todas();
    }

    public Persona buscarPorId(Long id) {
        return repository.porId(id)
                .orElseThrow(() -> new NotFoundException("No se encontró la persona con id " + id));
    }

    @Transactional
    public Persona crear(String nombre, String apellido, Integer edad, String sexo) {
        // La validación de nulls ahora ocurre en el Resource o se delega a las entidades de dominio
        Persona persona = Persona.crear(nombre, apellido, edad, sexo);
        return repository.guardar(persona);
    }

    @Transactional
    public Persona actualizar(Long id, String nombre, String apellido, Integer edad, String sexo) {
        Persona persona = buscarPorId(id);
        persona.actualizar(nombre, apellido, edad, sexo);
        return repository.guardar(persona);
    }

    @Transactional
    public void eliminar(Long id) {
        buscarPorId(id);
        repository.eliminarPorId(id);
    }

    public List<Persona> buscarPorSexo(String sexo) {
        return repository.porSexo(sexo);
    }
}