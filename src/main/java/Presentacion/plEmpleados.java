package Presentacion;

import BusinessObject.Empleado;
import BusinessObject.Usuario;
import DataAccessObject.EmpleadoDAO;
import DataAccessObject.UsuarioDAO;
import TransferObject.EmpleadoDTO;
import TransferObject.RolUsuarioDTO;
import Utilities.Controles;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN EP
 */
public class plEmpleados extends javax.swing.JPanel {

    private EmpleadoDTO dtoEmpleado;
    private EmpleadoDAO daoEmpleado;
    private Empleado oEmpleado;
    private DefaultTableModel modeloEmpleados;
    private panelFormularioEmpleado jpFormularioEmpleado;
    private panelFormularioUsuario jpFormularioUsuario;
    private JTextField txtCodigo;
    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtNumeroCelular;

    JComboBox<RolUsuarioDTO> cbRolUsuario;
    JTextField txtUserName;
    JTextField txtPassword;
    JRadioButton rbActivo;
    JRadioButton rbInactivo;

    int opcionCrearUsuario = JOptionPane.NO_OPTION;

    public plEmpleados() {
        initComponents();
        dtoEmpleado = new EmpleadoDTO();
        daoEmpleado = new EmpleadoDAO();
        oEmpleado = new Empleado();
        modeloEmpleados = new DefaultTableModel();
        jpFormularioEmpleado = new panelFormularioEmpleado();
        jpFormularioUsuario = new panelFormularioUsuario();
        iniciarPanelEmpleado();
        listarEmpleados();
    }

    private void iniciarPanelEmpleado() {
        Controles.cargarFormularios(panelContenedorEmpleado, jpFormularioEmpleado, 366, 300);
        Controles.cargarFormularios(panelContenedorUsuario, jpFormularioUsuario, 360, 300);
        
        jpFormularioUsuario.btnCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        panelContenedorUsuario.setVisible(false);
        // Instancias de elementos de Formulario Empleados
        txtCodigo = jpFormularioEmpleado.txtCodigoEmpleado;
        txtDni = jpFormularioEmpleado.txtDniEmpleado;
        txtNombres = jpFormularioEmpleado.txtNombresEmpleado;
        txtApellidoPaterno = jpFormularioEmpleado.txtApellidoPaternoEmple;
        txtApellidoMaterno = jpFormularioEmpleado.txtApellidoMaternoEmmple;
        txtNumeroCelular = jpFormularioEmpleado.txtCelularEmpleado;

        // Instancias de elementos de Formulario Usuario
        cbRolUsuario = jpFormularioUsuario.cbTipoUsuario;
        txtUserName = jpFormularioUsuario.txtNameUser;
        txtPassword = jpFormularioUsuario.txtPassword;
        rbActivo = jpFormularioUsuario.rbUsuarioActivo;
        rbInactivo = jpFormularioUsuario.rbUsuarioInactivo;

        txtDni.requestFocus();

        String[] tituloTabla = {"COÓDIGO", "N° DNI", "NOMBRES", "APELLIDOS", "CELULAR"};
        modeloEmpleados.setColumnIdentifiers(tituloTabla);
    }

    private void generarUsuario(String codigoEmpleado, String nombres, String apellidoPat, String apellidoMat) {
        String[] nombresArray = nombres.split(" ");
        jpFormularioUsuario.labelCodigoEmpleado.setText(codigoEmpleado);
        jpFormularioUsuario.labelNombreApellidoEmpleado.setText(nombresArray[0] + " " + apellidoPat + " " + apellidoMat);

        txtUserName.setText(txtDni.getText() + codigoEmpleado.substring(1, 4));
        txtPassword.setText(txtDni.getText());
        rbActivo.setSelected(true);
        rbInactivo.setEnabled(false);
    }

    private void btnCrearUsuarioActionPerformed(ActionEvent evt) {
        if (jpFormularioUsuario.validarFormularioUsuario()) {
            String userName = txtUserName.getText().trim();
            String password = txtPassword.getText().trim();
            int codRolUsuario = cbRolUsuario.getItemAt(cbRolUsuario.getSelectedIndex()).getCodRolUsuario();
            String codEmpleado = jpFormularioUsuario.labelCodigoEmpleado.getText();
            String estado = "";
            if (rbActivo.isSelected()) {
                estado = "1";
            } else if (rbInactivo.isSelected()) {
                estado = "0";
            }
            Toolkit.getDefaultToolkit().beep();
            // Registramos el usuario generado
            Usuario oUsuario = new Usuario();
            String mensaje = oUsuario.agregar(userName, password, estado, codRolUsuario, codEmpleado);
            JOptionPane.showMessageDialog(null, mensaje, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);

            jpFormularioUsuario.cancelar();
            cancelar();
        }
    }

    private void listarEmpleados() {
        Object[] datos = new Object[5];
        for (EmpleadoDTO empleado : oEmpleado.listar()) {
            datos[0] = empleado.getCodEmpleado();
            datos[1] = empleado.getDNIEmpleado();
            datos[2] = empleado.getNombres();
            datos[3] = empleado.getApellidoPaterno() + " " + empleado.getApellidoMaterno();
            datos[4] = empleado.getCelular();
            modeloEmpleados.addRow(datos);
        }
        tbEmpleados.setModel(modeloEmpleados);
    }

    private void limpiarTabla() {
        modeloEmpleados.setRowCount(0);
        //modeloEmpleados.getDataVector().removeAllElements();
        //tbEmpleados.removeAll();

    }

    private void cancelar() {
        txtCodigo.setText("");
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNumeroCelular.setText("");

        tbEmpleados.clearSelection();
        txtDni.requestFocus();

        tbEmpleados.setEnabled(true);
        opcionCrearUsuario = JOptionPane.NO_OPTION;

        panelContenedorUsuario.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelContenedorEmpleado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarDNI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnEditarrEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelContenedorUsuario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Empleado");

        jLabel2.setText("FORMULARIO EMPLEADO");

        javax.swing.GroupLayout panelContenedorEmpleadoLayout = new javax.swing.GroupLayout(panelContenedorEmpleado);
        panelContenedorEmpleado.setLayout(panelContenedorEmpleadoLayout);
        panelContenedorEmpleadoLayout.setHorizontalGroup(
            panelContenedorEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmpleadoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        panelContenedorEmpleadoLayout.setVerticalGroup(
            panelContenedorEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmpleadoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jLabel8.setText("Buscar por");

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGuardar.png"))); // NOI18N
        btnGuardarEmpleado.setContentAreaFilled(false);
        btnGuardarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarEmpleado.setName("btnGuardar"); // NOI18N
        btnGuardarEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGuardarHover.png"))); // NOI18N
        btnGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEmpleadoActionPerformed(evt);
            }
        });

        btnEditarrEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEditar.png"))); // NOI18N
        btnEditarrEmpleado.setContentAreaFilled(false);
        btnEditarrEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarrEmpleado.setName("btnActualizar"); // NOI18N
        btnEditarrEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEditarHover.png"))); // NOI18N
        btnEditarrEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarrEmpleadoEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEliminar.png"))); // NOI18N
        btnEliminarEmpleado.setContentAreaFilled(false);
        btnEliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEmpleado.setName("btnEliminar"); // NOI18N
        btnEliminarEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEliminarHover.png"))); // NOI18N
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoEmpleadoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelar.png"))); // NOI18N
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarHover.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarrEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarrEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jLabel3.setText("FORMULARIO USUARIO");

        javax.swing.GroupLayout panelContenedorUsuarioLayout = new javax.swing.GroupLayout(panelContenedorUsuario);
        panelContenedorUsuario.setLayout(panelContenedorUsuarioLayout);
        panelContenedorUsuarioLayout.setHorizontalGroup(
            panelContenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorUsuarioLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        panelContenedorUsuarioLayout.setVerticalGroup(
            panelContenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorUsuarioLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelContenedorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelContenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelContenedorEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEmpleadoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoEmpleadoActionPerformed
        if (opcionCrearUsuario == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Estas generando un Usuario. \nPresione Cancelar si deseas realizar esta acción", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tbEmpleados.getSelectedRowCount() > 0) {
            String codigoEmpleado = txtCodigo.getText();
            UsuarioDAO daoUsuario = new UsuarioDAO();
            String mensajeJOptionPane;
            JLabel labelMensaje = new JLabel();

            if (!daoUsuario.buscarCodigoEmpleado(codigoEmpleado)) {
                dtoEmpleado = oEmpleado.buscar(codigoEmpleado);

                mensajeJOptionPane = "<html>Estas seguro de Eliminar a: <b>" + dtoEmpleado.getCodEmpleado() + "</b> - " + dtoEmpleado.getNombres() + " " + dtoEmpleado.getApellidoPaterno() + "</html>";
                labelMensaje.setText(mensajeJOptionPane);
                int opcion = JOptionPane.showConfirmDialog(null, mensajeJOptionPane, "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    Toolkit.getDefaultToolkit().beep();
                    String mensaje = oEmpleado.eliminar(codigoEmpleado);
                    JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                limpiarTabla();
                listarEmpleados();
                cancelar();

            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar: \nEl empleado cuenta con un usuario.", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado de la tabla.", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarEmpleadoEmpleadoActionPerformed

    private void btnEditarrEmpleadoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarrEmpleadoEmpleadoActionPerformed
        if (opcionCrearUsuario == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Estas generando un Usuario. \nPresione Cancelar si deseas realizar esta acción", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tbEmpleados.getSelectedRowCount() > 0) {
            if (jpFormularioEmpleado.validarFormularioEmpleado()) {
                String codigo = txtCodigo.getText().trim();
                String dni = txtDni.getText().trim();
                String nombres = txtNombres.getText().trim();
                String apellidoPat = txtApellidoPaterno.getText().trim();
                String apellidoMat = txtApellidoMaterno.getText().trim();
                String celular = txtNumeroCelular.getText().trim();

                dtoEmpleado = oEmpleado.buscar(codigo);

                if (dtoEmpleado.getDNIEmpleado().equals(dni)) {
                    String mensaje = oEmpleado.actualizar(codigo, dni, nombres, apellidoPat, apellidoMat, celular);
                    JOptionPane.showMessageDialog(null, mensaje);
                    limpiarTabla();
                    listarEmpleados();
                    cancelar();
                } else {
                    String mensajeJOptionPane;
                    JLabel labelMensaje = new JLabel();
                    if (!daoEmpleado.buscarDNI(dni)) {
                        Toolkit.getDefaultToolkit().beep();
                        String mensaje = oEmpleado.actualizar(codigo, dni, nombres, apellidoPat, apellidoMat, celular);
                        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        limpiarTabla();
                        listarEmpleados();
                        cancelar();
                    } else {
                        mensajeJOptionPane = "<html>El <b>N° " + dni + "</b> ya está registrado</html>";
                        labelMensaje.setText(mensajeJOptionPane);
                        JOptionPane.showMessageDialog(null, labelMensaje, "¡Error! DNI Existe", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado de la tabla.", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarrEmpleadoEmpleadoActionPerformed

    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        if (opcionCrearUsuario == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Estas generando un Usuario. \nPresione Cancelar si deseas realizar esta acción", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tbEmpleados.getSelectedRowCount() == 0) {
            if (jpFormularioEmpleado.validarFormularioEmpleado()) {
                String dni = txtDni.getText().trim();
                String nombres = txtNombres.getText();
                String apellidoPat = txtApellidoPaterno.getText().trim();
                String apellidoMat = txtApellidoMaterno.getText().trim();
                String celular = txtNumeroCelular.getText().trim();
                String codigoEmpleado = ("E" + nombres.substring(0, 1) + apellidoPat.charAt(0) + apellidoMat.charAt(0) + dni.substring(dni.length() - 2)).toUpperCase();

                String mensajeJOptionPane;
                JLabel labelMensaje = new JLabel();
                if (!daoEmpleado.buscarCodigo(codigoEmpleado)) {
                    if (!daoEmpleado.buscarDNI(dni)) {
                        Toolkit.getDefaultToolkit().beep();
                        // Registramos al empleado
                        String mensaje = oEmpleado.agregar(codigoEmpleado.toUpperCase(), dni, nombres, apellidoPat, apellidoMat, celular);
                        JOptionPane.showMessageDialog(null, mensaje, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);

                        // Preguntar para generar usuario despues de registrar empleado
                        String mensajeCrearUsuario = "<html>¿Deseas generar una Cuenta de Usuario para  <b>" + nombres + " " + apellidoPat + "</b></html>";
                        JLabel labelMensajeCrearUsuario = new JLabel();
                        labelMensajeCrearUsuario.setText(mensajeCrearUsuario);
                        opcionCrearUsuario = JOptionPane.showConfirmDialog(null, labelMensajeCrearUsuario, "Confirmación", JOptionPane.YES_NO_OPTION);
                        if (opcionCrearUsuario == JOptionPane.YES_OPTION) {
                            panelContenedorUsuario.setVisible(true);
                            tbEmpleados.setEnabled(false);
                            generarUsuario(codigoEmpleado, nombres, apellidoPat, apellidoMat);

                        } else {
                            cancelar();
                        }
                        limpiarTabla();
                        listarEmpleados();

                    } else {
                        mensajeJOptionPane = "<html>El <b>N° " + dni + "</b> ya está registrado</html>";
                        labelMensaje.setText(mensajeJOptionPane);
                        JOptionPane.showMessageDialog(null, labelMensaje, "¡Error! DNI Existe", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    mensajeJOptionPane = "<html>La combinación <b>" + codigoEmpleado + "</b> ya existe en la base de datos</html>";
                    labelMensaje.setText(mensajeJOptionPane);
                    JOptionPane.showMessageDialog(null, labelMensaje, "¡Error! Codigo de Empleado", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Estas En Modo Edición \nHay un empleado seleccionado. \nPresione Cancelar", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        //String apellidosArray[] = new String[2];
        String apellidos, apePat, apeMat;
        apellidos = (String) tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 3);
        String[] apellidosArray = apellidos.split(" ");
        apePat = apellidosArray[0];
        apeMat = apellidosArray[1];

        txtCodigo.setText(tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 0).toString());
        txtDni.setText(tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 1).toString());
        txtNombres.setText(tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 2).toString());
        txtApellidoPaterno.setText(apePat);
        txtApellidoMaterno.setText(apeMat);
        txtNumeroCelular.setText(tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Toolkit.getDefaultToolkit().beep();
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarrEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContenedorEmpleado;
    private javax.swing.JPanel panelContenedorUsuario;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtBuscarDNI;
    // End of variables declaration//GEN-END:variables
}
