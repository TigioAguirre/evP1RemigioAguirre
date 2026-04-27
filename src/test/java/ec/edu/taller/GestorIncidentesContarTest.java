package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesContarTest {

    @Test
    void contarIncidentesPendientesDebeRetornarCantidadCorrecta() {
        GestorIncidentes gestor = new GestorIncidentes(5);

        assertEquals(0, gestor.contarIncidentesPendientes());

        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Archivo infectado", "CRITICA"));

        assertEquals(2, gestor.contarIncidentesPendientes());
    }
}
