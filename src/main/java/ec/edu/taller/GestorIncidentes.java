package ec.edu.taller;

import java.util.*;

public class GestorIncidentes {

    private Queue<IncidenteSeguridad> colaIncidentes;
    private int capacidadMaxima;

    public GestorIncidentes(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.colaIncidentes = new LinkedList<>();
    }

    public boolean registrarIncidente(IncidenteSeguridad incidente) {

        if (incidente == null || incidente.getCodigo() == null || incidente.getCodigo().trim().isEmpty()) {
            return false;
        }

        if (colaIncidentes.size() >= capacidadMaxima) {
            return false;
        }

        for (IncidenteSeguridad i : colaIncidentes) {
            if (i.getCodigo().trim().equals(incidente.getCodigo().trim())) {
                return false;
            }
        }

        colaIncidentes.add(incidente);
        return true;
    }

    public boolean existeIncidente(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }

        for (IncidenteSeguridad p : colaIncidentes) {
            if (p.getCodigo().trim().equals(codigo.trim())) {
                return true;
            }
        }
        return false;
    }

    public IncidenteSeguridad consultarSiguienteIncidente() {
        return colaIncidentes.peek(); // no elimina
    }

    public IncidenteSeguridad atenderSiguienteIncidente() {
        IncidenteSeguridad incidente = colaIncidentes.poll(); // elimina el primero
        if (incidente != null) {
            incidente.setEstado("ATENDIDO"); // depende de tu clase
        }
        return incidente;
    }

    public int contarIncidentesPendientes() {
        return colaIncidentes.size();
    }

    public int consultarEspaciosDisponibles() {
        return capacidadMaxima - colaIncidentes.size();
    }

    public List<IncidenteSeguridad> listarIncidentes() {
        return new ArrayList<>(colaIncidentes); // copia segura
    }
}
