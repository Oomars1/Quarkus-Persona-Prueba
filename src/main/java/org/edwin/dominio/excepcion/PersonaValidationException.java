package org.edwin.dominio.excepcion;

public class PersonaValidationException extends RuntimeException{
    public PersonaValidationException(String message) {
        super(message);
    }
}
