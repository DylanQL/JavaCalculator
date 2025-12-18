import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculadora {

  static JLabel lblPantalla = new JLabel("0", JLabel.CENTER);
  static String memoriaPantalla = "";

  public static void main(String[] args) {

    // Creando ventana principal de la aplicación
    JFrame ventana = new JFrame("Mi Calculadora");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null);
    ventana.setSize(300, 400);
    ventana.setLayout(new BorderLayout());

    // Creando label que se usara como pantall de la Calculadora
    lblPantalla.setOpaque(true);
    lblPantalla.setBackground(Color.LIGHT_GRAY);
    lblPantalla.setPreferredSize(new Dimension(0, 100));
    lblPantalla.setFont(new Font("Arial", Font.BOLD, 20));

    // Creando panel donde iran los botones de la Calculadora
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 4, 5, 5));

    // Creando array de botones para la Calculadora
    JButton[] arrayButtons = new JButton[20];
    arrayButtons[0] = new JButton("AC");
    arrayButtons[1] = new JButton("C");
    arrayButtons[2] = new JButton("√");
    arrayButtons[3] = new JButton("%");
    arrayButtons[4] = new JButton("7");
    arrayButtons[5] = new JButton("8");
    arrayButtons[6] = new JButton("9");
    arrayButtons[7] = new JButton("÷");
    arrayButtons[8] = new JButton("4");
    arrayButtons[9] = new JButton("5");
    arrayButtons[10] = new JButton("6");
    arrayButtons[11] = new JButton("x");
    arrayButtons[12] = new JButton("1");
    arrayButtons[13] = new JButton("2");
    arrayButtons[14] = new JButton("3");
    arrayButtons[15] = new JButton("-");
    arrayButtons[16] = new JButton("0");
    arrayButtons[17] = new JButton(".");
    arrayButtons[18] = new JButton("=");
    arrayButtons[19] = new JButton("+");

    // Añadiendo color a algunos botones del arrayButtons
    arrayButtons[0].setBackground(Color.RED);
    arrayButtons[1].setBackground(Color.RED);

    // Añadiendo color de fondo negro con letras blancas los otros de simbolos
    int[] arraySimbolosBtn = { 2, 3, 7, 11, 15, 17, 18, 19 };
    for (int i : arraySimbolosBtn) {
      arrayButtons[i].setBackground(Color.BLACK);
      arrayButtons[i].setForeground(Color.WHITE);
    }

    // Añadiendo los botones del array al panel
    int[] arrayNumerosBtn = { 4, 5, 6, 8, 9, 10, 12, 13, 14, 16, 17 };
    for (int i = 0; i < arrayButtons.length; i++) {
      arrayButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
      arrayButtons[i].setFocusPainted(false);
      panel.add(arrayButtons[i]);
    }

    // Añadiendo interactividad a los botones numerales
    for (int i : arrayNumerosBtn) {
      arrayButtons[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          memoriaPantalla += arrayButtons[i].getText();
          lblPantalla.setText(memoriaPantalla);
        }
      });
    }

    // Añadiendo interactividad en el boton C
    arrayButtons[1].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        restablecerMemoriaPantalla();
        restablecerLabelPantalla();
      }
    });

    // Añadiendo elementos a la ventana principal
    ventana.add(panel, BorderLayout.CENTER);
    ventana.add(lblPantalla, BorderLayout.NORTH);
    ventana.setVisible(true);
  }

  public static int capturarNumeroPantalla() {
    int numero = Integer.parseInt(lblPantalla.getText());
    return numero;
  }

  public static void restablecerLabelPantalla() {
    lblPantalla.setText("0");
  }

  public static void restablecerMemoriaPantalla() {
    memoriaPantalla = "";
  }
}
