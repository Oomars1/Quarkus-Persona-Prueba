package org.edwin.infraestructura.adaptador.entrada.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;
}
