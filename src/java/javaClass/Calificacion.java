
package javaClass;

public class Calificacion {
    
    
    private Estudiante estudiante;
    private Asignatura asignatura;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;
    private double promedio;
    

    public Calificacion(Estudiante estudiante, Asignatura asignatura, double nota1, double nota2, double nota3, double nota4, double nota5, double promedio) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;
        this.promedio = promedio;
        
    }

    public Calificacion(Estudiante estudiante, Asignatura asignatura) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }
    
    public Calificacion(Estudiante estudiante, Asignatura asignatura, double nota1, double nota2, double nota3, double nota4, double nota5) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;        
    }
    
    public Calificacion(){
        
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    

    

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNota5() {
        return nota5;
    }

    public void setNota5(double nota5) {
        this.nota5 = nota5;
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