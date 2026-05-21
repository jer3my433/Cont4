package Ventanas;

import DB.Métodos;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LibroDiario extends javax.swing.JPanel {

//    private TableRowSorter<DefaultTableModel> sorterPartidas;
    private TableRowSorter<DefaultTableModel> sorterPeriodos;

    public LibroDiario() {
        initComponents();
        mostrar();
        jTable1.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setForeground(java.awt.Color.BLACK);
        jTable1.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 14));
        TablaUsuario.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        TablaUsuario.getTableHeader().setForeground(java.awt.Color.BLACK);
        TablaUsuario.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 14));
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int filaSeleccionada = jTable1.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int idPeriodo = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());
                        DB.Métodos metodos = new DB.Métodos();
                        TablaUsuario.setModel(metodos.LeerJornalizacionParaLibroDiario(idPeriodo));
                        calcularTotalesEnTabla();
                        if (TablaUsuario.getRowCount() >= 2) {
                            ExportarExcel.setEnabled(true);
                        } else {
                            ExportarExcel.setEnabled(false);
                        }
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        ExportarExcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblEstadoCuadrado = new javax.swing.JLabel();
        lblTotalHaber = new javax.swing.JLabel();
        lblTotalDebe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(206, 221, 255));

        TablaUsuario.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Código", "Correlativo", "Descripción", "Debe", "Haber"
            }
        ));
        TablaUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        ExportarExcel.setBackground(new java.awt.Color(32, 163, 66));
        ExportarExcel.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        ExportarExcel.setText("Exportar a Excel");
        ExportarExcel.setEnabled(false);
        ExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarExcelActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(206, 221, 255));

        jTable1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Periodo", "Fecha inicio", "Fecha fin", "Descripción", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(206, 221, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Historial de cuentas");

        lblEstadoCuadrado.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        lblEstadoCuadrado.setForeground(new java.awt.Color(0, 0, 0));
        lblEstadoCuadrado.setText("?");

        lblTotalHaber.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        lblTotalHaber.setForeground(new java.awt.Color(51, 51, 255));
        lblTotalHaber.setText("Q.");

        lblTotalDebe.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        lblTotalDebe.setForeground(new java.awt.Color(51, 51, 255));
        lblTotalDebe.setText("Q.");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Haber:");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Debe:");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalDebe)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalHaber)
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadoCuadrado)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEstadoCuadrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTotalDebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTotalHaber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(206, 221, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Partidas");

        txtBuscar.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Buscar partida:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(282, 282, 282)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarExcelActionPerformed
        if (!verificarSuma()) {
            JOptionPane.showMessageDialog(this, "Los totales no cuadran", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        exportarExcel(TablaUsuario);
    }//GEN-LAST:event_ExportarExcelActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String textoBusqueda = txtBuscar.getText().trim();
        if (textoBusqueda.length() == 0) {
//            sorterPartidas.setRowFilter(null);
            sorterPeriodos.setRowFilter(null);
        } else {
            try {
//                sorterPartidas.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
                sorterPeriodos.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
            } catch (Exception e) {
                System.out.println("Error al filtrar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

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

            lblTotalDebe.setText("Q. " + String.format("%.2f", sumaDebe));
            lblTotalHaber.setText("Q. " + String.format("%.2f", sumaHaber));

            if (Math.abs(sumaDebe - sumaHaber) < 0.01) {
                lblEstadoCuadrado.setText("CUADRADO " + String.format("%.2f", sumaDebe) + "/" + String.format("%.2f", sumaHaber));
                lblEstadoCuadrado.setForeground(new java.awt.Color(46, 204, 113));
            } else {
                double dif = Math.abs(sumaDebe - sumaHaber);
                lblEstadoCuadrado.setText("DESCUADRADO (Dif: Q." + String.format("%.2f", dif) + ")");
                lblEstadoCuadrado.setForeground(new java.awt.Color(231, 76, 60));
            }
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
                org.apache.poi.ss.usermodel.Font fuenteHeader = libro.createFont();
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

    void mostrar() {
        Métodos objetoCrudd = new Métodos();
        DB.Métodos metodos = new DB.Métodos();
        jTable1.setModel(metodos.LeerDatosPeriodoLibroDiario());
//        TablaUsuario.setModel(objetoCrudd.LeerDatosLibroDiario());
//        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
//        sorterPartidas = new TableRowSorter<>(modelo);
//        TablaUsuario.setRowSorter(sorterPartidas);

        DefaultTableModel modeloP = (DefaultTableModel) jTable1.getModel();
        sorterPeriodos = new TableRowSorter<>(modeloP);
        jTable1.setRowSorter(sorterPeriodos);
//        calcularTotalesEnTabla();
    }

//    void nuevo() {
//        TextoCódigo.setText("");
//        TextoCorrelativo.setValue("P No.");
//        TextoFecha.setValue("  /  /    ");
//        Cuentas.removeAllItems();
//        Cuentas.addItem("Seleccione la cuenta");
//        cargarCuentasEnCombo();
//        Cuentas.setSelectedIndex(0);
//        TextoDeudor.setValue(null);
//        TextoAcreedor.setValue(null);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExportarExcel;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstadoCuadrado;
    private javax.swing.JLabel lblTotalDebe;
    private javax.swing.JLabel lblTotalHaber;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
