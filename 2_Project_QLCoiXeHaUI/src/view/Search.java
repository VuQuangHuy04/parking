
package view;

import dao.SearchDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ticket;
import utils.DateValidator;
import utils.LicensePlateValidator;
import utils.TicketIdValidator;

public class Search extends javax.swing.JFrame {

    public Search() {
        initComponents();
        
        javax.swing.table.JTableHeader header = tblResult.getTableHeader();
        javax.swing.table.DefaultTableCellRenderer headerRenderer = (javax.swing.table.DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        
        tblResult.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"TicketID", "License Plate", "Vehicle Type", "Date", "Checkin", "Checkout"}));
        styleUI();
        cboVehicles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Car", "Motorbike" }));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cboType = new javax.swing.JComboBox<>();
        txtInput = new javax.swing.JTextField();
        cboVehicles = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ticket ID", "License Plate", "Vehicle Type", "Date", "Check-in", "Check-out"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.setPreferredSize(new java.awt.Dimension(130, 35));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(130, 35));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(130, 35));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setPreferredSize(new java.awt.Dimension(130, 35));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        cboType.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ticket ID", "License Plate", "Date" }));
        cboType.setPreferredSize(new java.awt.Dimension(120, 35));
        cboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTypeActionPerformed(evt);
            }
        });

        txtInput.setPreferredSize(new java.awt.Dimension(200, 35));

        cboVehicles.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cboVehicles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Car", "Motorbike" }));
        cboVehicles.setPreferredSize(new java.awt.Dimension(120, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cboVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 26)); // NOI18N
        jLabel1.setText("Tìm kiếm phương tiện");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new HomeAdmin().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); 
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtInput.getText().trim();
        String fieldSelected = cboType.getSelectedItem().toString();
        String vehicleType = cboVehicles.getSelectedItem().toString();

        String field;
        switch (fieldSelected) {
            case "License Plate": field = "license_plate"; break;
            case "Date": field = "parking_date"; break;
            case "Ticket ID": field = "ticket_id"; break;
            default: field = "ticket_id";
        }
        
        if (field.equals("license_plate") && !LicensePlateValidator.isValidLicensePlate(keyword)) {
            JOptionPane.showMessageDialog(this, "License plate must be in format like 29A-12345", "Invalid License Plate", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (field.equals("ticket_id") && !TicketIdValidator.isValidTicketId(keyword)) {
            JOptionPane.showMessageDialog(this, "Ticket ID must be in format like VX001", "Invalid Ticket ID", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (field.equals("parking_date") && !DateValidator.isValidDate(keyword)) {
            JOptionPane.showMessageDialog(this, "Input for Date must be in format YYYY-MM-DD or MM-YYYY or YYYY", "Invalid Date Format", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ArrayList<Ticket> results;
        if (vehicleType.equals("All")) {
            results = SearchDAO.searchAll(keyword, field);
        } else {
            results = SearchDAO.search(keyword, field, vehicleType);
        }

        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0); 

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matching tickets found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Ticket d : results) {
                model.addRow(new Object[]{d.getTicketId(), d.getLicensePlate(), d.getVehicleType(), d.getDate(), d.getCheckin(), d.getCheckout()});
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtInput.setText(""); 

        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0);

        cboType.setSelectedIndex(0);
        cboVehicles.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void cboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTypeActionPerformed
        
    }//GEN-LAST:event_cboTypeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }
    private void styleUI() {

    // ===== BACKGROUND =====
    getContentPane().setBackground(new java.awt.Color(236, 240, 241));
    jPanel1.setBackground(new java.awt.Color(236, 240, 241));
    jPanel2.setBackground(new java.awt.Color(236, 240, 241));

    // ===== TITLE =====
    jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 26));
    jLabel1.setForeground(new java.awt.Color(44, 62, 80));

    // ===== INPUT =====
    txtInput.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
    txtInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));

    // ===== COMBOBOX =====
    styleComboBox(cboType);
    styleComboBox(cboVehicles);

    // ===== TABLE =====
    tblResult.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
    tblResult.setRowHeight(25);
    tblResult.setGridColor(new java.awt.Color(189, 195, 199));
    tblResult.setSelectionBackground(new java.awt.Color(52, 152, 219));
    tblResult.setSelectionForeground(java.awt.Color.WHITE);

    // TABLE HEADER
    javax.swing.table.JTableHeader header = tblResult.getTableHeader();
    header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    header.setBackground(new java.awt.Color(52, 73, 94));
    header.setForeground(java.awt.Color.WHITE);

    // CENTER HEADER TEXT
    javax.swing.table.DefaultTableCellRenderer renderer =
        (javax.swing.table.DefaultTableCellRenderer) header.getDefaultRenderer();
    renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    // ===== BUTTONS =====
    styleButton(btnSearch, new java.awt.Color(46, 204, 113)); // xanh lá
    styleButton(btnReset, new java.awt.Color(241, 196, 15));  // vàng
    styleButton(btnBack, new java.awt.Color(52, 152, 219));   // xanh dương
    styleButton(btnExit, new java.awt.Color(231, 76, 60));    // đỏ

    // ===== PANEL BORDER =====
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));
    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Filter"));
}  private void styleButton(javax.swing.JButton btn, java.awt.Color color) {

    btn.setBackground(color);
    btn.setForeground(java.awt.Color.WHITE);
    btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}  private void styleComboBox(javax.swing.JComboBox cb) {

    cb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
    cb.setBackground(java.awt.Color.WHITE);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JComboBox<String> cboVehicles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
