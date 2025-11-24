package org.edwin.dominio.modelo;


import org.edwin.dominio.vo.Sexo;

/*
    * No hay ninguna importación de frameworks de infraestructura como jakarta.persistence.*(JPA),
    * io.quarkus.*, o clases específicas de Panache.
    * Esto asegura que el Dominio es agnóstico a la tecnología.
 */

public class Persona { //Entidad de dominio puro
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Sexo sexo;

    public Persona(){

    }

    public Persona(String nombre, String apellido, Integer edad, Sexo sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(Long id, String nombre, String apellido, Integer edad, Sexo sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }
    public void validar(){
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if(nombre.length() < 2){
            throw new IllegalArgumentException("El nombre no puede tener más de 50 caracteres");
        }
        if(apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
        }
        if(apellido.length() < 2) {
            throw new IllegalArgumentException("El apellido no puede tener más de 50 caracteres");
        }
        if(edad == null || edad < 0){
            throw new IllegalArgumentException("La edad no puede ser nula o negativa");
        }
        if(sexo == null ){
            throw new IllegalArgumentException("El sexo no puede ser nulo o vacío");
        }
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void actualizar(String nombre,String apellido, Integer edad, Sexo sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }
}