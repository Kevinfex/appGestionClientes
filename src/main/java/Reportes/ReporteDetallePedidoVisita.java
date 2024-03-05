/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Reportes;

import TransferObject.VisitaPedidoDTO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class ReporteDetallePedidoVisita extends javax.swing.JPanel {
DefaultTableModel modelo;
    /**
     * Creates new form NewJPanel
     */
    public ReporteDetallePedidoVisita() {
        initComponents();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        
        panel.add(new JButton("Button in the center"));
        panel.add(tabla());

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JScrollPane tabla() {
        JScrollPane scrollPane = null;
        try {
            plReporteTablaVisita rtv = new plReporteTablaVisita();
            
            String[] columnNames = {"ID", "First Name", "Last Name", "f"};
            modelo = new DefaultTableModel(columnNames, 0);
            
            JTable table = new JTable(modelo);
            
            for (VisitaPedidoDTO p : rtv.listaVisitasPedidos) {
                Object[] dato = new Object[4];
                dato[0] = p.getProducto();
                dato[1] = p.getPrecio().toString();
                dato[2] = p.getCantidad().toString();
                dato[3] = p.getImporte().toString();
                modelo.addRow(dato);
                
                
            }
            
            scrollPane = new JScrollPane(table);
            
            
            

            
        } catch (Exception ex) {

        }
        return scrollPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}