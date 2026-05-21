package Ventanas;

import DB.Métodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import raven.application.Application;

public class Periodos extends javax.swing.JPanel {

    public Periodos() {
        initComponents();
        TablaUsuario.getTableHeader().setBackground(new java.awt.Color(204, 204, 204));
        TablaUsuario.getTableHeader().setForeground(java.awt.Color.BLACK);
        TablaUsuario.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 14));
        mostrar();
        jDateChooser1.setMaxSelectableDate(new Date());
        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.setMaxSelectableDate(new Date());
        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        TablaUsuario.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        TablaUsuario.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(TablaUsuario, this));
        TablaUsuario.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int row = TablaUsuario.getSelectedRow();
                    int col = TablaUsuario.getSelectedColumn();

                    if (row != -1 && col < 4) {
                        try {
                            Object valInicio = TablaUsuario.getValueAt(row, 1);
                            Object valFin = TablaUsuario.getValueAt(row, 2);
                            Object valDesc = TablaUsuario.getValueAt(row, 3);

                            TextoDesc.setText(valDesc != null ? valDesc.toString() : "");

                            SimpleDateFormat sdfBD = new SimpleDateFormat("yyyy-MM-dd");
                            if (valInicio != null && valFin != null) {
                                jDateChooser1.setDate(sdfBD.parse(valInicio.toString()));
                                jDateChooser2.setDate(sdfBD.parse(valFin.toString()));
                            }
                        } catch (Exception ex) {
                            System.out.println("Error al cargar datos en campos: " + ex.getMessage());
                        }
                    }
                }
            }
        });
        jDateChooser1.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date fechaInicio = jDateChooser1.getDate();
                    if (fechaInicio != null) {
                        jDateChooser2.setMinSelectableDate(fechaInicio);
                        Date fechaFin = jDateChooser2.getDate();
                        if (fechaFin != null && fechaFin.before(fechaInicio)) {
                            jDateChooser2.setDate(null);
                        }
                    } else {
                        jDateChooser2.setMinSelectableDate(null);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        TextoDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(206, 221, 255));

        Agregar.setBackground(new java.awt.Color(102, 204, 127));
        Agregar.setText("Agregar");
        Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        Eliminar.setText("Eliminar");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Eliminar))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(206, 221, 255));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Descripción");

        jDateChooser1.setToolTipText("");
        jDateChooser1.setMaxSelectableDate(new java.util.Date(253370790116000L));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Desde");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Hasta");

        jDateChooser2.setToolTipText("");
        jDateChooser2.setMaxSelectableDate(new java.util.Date(253370790116000L));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoDesc)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 373, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(TextoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(206, 221, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingresar periodos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(206, 221, 255));

        TablaUsuario.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Periodo", "Fecha inicio", "Fecha fin", "Descripción", "Estado", "Archivo"
            }
        ));
        TablaUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaUsuario);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(206, 221, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lista de periodos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if (TablaUsuario.getSelectedRow() == -1) {
            try {
                if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null || TextoDesc.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos para crear un nuevo periodo.");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaInicio = jDateChooser1.getDate();
                Date fechaFin = jDateChooser2.getDate();
                String descripcion = TextoDesc.getText();
                Date fechaAc = new Date();
                if (fechaInicio.after(fechaAc) || fechaFin.after(fechaAc)) {
                    JOptionPane.showMessageDialog(this, "Ingrese una fecha actual");
                    return;
                }

                String fechaInicioStr = (fechaInicio != null) ? sdf.format(fechaInicio) : "";
                String fechaFinStr = (fechaFin != null) ? sdf.format(fechaFin) : "";
                DB.Métodos metodos = new DB.Métodos();
                metodos.InsertarDatosPeriodo(fechaInicioStr, fechaFinStr, descripcion);
                mostrar();
                nuevo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
            }
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaInicio = sdf.format(jDateChooser1.getDate());
                String fechaFin = sdf.format(jDateChooser2.getDate());
                String descripcion = TextoDesc.getText();
                int idPeriodo = Integer.parseInt(TablaUsuario.getValueAt(TablaUsuario.getSelectedRow(), 0).toString());
                DB.Métodos metodos = new DB.Métodos();
                metodos.ActualizarDatosPeriodo(fechaInicio, fechaFin, descripcion, idPeriodo);
                mostrar();
                nuevo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
            }
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = TablaUsuario.getSelectedRow();
        if (fila != -1) {
            int idPeriodo = Integer.parseInt(TablaUsuario.getValueAt(fila, 0).toString());
            String nombrePeriodo = TablaUsuario.getValueAt(fila, 3).toString();

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro de que deseas eliminar este registro?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    Métodos objetoCrudd = new Métodos();
                    objetoCrudd.EliminarPeriodo(idPeriodo);
                    mostrar();
                    nuevo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el periodo " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un periodo de la tabla");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    void nuevo() {
        TextoDesc.setText(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }

    void mostrar() {
        Métodos objeto = new Métodos();
        TablaUsuario.setModel(objeto.LeerDatosPeriodo());
        TablaUsuario.setRowHeight(25);
        javax.swing.Action accionEstado = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int row = Integer.parseInt(e.getActionCommand());
                int idPeriodo = (int) TablaUsuario.getModel().getValueAt(row, 0);
                Object valorActual = TablaUsuario.getValueAt(row, 4);

                String estadoActual = (valorActual == null) ? "Cerrado" : valorActual.toString();
                String nuevoEstado = estadoActual.equals("Abierto") ? "Cerrado" : "Abierto";

                // Guardamos en la base de datos
                Métodos op = new Métodos();
                op.ActualizarEstadoPeriodo(idPeriodo, nuevoEstado);

                // Refrescamos la interfaz completa
                mostrar();

                // Forzamos la limpieza asíncrona de focos fantasma para permitir clics continuos
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        TablaUsuario.getSelectionModel().clearSelection();
                        TablaUsuario.requestFocusInWindow();
                    }
                });
            }
        };
        // Vinculamos de forma única la columna 4 al componente de botón interactivo
        new ButtonColumn(TablaUsuario, accionEstado, 4);

        // ACCIÓN PARA LA COLUMNA DE ARCHIVO / JORNALIZACIÓN (COLUMNA 5)
        javax.swing.Action accionIngresar = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int row = Integer.parseInt(e.getActionCommand());
                String estado = TablaUsuario.getValueAt(row, 4).toString();

                if (estado.equals("Abierto")) {
                    try {
                        int idPeriodo = Integer.parseInt(TablaUsuario.getValueAt(row, 0).toString());
                        String fechaInicioStr = TablaUsuario.getModel().getValueAt(row, 1).toString();
                        String fechaFinStr = TablaUsuario.getModel().getValueAt(row, 2).toString();
                        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        Date fechaInicio = sdf.parse(fechaInicioStr);
                        Date fechaFin = sdf.parse(fechaFinStr);
                        Application.showForm(new Jornalización(idPeriodo, fechaInicio, fechaFin));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Periodos.this, "Error al leer las fechas del periodo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe abrir el periodo primero");
                }
            }
        };
        new ButtonColumn(TablaUsuario, accionIngresar, 5);
    }

    class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

        private JTable table;
        private Action action;
        private JToggleButton renderButton;
        private JToggleButton editButton;
        private Object editorValue;

        public ButtonColumn(JTable table, Action action, int column) {
            this.table = table;
            this.action = action;
            renderButton = new JToggleButton();
            editButton = new JToggleButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String texto = (value == null) ? "Cerrado" : value.toString();
            renderButton.setText(texto);
            renderButton.setSelected(texto.equals("Abierto"));
            return renderButton;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            String texto = (value == null) ? "Cerrado" : value.toString();
            editButton.setText(texto);
            editButton.setSelected(texto.equals("Abierto"));
            editorValue = texto;
            return editButton;
        }

        @Override
        public Object getCellEditorValue() {
            return editorValue;
        }

        public void actionPerformed(ActionEvent e) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            fireEditingStopped();
            ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, "" + row);
            action.actionPerformed(event);
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
//
//            if ("Abierto".equals(value.toString())) {
//                setBackground(new Color(102, 204, 127));
//                setForeground(Color.WHITE);
//            } else {
//                setBackground(new Color(255, 102, 102));
//                setForeground(Color.WHITE);
//            }

            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

        private JButton button;
        private String label;
        private JTable table;
        private int row;
        private String estado;
        private Periodos parent;

        public ButtonEditor(JTable table, Periodos parent) {
            this.table = table;
            this.parent = parent;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            this.row = row;
            estado = (value == null) ? "Cerrado" : value.toString();
            label = estado;

//            if ("Abierto".equals(estado)) {
//                button.setBackground(new Color(102, 204, 127));
//                button.setForeground(Color.WHITE);
//            } else {
//                button.setBackground(new Color(255, 102, 102));
//                button.setForeground(Color.WHITE);
//            }
            button.setText(label);
            return button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nuevoEstado = "Abierto".equals(estado) ? "Cerrado" : "Abierto";
            int idPeriodo = (int) table.getValueAt(row, 0);
            Métodos op = new Métodos();
            op.ActualizarEstadoPeriodo(idPeriodo, nuevoEstado);

            table.setValueAt(nuevoEstado, row, 4);
            fireEditingStopped();

            table.repaint();
            parent.mostrar();
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTable TablaUsuario;
    private javax.swing.JTextField TextoDesc;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
