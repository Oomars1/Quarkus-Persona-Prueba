package org.edwin.infraestructura.adaptador.entrada.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "La edad no puede estar vacio")
    @Min(value = 0, message = "La edad debe ser mayor a 0")
    @Max(value=120, message = "La edad debe ser menor a 120")
    private int edad;

    @NotBlank(message = "El sexo es obligatorio")
    @Pattern(regexp = "^(M|F)$", message = "El sexo debe ser 'M' (Masculino) o 'F' (Femenino)")
    private String sexo;
}
