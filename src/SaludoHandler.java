import javax.swing.*;
import java.util.ResourceBundle;

public class SaludoHandler {
    private ResourceBundle mensajes;

    public SaludoHandler(ResourceBundle mensajes) {
        this.mensajes = mensajes;
    }

    public void saludar(JFrame frame) {
        String nombre = JOptionPane.showInputDialog(frame, mensajes.getString("input.nombre"));
        if (nombre != null && !nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, mensajes.getString("mensaje.saludo") + " " + nombre + "!");
        } else {
            JOptionPane.showMessageDialog(frame, mensajes.getString("mensaje.invalido"));
        }
    }
}
