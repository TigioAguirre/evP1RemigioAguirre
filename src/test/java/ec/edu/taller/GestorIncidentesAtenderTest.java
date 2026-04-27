package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesAtenderTest {

    @Test
    void atenderSiguienteDebeRespetarOrdenFIFO() {
        GestorIncidentes gestor = new GestorIncidentes(5);
        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Archivo infectado", "CRITICA"));

        IncidenteSeguridad atendido = gestor.atenderSiguienteIncidente();

        assertNotNull(atendido);
        assertEquals("INC-001", atendido.getCodigo());
        assertEquals("ATENDIDO", atendido.getEstado());
        assertEquals(1, gestor.contarIncidentesPendientes());
        assertEquals("INC-002", gestor.consultarSiguienteIncidente().getCodigo());
    }

    @Test
    void atenderSiguienteConColaVaciaDebeRetornarNull() {
        GestorIncidentes gestor = new GestorIncidentes(5);

        assertNull(gestor.atenderSiguienteIncidente());
    }
}
