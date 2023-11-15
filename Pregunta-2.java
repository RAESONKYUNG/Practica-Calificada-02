import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal();
            }
        });
    }
}

class MenuPrincipal extends JFrame {
    private JDesktopPane desktopPane;

    public MenuPrincipal() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuCarros = new JMenu("Carros");
        menuBar.add(menuCarros);

        JMenuItem itemRegistrarCarro = new JMenuItem("Registrar Carro");
        itemRegistrarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioRegistrarCarro();
            }
        });
        menuCarros.add(itemRegistrarCarro);

        JMenuItem itemListarCarros = new JMenuItem("Listar Carros");
        itemListarCarros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioListarCarros();
            }
        });
        menuCarros.add(itemListarCarros);

        setVisible(true);
    }

    private void abrirFormularioRegistrarCarro() {
        FormularioRegistrarCarro formulario = new FormularioRegistrarCarro();
        desktopPane.add(formulario);
        formulario.setVisible(true);
    }

    private void abrirFormularioListarCarros() {
        FormularioListarCarros formulario = new FormularioListarCarros();
        desktopPane.add(formulario);
        formulario.setVisible(true);
    }
}

class FormularioRegistrarCarro extends JInternalFrame {
    // Aquí colocarías el código para el formulario de registrar carro
}

class FormularioListarCarros extends JInternalFrame {
    // Aquí colocarías el código para el formulario de listar carros
}
