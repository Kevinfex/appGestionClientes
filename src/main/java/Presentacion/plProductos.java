/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import BusinessObject.producto;
import TransferObject.productoDTO;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar
 */
public class plProductos extends javax.swing.JPanel {

    private frameAdministrador jFrameAdmin;
    private frameVendedor jFrameVededor;
    DefaultTableModel modelo;
    productoDTO productoDTO;
    producto producto;
    String nombre;
    String codproducto;
    Integer estado = 0;

    /**
     * Creates new form panelProductos
     * @param jFrame
     */
    public plProductos(JFrame jFrame) {
        jFrameAdmin = new frameAdministrador();
        jFrameVededor = new frameVendedor();
        if (jFrame.getClass()== jFrameAdmin.getClass()) {
            this.jFrameAdmin = (frameAdministrador) jFrame;
        }else {
            this.jFrameVededor = (frameVendedor) jFrame;
        }
        
        
        initComponents();
        modelo = new DefaultTableModel();
        productoDTO = new productoDTO();
        producto = new producto();
        limpiarTabla();
        listar();
        bloquearCajas();
        desbloquearBotones();
    }

//    public plProductos() {
//        initComponents();
//        modelo = new DefaultTableModel();
//        productoDTO = new productoDTO();
//        producto = new producto();
//        limpiarTabla();
//        listar();
//        bloquearCajas();
//        desbloquearBotones();
//        btnGestionarCategoria.setVisible(false);
//    }

    private void limpiarCajas() {
        txtCodProducto.setText("");
        txtNombreProducto.setText("");
        txtDescripcionProd.setText("");
        cboPresentacion.setSelectedItem("");
        txtprecio.setText("");
        txtstock.setText("");
        txtCodProducto.requestFocus();
    }

    private void bloquearCajas() {
        txtCodProducto.setEnabled(false);
        txtNombreProducto.setEnabled(false);
        txtDescripcionProd.setEnabled(false);
        txtprecio.setEnabled(false);
        txtstock.setEnabled(false);
        cboPresentacion.setEnabled(false);
    }

    private void desbloquearCajas() {
        txtNombreProducto.setEnabled(true);
        txtDescripcionProd.setEnabled(true);
        txtprecio.setEnabled(true);
        txtstock.setEnabled(true);
        cboPresentacion.setEnabled(true);
    }

    private void desbloquearBotones() {
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    private void bloquearBotones() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void listar() {
        try {
            modelo = (DefaultTableModel) tbproducto.getModel();
            Object[] ob = new Object[6];
            for (productoDTO p : producto.listar()) {
                ob[0] = p.getCodProducto();
                ob[1] = p.getNombre();
                ob[2] = p.getDescripcion();
                ob[3] = p.getPresentacion();
                ob[4] = p.getPrecio();
                ob[5] = p.getStock();
                modelo.addRow(ob);
            }
            tbproducto.setModel(modelo);
        } catch (Exception ex) {

        }
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tbproducto.getModel();
        modelo.getDataVector().removeAllElements();
        tbproducto.removeAll();
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
        jLabel2 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionProd = new javax.swing.JTextArea();
        txtNombreProducto = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        cboPresentacion = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnGestionarCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbproducto = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Producto"));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRAR PRODUCTO");

        txtCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProductoActionPerformed(evt);
            }
        });

        txtDescripcionProd.setColumns(20);
        txtDescripcionProd.setRows(5);
        txtDescripcionProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProdKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionProd);

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtstockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        cboPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "unidad", "paquete", "saco", "caja" }));
        cboPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPresentacionActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Código:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Descripción:");

        jLabel6.setText("Precio:");

        jLabel7.setText("stock");

        jLabel8.setText("Presentación:");

        jLabel9.setText("Categoria:");

        btnNuevo.setBackground(new java.awt.Color(153, 255, 153));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 51, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 204));
        btnActualizar.setText("Modificar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPresentacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Producto");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Productos"));

        jLabel10.setText("Buscar:");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        btnGestionarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnGestionarCategoria.png"))); // NOI18N
        btnGestionarCategoria.setContentAreaFilled(false);
        btnGestionarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarCategoria.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnGestionarCategoriaHover.png"))); // NOI18N
        btnGestionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGestionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnGestionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Descripcion", "presentacion", "precio", "stock"
            }
        ));
        tbproducto.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tbproductoComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tbproductoComponentRemoved(evt);
            }
        });
        tbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbproductoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbproducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        listar();
        desbloquearCajas();
        bloquearBotones();
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed


    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed

    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String nombre = txtNombreProducto.getText();
        String descripcion = txtDescripcionProd.getText();
        String presentacion = (String) cboPresentacion.getSelectedItem();
        String precioStr = txtprecio.getText();
        String stockStr = txtstock.getText();

        if (!nombre.isEmpty() && !descripcion.isEmpty() && !precioStr.isEmpty() && !stockStr.isEmpty()) {
            try {
                float precio = Float.parseFloat(precioStr);
                int stock = Integer.parseInt(stockStr);
                String mensaje = producto.agregar(txtCodProducto.getText(), txtNombreProducto.getText(), txtDescripcionProd.getText(), cboPresentacion.getSelectedItem().toString(), precio, stock);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarTabla();
                listar();
                limpiarCajas();
                desbloquearBotones();
                bloquearCajas();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El precio o el stock no son válidos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String mensaje = "";

        int fila = tbproducto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            estado += 1;
            if (estado == 1) {
                desbloquearCajas();
                btnActualizar.setText("Modificar");
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
            } else if (estado == 2) {
                String nombre = txtNombreProducto.getText();
                String descripcion = txtDescripcionProd.getText();
                String presentacion = (String) cboPresentacion.getSelectedItem();
                String precioStr = txtprecio.getText();
                String stockStr = txtstock.getText();
                if (!nombre.isEmpty() && !descripcion.isEmpty() && !presentacion.isEmpty() && !precioStr.isEmpty() && !stockStr.isEmpty()) {
                    float precio = Float.parseFloat(txtprecio.getText());
                    int stock = Integer.parseInt(txtstock.getText());
                    mensaje = producto.actualizar(codproducto, txtNombreProducto.getText(), txtDescripcionProd.getText(), cboPresentacion.getSelectedItem().toString(), precio, stock);
                    JOptionPane.showMessageDialog(null, mensaje);
                    btnActualizar.setText("EDITAR");
                    limpiarTabla();
                    listar();
                    desbloquearBotones();
                    bloquearCajas();
                    //estado = 1
                } else {
                    JOptionPane.showMessageDialog(null, "Debes completar todos los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                estado = 0;
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed


    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void tbproductoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbproductoComponentAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_tbproductoComponentAdded

    private void tbproductoComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbproductoComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tbproductoComponentRemoved

    private void cboPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPresentacionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboPresentacionActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String mensaje = "";
        int fila = tbproducto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            mensaje = producto.eliminar(codproducto);
            JOptionPane.showMessageDialog(null, mensaje);
        }

        limpiarTabla();
        listar();
        //btnNuevoActionPerformed(evt);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tbproductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductoMouseReleased
        // TODO add your handling code here:
        int fila = tbproducto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            codproducto = (tbproducto.getValueAt(fila, 0).toString());
            txtCodProducto.setText(tbproducto.getValueAt(fila, 0).toString());
            txtNombreProducto.setText(tbproducto.getValueAt(fila, 1).toString());
            txtDescripcionProd.setText(tbproducto.getValueAt(fila, 2).toString());
            cboPresentacion.setSelectedItem(tbproducto.getValueAt(fila, 3).toString());
            txtprecio.setText(tbproducto.getValueAt(fila, 4).toString());
            txtstock.setText(tbproducto.getValueAt(fila, 5).toString());

        }
    }//GEN-LAST:event_tbproductoMouseReleased

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped

        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((!(Character.isLetter(c)) && (!(c == KeyEvent.VK_BACK_SPACE)) && (!(c == KeyEvent.VK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if (txtNombreProducto.getText().length() >= 50) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtDescripcionProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProdKeyTyped

        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!(Character.isLetterOrDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE) && !(c == KeyEvent.VK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (txtDescripcionProd.getText().length() >= 100) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtDescripcionProdKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE) && !(c == '.') && !(c == ',')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (txtprecio.getText().length() >= 12) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtstockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockKeyPressed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if (txtstock.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

        // TODO add your handling code here:
        /*char c = evt.getKeyChar();

        if ((!(Character.isDigit(c)) && (!(c == KeyEvent.VK_BACK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        txtBuscarKeyPressed(evt);
        
        
        if (txtbuscar.getText().length() >= 11) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            
            if ((!txtbuscar.getText().startsWith("1")) && (!txtbuscar.getText().startsWith("2"))) {
                JOptionPane.showMessageDialog(null, "Nombre no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
              
            }
        }*/
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

        if (!txtbuscar.getText().isEmpty()) {
            nombre = txtbuscar.getText();
            productoDTO = producto.buscar(nombre);
            if (productoDTO != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) tbproducto.getModel();
                Object[] ob = new Object[8];
                ob[0] = productoDTO.getCodProducto();
                ob[1] = productoDTO.getNombre();
                ob[2] = productoDTO.getDescripcion();
                ob[3] = productoDTO.getDescripcion();
                ob[4] = productoDTO.getPrecio();
                ob[5] = productoDTO.getStock();
                modelo.addRow(ob);
                tbproducto.setModel(modelo);
                //lblMensaje.setText("Producto Encontrado");
            } else {
                //lblMensaje.setText("Producto no Encontrado");
                limpiarTabla();
            }
        } else {
            limpiarTabla();
            listar();
            //lblMensaje.setText("");

        }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((!(Character.isLetter(c)) && (!(c == KeyEvent.VK_BACK_SPACE)) && (!(c == KeyEvent.VK_SPACE)))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        txtbuscarKeyPressed(evt);

        if (txtbuscar.getText().length() >= 50) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();

            if ((!txtbuscar.getText().startsWith("1")) && (!txtbuscar.getText().startsWith("2"))) {
                JOptionPane.showMessageDialog(null, "Nombre no válido", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_txtbuscarKeyTyped

    private void btnGestionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarCategoriaActionPerformed
        if (jFrameAdmin.isVisible()) {
            plCategoria panelCategoria = new plCategoria(jFrameAdmin);
            panelCategoria.setSize(1024, 700);
            panelCategoria.setLocation(0, 0);
            jFrameAdmin.jpContenedor.removeAll();
            jFrameAdmin.jpContenedor.add(panelCategoria, BorderLayout.CENTER);
            jFrameAdmin.jpContenedor.revalidate();
            jFrameAdmin.jpContenedor.repaint();
        } else {
            plCategoria panelCategoria = new plCategoria(jFrameVededor);
            panelCategoria.setSize(1024, 700);
            panelCategoria.setLocation(0, 0);
            jFrameVededor.contenidoJPanel.removeAll();
            jFrameVededor.contenidoJPanel.add(panelCategoria, BorderLayout.CENTER);
            jFrameVededor.contenidoJPanel.revalidate();
            jFrameVededor.contenidoJPanel.repaint();
        }
    }//GEN-LAST:event_btnGestionarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGestionarCategoria;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboPresentacion;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbproducto;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextArea txtDescripcionProd;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables

}
