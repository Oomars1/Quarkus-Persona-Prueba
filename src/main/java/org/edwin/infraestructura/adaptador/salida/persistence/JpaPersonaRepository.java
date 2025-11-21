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
public class JpaPersonaRepository implements PersonaRepository, PanacheRepositoryBase<PersonaEntity, Long> { // ← EXTENDIENDO PanacheRepositoryBase
    //este es el traductor entre la capa de dominio y la capa de persistencia
    private final PersonaMapper mapper;

    public JpaPersonaRepository(PersonaMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Persona guardar(Persona persona) {
        if (persona.getId() == null) {
            // CREAR NUEVO
            PersonaEntity entity = mapper.toEntity(persona);
            entity.persistAndFlush();
            return mapper.toDomain(entity);
        } else {
            // ACTUALIZAR EXISTENTE
            PersonaEntity entity = findByIdOptional(persona.getId())   // ← Usa findByIdOptional
                    .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException(
                            "Persona no encontrada con id: " + persona.getId()));

            mapper.updateEntityFromDomain(persona, entity);
            flush();  // método del repository
            return mapper.toDomain(entity);
        }
    }

    @Override
    public Optional<Persona> porId(Long id) {
        return findByIdOptional(id)
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
    public void eliminarPorId(Long id) {
        deleteById(id);
    }
}