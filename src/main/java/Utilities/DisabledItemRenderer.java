package Utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author KEVIN EP
 */
public class DisabledItemRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (index == 0) {
            setForeground(Color.GRAY); // Cambiar el color del texto del primer ítem a gris
            setEnabled(false); // Deshabilitar el primer ítem
        }
        return this;
    }
}
