package org.edwin.aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.edwin.dominio.repositorio.PersonaRepository;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;
import org.edwin.infraestructura.adaptador.salida.persistence.JpaPersonaRepository;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;

import java.util.List;

@ApplicationScoped
public class PersonaService {
    private final JpaPersonaRepository jpaPersonaRepository;
    private final PersonaMapper personaMapper;

    public PersonaService(JpaPersonaRepository jpaPersonaRepository, PersonaMapper personaMapper) {
        this.jpaPersonaRepository = jpaPersonaRepository;
        this.personaMapper = personaMapper;
    }

    public List<PersonaEntity> buscarTodasLasPersonas() {
        return jpaPersonaRepository.listAll();
    }

    public PersonaEntity buscarPorId(Long idpersona) {
        return jpaPersonaRepository.findByIdOptional(idpersona).orElseThrow(()->new NotFoundException("No se encontro el id "+idpersona));
    }

    @Transactional
    public void guardarPersona(PersonaEntity persona) {
        jpaPersonaRepository.persist(persona);
    }

    public List<PersonaEntity> buscarPersonasPorSexo(String sexo){
        List<PersonaEntity> listaPersonas = jpaPersonaRepository.BuscarPersonasPorSexo(sexo);
        if(listaPersonas.isEmpty()) throw new NotFoundException("No se encontraron personas");
        return listaPersonas;
    }

    @Transactional
    public PersonaEntity actualizarPersona(Long idpersona, PersonaRequestDTO personaRequestDTO) {
        PersonaEntity persona = jpaPersonaRepository.findByIdOptional(idpersona)
                .orElseThrow(() -> new NotFoundException("No se encontro la persona con id " + idpersona));

        personaMapper.updateEntityFromDTO(personaRequestDTO, persona);
        return persona;
    }

    @Transactional
    public void eliminarPersona(Long idpersona) {
        PersonaEntity persona = jpaPersonaRepository.findByIdOptional(idpersona).orElseThrow(()->new NotFoundException("No se encontro el id "+idpersona));
        jpaPersonaRepository.delete(persona);
    }
}
