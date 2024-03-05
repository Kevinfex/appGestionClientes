/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Reportes;

import BusinessObject.Cliente;
import BusinessObject.Visita;
import BusinessObject.VisitaPedido;
import Reportes.Designs.VisitaPDF;
import Reportes.Designs.VisitaPedidoPDF;
import static Reportes.plReporteTablaVisita.tbReporteVisitas;
import Reportes.plReporteVisitas.BotonRenderer;
import TransferObject.ClienteDTO;
import TransferObject.VisitaDTO;
import TransferObject.VisitaPedidoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Bryam
 */
public class plReporteVisitas extends javax.swing.JPanel {

    DefaultTableModel modelo;
    VisitaDTO visitaDTO;
    String personajuridica;
    Visita visita;
    String codvisita;
    String empleado;
    String cliente;
    String fecha;
    String venta;
    VisitaPedidoDTO visitaPedidoDTO;
    VisitaPedido visitaPedido;
    
    public static JPanel panel;
    public static JButton btnVer;
    public static List<VisitaPedidoDTO> listaVisitasPedidos;

    /**
     * Creates new form plReporteClientes
     */
    public plReporteVisitas() {
        initComponents();
        modelo = new DefaultTableModel();
        visitaDTO = new VisitaDTO();
        visita = new Visita();
        visitaPedidoDTO = new VisitaPedidoDTO();
        visitaPedido = new VisitaPedido();
    }

    public void cargarVisitas() {

        try {
            
            plReporteTablaVisita.tbReporteVisitas.setDefaultRenderer(Object.class, new BotonRenderer());
            btnVer = new JButton("VER");
            btnVer.setName("Ver");
            
            
            
            modelo = (DefaultTableModel) plReporteTablaVisita.tbReporteVisitas.getModel();
            //tbReporteVisitas.getColumn("Ver").setCellRenderer(new ButtonRenderer());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            //plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
            Object[] ob = new Object[6];
            for (VisitaDTO p : visita.listarVisita()) {
                ob[0] = p.getCodVisita();
                ob[1] = p.getCodempleado();
                ob[2] = p.getCodcliente();
                ob[3] = dateFormat.format(p.getFechavisita());
                ob[4] = p.getVenta();
                ob[5] = btnVer;
                //plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
                modelo.addRow(ob);
            }
            String obtener = ob[5].toString();
            
            
            
            //panel = new JPanel();
        
            //panel.add(new JButton("Button in the center"));
            
            //plReporteTablaVisita.tbReporteVisitas.getColumn("VER").setCellRenderer(new ButtonRenderer());

        } catch (Exception ex) {

        }

    }

    class BotonRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JButton) {
                JButton btn = (JButton)value;
                
                return btn;
            }
            //tbReporteVisitas.clearSelection();
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
        }
    }

    

    public void medidaColumnasTabla() {
        //Medida de 996
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(0).setPreferredWidth(60);
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(1).setPreferredWidth(215);//
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(2).setPreferredWidth(215);//
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(3).setPreferredWidth(215);//
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(4).setPreferredWidth(215);//
        plReporteTablaVisita.tbReporteVisitas.getColumnModel().getColumn(5).setPreferredWidth(100);//
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngTipoCliente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbtnVisitas = new javax.swing.JRadioButton();
        btnMostrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnVerDetalle = new javax.swing.JButton();
        plContenedorReporteVisita = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 176, 212), 2, true)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 176, 212), 2, true), "VISITAS"));

        btngTipoCliente.add(rbtnVisitas);
        rbtnVisitas.setText("Visitas");
        rbtnVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVisitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnVisitas)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnVisitas)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMostrar.setText("MOSTRAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnVerDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerDetalle.setText("VER DETALLE");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btnMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addGap(165, 165, 165)
                .addComponent(btnVerDetalle)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        plContenedorReporteVisita.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 176, 212), 2, true)));

        javax.swing.GroupLayout plContenedorReporteVisitaLayout = new javax.swing.GroupLayout(plContenedorReporteVisita);
        plContenedorReporteVisita.setLayout(plContenedorReporteVisitaLayout);
        plContenedorReporteVisitaLayout.setHorizontalGroup(
            plContenedorReporteVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        plContenedorReporteVisitaLayout.setVerticalGroup(
            plContenedorReporteVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plContenedorReporteVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plContenedorReporteVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        plReporteTablaVisita pReporteVisita = new plReporteTablaVisita();
        pReporteVisita.setSize(1020, 549);
        pReporteVisita.setLocation(0, 0);
        plContenedorReporteVisita.removeAll();
        plContenedorReporteVisita.add(pReporteVisita, BorderLayout.CENTER);
        plContenedorReporteVisita.revalidate();
        plContenedorReporteVisita.repaint();

        if (plReporteVisitas.rbtnVisitas.isSelected()) {
            medidaColumnasTabla();
            cargarVisitas();
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void rbtnVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVisitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVisitasActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        VisitaPDF pdf = new VisitaPDF();
        pdf.generarBoletaPDF();
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        // TODO add your handling code here:
        
        
            
            
            
        
        
        
        /*for (int i=0; i <= tbReporteVisitas.getRowCount()-1; i++) {
            codvisita = (tbReporteVisitas.getValueAt(i, 0).toString());
            listaVisitasPedidos = visitaPedido.buscarVisitaPedido(Integer.parseInt(codvisita));
        }*/
        
    }//GEN-LAST:event_btnVerDetalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.ButtonGroup btngTipoCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel plContenedorReporteVisita;
    public static javax.swing.JRadioButton rbtnVisitas;
    // End of variables declaration//GEN-END:variables
}
