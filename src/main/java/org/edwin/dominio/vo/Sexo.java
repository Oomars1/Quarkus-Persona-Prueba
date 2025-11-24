package org.edwin.dominio.vo;

public enum Sexo {
    MASCULINO("M","Masculino"),
    FEMENINO("F","Femenino");

    private final String codigo;
    private final String descripcion;

    Sexo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Sexo fromCodigo(String codigo) {
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("El código de sexo no puede ser nulo");
        }
        for (Sexo sexo : Sexo.values()) {
            if (sexo.codigo.equalsIgnoreCase(codigo.trim())) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Sexo no válido: " + codigo + ". Valores permitidos: M, F");
    }

}
