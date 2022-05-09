
package javaClass;

public class Curso {
    
    private short idCurso;
    private String nombreCurso;

    public Curso(short idCurso, String nombreCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
    }

    public short getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(short idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    
    
}
