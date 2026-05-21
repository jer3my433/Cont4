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

public class LibroMayor extends javax.swing.JPanel {

    private TableRowSorter<DefaultTableModel> sorterCuentas;

    public LibroMayor() {
        initComponents();
        jTable1.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        jTable1.getTableHeader().setForeground(java.awt.Color.BLACK);
        jTable1.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 14));
        TablaUsuario.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        TablaUsuario.getTableHeader().setForeground(java.awt.Color.BLACK);
        TablaUsuario.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 14));
        mostrar();
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    if (jTable1.getSelectedRow() != -1) {
                        try {
                            String cuentaSeleccionada = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                            DB.Métodos metodos = new DB.Métodos();
                            TablaUsuario.setModel(metodos.LeerDetalleCuentaMayor(cuentaSeleccionada));
                              double sumaDebe = 0, sumaHaber = 0;
                    DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        try {
                            sumaDebe  += Double.parseDouble(modelo.getValueAt(i, 3).toString());
                            sumaHaber += Double.parseDouble(modelo.getValueAt(i, 4).toString());
                        } catch (Exception ex) {}
                    }

                    calcularTotales(sumaDebe, sumaHaber);
                        } catch (Exception e) {
                            System.out.println("Error al cambiar de cuenta: " + e.getMessage());
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTotalDebe = new javax.swing.JLabel();
        lblTotalHaber = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        ExportarExcel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1124, 712));

        jPanel3.setBackground(new java.awt.Color(206, 221, 255));

        TablaUsuario.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Código", "Descripción", "Debe", "Haber", "Saldo"
            }
        ));
        TablaUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaUsuario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        lblTotalDebe.setText("jLabel3");

        lblTotalHaber.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(lblTotalDebe)
                .addGap(79, 79, 79)
                .addComponent(lblTotalHaber)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalDebe)
                    .addComponent(lblTotalHaber))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(206, 221, 255));

        jTable1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Periodo", "Código", "Cuenta", "Deudor", "Acreedor"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lista de cuentas");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar cuentas:");

        txtBuscar.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            sorterCuentas.setRowFilter(null);
        } else {
            try {
                sorterCuentas.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
            } catch (Exception e) {
                System.out.println("Error al filtrar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    void mostrar() {
        Métodos ObjetoCrudd = new Métodos();
        jTable1.setModel(ObjetoCrudd.LeerCuentasMayor());
        if (TablaUsuario.getRowCount() >= 2) {
            ExportarExcel.setEnabled(true);
        } else {
            ExportarExcel.setEnabled(false);
        }
        DefaultTableModel modeloP = (DefaultTableModel) jTable1.getModel();
        sorterCuentas = new TableRowSorter<>(modeloP);
        jTable1.setRowSorter(sorterCuentas);
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
                sumaDebe += Double.parseDouble(modelo.getValueAt(i, 3).toString());
                sumaHaber += Double.parseDouble(modelo.getValueAt(i, 4).toString());
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

    public void obtenercuentas() {
        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
        Métodos objeto = new Métodos();
        if (modelo.getRowCount() >= 2) {
            double sumaDebe = 0;
            double sumaHaber = 0;

            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0) != null && modelo.getValueAt(i, 0).toString().equals("TOTAL")) {
                    continue;
                }

                try {
                    double debe = Double.parseDouble(modelo.getValueAt(i, 3).toString());
                    double haber = Double.parseDouble(modelo.getValueAt(i, 4).toString());
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
            filaTotal[2] = "TOTAL";
            filaTotal[3] = String.format("%.2f", sumaDebe);
            filaTotal[4] = String.format("%.2f", sumaHaber);
            modelo.addRow(filaTotal);

        }

    }

   // 1. Recibe los totales, agrega la fila TOTAL y llama a guardar en BD
public void calcularTotales(double sumaDebe, double sumaHaber) {
    DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
    if (modelo.getRowCount() < 1) return;

    // Elimina fila TOTAL anterior si existe
    for (int i = 0; i < modelo.getRowCount(); i++) {
        if (modelo.getValueAt(i, 0) != null && modelo.getValueAt(i, 0).toString().equals("TOTAL")) {
            modelo.removeRow(i);
            break;
        }
    }

    // Agrega fila TOTAL con los valores recibidos por parámetro (sin volver a sumar)
    Object[] filaTotal = new Object[modelo.getColumnCount()];
    filaTotal[2] = "TOTAL";
    filaTotal[3] = String.format("%.2f", sumaDebe);
    filaTotal[4] = String.format("%.2f", sumaHaber);
    modelo.addRow(filaTotal);

    // Pasa los mismos totales directamente a calcularTotalesEnTabla
    calcularTotalesEnTabla(sumaDebe, sumaHaber);
}

// 2. Recibe debe y haber ya calculados, extrae fecha/codigo/cuenta de la tabla y guarda en BD
public void calcularTotalesEnTabla(double sumaDebe, double sumaHaber) {
    DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
    if (modelo.getRowCount() == 0) return;

    try {
        // Extrae fecha, código y cuenta de la primera fila real (fila 0)
        Object fechaObj  = modelo.getValueAt(0, 0);
        Object codigoObj = modelo.getValueAt(0, 1);
        Object cuentaObj = modelo.getValueAt(0, 2);

        String fecha  = (fechaObj  != null) ? fechaObj.toString().trim()  : new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        String codigo = (codigoObj != null) ? codigoObj.toString().trim() : "";
        String cuenta = (cuentaObj != null) ? cuentaObj.toString().trim() : "";

        // Usa los totales que llegaron por parámetro, NO los lee de la tabla
        DB.Métodos metodosDB = new DB.Métodos();
        metodosDB.insertarDatosLibroMayor(codigo, fecha, cuenta, sumaDebe, sumaHaber);

    } catch (Exception e) {
        System.err.println("Error al procesar y guardar datos: " + e.getMessage());
    }
}
//    public double[] obtenerTotalesTablaMayor() {
//        double totalDebe = 0.0;
//        double totalHaber = 0.0;
//        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
//        int limiteFilas = modelo.getRowCount();
//
//        for (int i = 0; i < limiteFilas; i++) {
//            if (modelo.getValueAt(i, 2) != null && modelo.getValueAt(i, 2).toString().equals("TOTAL")) {
//                try {
//
//                    if (modelo.getValueAt(i, 3) != null) {
//                        totalDebe = Double.parseDouble(modelo.getValueAt(i, 3).toString());
//                    }
//                    if (modelo.getValueAt(i, 4) != null) {
//                        totalHaber = Double.parseDouble(modelo.getValueAt(i, 4).toString());
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Error al leer la fila TOTAL en la fila " + i + ": " + e.getMessage());
//                }
//                break;
//            }
//        }
//
//        return new double[]{totalDebe, totalHaber};
//    }
//
//    public void calcularYAgregarFilaTotal() {
//        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
//        if (modelo != null) {
//            double sumaDebe = 0;
//            double sumaHaber = 0;
//            String cuenta = "";
//            String fechaMovimiento = "";
//            int codigo = 0;
//
//            // 1. OBTENER LA FECHA: Extraemos la fecha de la primera fila (fila 0), primera columna (columna 0)
//            if (modelo.getRowCount() > 0 && modelo.getValueAt(0, 0) != null) {
//                fechaMovimiento = modelo.getValueAt(0, 0).toString();
//                codigo = (int) modelo.getValueAt(0, 1);
//                cuenta = modelo.getValueAt(0, 2).toString();
//            } else {
//                // Si por alguna razón la tabla no tiene filas, usamos una fecha por defecto/actual
//                fechaMovimiento = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
//            }
//
//            // 2. Recorremos la tabla para calcular las sumas
//            for (int i = 0; i < modelo.getRowCount(); i++) {
//                try {
//                    if (modelo.getValueAt(i, 2) != null && modelo.getValueAt(i, 2).toString().equals("TOTAL")) {
//                        continue;
//                    }
//                    if (modelo.getValueAt(i, 3) != null) {
//                        sumaDebe += Double.parseDouble(modelo.getValueAt(i, 3).toString());
//                    }
//                    if (modelo.getValueAt(i, 4) != null) {
//                        sumaHaber += Double.parseDouble(modelo.getValueAt(i, 4).toString());
//                    }
//                } catch (Exception e) {
//                }
//            }
//            Object[] filaTotal = new Object[modelo.getColumnCount()];
//            filaTotal[2] = "TOTAL";
//            filaTotal[3] = String.format("%.2f", sumaDebe);
//            filaTotal[4] = String.format("%.2f", sumaHaber);
//            modelo.addRow(filaTotal);
//           if (sumaDebe > 0 || sumaHaber > 0) {
//    try {
//        DB.Métodos metodosDB = new DB.Métodos();
//        
//        // CORRECCIÓN: Como jTable1 NO tiene fecha en sus columnas, 
//        // usamos la fecha de hoy para registrar cuándo se consolidó este libro mayor.
//        java.util.Date fechaSegura = new java.util.Date(); 
//        
//        // Enviamos a guardar a la base de datos
//        metodosDB.guardarTotalLibroMayor(codigo, cuenta, sumaDebe, sumaHaber, fechaSegura);
//        
//    } catch (Exception e) {
//        System.out.println("Error al intentar guardar en libro_mayor: " + e.getMessage());
//    }
//            } else {
//                System.out.println("Cuenta sin movimientos (" + codigo + "). No se sube a MySQL Workbench.");
//            }
//
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExportarExcel;
    public javax.swing.JTable TablaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTotalDebe;
    private javax.swing.JLabel lblTotalHaber;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
