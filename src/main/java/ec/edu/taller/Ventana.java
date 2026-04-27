import ec.edu.taller.GestorIncidentes;
import ec.edu.taller.IncidenteSeguridad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox<Integer> cmbPrioridad;
    private JButton btnRegistrar;
    private JButton btnAtender;
    private JButton btnVer;
    private JButton btnListar;
    private JTextArea txtListar;
    public int capacidadMAxima;

    private GestorIncidentes sistema;

    public Ventana() {
        sistema = new GestorIncidentes(capacidadMAxima);

        cmbPrioridad.addItem(1);
        cmbPrioridad.addItem(2);
        cmbPrioridad.addItem(3);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                int prioridad = (int) cmbPrioridad.getSelectedItem();

                if (sistema.registrarIncidente(new IncidenteSeguridad())) {
                    JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.");
                    limpiarCampos();
                    txtListar.setText(sistema.listarIncidentes().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Datos inválidos, código duplicado o cupo lleno.");
                }
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = sistema.atenderSiguienteIncidente().toString();
                if (resultado.equals("No hay pacientes")) {
                    JOptionPane.showMessageDialog(null, resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Atendiendo a: " + resultado);
                }
                txtListar.setText(sistema.listarIncidentes().toString());
            }
        });

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("Siguiente en espera: " + sistema.verSiguientePaciente());
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(sistema.mostrarColaPrioridad());
            }
        });
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        cmbPrioridad.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Triaje Médico");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}