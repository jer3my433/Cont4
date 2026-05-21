package Ventanas;

import DB.Métodos;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BalanceDeSaldos extends javax.swing.JPanel {

    private int idPeriodoSeleccionado = -1;

    public BalanceDeSaldos() {
        initComponents();
        cargarPeriodosEnCombo();
        mostrar();
        jLabelFiltro = new javax.swing.JLabel("Filtrar por período:");
        jLabelFiltro.setFont(new java.awt.Font("Tw Cen MT", java.awt.Font.BOLD, 14));

        comboPeriodo = new javax.swing.JComboBox<>();
        comboPeriodo.setFont(new java.awt.Font("Tw Cen MT", 0, 14));

        lblCuadre = new javax.swing.JLabel("--");
        lblCuadre.setFont(new java.awt.Font("Tw Cen MT", java.awt.Font.BOLD, 14));

// Agregalos al jPanel8 con un layout sencillo
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        jPanel8.add(jLabelFiltro);
        jPanel8.add(comboPeriodo);
        jPanel8.add(lblCuadre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        comboPeriodo = new javax.swing.JComboBox<>();
        lblCuadre = new javax.swing.JLabel();
        jLabelFiltro = new javax.swing.JLabel();
        exportarExcel = new javax.swing.JButton();

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
                "Código", "Cuenta", "Total debe", "Total haber", "Saldo deudor", "Saldo acreedor"
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(206, 221, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        comboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCuadre.setText("jLabel1");

        jLabelFiltro.setText("jLabel1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(lblCuadre)))
                .addGap(48, 48, 48)
                .addComponent(jLabelFiltro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(comboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCuadre))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabelFiltro)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        exportarExcel.setBackground(new java.awt.Color(32, 163, 66));
        exportarExcel.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        exportarExcel.setText("Exportar a Excel");
        exportarExcel.setEnabled(false);
        exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(exportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarExcelActionPerformed
        if (!verificarSuma()) {
            JOptionPane.showMessageDialog(this, "Los totales no cuadran", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        exportarExcel(TablaUsuario);
    }//GEN-LAST:event_exportarExcelActionPerformed
    private void cargarPeriodosEnCombo() {
        Métodos objeto = new Métodos();
        DefaultTableModel modeloPeriodos = objeto.LeerDatosPeriodo();

        comboPeriodo.addItem("-- Todos los períodos --"); // opción por defecto
        for (int i = 0; i < modeloPeriodos.getRowCount(); i++) {
            int id = (int) modeloPeriodos.getValueAt(i, 0);
            String desc = modeloPeriodos.getValueAt(i, 3).toString();
            String inicio = modeloPeriodos.getValueAt(i, 1).toString();
            String fin = modeloPeriodos.getValueAt(i, 2).toString();
            comboPeriodo.addItem(id + " | " + desc + " (" + inicio + " - " + fin + ")");
        }

        comboPeriodo.addActionListener(e -> {
            int index = comboPeriodo.getSelectedIndex();
            if (index <= 0) {
                idPeriodoSeleccionado = -1;
            } else {
                // Extrae el id del texto "1 | Descripcion (fecha - fecha)"
                String seleccionado = comboPeriodo.getSelectedItem().toString();
                idPeriodoSeleccionado = Integer.parseInt(seleccionado.split("\\|")[0].trim());
            }
            mostrar();
        });
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

    private void verificarCuadre() {
        DefaultTableModel modelo = (DefaultTableModel) TablaUsuario.getModel();
        double sumaDebe = 0, sumaHaber = 0;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            // Salta la fila de Sumas
            Object cuenta = modelo.getValueAt(i, 1);
            if (cuenta != null && cuenta.toString().equals("Sumas")) {
                continue;
            }
            try {
                sumaDebe += Double.parseDouble(modelo.getValueAt(i, 2).toString());
                sumaHaber += Double.parseDouble(modelo.getValueAt(i, 3).toString());
            } catch (Exception ex) {
            }
        }

        boolean cuadra = Math.abs(sumaDebe - sumaHaber) < 0.01;
        lblCuadre.setText(cuadra ? "✔ Balance cuadrado" : "✘ Balance no cuadra");
        lblCuadre.setForeground(cuadra
                ? new java.awt.Color(0, 153, 0)
                : new java.awt.Color(204, 0, 0));
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
        if (TablaUsuario.getRowCount() >= 2) {
            exportarExcel.setEnabled(true);
        } else {
            exportarExcel.setEnabled(false);
        }
        Métodos objeto = new Métodos();
        TablaUsuario.setModel(objeto.obtenerTotalesDesdeLibroMayor());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JComboBox<String> comboPeriodo;
    private javax.swing.JButton exportarExcel;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCuadre;
    // End of variables declaration//GEN-END:variables
}
