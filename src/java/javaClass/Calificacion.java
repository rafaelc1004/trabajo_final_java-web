
package javaClass;

public class Calificacion {

    private short numCalificacion;
    private double nota;
    private Asignatura asignatura;
    private Estudiante estudiante;

    public Calificacion(short numCalificacion, double nota, Asignatura asignatura, Estudiante estudiante) {

        this.numCalificacion = numCalificacion;
        this.nota = nota;
        this.asignatura = asignatura;
        this.estudiante = estudiante;
    }

    public Calificacion() {
    }

    public short getNumCalificacion() {
        return numCalificacion;
    }

    public void setNumCalificacion(short numCalificacion) {
        this.numCalificacion = numCalificacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}