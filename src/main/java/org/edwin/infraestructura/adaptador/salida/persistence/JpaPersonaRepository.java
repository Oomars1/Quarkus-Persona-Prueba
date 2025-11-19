package org.edwin.infraestructura.adaptador.salida.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.repositorio.PersonaRepository;
import org.edwin.infraestructura.adaptador.entrada.web.mapper.PersonaMapper;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JpaPersonaRepository implements PersonaRepository, PanacheRepositoryBase<PersonaEntity, Long> {

    private final PersonaMapper mapper;

    public JpaPersonaRepository(PersonaMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void guardar(Persona persona) {
        if (persona.getId() == null) {
            mapper.toEntity(persona).persist();
        } else {
            PersonaEntity entity = PersonaEntity.findById(persona.getId());
            if (entity != null) {
                mapper.updateEntityFromDomain(persona, entity);
            }
        }
    }

    @Override
    public Optional<Persona> porId(Long id) {
        return PersonaEntity.<PersonaEntity>findByIdOptional(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Persona> todas() {
        return listAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Persona> porSexo(String sexo) {
        return list("sexo", sexo).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        PersonaEntity.deleteById(id);
    }
}