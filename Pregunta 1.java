import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carro {
    private String modelo;
    private String color;
    private boolean pinturaMetalizada;
    private String placa;
    private String tipoCarro;
    private int añoFabricacion;
    private String modalidadSeguro;

    // Constructor
    public Carro(String modelo, String color, boolean pinturaMetalizada, String placa,
                 String tipoCarro, int añoFabricacion, String modalidadSeguro) {
        this.modelo = modelo;
        this.color = color;
        this.pinturaMetalizada = pinturaMetalizada;
        this.placa = placa;
        this.tipoCarro = tipoCarro;
        this.añoFabricacion = añoFabricacion;
        this.modalidadSeguro = modalidadSeguro;
    }

    // Getters y setters (puedes generarlos automáticamente en muchos entornos de desarrollo)
    // ...

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", pinturaMetalizada=" + pinturaMetalizada +
                ", placa='" + placa + '\'' +
                ", tipoCarro='" + tipoCarro + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", modalidadSeguro='" + modalidadSeguro + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazCarro();
            }
        });
    }
}

class InterfazCarro extends JFrame {
    private JTextField modeloField;
    private JTextField colorField;
    private JTextField placaField;
    private JComboBox<String> tipoCarroComboBox;
    private JCheckBox pinturaMetalizadaCheckBox;
    private JTextField añoFabricacionField;
    private JRadioButton todoRiesgoRadioButton;
    private JRadioButton tercerosRadioButton;

    public InterfazCarro() {
        setTitle("Editar Carro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        modeloField = new JTextField();
        colorField = new JTextField();
        placaField = new JTextField();
        tipoCarroComboBox = new JComboBox<>(new String[]{"MINI", "UTILITARIO", "FAMILIAR", "DEPORTIVO"});
        pinturaMetalizadaCheckBox = new JCheckBox("Pintura Metalizada");
        añoFabricacionField = new JTextField();
        todoRiesgoRadioButton = new JRadioButton("A todo Riesgo");
        tercerosRadioButton = new JRadioButton("A terceros");

        ButtonGroup modalidadSeguroGroup = new ButtonGroup();
        modalidadSeguroGroup.add(todoRiesgoRadioButton);
        modalidadSeguroGroup.add(tercerosRadioButton);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        // Configurar el diseño
        setLayout(new GridLayout(9, 2));
        add(new JLabel("Modelo:"));
        add(modeloField);
        add(new JLabel("Color:"));
        add(colorField);
        add(new JLabel("Placa:"));
        add(placaField);
        add(new JLabel("Tipo de carro:"));
        add(tipoCarroComboBox);
        add(new JLabel("Tipo de pintura:"));
        add(pinturaMetalizadaCheckBox);
        add(new JLabel("Año de Fabricación:"));
        add(añoFabricacionField);
        add(new JLabel("Modalidad de Seguro:"));
        add(todoRiesgoRadioButton);
        add(new JLabel());
        add(tercerosRadioButton);
        add(new JLabel()); // Espacio en blanco
        add(guardarButton);

        setVisible(true);
    }

    private void guardarDatos() {
        String modelo = modeloField.getText();
        String color = colorField.getText();
        String placa = placaField.getText();
        String tipoCarro = (String) tipoCarroComboBox.getSelectedItem();
        boolean pinturaMetalizada = pinturaMetalizadaCheckBox.isSelected();
        int añoFabricacion = Integer.parseInt(añoFabricacionField.getText());
        String modalidadSeguro = todoRiesgoRadioButton.isSelected() ? "A todo Riesgo" : "A terceros";

        Carro carro = new Carro(modelo, color, pinturaMetalizada, placa, tipoCarro, añoFabricacion, modalidadSeguro);

        JOptionPane.showMessageDialog(this, "Datos del carro guardados:\n" + carro.toString());
    }
}
