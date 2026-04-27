package ec.edu.taller;

public class IncidenteSeguridad {

    private String codigo;
    private String tipo;
    private String descripcion;
    private String prioridad;
    private String estado;

    public IncidenteSeguridad(String codigo, String tipo, String descripcion, String prioridad) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = "";
    }

    
    @Override
    public String toString() {
        return codigo + " | " + tipo + " | " + prioridad + " | " + estado;
    }
}
