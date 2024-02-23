package Utilities;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author KEVIN EP
 */
public class Controles {
    
    public static void solonumeros(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((!(Character.isDigit(c)) && (!(c == KeyEvent.VK_BACK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void solonumerosDecimales(KeyEvent evt) {
        if ((evt.getKeyChar() < 46) || (evt.getKeyChar() > 57)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void soloLetras(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((!(Character.isLetter(c)) && (!(c == KeyEvent.VK_BACK_SPACE)) && (!(c == KeyEvent.VK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void longitudTexto(KeyEvent evt, JTextField jTextField,int sizeText) {
        if (jTextField.getText().length() >= sizeText) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
     public static void cargarFormularios(JPanel contendedor, JPanel contenido, int anchoContenido, int altoContenido) {
        contenido.setSize(anchoContenido, altoContenido);
        contenido.setLocation(0, 0);
        contendedor.removeAll();
        contendedor.add(contenido, BorderLayout.CENTER);
        contendedor.revalidate();
        contendedor.repaint();
    }
}
