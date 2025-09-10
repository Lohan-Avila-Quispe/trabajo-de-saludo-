import javax.swing.*;
import java.awt.*;


public class VentanaBienvenida {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bienvenid@");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);


            // 🔹 Cargar ícono desde resources
            ImageIcon icono = new ImageIcon(
                    VentanaBienvenida.class.getResource("/resources/conejito.png")
            );
            frame.setIconImage(icono.getImage());


            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(Color.LIGHT_GRAY);


            JButton boton = new JButton("Mostrar saludo");
            boton.setBackground(new Color(100, 180, 255));
            boton.setFocusPainted(false);
            boton.setPreferredSize(new Dimension(160, 40));


            boton.addActionListener(e -> {
                String nombre = JOptionPane.showInputDialog(frame, "Escribe tu nombre:");
                if (nombre != null && !nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "¡Hola, " + nombre.trim() + "! ¡Buen trabajo!");
                } else if (nombre != null) {
                    JOptionPane.showMessageDialog(frame, "No ingresaste un nombre válido.");
                }
            });


            panel.add(boton);
            frame.setContentPane(panel);
            frame.setVisible(true);
        });
    }
}
