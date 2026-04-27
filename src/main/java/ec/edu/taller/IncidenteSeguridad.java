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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + " | " + tipo + " | " + prioridad + " | " + estado;
    }
}
