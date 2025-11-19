package org.edwin.aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.repositorio.PersonaRepository;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;

import java.util.List;

@ApplicationScoped
public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public List<Persona> buscarTodasLasPersonas() {
        return repository.todas();
    }

    public Persona buscarPorId(Long id) {
        return repository.porId(id)
                .orElseThrow(() -> new NotFoundException("No se encontró la persona con id " + id));
    }

    @Transactional
    public Persona crear(PersonaRequestDTO dto) {
        Persona persona = Persona.crear(
                dto.getNombre(),
                dto.getApellido(),
                dto.getEdad(),
                dto.getSexo()
        );
        repository.guardar(persona);
        return persona;
    }

    @Transactional
    public Persona actualizar(Long id, PersonaRequestDTO dto) {
        Persona persona = buscarPorId(id);

        // Si tu Persona tiene método actualizar()
        persona.actualizar(dto.getNombre(), dto.getApellido(), dto.getEdad(), dto.getSexo());

        // Si usas Lombok @Builder(toBuilder = true), también puedes hacer:
        // persona = persona.toBuilder()
        //         .nombre(dto.getNombre())
        //         .apellido(dto.getApellido())
        //         .edad(dto.getEdad())
        //         .sexo(dto.getSexo())
        //         .build();

        repository.guardar(persona);
        return persona;
    }

    @Transactional
    public void eliminar(Long id) {
        repository.eliminar(id);  // ← ahora es Long directamente
    }

    public List<Persona> buscarPorSexo(String sexo) {
        return repository.porSexo(sexo);
    }
}
