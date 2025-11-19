package org.edwin.infraestructura.adaptador.salida.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.edwin.infraestructura.adaptador.salida.persistence.entity.PersonaEntity;

import java.util.List;

@ApplicationScoped
public class JpaPersonaRepository implements PanacheRepositoryBase<PersonaEntity, Long> {

    public List<PersonaEntity> BuscarPersonasPorSexo (String sexo) {
        return list("sexo = ?1",sexo);
    }
}
