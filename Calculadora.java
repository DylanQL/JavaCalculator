import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculadora {

  public static void main(String[] args) {

    // Creando ventana principal de la aplicación
    JFrame ventana = new JFrame("Mi Calculadora");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null);
    ventana.setSize(400, 600);
    ventana.setLayout(new BorderLayout());

    // Creando label que se usara como pantall de la Calculadora
    JLabel lblPantalla = new JLabel("", JLabel.CENTER);
    lblPantalla.setOpaque(true);
    lblPantalla.setBackground(Color.LIGHT_GRAY);
    lblPantalla.setPreferredSize(new Dimension(0, 100));
    lblPantalla.setFont(new Font("Arial", Font.BOLD, 20));

    // Creando panel donde iran los botones de la Calculadora
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 4, 5, 5));

    // Añadiendo elementos a la ventana principal
    ventana.add(panel, BorderLayout.SOUTH);
    ventana.add(lblPantalla, BorderLayout.NORTH);
    ventana.setVisible(true);
  }
}
