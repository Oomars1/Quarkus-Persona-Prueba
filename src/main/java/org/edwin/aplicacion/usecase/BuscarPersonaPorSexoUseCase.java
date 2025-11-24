package org.edwin.aplicacion.usecase;

import org.edwin.aplicacion.port.output.PersonaRepository;
import org.edwin.dominio.modelo.Persona;
import org.edwin.dominio.vo.Sexo;

import java.util.List;

public class BuscarPersonaPorSexoUseCase {

    private final PersonaRepository personaRepository;

    public BuscarPersonaPorSexoUseCase(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> ejecutar(String sexoString){
        Sexo sexo = Sexo.fromCodigo(sexoString);
        return personaRepository.buscarPersonaPorSexo(sexo);

    }
}
