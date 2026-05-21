package Ventanas;

import DB.Métodos;
import java.awt.Font;
import javax.swing.table.TableColumn;

/**
 *
 * @author Raven
 */
public class BancoDeCuentas extends javax.swing.JPanel {

    public BancoDeCuentas() {
        initComponents();
        cargarTablaCuentas();
        TablaCuentas.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(315);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCuentas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1095, 813));

        jPanel2.setBackground(new java.awt.Color(206, 221, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 717));

        TablaCuentas.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TablaCuentas.setForeground(new java.awt.Color(0, 0, 0));
        TablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Cuenta", "Debe", "Haber", "Perdida", "Ganancia", "Activo", "Pasivo"
            }
        ));
        TablaCuentas.setGridColor(new java.awt.Color(0, 0, 0));
        TablaCuentas.setShowGrid(true);
        TablaCuentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaCuentas);

        jLabel3.setText("Clasificación de cuentas");
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1095, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1095, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTablaCuentas() {
        Métodos objetoCrudd = new Métodos();
        TablaCuentas.setModel(objetoCrudd.LeerBancCuentas());
        TableColumn columnaNo = TablaCuentas.getColumnModel().getColumn(0);
        columnaNo.setPreferredWidth(35);
        TableColumn columnaCuenta = TablaCuentas.getColumnModel().getColumn(1);
        columnaCuenta.setPreferredWidth(280);
        TableColumn columnaGan = TablaCuentas.getColumnModel().getColumn(5);
        columnaGan.setPreferredWidth(100);
        TablaCuentas.getTableHeader().setBackground(new java.awt.Color(40, 40, 40));
        TablaCuentas.getTableHeader().setForeground(java.awt.Color.WHITE);
        TablaCuentas.getTableHeader().setFont(new Font("TW Cent MT", Font.BOLD, 12));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCuentas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
