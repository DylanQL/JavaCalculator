import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Calculadora {

  public static void main(String[] args) {

    // Creando ventana principal de la aplicación
    JFrame ventana = new JFrame("Mi Calculadora");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null);
    ventana.setSize(400, 600);
    ventana.setLayout(new BorderLayout());

    ventana.setVisible(true);
  }
}
