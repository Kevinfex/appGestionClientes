package Presentacion;

import BusinessObject.Empleado;
import BusinessObject.RolUsuario;
import BusinessObject.Usuario;
import TransferObject.EmpleadoDTO;
import TransferObject.RolUsuarioDTO;
import TransferObject.UsuarioDTO;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author KEVIN EP
 */
public class frameAdministrador extends javax.swing.JFrame {
    private UsuarioDTO dtoUsuario;
    private EmpleadoDTO dtoEmpleado;
    private RolUsuarioDTO dtoRolUsuario;
    private Usuario oUsuario;
    private Empleado oEmpleado;
    private RolUsuario oRolUsuario;
    private int codUsuario, codRolUsuario;
    private String codEmpleado;
    /**
     * Creates new form frameAdministrador
     * @param dtoUsuario
     */
    public frameAdministrador(UsuarioDTO dtoUsuario) {
        codEmpleado = dtoUsuario.getCodEmpleado();
        codUsuario = dtoUsuario.getCodUsuario();
        codRolUsuario = dtoUsuario.getCodRolUsuario();
        initComponents();
        inicarFrameAdministrador();
    }

    frameAdministrador() {
        initComponents();
    }
    
    public void inicarFrameAdministrador() {
        this.setLocationRelativeTo(null);
        this.setTitle("Administrador - Sistema de Gestión de Clientes");
        oEmpleado = new Empleado();
        oRolUsuario = new RolUsuario();
        oUsuario = new Usuario();
        
        dtoEmpleado = oEmpleado.buscar(codEmpleado);
        dtoRolUsuario = oRolUsuario.buscar(codRolUsuario);
        dtoUsuario = oUsuario.buscar(codUsuario);
        
        nombresEmpleado.setText(dtoEmpleado.getNombres() + " " + dtoEmpleado.getApellidoPaterno());
        rolUsuario.setText(dtoRolUsuario.getNombreRol());
    }
   
    private void mostrarPanel(JPanel jPanel) {
        jPanel.setSize(1024, 700);
        jPanel.setLocation(0,0);
        jpContenedor.removeAll();
        jpContenedor.add(jPanel, BorderLayout.CENTER);
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }
    public void seleccionarBoton(boolean botonEmpleado, boolean botonUsuario, boolean botonProductos, boolean botonClientes, boolean botonVentas, boolean botonReportes, boolean  botonPerfil){
        btnEmpleados.setSelected(botonEmpleado);
        btnUsuarios.setSelected(botonUsuario);
        btnProductos.setSelected(botonProductos);
        btnClientes.setSelected(botonClientes);
        btnVentas.setSelected(botonVentas);
        btnReportes.setSelected(botonReportes);
        btnPerfil.setSelected(botonPerfil);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rolUsuario = new javax.swing.JLabel();
        nombresEmpleado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jpContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(1, 75, 160));

        rolUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        rolUsuario.setForeground(new java.awt.Color(255, 255, 255));
        rolUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rolUsuario.setText("ROL");

        nombresEmpleado.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        nombresEmpleado.setForeground(new java.awt.Color(237, 237, 237));
        nombresEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombresEmpleado.setText("Ful Name");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(200, 200, 200));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hola");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoAbasto187x88.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombresEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(rolUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombresEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 242, -1));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCerrarSesionHover.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 218, 40));

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnPerfil2.png"))); // NOI18N
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnPerfil2Hover.png"))); // NOI18N
        btnPerfil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnPerfil2Selected.png"))); // NOI18N
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, 90));

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnProductos.png"))); // NOI18N
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnProductosHover.png"))); // NOI18N
        btnProductos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnProductosSelected.png"))); // NOI18N
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, 90));

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReportes.png"))); // NOI18N
        btnReportes.setContentAreaFilled(false);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReportesHover.png"))); // NOI18N
        btnReportes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReportesSelected.png"))); // NOI18N
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 100, 90));

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnUsuarios.png"))); // NOI18N
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnUsuariosHover.png"))); // NOI18N
        btnUsuarios.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnUsuariosSelected.png"))); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 100, 90));

        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEmpleados.png"))); // NOI18N
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEmpleadosHover.png"))); // NOI18N
        btnEmpleados.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEmpleadosSelected.png"))); // NOI18N
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 90));

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClientes.png"))); // NOI18N
        btnClientes.setContentAreaFilled(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClientesHover.png"))); // NOI18N
        btnClientes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClientesSelected.png"))); // NOI18N
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 100, 90));

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnVentas.png"))); // NOI18N
        btnVentas.setContentAreaFilled(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnVentasHover.png"))); // NOI18N
        btnVentas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnVentasSelected.png"))); // NOI18N
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, 90));

        jpContenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpContenedorLayout = new javax.swing.GroupLayout(jpContenedor);
        jpContenedor.setLayout(jpContenedorLayout);
        jpContenedorLayout.setHorizontalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jpContenedorLayout.setVerticalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        plProductos jpProductos = new plProductos(frameAdministrador.this);
        mostrarPanel(jpProductos);
        seleccionarBoton(false, false, true, false, false, false, false);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        plReportes jpReportes = new plReportes();
        mostrarPanel(jpReportes);
        seleccionarBoton(false, false, false, false, false, true, false);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        plUsuarios jpUsuarios = new plUsuarios();
        mostrarPanel(jpUsuarios);
        seleccionarBoton(false, true, false, false, false, false, false);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        plEmpleados jpEmpleado = new plEmpleados();
        mostrarPanel(jpEmpleado);
        seleccionarBoton(true, false, false, false, false, false, false);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        plCliente pCliente = new plCliente();
        mostrarPanel(pCliente);
        seleccionarBoton(false, false, false, true, false, false, false);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        VentaProductos venta = new VentaProductos(dtoEmpleado, dtoUsuario, dtoRolUsuario, frameAdministrador.this);
        //mostrarPanel(plventa);
        mostrarPanel(venta);
        seleccionarBoton(false, false, false, false, true, false, false);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        plPerfil jpPerfil = new plPerfil(dtoEmpleado, dtoUsuario, dtoRolUsuario, frameAdministrador.this);
        mostrarPanel(jpPerfil);
        seleccionarBoton(false, false, false, false, false, false, true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        frameLogin jpLogin = new frameLogin();
        jpLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frameAdministrador().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    public javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jpContenedor;
    public javax.swing.JLabel nombresEmpleado;
    public javax.swing.JLabel rolUsuario;
    // End of variables declaration//GEN-END:variables
}
