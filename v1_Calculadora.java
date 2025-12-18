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

public class v1_Calculadora {
  static String messagePantalla = "";
  static int numeroInputOne;
  static int numeroInputTwo;
  static String operacion;

  public static void main(String[] args) {
    JFrame ventana = new JFrame("Mi Calculadora");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(400, 600);
    ventana.setLayout(new BorderLayout());
    ventana.setLocationRelativeTo(null);

    JLabel lblPantalla = new JLabel("", JLabel.CENTER);
    lblPantalla.setOpaque(true);
    lblPantalla.setBackground(Color.LIGHT_GRAY);
    lblPantalla.setPreferredSize(new Dimension(0, 100));
    lblPantalla.setFont(new Font("Arial", Font.BOLD, 20));

    JPanel panel = new JPanel();
    panel.setBackground(Color.BLUE);
    panel.setLayout(new GridLayout(6, 3));

    JButton[] arrayBtnNumeros = new JButton[10];

    // Creando botones para el panel
    for (int i = 9; i >= 0; i--) {
      arrayBtnNumeros[i] = new JButton(Integer.toString(i));
      panel.add(arrayBtnNumeros[i]);

      final String num = Integer.toString(i);

      arrayBtnNumeros[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          messagePantalla += num;
          lblPantalla.setText(messagePantalla);
        }
      });
    }

    JButton btnSumar = new JButton("+");
    JButton btnRestar = new JButton("-");
    JButton btnMultiplicar = new JButton("x");
    JButton btnDividir = new JButton("÷");
    JButton btnBorrarC = new JButton("C");
    JButton btnBorrarAC = new JButton("AC");
    JButton btnIgual = new JButton("=");
    JButton btnPunto = new JButton(".");

    panel.add(btnSumar);
    panel.add(btnRestar);
    panel.add(btnMultiplicar);
    panel.add(btnDividir);
    panel.add(btnBorrarC);
    panel.add(btnBorrarAC);
    panel.add(btnIgual);
    panel.add(btnPunto);

    // Logica de agregar texto de los botones no numerales

    btnBorrarC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        messagePantalla = "0";
        lblPantalla.setText(messagePantalla);
      }
    });

    btnSumar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        numeroInputOne = Integer.parseInt(messagePantalla);
        operacion = "suma";
        messagePantalla = "";
      }
    });

    btnIgual.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        numeroInputTwo = Integer.parseInt(messagePantalla);
        if (operacion.equals("suma")) {
          messagePantalla = Integer.toString(numeroInputOne + numeroInputTwo);
          lblPantalla.setText(messagePantalla);
          // int respuesta = numeroInputOne + numeroInputTwo;
          // numeroInputOne = respuesta;
          // lblPantalla.setText(Integer.toString(respuesta));

        }
      }
    });

    ventana.add(lblPantalla, BorderLayout.NORTH);
    ventana.add(panel, BorderLayout.CENTER);

    ventana.setVisible(true);

  }
}
