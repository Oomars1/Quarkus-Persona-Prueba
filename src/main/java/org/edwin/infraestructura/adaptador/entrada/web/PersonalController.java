package org.edwin.infraestructura.adaptador.entrada.web;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.edwin.aplicacion.port.input.PersonaInputPort;
import org.edwin.dominio.modelo.Persona;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;

import java.util.List;

@Path("/personas")
public class PersonalController {

    private final PersonaInputPort personaInputPort;
    private final PersonaMapper personaMapper;

    public PersonalController(PersonaInputPort personaInputPort, PersonaMapper personaMapper) {
        this.personaInputPort = personaInputPort;
        this.personaMapper = personaMapper;
    }

    @POST
    @Transactional
    public Response guardarPersona(PersonaRequestDTO personaDto) {
        Persona persona = personaMapper.toPersonaDomain(personaDto);
        Persona personaGuardada = personaInputPort.crearPersona(persona);
        PersonaResponseDTO responseDTO = personaMapper.toDtoResponde(personaGuardada);

        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        // Lógica para guardar personas
    }

    @GET
    @Path("/persona/{id}")
    public PersonaResponseDTO buscarPorId(@PathParam("id") Long id) {
        Persona persona = personaInputPort.buscarPersonaPorId(id);
        return personaMapper.toDtoResponde(persona);
        // Lógica para buscar personal por ID
    }

    @GET
    public List<PersonaResponseDTO> buscarTodas() {
        return personaInputPort.buscarTodasLasPersonas().stream()
            .map(personaMapper::toDtoResponde)
            .toList();
        // Lógica para buscar personal por ID
    }

    @GET
    @Path("/persona/{sexo}")
    public List<PersonaResponseDTO> buscarPorSexo(@PathParam("sexo") String sexo) {
        List<Persona> personas = personaInputPort.buscarPersonaPorSexo(sexo);
        return personas.stream()
            .map(personaMapper::toDtoResponde)
            .toList();
    }

    @PUT
    @Path("/persona/{id}")
    public Persona actualizar(@PathParam("id") Long id) {
        Persona persona = personaInputPort.buscarPersona(id);
        return personaInputPort.actualizarPersona(id, persona);
    }

    @DELETE
    @Path("/persona/{id}")
    public void eliminar(@PathParam("id") Long id) {
        personaInputPort.eliminarPersona(id);
    }
}
