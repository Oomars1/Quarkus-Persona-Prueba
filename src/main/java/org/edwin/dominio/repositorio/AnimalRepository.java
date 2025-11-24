package org.edwin.dominio.repositorio;

import org.edwin.dominio.modelo.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal guardar(Animal animal);
    Optional<Animal> porId(Long id);
    List<Animal> todos();
    void eliminarPorId(Long id);
}
