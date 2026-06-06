package view;

import javax.swing.JOptionPane;

public class HomeAdmin extends javax.swing.JFrame {

    public HomeAdmin() {
        initComponents();
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở chính giữa màn hình
        styleUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRevenue = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtManage = new javax.swing.JButton();
        btnFare = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Trang quản lý ADMIN");

        btnRevenue.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/revenue.png"))); // NOI18N
        btnRevenue.setText("Thống kê thu nhập");
        btnRevenue.setPreferredSize(new java.awt.Dimension(135, 40));
        btnRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenueActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnExit.setText("Thoát khỏi ứng dụng");
        btnExit.setPreferredSize(new java.awt.Dimension(135, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnLogout.setText("Đăng xuất tài khoản");
        btnLogout.setPreferredSize(new java.awt.Dimension(135, 40));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(135, 40));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtManage.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txtManage.setText("Quản lý người dùng");
        txtManage.setPreferredSize(new java.awt.Dimension(169, 40));
        txtManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManageActionPerformed(evt);
            }
        });

        btnFare.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnFare.setText("Điều chỉnh giá vé");
        btnFare.setPreferredSize(new java.awt.Dimension(169, 40));
        btnFare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFareActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel3.setText("Chọn chức năng cho admin ....");

        btnChangePassword.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnChangePassword.setText("Đổi mật khẩu");
        btnChangePassword.setPreferredSize(new java.awt.Dimension(169, 40));
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnHistory.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnHistory.setText("Lịch sử người dùng");
        btnHistory.setPreferredSize(new java.awt.Dimension(169, 40));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(211, 211, 211))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(338, 338, 338)
                            .addComponent(txtManage, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRevenue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFare, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            new LoginAdmin().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.dispose();
        new Search().setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        this.dispose();
        new Revenue().setVisible(true);
    }//GEN-LAST:event_btnRevenueActionPerformed

    private void txtManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManageActionPerformed
        this.dispose();
        new UserManagement().setVisible(true);
    }//GEN-LAST:event_txtManageActionPerformed

    // Hàm thực thi sự kiện khi Admin nhấn nút Config Fare
    private void btnFareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigFareActionPerformed
        this.dispose();
        new FareManagement().setVisible(true); // Mở giao diện cấu hình giá vé
    }//GEN-LAST:event_btnConfigFareActionPerformed

    private void btnConfigFareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFareActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FareManagement().setVisible(true);
    }//GEN-LAST:event_btnFareActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoryActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }
    private void styleUI() {

   // ===== BACKGROUND =====
    jPanel1.setBackground(new java.awt.Color(236, 240, 241));
    getContentPane().setBackground(new java.awt.Color(236, 240, 241));

    // ===== TITLE =====
    jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 32));
    jLabel1.setForeground(new java.awt.Color(44, 62, 80));

    // ===== SUBTITLE =====
    jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
    jLabel3.setForeground(new java.awt.Color(127, 140, 141));

    // ===== MAIN BUTTONS =====
    styleButton(btnRevenue, new java.awt.Color(52, 152, 219));
    styleButton(btnSearch, new java.awt.Color(155, 89, 182));
    styleButton(txtManage, new java.awt.Color(46, 204, 113));

    // ===== NEW BUTTONS =====
    styleButton(btnFare, new java.awt.Color(230, 126, 34));            // cam
    styleButton(btnChangePassword, new java.awt.Color(52, 73, 94));    // xám đậm
    styleButton(btnHistory, new java.awt.Color(22, 160, 133));         // xanh ngọc

    // ===== SYSTEM BUTTONS =====
    styleButton(btnExit, new java.awt.Color(231, 76, 60));
    styleButton(btnLogout, new java.awt.Color(241, 196, 15));

    // ===== SIZE UNIFORM =====
    btnRevenue.setPreferredSize(new java.awt.Dimension(200, 60));
    btnSearch.setPreferredSize(new java.awt.Dimension(200, 60));
    txtManage.setPreferredSize(new java.awt.Dimension(200, 60));

    btnFare.setPreferredSize(new java.awt.Dimension(200, 60));
    btnChangePassword.setPreferredSize(new java.awt.Dimension(200, 60));
    btnHistory.setPreferredSize(new java.awt.Dimension(200, 60));

    btnExit.setPreferredSize(new java.awt.Dimension(200, 50));
    btnLogout.setPreferredSize(new java.awt.Dimension(200, 50));
}
    private void styleButton(javax.swing.JButton btn, java.awt.Color color) {

    btn.setBackground(color);
    btn.setForeground(java.awt.Color.WHITE);
    btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFare;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtManage;
    // End of variables declaration//GEN-END:variables
}