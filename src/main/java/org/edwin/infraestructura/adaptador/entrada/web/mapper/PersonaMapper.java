package org.edwin.infraestructura.adaptador.entrada.web.mapper;

import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.vo.Sexo;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaRequestDTO;
import org.edwin.infraestructura.adaptador.entrada.web.dto.PersonaResponseDTO;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "cdi")
public interface PersonaMapper { // Mapper de MapStruct

    @Mapping(target = "sexo", source= "sexo", qualifiedByName = "stringToSexo") // mapeo exp
    Persona toPersonaDomain(PersonaRequestDTO dto);

        @Mapping(target = "sexo", source= "sexo", qualifiedByName = "sexoToString") // mapeo exp
    PersonaResponseDTO toDtoResponde(Persona persona);

    @Named("stringToSexo")
    default Sexo stringToSexo(String codigo) {
        if (codigo == null) {
            return null;
        }
        return Sexo.fromCodigo(codigo);
    }

    @Named("sexoToString")
    default Sexo stringToSexo(Sexo sexo) {
        if (sexo == null) {
            return null;
        }
        return sexo.getCodigo();
    }
}
