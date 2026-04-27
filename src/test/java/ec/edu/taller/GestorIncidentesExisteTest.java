package ec.edu.taller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesExisteTest {

    @Test
    void existeIncidenteDebeRetornarTrueSiCodigoExiste() {
        GestorIncidentes gestor = new GestorIncidentes(3);
        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));

        assertTrue(gestor.existeIncidente("INC-001"));
    }

    @Test
    void existeIncidenteDebeRetornarFalseSiCodigoNoExiste() {
        GestorIncidentes gestor = new GestorIncidentes(3);
        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));

        assertFalse(gestor.existeIncidente("INC-999"));
    }

    @Test
    void existeIncidenteDebeRetornarFalseConCodigoNullOVacio() {
        GestorIncidentes gestor = new GestorIncidentes(3);

        assertFalse(gestor.existeIncidente(null));
        assertFalse(gestor.existeIncidente(""));
        assertFalse(gestor.existeIncidente("   "));
    }

    @Test
    void registrarDuplicadoDebeRetornarFalse() {
        GestorIncidentes gestor = new GestorIncidentes(3);

        assertTrue(gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA")));
        assertFalse(gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "MALWARE", "Virus", "CRITICA")));
        assertEquals(1, gestor.contarIncidentesPendientes());
    }
}
