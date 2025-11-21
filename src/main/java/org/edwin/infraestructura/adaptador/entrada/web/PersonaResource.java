package org.edwin.infraestructura.adaptador.entrada.web;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.edwin.aplicacion.PersonaService;
import org.edwin.dominio.modelo.Persona;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;
import java.net.URI;
import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaResource { // Adaptador de entrada - Recurso REST

    private final PersonaService personaService;
    private final PersonaMapper personaMapper;

    public PersonaResource(PersonaService personaService, PersonaMapper personaMapper) {
        this.personaService = personaService;
        this.personaMapper = personaMapper;
    }

    @GET
    public List<PersonaResponseDTO> listarPersonas() {
        return personaService.buscarTodasLasPersonas()
                .stream()
                .map(personaMapper::toResponseDto)
                .toList();
    }

    @GET
    @Path("/{id}")
    public PersonaResponseDTO buscarPorId(@PathParam("id") Long id) {
        return personaMapper.toResponseDto(personaService.buscarPorId(id));
    }

    @POST
    public Response crear(@Valid PersonaRequestDTO dto) {
        // El Resource mapea el DTO a los parámetros del servicio
        Persona creada = personaService.crear(
                dto.getNombre(),
                dto.getApellido(),
                dto.getEdad(),
                dto.getSexo()
        );
        return Response
                .created(URI.create("/personas/" + creada.getId()))
                .entity(personaMapper.toResponseDto(creada))
                .build();
    }

    @GET
    @Path("/sexo/{sexo}")
    public List<PersonaResponseDTO> porSexo(@PathParam("sexo") String sexo) {
        return personaService.buscarPorSexo(sexo)
                .stream()
                .map(personaMapper::toResponseDto)
                .toList();
    }

    @PUT
    @Path("/{id}")
    public PersonaResponseDTO actualizar(@PathParam("id") Long id, @Valid PersonaRequestDTO dto) {
        // El Resource mapea el DTO a los parámetros del servicio
        Persona actualizada = personaService.actualizar(
                id,
                dto.getNombre(),
                dto.getApellido(),
                dto.getEdad(),
                dto.getSexo()
        );
        return personaMapper.toResponseDto(actualizada);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        personaService.eliminar(id);
        return Response.noContent().build();
    }
}