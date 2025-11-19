package org.edwin.infraestructura.adaptador.entrada.web;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.edwin.aplicacion.PersonaService;
import org.edwin.dominio.repositorio.PersonaRepository;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;
import org.edwin.infraestructura.adaptador.salida.persistence.JpaPersonaRepository;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;

import java.util.List;

@Path("/personas")
public class PersonaResource {

    private final PersonaService personaService;
    private final PersonaMapper personaMapper;

    public PersonaResource(PersonaService personaService, PersonaMapper personaMapper) {
        this.personaService = personaService;
        this.personaMapper = personaMapper;
    }

    @GET
    public List<PersonaResponseDTO> listarPersonas() {
        return personaService.buscarTodasLasPersonas().stream()
                .map(personaMapper::toPersonaResponseDto)
                .toList();
    }

    @GET
    @Path("/idpersona/{idpersona}")
    public PersonaResponseDTO buscarPorId(@PathParam("idpersona") Long idpersona) {
        return personaMapper.toPersonaResponseDto(personaService.buscarPorId(idpersona));
    }

    @POST
    public Response guardarPersona(@Valid PersonaRequestDTO personaRequestDTO) {
        PersonaEntity persona = personaMapper.fromPersonaRequest(personaRequestDTO);
        personaService.guardarPersona(persona);

        return Response.ok("Persona Creada").build();
    }

    @GET
    @Path("/sexo/{sexo}")
    public List<PersonaResponseDTO> buscarPersonasPorSexo(@PathParam("sexo") String sexo) {
        return personaService.buscarPersonasPorSexo(sexo).stream()
                .map(personaMapper::toPersonaResponseDto)
                .toList();
    }

    @PUT
    @Path("/idpersona/{idpersona}")
    public PersonaResponseDTO actualizarPersona(@PathParam("idpersona") Long idPersona,
                                     @Valid PersonaRequestDTO personaRequestDTO) {
         return personaMapper.toPersonaResponseDto(
                 personaService.actualizarPersona(idPersona, personaRequestDTO));
    }

    @DELETE
    @Path("/idpersona/{idpersona}")
    public Response eliminarPersona(@PathParam("idpersona") Long idpersona) {
        personaService.eliminarPersona(idpersona);
        return Response.ok("Persona eliminada").build();
    }

}
