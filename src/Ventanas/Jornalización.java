package Ventanas;

import DB.MétodosJornalización;
import DB.Métodos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Jornalización extends javax.swing.JPanel {

    private int IdPeriodoSelec = -1;
    private Date fechaInicioPeriodo;
    private Date fechaFinPeriodo;
    MétodosJornalización crud = new MétodosJornalización();
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Jornalización(int idPeriodo, Date fechaInicio, Date fechaFin) {
        this.IdPeriodoSelec = idPeriodo;
        this.fechaInicioPeriodo = fechaInicio;
        this.fechaFinPeriodo = fechaFin;
        initComponents();
        jLabel7.setText("(" + formatoFecha.format(fechaInicioPeriodo) + " - " + formatoFecha.format(fechaFinPeriodo) + ")");
        TextoFecha.setDateFormatString("dd/MM/yyyy");
        if (fechaInicioPeriodo != null && fechaFinPeriodo != null) {
            TextoFecha.setMinSelectableDate(fechaInicioPeriodo);
            TextoFecha.setMaxSelectableDate(fechaFinPeriodo);
        }
        TablaUsuario.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        TablaUsuario.getTableHeader().setForeground(java.awt.Color.BLACK);
        TablaUsuario.getTableHeader().setFont(new java.awt.Font("TW Cent MT", java.awt.Font.BOLD, 14));
        Cuentas.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    String cuentaSeleccionada = Cuentas.getSelectedItem().toString();
                    // Lógica para extraer el código. Supongamos que tu combo guarda "101 - Caja General"
                    if (cuentaSeleccionada.contains("-")) {
                        String codigo = cuentaSeleccionada.split("-")[0].trim();
                        TextoCodigo.setText(codigo);
                    }
                }
            }
        });
        mostrar();
        cargarCuentasEnCombo();
//        configurarBuscadorCombo();
        configurarBuscadorCuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextoCodigo = new javax.swing.JTextField();
        Cuentas = new javax.swing.JComboBox<>();
        TextoDeudor = new javax.swing.JFormattedTextField();
        TextoAcreedor = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextoCorrelativo = new javax.swing.JFormattedTextField();
        TextoFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
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

        TablaUsuario.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(206, 221, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Correlativo");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Fecha");

        TextoCodigo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Cuentas.setEditable(true);
        Cuentas.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Cuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la cuenta" }));
        Cuentas.setToolTipText("");
        Cuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TextoDeudor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        TextoAcreedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Acreedor");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Deudor");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Cuenta");

        try {
            TextoCorrelativo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("P No.****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(402, 402, 402))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextoFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextoCorrelativo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoCodigo)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoDeudor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextoAcreedor)
                    .addComponent(Cuentas, javax.swing.GroupLayout.Alignment.TRAILING, 0, 618, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(TextoDeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextoAcreedor, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(TextoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        BorrarTodo.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        BorrarTodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliminar todo" }));
        BorrarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BorrarTodo.setEnabled(false);
        BorrarTodo.setOpaque(true);
        BorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarTodoActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addComponent(Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        ExportarExcel.setBackground(new java.awt.Color(32, 163, 66));
        ExportarExcel.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        ExportarExcel.setText("Exportar a Excel");
        ExportarExcel.setEnabled(false);
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
                .addContainerGap()
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaUsuarioMouseClicked
        if (TablaUsuario.getSelectedRow() != -1) {
            TextoCodigo.setText(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 0).toString());
            String fechaTabla = TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 1).toString();
            Date date;
            try {
                date = formatoFecha.parse(fechaTabla);
                TextoFecha.setDate(date);
            } catch (ParseException ex) {
                System.getLogger(Jornalización.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

            TextoCorrelativo.setValue(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 2).toString());
            Cuentas.setSelectedItem(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 3).toString());
            TextoDeudor.setText(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 4).toString());
            TextoAcreedor.setText(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 5).toString());
            TextoCodigo.setEditable(false);
        }
    }//GEN-LAST:event_TablaUsuarioMouseClicked


    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        try {
            int codigo = Integer.parseInt(TextoCodigo.getText());
            String correlativo = TextoCorrelativo.getText().trim();
            String cuenta = Cuentas.getSelectedItem().toString();
            Date fechaSelec = TextoFecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            if (fechaSelec.before(fechaInicioPeriodo) || fechaSelec.after(fechaFinPeriodo)) {

                JOptionPane.showMessageDialog(this,
                        "Error: La fecha (" + sdf.format(fechaSelec) + ") no está permitida.\n"
                        + "Debe estar estrictamente dentro del rango de este periodo:\n"
                        + "Desde: " + sdf.format(fechaInicioPeriodo) + " hasta: " + sdf.format(fechaFinPeriodo),
                        "Fecha fuera de rango",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
            String fechaFormateada = sdf.format(TextoFecha.getDate());
            String dStr = TextoDeudor.getText();
            String aStr = TextoAcreedor.getText();

            dStr = dStr.replace("Q", "").replace(",", "").trim();
            aStr = aStr.replace("Q", "").replace(",", "").trim();

            double deudor = dStr.isEmpty() ? 0.00 : Double.parseDouble(dStr);
            double acreedor = aStr.isEmpty() ? 0.00 : Double.parseDouble(aStr);

            Métodos objetoCrudd = new Métodos();

            if (objetoCrudd.existeRegistroJornalizacion(codigo, this.IdPeriodoSelec)) {
                objetoCrudd.ActualizarDatosJornalizacion(codigo, correlativo, fechaFormateada, cuenta, deudor, acreedor, this.IdPeriodoSelec);

            } else {
                crud.InsertarPartida(codigo, correlativo, fechaFormateada, cuenta, deudor, acreedor, this.IdPeriodoSelec);
            }
            nuevo();
            mostrar();

            actualizarLibroMayor(cuenta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar " + e.getMessage());
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        if (TablaUsuario.getSelectedRow() >= 0) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro de que deseas eliminar este registro?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                int codigo = Integer.parseInt(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 0).toString());
                Métodos objeto = new Métodos();
                objeto.EliminarDatosJornalizacion(codigo);
                mostrar();
                nuevo();
                String cuenta = Cuentas.getSelectedItem().toString();
                actualizarLibroMayor(cuenta);
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
                Métodos objeto = new Métodos();
                objeto.EliminarTodoJornalizacion(this.IdPeriodoSelec);
                mostrar();
                nuevo();
                String cuenta = Cuentas.getSelectedItem().toString();
                actualizarLibroMayor(cuenta);
            }
        }
    }//GEN-LAST:event_BorrarTodoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        if (!verificarSuma()) {
            JOptionPane.showMessageDialog(this, "Los datos no cuadran", "Alerta", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Guardado exitosamente");
        }
        String cuenta = Cuentas.getSelectedItem().toString();
        actualizarLibroMayor(cuenta);
    }//GEN-LAST:event_GuardarActionPerformed

    private void ExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarExcelActionPerformed
        if (!verificarSuma()) {
            JOptionPane.showMessageDialog(this, "Los totales no cuadran", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        exportarExcel(TablaUsuario);
    }//GEN-LAST:event_ExportarExcelActionPerformed

    void mostrar() {
        TablaUsuario.setModel(crud.LeerPartidasPorPeriodo(this.IdPeriodoSelec));
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
        TextoFecha.setDate(null);
//        Cuentas.removeAllItems();
//        Cuentas.addItem("Seleccione la cuenta");
//        cargarCuentasEnCombo();
//        Cuentas.setSelectedIndex(0);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Cuentas.removeAllItems();
                Cuentas.addItem("Seleccione la cuenta");
                cargarCuentasEnCombo();
                Cuentas.setSelectedIndex(0);
            }
        });
        TextoDeudor.setValue(null);
        TextoAcreedor.setValue(null);
        TextoCodigo.requestFocus();
        TextoCodigo.setEditable(true);
        TablaUsuario.clearSelection();
    }

    private void cargarCuentasEnCombo() {
        Métodos objeto = new Métodos();
        DefaultTableModel modelo = objeto.LeerBancCuentas();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombreCuenta = modelo.getValueAt(i, 1).toString();
            Cuentas.addItem(nombreCuenta);
        }
    }

    private void actualizarLibroMayor(String nombreCuenta) {
        try {
            DB.Métodos metodosDB = new DB.Métodos();
            DefaultTableModel modeloDetalle = metodosDB.LeerDetalleCuentaMayor(nombreCuenta);

            double sumaDebe = 0, sumaHaber = 0;
            for (int j = 0; j < modeloDetalle.getRowCount(); j++) {
                try {
                    sumaDebe += Double.parseDouble(modeloDetalle.getValueAt(j, 3).toString());
                    sumaHaber += Double.parseDouble(modeloDetalle.getValueAt(j, 4).toString());
                } catch (Exception ex) {
                }
            }

            // Obtiene la fecha de la primera fila
            String fecha = (modeloDetalle.getRowCount() > 0 && modeloDetalle.getValueAt(0, 0) != null)
                    ? modeloDetalle.getValueAt(0, 0).toString()
                    : new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());

            String codigo = (modeloDetalle.getRowCount() > 0 && modeloDetalle.getValueAt(0, 1) != null)
                    ? modeloDetalle.getValueAt(0, 1).toString()
                    : "";

            if (sumaDebe > 0 || sumaHaber > 0) {
                metodosDB.eliminarCuentaLibroMayor(nombreCuenta);
                metodosDB.insertarDatosLibroMayor(codigo, fecha, nombreCuenta, sumaDebe, sumaHaber);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar libro_mayor: " + e.getMessage());
        }
    }

    private void configurarBuscadorCuentas() {
        final javax.swing.text.JTextComponent editor = (javax.swing.text.JTextComponent) Cuentas.getEditor().getEditorComponent();

        editor.addKeyListener(new java.awt.event.KeyAdapter() {
            private String textoPrevio = "";

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                // 1. Ignoramos teclas de navegación para no interferir con las flechas o Enter
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_UP
                        || e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN
                        || e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                        || e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    return;
                }

                String textoActual = editor.getText();
                if (textoActual.equals(textoPrevio)) {
                    return;
                }
                textoPrevio = textoActual;

                // 2. Si el usuario borró todo el texto, restablecemos el combo original de la Base de Datos
                if (textoActual.trim().isEmpty()) {
                    Cuentas.hidePopup();
                    Cuentas.removeAllItems();
                    Cuentas.addItem("Seleccione la cuenta");
                    cargarCuentasEnCombo();
                    Cuentas.setSelectedItem("");
                    return;
                }

                // 3. Cargamos y filtramos los elementos desde los datos reales de la BD
                DB.Métodos objeto = new DB.Métodos();
                javax.swing.table.DefaultTableModel modelo = objeto.LeerBancCuentas();
                java.util.List<String> itemsFiltrados = new java.util.ArrayList<>();

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String nombreCuenta = modelo.getValueAt(i, 1).toString();
                    // Filtramos ignorando mayúsculas y minúsculas (búsqueda flexible)
                    if (nombreCuenta.toLowerCase().contains(textoActual.toLowerCase())) {
                        itemsFiltrados.add(nombreCuenta);
                    }
                }

                // 4. Actualizamos la lista desplegable visual sin perder lo que el usuario está escribiendo
                Cuentas.hidePopup();
                Cuentas.removeAllItems(); // Limpiamos elementos anteriores

                if (!itemsFiltrados.isEmpty()) {
                    for (String item : itemsFiltrados) {
                        Cuentas.addItem(item);
                    }

                    // Mantenemos el texto que el usuario llevaba escrito en el campo de texto
                    editor.setText(textoActual);
                    Cuentas.showPopup();
                } else {
                    Cuentas.addItem("Sin coincidencias");
                    editor.setText(textoActual);
                    Cuentas.showPopup();
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

    private boolean verificarSuma() {
        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
        double sumaDebe = 0;
        double sumaHaber = 0;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 3) != null && modelo.getValueAt(i, 3).toString().equals("TOTAL")) {
                continue;
            }

            try {
                sumaDebe += Double.parseDouble(modelo.getValueAt(i, 4).toString());
                sumaHaber += Double.parseDouble(modelo.getValueAt(i, 5).toString());
            } catch (Exception e) {
            }
        }
        return Math.abs(sumaDebe - sumaHaber) < 0.01;
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
    private com.toedter.calendar.JDateChooser TextoFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
