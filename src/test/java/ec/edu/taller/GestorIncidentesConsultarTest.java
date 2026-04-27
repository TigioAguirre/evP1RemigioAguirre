package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesConsultarTest {

    @Test
    void consultarSiguienteDebeRetornarPrimeroSinEliminar() {
        GestorIncidentes gestor = new GestorIncidentes(5);
        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Archivo infectado", "CRITICA"));

        IncidenteSeguridad siguiente = gestor.consultarSiguienteIncidente();

        assertNotNull(siguiente);
        assertEquals("INC-001", siguiente.getCodigo());
        assertEquals(2, gestor.contarIncidentesPendientes());
    }

    @Test
    void consultarSiguienteConColaVaciaDebeRetornarNull() {
        GestorIncidentes gestor = new GestorIncidentes(5);

        assertNull(gestor.consultarSiguienteIncidente());
    }
}
