
package javaClass;

public class Estudiante {
    
    private short idEstudiante;
    private String rut;
    private String apellidoEstudiante;
    private String nombreEstudiante;
    private char genero;
    private String fono;
    private Curso curso;

    public Estudiante(short idEstudiante, String rut, String apellidoEstudiante, String nombreEstudiante, char genero, String fono, Curso curso) {
        this.idEstudiante = idEstudiante;
        this.rut = rut;
        this.apellidoEstudiante = apellidoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.genero = genero;
        this.fono = fono;
        this.curso = curso;
    }
    
    public Estudiante(){
        
    }
    
    public Estudiante(short idEstudiante){
        this.idEstudiante = idEstudiante;
    }

    public short getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(short idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
    
}
