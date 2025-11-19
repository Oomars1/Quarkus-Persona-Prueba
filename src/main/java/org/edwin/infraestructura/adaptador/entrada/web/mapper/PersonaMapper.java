package org.edwin.infraestructura.adaptador.entrada.web.mapper;

import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface PersonaMapper {

    PersonaEntity fromPersonaRequest(PersonaRequestDTO personaRequestDTO);

    PersonaResponseDTO toPersonaResponseDto(PersonaEntity persona);

    void updateEntityFromDTO(PersonaRequestDTO dto, @MappingTarget PersonaEntity persona);
}
