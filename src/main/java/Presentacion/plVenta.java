/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import BusinessObject.Cliente;
import TransferObject.ClienteDTO;
import TransferObject.EmpleadoDTO;
import TransferObject.RolUsuarioDTO;
import TransferObject.UsuarioDTO;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryam
 */
public class plVenta extends javax.swing.JPanel {
   private EmpleadoDTO dtoEmpleado;
    private UsuarioDTO dtoUsuario;
    private RolUsuarioDTO dtoRolUsuario;
    private JFrame jFrame;
    
    ClienteDTO clienteDTO;
    Cliente cliente;
    String ruccliente;
    /**
     * Creates new form plVenta
     * @param dtoEmpleado
     * @param dtoUsuario
     * @param dtoRolUsuario
     * @param jFrame
     */
    public plVenta(EmpleadoDTO dtoEmpleado, UsuarioDTO dtoUsuario, RolUsuarioDTO dtoRolUsuario, JFrame jFrame) {
        this.dtoEmpleado = dtoEmpleado;
        this.dtoUsuario = dtoUsuario;
        this.dtoRolUsuario = dtoRolUsuario;
        this.jFrame = jFrame;
        initComponents();
        initComponents();
        fechaActual();
        txtClienteVisita.setEnabled(true);
        btnProcesar.setEnabled(false);
        clienteDTO = new ClienteDTO();
        cliente = new Cliente();
    }
    
    private void fechaActual() {
        LocalDate fechaActual = LocalDate.now();
        String fechaConvertida = fechaActual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        lblFechaVisita.setText(fechaConvertida);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVisita = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblFechaVisita = new javax.swing.JLabel();
        txtClienteVisita = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        chkbVenta = new javax.swing.JCheckBox();
        btnProcesar = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        pnlBoleta = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccionFiscal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        btnCerrarBoleta = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        pnlVisita.setBorder(javax.swing.BorderFactory.createTitledBorder("VISITA"));

        jLabel15.setText("CLIENTE :");

        txtClienteVisita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteVisitaKeyTyped(evt);
            }
        });

        btnAgregarCliente.setText("+");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        jLabel9.setText("VENTA :");

        chkbVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbVentaActionPerformed(evt);
            }
        });

        btnProcesar.setText("PROCESAR");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVisitaLayout = new javax.swing.GroupLayout(pnlVisita);
        pnlVisita.setLayout(pnlVisitaLayout);
        pnlVisitaLayout.setHorizontalGroup(
            pnlVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtClienteVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente)
                .addGap(103, 103, 103)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(chkbVenta)
                .addGap(173, 173, 173)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcesar)
                .addGap(139, 139, 139)
                .addComponent(lblFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        pnlVisitaLayout.setVerticalGroup(
            pnlVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(chkbVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(btnAgregarCliente)
                    .addComponent(btnBuscarCliente)
                    .addComponent(jLabel9)))
            .addGroup(pnlVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnProcesar)
                .addComponent(lblFechaVisita)
                .addComponent(btnNuevo))
        );

        javax.swing.GroupLayout pnlBoletaLayout = new javax.swing.GroupLayout(pnlBoleta);
        pnlBoleta.setLayout(pnlBoletaLayout);
        pnlBoletaLayout.setHorizontalGroup(
            pnlBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        pnlBoletaLayout.setVerticalGroup(
            pnlBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setText("DIRECCIÓN FISCAL :");

        txtDireccionFiscal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionFiscalKeyTyped(evt);
            }
        });

        jLabel7.setText("CELULAR :");

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel8.setText("DISTRITO :");

        txtDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDistritoKeyTyped(evt);
            }
        });

        jLabel10.setText("PROVINCIA :");

        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccionFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(440, Short.MAX_VALUE))
        );

        btnCerrarBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnCerrarBoleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrarBoleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 1286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnCerrarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkbVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbVentaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chkbVentaActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        int confirmar;
        if (!txtClienteVisita.getText().isEmpty()){
            ruccliente = txtClienteVisita.getText();
            clienteDTO = cliente.buscar(ruccliente);
            if (clienteDTO != null) {
                JOptionPane.showMessageDialog(null,"Cliente Agregado");
            }
            else {
                confirmar = JOptionPane.showConfirmDialog(null, "¿Deseas Registrar un nuevo Cliente?", "CLIENTE NO EXISTE",JOptionPane.YES_NO_OPTION);
                if (confirmar == 0) {
                    plCliente pCliente = new plCliente();
                    pCliente.setSize(755, 560);
                    pCliente.setLocation(0, 0);

                    pnlDatos.removeAll();
                    pnlDatos.add(pCliente, BorderLayout.CENTER);
                    pnlDatos.revalidate();
                    pnlDatos.repaint();
                }              
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Cliente", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        plCliente pCliente = new plCliente();
        pCliente.setSize(750, 560);
        pCliente.setLocation(0, 0);

        pnlDatos.removeAll();
        pnlDatos.add(pCliente, BorderLayout.CENTER);
        pnlDatos.revalidate();
        pnlDatos.repaint();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:
        if (chkbVenta.isSelected()) {
            if (!txtClienteVisita.getText().isEmpty()) {
                txtClienteVisita.setEnabled(false);
                plBoleta pBoleta = new plBoleta(dtoEmpleado, dtoUsuario, dtoRolUsuario, jFrame);
                pBoleta.setSize(600, 579);
                pBoleta.setLocation(0, 0);

                pnlBoleta.removeAll();
                pnlBoleta.add(pBoleta, BorderLayout.CENTER);
                pnlBoleta.revalidate();
                pnlBoleta.repaint();
            }
            else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Cliente");
            }
        }
        
        if (!chkbVenta.isSelected()) {
            if (!txtClienteVisita.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Visita Guardada");
            }
            else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Cliente");
            }
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnCerrarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarBoletaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarBoletaActionPerformed

    private void txtClienteVisitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteVisitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((!(Character.isDigit(c)) && (!(c==KeyEvent.VK_BACK_SPACE)))){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if (txtClienteVisita.getText().length()>=11){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtClienteVisitaKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        txtClienteVisita.setEnabled(true);
        btnProcesar.setEnabled(true);
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtDireccionFiscalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionFiscalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionFiscalKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((!(Character.isDigit(c)) && (!(c == KeyEvent.VK_BACK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if (txtCelular.getText().length() >= 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            if (!txtCelular.getText().startsWith("9")) {
                JOptionPane.showMessageDialog(null, "N° Celular no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtDistritoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistritoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((!(Character.isLetter(c)) && (!(c == KeyEvent.VK_BACK_SPACE)) && (!(c == KeyEvent.VK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if (txtDistrito.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtDistritoKeyTyped

    private void txtProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((!(Character.isLetter(c)) && (!(c == KeyEvent.VK_BACK_SPACE)) && (!(c == KeyEvent.VK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if (txtProvincia.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtProvinciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCerrarBoleta;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JCheckBox chkbVenta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lblFechaVisita;
    private javax.swing.JPanel pnlBoleta;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlVisita;
    private javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtClienteVisita;
    private javax.swing.JTextField txtDireccionFiscal;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables
}
