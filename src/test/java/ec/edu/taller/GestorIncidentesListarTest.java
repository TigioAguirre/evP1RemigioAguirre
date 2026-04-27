package ec.edu.taller;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestorIncidentesListarTest {

    @Test
    void listarIncidentesDebeMantenerOrdenFIFOSinModificarCola() {
        GestorIncidentes gestor = new GestorIncidentes(5);
        gestor.registrarIncidente(new IncidenteSeguridad("INC-001", "PHISHING", "Correo falso", "ALTA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-002", "MALWARE", "Archivo infectado", "CRITICA"));
        gestor.registrarIncidente(new IncidenteSeguridad("INC-003", "FUGA_DATOS", "Datos expuestos", "CRITICA"));

        List<IncidenteSeguridad> incidentes = gestor.listarIncidentes();

        assertEquals(3, incidentes.size());
        assertEquals("INC-001", incidentes.get(0).getCodigo());
        assertEquals("INC-002", incidentes.get(1).getCodigo());
        assertEquals("INC-003", incidentes.get(2).getCodigo());

        assertEquals(3, gestor.contarIncidentesPendientes());
        assertEquals("INC-001", gestor.consultarSiguienteIncidente().getCodigo());
    }
}
