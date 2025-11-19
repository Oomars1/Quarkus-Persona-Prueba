package org.edwin.infraestructura.adaptador.entrada.web.mapper;

import org.edwin.dominio.modelo.Persona;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface PersonaMapper {

    @Mapping(target = "id", ignore = true)
    PersonaEntity toEntity(PersonaRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    PersonaEntity toEntity(Persona persona);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDomain(Persona persona, @MappingTarget PersonaEntity entity);

    Persona toDomain(PersonaEntity entity);  // MapStruct lo hace automático

    @Mapping(target = "id", source = "id")   // ← ahora id es Long directamente
    PersonaResponseDTO toResponseDto(Persona persona);
}
