package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesRegistrarTest {

    @Test
    void registrarIncidenteValidoDebeRetornarTrue() {
        GestorIncidentes gestor = new GestorIncidentes(3);
        IncidenteSeguridad incidente = new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA");

        assertTrue(gestor.registrarIncidente(incidente));
        assertEquals(1, gestor.contarIncidentesPendientes());
    }

    @Test
    void registrarIncidenteNullDebeRetornarFalse() {
        GestorIncidentes gestor = new GestorIncidentes(3);

        assertFalse(gestor.registrarIncidente(null));
        assertEquals(0, gestor.contarIncidentesPendientes());
    }

    @Test
    void registrarIncidenteConCodigoVacioDebeRetornarFalse() {
        GestorIncidentes gestor = new GestorIncidentes(3);
        IncidenteSeguridad incidente = new IncidenteSeguridad("   ", "MALWARE", "Archivo infectado", "MEDIA");

        assertFalse(gestor.registrarIncidente(incidente));
        assertEquals(0, gestor.contarIncidentesPendientes());
    }

    @Test
    void registrarIncidenteCuandoColaLlenaDebeRetornarFalse() {
        GestorIncidentes gestor = new GestorIncidentes(1);

        assertTrue(gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA")));
        assertFalse(gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Virus", "CRITICA")));
        assertEquals(1, gestor.contarIncidentesPendientes());
    }
}
