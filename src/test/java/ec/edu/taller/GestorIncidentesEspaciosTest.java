package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesEspaciosTest {

    @Test
    void consultarEspaciosDisponiblesDebeRetornarCapacidadRestante() {
        GestorIncidentes gestor = new GestorIncidentes(5);

        assertEquals(5, gestor.consultarEspaciosDisponibles());

        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Archivo infectado", "CRITICA"));

        assertEquals(3, gestor.consultarEspaciosDisponibles());
    }
}
