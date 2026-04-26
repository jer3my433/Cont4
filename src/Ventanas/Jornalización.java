package Ventanas;

import DB.Crudd;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Raven
 */
public class Jornalización extends javax.swing.JPanel {

    public Jornalización() {
        initComponents();
//        lb.putClientProperty(FlatClientProperties.STYLE, ""
//                + "font:$h1.font");
        mostrar();
        cargarCuentasEnCombo();
        configurarBuscadorCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextoCodigo = new javax.swing.JTextField();
        Cuentas = new javax.swing.JComboBox<>();
        TextoFecha = new javax.swing.JFormattedTextField();
        TextoDeudor = new javax.swing.JFormattedTextField();
        TextoAcreedor = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextoCorrelativo = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        BorrarTodo = new javax.swing.JComboBox<>();
        Guardar = new javax.swing.JButton();
        ExportarExcel = new javax.swing.JButton();

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(206, 221, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        TablaUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha", "Correlativo", "Cuenta", "Deudor", "Acreedor"
            }
        ));
        TablaUsuario.getTableHeader().setReorderingAllowed(false);
        TablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaUsuario);

        jLabel9.setText("Base de datos");
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(206, 221, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel1.setText("Codigo");
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel2.setText("Correlativo");
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel3.setText("Fecha");
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        TextoCodigo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Cuentas.setEditable(true);
        Cuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la cuenta" }));
        Cuentas.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Cuentas.setToolTipText("");

        try {
            TextoFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        TextoDeudor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        TextoAcreedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel6.setText("Acreedor");
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel5.setText("Deudor");
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel4.setText("Cuenta");
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        try {
            TextoCorrelativo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("P No.****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(402, 402, 402))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextoFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoCorrelativo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoCodigo)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoDeudor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addComponent(TextoAcreedor)
                    .addComponent(Cuentas, javax.swing.GroupLayout.Alignment.TRAILING, 0, 615, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(TextoDeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoAcreedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(TextoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(206, 221, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel5.setBackground(new java.awt.Color(206, 221, 255));

        Agregar.setBackground(new java.awt.Color(102, 204, 127));
        Agregar.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        Eliminar.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setEnabled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        BorrarTodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliminar todo" }));
        BorrarTodo.setEnabled(false);
        BorrarTodo.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        BorrarTodo.setOpaque(true);
        BorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarTodoActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.setEnabled(false);
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BorrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ExportarExcel.setText("Exportar a Excel");
        ExportarExcel.setBackground(new java.awt.Color(32, 163, 66));
        ExportarExcel.setEnabled(false);
        ExportarExcel.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        ExportarExcel.setOpaque(true);
        ExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaUsuarioMouseClicked
        int fila = TablaUsuario.getSelectedRow();
        if (fila != -1) {
            TextoCodigo.setText(TablaUsuario.getValueAt(fila, 0).toString());
            TextoCorrelativo.setValue(TablaUsuario.getValueAt(fila, 1).toString());
            TextoFecha.setValue(TablaUsuario.getValueAt(fila, 2).toString());
            Cuentas.setSelectedItem(TablaUsuario.getValueAt(fila, 3).toString());
            TextoDeudor.setText(TablaUsuario.getValueAt(fila, 4).toString());
            TextoAcreedor.setText(TablaUsuario.getValueAt(fila, 5).toString());
            TextoCodigo.setEditable(false);
        }
    }//GEN-LAST:event_TablaUsuarioMouseClicked

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        try {
            Crudd op = new Crudd();
            int cod = Integer.parseInt(TextoCodigo.getText().trim());
            String corre = TextoCorrelativo.getText().trim();
            String fecha = TextoFecha.getText().trim();
            String cuentaSeleccionada = "";
            if (Cuentas.getEditor().getItem() != null) {
                cuentaSeleccionada = Cuentas.getEditor().getItem().toString().trim();
            }

            if (cuentaSeleccionada.isEmpty() || cuentaSeleccionada.equals("Seleccione la cuenta")) {
                JOptionPane.showMessageDialog(this, "Indique la cuenta");
                Cuentas.requestFocus();
                return;
            }
            String cuenta = cuentaSeleccionada;
            configurarBuscadorCombo();

            String dStr = TextoDeudor.getText();
            String aStr = TextoAcreedor.getText();

            dStr = dStr.replace(",", "").trim();
            aStr = aStr.replace(",", "").trim();

            double deudor = dStr.isEmpty() ? 0.00 : Double.parseDouble(dStr);
            double acreedor = aStr.isEmpty() ? 0.00 : Double.parseDouble(aStr);

            if (op.existeRegistro(cod)) {
                op.ActualizarDatos(cod, corre, fecha, cuenta, deudor, acreedor);
            } else {
                op.InsertarDatos(cod, corre, fecha, cuenta, deudor, acreedor);
            }
            mostrar();
            nuevo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Llene los datos");
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        if (TablaUsuario.getSelectedRow() >= 0) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro de que deseas eliminar este registro?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                int codigo = Integer.parseInt(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 0).toString());
                Crudd objeto = new Crudd();
                objeto.EliminarDatos(codigo);
                mostrar();
                nuevo();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que desea eliminar");
    }//GEN-LAST:event_EliminarActionPerformed
    }
    private void BorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarTodoActionPerformed
        int filas = TablaUsuario.getRowCount();
        if (filas >= 2) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro de que deseas eliminar TODOS los registros?", "Eliminación de registro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                Crudd objeto = new Crudd();
                objeto.EliminarTodo();
                calcularTotalesEnTabla();
                mostrar();
                nuevo();
            }
        }
    }//GEN-LAST:event_BorrarTodoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
        int ultimaFila = modelo.getRowCount() - 1;

        try {
            double debe = Double.parseDouble(modelo.getValueAt(ultimaFila, 4).toString());
            double haber = Double.parseDouble(modelo.getValueAt(ultimaFila, 5).toString());

            if (debe != haber) {
                JOptionPane.showMessageDialog(this, "Los resultados no cuadran", "Alerta", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Guardado exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void ExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarExcelActionPerformed
        exportarExcel(TablaUsuario);
    }//GEN-LAST:event_ExportarExcelActionPerformed

    void mostrar() {
        Crudd objeto = new Crudd();
        TablaUsuario.setModel(objeto.LeerDatos());
        calcularTotalesEnTabla();
        if (TablaUsuario.getRowCount() >= 2) {
            BorrarTodo.setEnabled(true);
            Guardar.setEnabled(true);
            ExportarExcel.setEnabled(true);
        } else {
            BorrarTodo.setEnabled(false);
            Guardar.setEnabled(false);
            ExportarExcel.setEnabled(false);
        }
        if (TablaUsuario.getRowCount() >= 1) {
            Eliminar.setEnabled(true);
        } else {
            Eliminar.setEnabled(false);
        }
    }

    void nuevo() {
        TextoCodigo.setText("");
        TextoCorrelativo.setValue("P No.");
        TextoFecha.setValue("  /  /    ");
        Cuentas.removeAllItems();
        Cuentas.addItem("Seleccione la cuenta");
        cargarCuentasEnCombo();
        Cuentas.setSelectedIndex(0);
        TextoDeudor.setValue(null);
        TextoAcreedor.setValue(null);
        TextoCodigo.requestFocus();
        TextoCodigo.setEditable(true);
        TablaUsuario.clearSelection();
    }

    private void cargarCuentasEnCombo() {
        Crudd objeto = new Crudd();
        DefaultTableModel modelo = objeto.LeerBancCuentas();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombreCuenta = modelo.getValueAt(i, 1).toString();
            Cuentas.addItem(nombreCuenta);
        }
    }

    private void configurarBuscadorCombo() {
        JTextComponent editor = (JTextComponent) Cuentas.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String charEscrito = editor.getText();

                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    return;
                }
                Crudd objeto = new Crudd();
                DefaultTableModel modelo = objeto.LeerBancCuentas();
                Cuentas.removeAllItems();
                boolean Coincidencias = false;
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String nombre = modelo.getValueAt(i, 1).toString();
                    if (nombre.toLowerCase().contains(charEscrito.toLowerCase())) {
                        Cuentas.addItem(nombre);
                        Coincidencias = true;
                    }
                }
                editor.setText(charEscrito);
                if (Coincidencias) {
                    Cuentas.setPopupVisible(true);
                }
            }
        });
    }

    public void exportarExcel(javax.swing.JTable tabla) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel (*.xlsx)", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar Reporte");

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString();

            if (!ruta.endsWith(".xlsx")) {
                ruta += ".xlsx";
            }

            try (Workbook libro = new XSSFWorkbook()) {
                Sheet hoja = libro.createSheet("Libro1");

                CellStyle estiloHeader = libro.createCellStyle();
                Font fuenteHeader = libro.createFont();
                fuenteHeader.setBold(true);
                estiloHeader.setFont(fuenteHeader);
                estiloHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                estiloHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                Row filaHeader = hoja.createRow(0);
                for (int i = 0; i < tabla.getColumnCount(); i++) {
                    Cell celda = filaHeader.createCell(i);
                    celda.setCellValue(tabla.getColumnName(i));
                    celda.setCellStyle(estiloHeader);
                }

                for (int f = 0; f < tabla.getRowCount(); f++) {
                    Row filaDatos = hoja.createRow(f + 1);
                    for (int c = 0; c < tabla.getColumnCount(); c++) {
                        Cell celda = filaDatos.createCell(c);
                        Object valor = tabla.getValueAt(f, c);

                        if (valor != null) {
                            if (valor instanceof Number) {
                                celda.setCellValue(((Number) valor).doubleValue());
                            } else {
                                celda.setCellValue(valor.toString());
                            }
                        }
                    }
                }

                for (int i = 0; i < tabla.getColumnCount(); i++) {
                    hoja.autoSizeColumn(i);
                }

                try (FileOutputStream out = new FileOutputStream(ruta)) {
                    libro.write(out);
                    JOptionPane.showMessageDialog(this, "Reporte generado satisfactoriamente", "Reporte", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al crear el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void calcularTotalesEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();

        if (modelo.getRowCount() >= 2) {
            double sumaDebe = 0;
            double sumaHaber = 0;

            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0) != null && modelo.getValueAt(i, 0).toString().equals("TOTAL")) {
                    continue;
                }

                try {
                    double debe = Double.parseDouble(modelo.getValueAt(i, 4).toString());
                    double haber = Double.parseDouble(modelo.getValueAt(i, 5).toString());
                    sumaDebe += debe;
                    sumaHaber += haber;
                } catch (Exception e) {
                }
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0) != null && modelo.getValueAt(i, 0).toString().equals("TOTAL")) {
                    modelo.removeRow(i);
                    break;
                }
            }
            Object[] filaTotal = new Object[modelo.getColumnCount()];
            filaTotal[3] = "TOTAL";
            filaTotal[4] = String.format("%.2f", sumaDebe);
            filaTotal[5] = String.format("%.2f", sumaHaber);
            modelo.addRow(filaTotal);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JComboBox<String> BorrarTodo;
    private javax.swing.JComboBox<String> Cuentas;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton ExportarExcel;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JFormattedTextField TextoAcreedor;
    private javax.swing.JTextField TextoCodigo;
    private javax.swing.JFormattedTextField TextoCorrelativo;
    private javax.swing.JFormattedTextField TextoDeudor;
    private javax.swing.JFormattedTextField TextoFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
