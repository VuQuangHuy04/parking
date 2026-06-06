
package view;

import javax.swing.JOptionPane;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
        styleUI();
        setLocationRelativeTo(null);
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLoginAdmin = new javax.swing.JButton();
        btnLoginStaff = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("WELCOME TO E-PARKING HAUI");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel2.setText("Chọn 1 option để bắt đầu");

        btnLoginAdmin.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnLoginAdmin.setText("Login with Admin");
        btnLoginAdmin.setPreferredSize(new java.awt.Dimension(170, 40));
        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAdminActionPerformed(evt);
            }
        });

        btnLoginStaff.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnLoginStaff.setText("Login with Staff");
        btnLoginStaff.setPreferredSize(new java.awt.Dimension(170, 40));
        btnLoginStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginStaffActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnExit.setText("Thoát khỏi ứng dụng");
        btnExit.setPreferredSize(new java.awt.Dimension(95, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoginStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(btnLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoginStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAdminActionPerformed
        this.dispose();
        LoginAdmin a1 = new LoginAdmin();
        a1.setVisible(true);
    }//GEN-LAST:event_btnLoginAdminActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); 
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginStaffActionPerformed
        this.dispose();
        LoginStaff a1 = new LoginStaff();
        a1.setVisible(true);
    }//GEN-LAST:event_btnLoginStaffActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }
    private void styleUI() {

    // ===== BACKGROUND PANEL =====
    jPanel1.setBackground(new java.awt.Color(245, 247, 250));

    // ===== TITLE =====
    jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 34));
    jLabel1.setForeground(new java.awt.Color(25, 42, 86));

    jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
    jLabel2.setForeground(new java.awt.Color(80, 80, 80));

    // ===== BUTTON ADMIN =====
    btnLoginAdmin.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
    btnLoginAdmin.setBackground(new java.awt.Color(52, 152, 219));
    btnLoginAdmin.setForeground(java.awt.Color.WHITE);
    btnLoginAdmin.setFocusPainted(false);
    btnLoginAdmin.setBorderPainted(false);
    btnLoginAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    // ===== BUTTON STAFF =====
    btnLoginStaff.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
    btnLoginStaff.setBackground(new java.awt.Color(46, 204, 113));
    btnLoginStaff.setForeground(java.awt.Color.WHITE);
    btnLoginStaff.setFocusPainted(false);
    btnLoginStaff.setBorderPainted(false);
    btnLoginStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    // ===== BUTTON EXIT =====
    btnExit.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
    btnExit.setBackground(new java.awt.Color(231, 76, 60));
    btnExit.setForeground(java.awt.Color.WHITE);
    btnExit.setFocusPainted(false);
    btnExit.setBorderPainted(false);
    btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    // ===== BUTTON SIZE UNIFORM =====
    btnLoginAdmin.setPreferredSize(new java.awt.Dimension(180, 45));
    btnLoginStaff.setPreferredSize(new java.awt.Dimension(180, 45));
    btnExit.setPreferredSize(new java.awt.Dimension(120, 40));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoginAdmin;
    private javax.swing.JButton btnLoginStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
