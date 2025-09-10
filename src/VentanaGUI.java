import javax.swing.*;
import java.awt.*;
import java.util.Locale;


public class VentanaGUI extends JFrame {


    private String tituloVentana;
    private String textoBoton;
    private String mensajeInput;
    private String mensajeExito;
    private String mensajeError;


    public VentanaGUI() {
        // Configurar idioma según sistema
        configurarTextos(Locale.getDefault());


        setTitle(tituloVentana);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // 🔹 Cargar ícono desde resources
        ImageIcon icono = new ImageIcon(getClass().getResource("/resources/conejito.png"));
        setIconImage(icono.getImage());


        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY);


        // Botón
        JButton boton = new JButton(textoBoton);
        boton.setBackground(new Color(100, 180, 255));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(160, 40));


        boton.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, mensajeInput);
            if (nombre != null && !nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        String.format(mensajeExito, nombre.trim()));
            } else if (nombre != null) {
                JOptionPane.showMessageDialog(this, mensajeError);
            }
        });


        panel.add(boton);
        setContentPane(panel);
        setVisible(true);
    }


    // Método para configurar los textos según el idioma
    private void configurarTextos(Locale locale) {
        if (locale.getLanguage().equals("es")) {
            tituloVentana = "Bienvenid@";
            textoBoton = "Mostrar saludo";
            mensajeInput = "Escribe tu nombre:";
            mensajeExito = "¡Hola, %s! ¡Buen trabajo!";
            mensajeError = "No ingresaste un nombre válido.";
        } else {
            tituloVentana = "Welcome";
            textoBoton = "Show greeting";
            mensajeInput = "Enter your name:";
            mensajeExito = "Hello, %s! Good job!";
            mensajeError = "You did not enter a valid name.";
        }
    }
}

