package raven.application.form;

import DB.Crudd;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import raven.application.Application;

public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("al center center"));
        lbError.setVisible(false);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
//        lbError.putClientProperty(FlatClientProperties.STYLE, ""
//        + "foreground:#e63946;" // Un rojo suave
//        + "font:-1;");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese el usuario");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new raven.application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();

        panelLogin1.setBackground(new java.awt.Color(204, 204, 255));

        lbTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Inicio de sesión");
        panelLogin1.add(lbTitle);

        lbUser.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        lbUser.setText("Usuario");
        panelLogin1.add(lbUser);

        txtUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        panelLogin1.add(txtUser);

        lbPass.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        lbPass.setText("Contraseña");
        panelLogin1.add(lbPass);

        txtPass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });
        panelLogin1.add(txtPass);

        cmdLogin.setBackground(new java.awt.Color(132, 132, 255));
        cmdLogin.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        cmdLogin.setText("Iniciar sesión");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        lbError.setBackground(new java.awt.Color(204, 204, 255));
        lbError.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(232, 64, 64));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbError.setText("El usuario o contraseña son incorrectos");
        lbError.setOpaque(true);
        panelLogin1.add(lbError);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        String userIn = txtUser.getText();
        String passIn = new String(txtPass.getPassword());

        Crudd objeto = new Crudd();
        if (objeto.autenticar(userIn, passIn)) {
            lbError.setVisible(false);
            Application.login();
        } else {
            lbError.setVisible(true);
        }
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        lbError.setVisible(false);
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        lbError.setVisible(false);
    }//GEN-LAST:event_txtPassKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private raven.application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
