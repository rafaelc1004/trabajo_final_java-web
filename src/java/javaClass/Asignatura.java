
package javaClass;

public class Asignatura {
    
    private short idAsignatura;
    private String nombreAsignatura;

    public Asignatura(short idAsignatura, String nombreAsignatura) {
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
    }

    public Asignatura(short idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Asignatura() {
    }

    
    
    public short getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(short idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
    
    
}
