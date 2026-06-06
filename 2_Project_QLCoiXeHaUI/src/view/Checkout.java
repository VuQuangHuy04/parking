
package view;

import dao.CheckoutDAO;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DBConnect;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Ticket;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Checkout extends javax.swing.JFrame {

    public Checkout() {
        initComponents();
    }
    
    private void displayImage(File file) {
        try {
            BufferedImage img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
            lblImage.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String readImage(File imageFile) {
        ITesseract instance = new Tesseract();
        instance.setDatapath("./tessdata");
        instance.setLanguage("eng");
        try {
            return instance.doOCR(imageFile).replaceAll("\\s", "");
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void fillInfo(String plate) {
        Ticket ticket = CheckoutDAO.findByLicensePlate(plate);
        if (ticket != null) {
            txtLicensePlate.setText(ticket.getLicensePlate());
            txtTicketID.setText(ticket.getTicketId());
            cboVehicleType.setSelectedItem(ticket.getVehicleType());
            txtDate.setText(ticket.getDate());
            txtCheckin.setText(ticket.getCheckin());
            txtCheckout.setText(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));

            // --- ĐOẠN UPDATE CHỨC NĂNG TỰ TÍNH TIỀN ---
            int totalFare = CheckoutDAO.getFareAmount(ticket.getVehicleType());

            // Hiển thị thông báo nhanh cho nhân viên biết số tiền cần thu ngay khi quét ảnh xong
            JOptionPane.showMessageDialog(this,
                    "======= VEHICLE INFO =======\n" +
                            "Vehicle Type: " + ticket.getVehicleType() + "\n" +
                            "License Plate: " + ticket.getLicensePlate() + "\n" +
                            "==========================\n" +
                            "💰 PARKING FARE: " + totalFare + " VND",
                    "Fare Calculation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "License plate not found in the system.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboVehicleType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTicketID = new javax.swing.JTextField();
        txtLicensePlate = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCheckin = new javax.swing.JTextField();
        txtCheckout = new javax.swing.JTextField();
        btnImage = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 26)); // NOI18N
        jLabel1.setText("CHECK OUT");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setPreferredSize(new java.awt.Dimension(132, 35));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCheckout.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkout.png"))); // NOI18N
        btnCheckout.setText("Check-out");
        btnCheckout.setPreferredSize(new java.awt.Dimension(132, 35));
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(132, 35));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(132, 35));
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
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel2.setText("Ticket ID");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel3.setText("License Plate");

        cboVehicleType.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        cboVehicleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Motorbike" }));
        cboVehicleType.setPreferredSize(new java.awt.Dimension(117, 30));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel5.setText("Check-in");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel6.setText("Check-out");

        txtTicketID.setPreferredSize(new java.awt.Dimension(64, 30));

        txtLicensePlate.setPreferredSize(new java.awt.Dimension(64, 30));

        txtDate.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel7.setText("Vehicle Type");

        txtCheckin.setPreferredSize(new java.awt.Dimension(64, 30));

        txtCheckout.setPreferredSize(new java.awt.Dimension(64, 30));

        btnImage.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnImage.setText("Image");
        btnImage.setPreferredSize(new java.awt.Dimension(80, 30));
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jLabel8Layout = new javax.swing.GroupLayout(jLabel8);
        jLabel8.setLayout(jLabel8Layout);
        jLabel8Layout.setHorizontalGroup(
            jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabel8Layout.createSequentialGroup()
                .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLabel8Layout.createSequentialGroup()
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(56, 56, 56)
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jLabel8Layout.createSequentialGroup()
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLabel8Layout.createSequentialGroup()
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTicketID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLicensePlate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboVehicleType, 0, 177, Short.MAX_VALUE))))
                .addGap(61, 61, 61)
                .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jLabel8Layout.setVerticalGroup(
            jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLicensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLabel8Layout.createSequentialGroup()
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jLabel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(9, 9, 9))
                    .addGroup(jLabel8Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(262, 262, 262))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new HomeStaff().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        String ticketId = txtTicketID.getText().trim();
        String checkoutTime = txtCheckout.getText().trim();
        String vehicleType = (String) cboVehicleType.getSelectedItem();
        String licensePlate = txtLicensePlate.getText().trim();
        String checkinTime = txtCheckin.getText().trim();
        String date = txtDate.getText().trim();

        if (ticketId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No license plate detected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (checkoutTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Check-out time is missing.", "Missing Data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean updated = CheckoutDAO.updateCheckoutTime(ticketId, checkoutTime);
            if (updated) {
                // --- ĐOẠN CODE CŨ CỦA BẠN: ---
// int finalFare = CheckoutDAO.getFareAmount(vehicleType);

// --- ĐOẠN CODE UPDATE TÍNH TIỀN QUA ĐÊM CHUẨN XÁC: ---
                int baseFare = CheckoutDAO.getFareAmount(vehicleType); // Lấy giá gốc từ DB (Ví dụ: 15000)
                int finalFare = baseFare; // Mặc định nếu đi trong ngày là bằng giá gốc

                try {
                    // Lấy ngày vào (Date) từ ô txtDate trên giao diện
                    java.time.LocalDate dateIn = java.time.LocalDate.parse(txtDate.getText().trim());
                    // Lấy ngày ra hiện tại của hệ thống máy tính
                    java.time.LocalDate dateOut = java.time.LocalDate.now();

                    // Tính toán số ngày chênh lệch thực tế giữa ngày vào và ngày ra
                    long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateIn, dateOut);

                    // Nếu gửi qua đêm (số ngày chênh lệch lớn hơn 0)
                    if (daysBetween > 0) {
                        // Tổng tiền = Giá gốc x (Số ngày đỗ + 1)
                        finalFare = baseFare * (int) (daysBetween + 1);
                    }
                } catch (Exception ex) {
                    System.out.println("Lỗi tính toán ngày qua đêm, hệ thống tự lấy giá mặc định 1 lượt.");
                }

                // Chuỗi nội dung hóa đơn thanh toán
                String receiptText =
                        "===================================\n" +
                                "        E-PARKING HAUI RECEIPT     \n" +
                                "===================================\n" +
                                " Ticket ID    : " + ticketId + "\n" +
                                " License Plate: " + licensePlate + "\n" +
                                " Vehicle Type : " + vehicleType + "\n" +
                                " Parking Date : " + date + "\n" +
                                " Time In      : " + checkinTime + "\n" +
                                " Time Out     : " + checkoutTime + "\n" +
                                "-----------------------------------\n" +
                                " TOTAL CASH   : " + finalFare + " VND\n" +
                                "===================================\n" +
                                "      THANK YOU! SEE YOU AGAIN!    \n";

                // Hiển thị màn hình hóa đơn điện tử cho nhân viên thu tiền
                JOptionPane.showMessageDialog(this, receiptText, "Payment Successful", JOptionPane.INFORMATION_MESSAGE);

                // Tự động xuất file hóa đơn vật lý ra thư mục để lưu trữ log hệ thống
                try {
                    java.io.FileWriter writer = new java.io.FileWriter("Receipt_" + ticketId + ".txt");
                    writer.write(receiptText);
                    writer.close();
                } catch (java.io.IOException ioEx) {
                    System.out.println("Failed to export physical receipt file.");
                }

                // Sau khi hoàn thành, tự động kích hoạt nút Reset để nhân viên đón xe tiếp theo
                btnResetActionPerformed(null);

            } else {
                JOptionPane.showMessageDialog(this, "No ticket found with ID: " + ticketId, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database update failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTicketID.setText(""); 
        txtLicensePlate.setText(""); 
        txtDate.setText(""); 
        txtCheckin.setText(""); 
        txtCheckout.setText(""); 
        cboVehicleType.setSelectedIndex(0);
        lblImage.setIcon(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        JFileChooser chooser = new JFileChooser(new File("src/licensePlate"));
        chooser.setFileFilter(new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            displayImage(selectedFile);                   
            String plate = readImage(selectedFile); 
            fillInfo(plate);                     
        }
    }//GEN-LAST:event_btnImageActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboVehicleType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtCheckin;
    private javax.swing.JTextField txtCheckout;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtLicensePlate;
    private javax.swing.JTextField txtTicketID;
    // End of variables declaration//GEN-END:variables
}
