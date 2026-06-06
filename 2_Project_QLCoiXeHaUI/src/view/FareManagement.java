package view;

import dao.FareDAO;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FareManagement extends javax.swing.JFrame {

    public FareManagement() {
        initComponents();
        loadCurrentFares();
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở chính giữa màn hình
        styleUI();
    }
    private void loadCurrentFares() {
        HashMap<String, Integer> fares = FareDAO.getAllFares();
        lblCurrentMotorbike.setText(fares.getOrDefault("Motorbike", 10000) + " VND");
        lblCurrentCar.setText(fares.getOrDefault("Car", 20000) + " VND");
    }
    // Thiết lập giao diện thủ công an toàn, không sợ lỗi kéo thả của IDE
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCurrentMotorbike = new javax.swing.JLabel();
        lblCurrentCar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNewMotorbike = new javax.swing.JTextField();
        txtNewCar = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking Fare Management");
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("FARE CONFIGURATION");
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        jLabel2.setText("Current Motorbike Fare:");
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        jLabel3.setText("Current Car Fare:");
        lblCurrentMotorbike.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblCurrentMotorbike.setText("10000 VND");

        lblCurrentCar.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        lblCurrentCar.setText("20000 VND");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        jLabel6.setText("New Motorbike Fare:");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        jLabel7.setText("New Car Fare:");

        btnSave.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        btnSave.setText("Save Changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        // Sử dụng Absolute Layout đơn giản để cố định vị trí các thành phần, loại bỏ GroupLayout gây lỗi
        getContentPane().setLayout(null);

        jLabel1.setBounds(90, 20, 300, 30);
        getContentPane().add(jLabel1);

        jLabel2.setBounds(40, 80, 180, 20);
        getContentPane().add(jLabel2);

        lblCurrentMotorbike.setBounds(240, 80, 150, 20);
        getContentPane().add(lblCurrentMotorbike);

        jLabel3.setBounds(40, 120, 180, 20);
        getContentPane().add(jLabel3);

        lblCurrentCar.setBounds(240, 120, 150, 20);
        getContentPane().add(lblCurrentCar);

        jLabel6.setBounds(40, 170, 180, 25);
        getContentPane().add(jLabel6);

        txtNewMotorbike.setBounds(240, 170, 160, 25);
        getContentPane().add(txtNewMotorbike);

        jLabel7.setBounds(40, 210, 180, 25);
        getContentPane().add(jLabel7);

        txtNewCar.setBounds(240, 210, 160, 25);
        getContentPane().add(txtNewCar);

        btnBack.setBounds(40, 270, 120, 35);
        getContentPane().add(btnBack);

        btnSave.setBounds(240, 270, 160, 35);
        getContentPane().add(btnSave);

        // Đặt kích thước cho toàn bộ khung hiển thị
        setSize(460, 380);
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomeAdmin().setVisible(true);
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String motorbikeInput = txtNewMotorbike.getText().trim();
        String carInput = txtNewCar.getText().trim();

        if (motorbikeInput.isEmpty() && carInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter at least one new fare to update.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean success = false;
            if (!motorbikeInput.isEmpty()) {
                int motoFare = Integer.parseInt(motorbikeInput);
                if (motoFare < 0) throw new NumberFormatException();
                success = FareDAO.updateFare("Motorbike", motoFare);
            }
            if (!carInput.isEmpty()) {
                int carFare = Integer.parseInt(carInput);
                if (carFare < 0) throw new NumberFormatException();
                success = FareDAO.updateFare("Car", carFare) || success;
            }

            if (success) {
                JOptionPane.showMessageDialog(this, "Fare updated successfully!");
                loadCurrentFares();
                txtNewMotorbike.setText("");
                txtNewCar.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update fare.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Fare must be a valid positive integer number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FareManagement().setVisible(true);
            }
        });
    }
    private void styleUI() {

    // ===== BACKGROUND =====
    getContentPane().setBackground(new java.awt.Color(236, 240, 241));

    // ===== TITLE =====
    jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 26));
    jLabel1.setForeground(new java.awt.Color(44, 62, 80));

    // ===== LABELS =====
    jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jLabel6.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jLabel7.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

    jLabel2.setForeground(new java.awt.Color(52, 73, 94));
    jLabel3.setForeground(new java.awt.Color(52, 73, 94));
    jLabel6.setForeground(new java.awt.Color(52, 73, 94));
    jLabel7.setForeground(new java.awt.Color(52, 73, 94));

    // ===== CURRENT VALUE LABEL =====
    lblCurrentMotorbike.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    lblCurrentCar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

    lblCurrentMotorbike.setForeground(new java.awt.Color(39, 174, 96));
    lblCurrentCar.setForeground(new java.awt.Color(41, 128, 185));

    // ===== TEXTFIELD STYLE =====
    styleTextField(txtNewMotorbike);
    styleTextField(txtNewCar);

    // ===== BUTTON STYLE =====
    styleButton(btnSave, new java.awt.Color(46, 204, 113)); // xanh lá
    styleButton(btnBack, new java.awt.Color(231, 76, 60));  // đỏ

}  
    private void styleButton(javax.swing.JButton btn, java.awt.Color color) {

    btn.setBackground(color);
    btn.setForeground(java.awt.Color.WHITE);
    btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}
    private void styleTextField(javax.swing.JTextField txt) {

    txt.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
    txt.setBackground(java.awt.Color.WHITE);
    txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));
}
    // Đảm bảo khai báo đầy đủ các biến thành phần ở cuối class để IntelliJ nhận diện được
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblCurrentCar;
    private javax.swing.JLabel lblCurrentMotorbike;
    private javax.swing.JTextField txtNewCar;
    private javax.swing.JTextField txtNewMotorbike;
}