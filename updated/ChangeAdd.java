package loginregister;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeAdd extends javax.swing.JFrame {

    private String Username;

    ChangeAdd(String Username) {
        this.Username = Username;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ChangeAdd = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        STATE = new javax.swing.JComboBox<>();
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            // Query to get distinct STATE
            String StateQuery = "SELECT DISTINCT state FROM lookup_premise;";
            PreparedStatement StateStatement = sqlconnection.prepareStatement(StateQuery);
            ResultSet StateResult = StateStatement.executeQuery();
            while (StateResult.next()) {
                STATE.addItem(StateResult.getString("state"));
            }

        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
        DISTRICT = new javax.swing.JComboBox<>();
        State = new javax.swing.JLabel();
        District = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        ChangeAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ChangeAdd.setForeground(new java.awt.Color(102, 204, 255));
        ChangeAdd.setText("Change Address");

        Confirm.setForeground(new java.awt.Color(102, 204, 255));
        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Back.setForeground(new java.awt.Color(102, 204, 255));
        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        STATE.setMinimumSize(new java.awt.Dimension(64, 22));
        STATE.setPreferredSize(new java.awt.Dimension(64, 22));
        STATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STATEActionPerformed(evt);
            }
        });

        DISTRICT.setMinimumSize(new java.awt.Dimension(64, 22));
        DISTRICT.setPreferredSize(new java.awt.Dimension(64, 22));

        State.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        State.setForeground(new java.awt.Color(102, 204, 255));
        State.setText("State:");

        District.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        District.setForeground(new java.awt.Color(102, 204, 255));
        District.setText("District:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ChangeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(District, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(State, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(STATE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Confirm)
                        .addGap(89, 89, 89)
                        .addComponent(Back)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ChangeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(State, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(District, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirm)
                    .addComponent(Back))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        AccSetting Acc = new AccSetting(Username);
        Acc.setVisible(true);
        Acc.pack();
        Acc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        Object Selectedstate = STATE.getSelectedItem();
        Object Selecteddistrict = DISTRICT.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String checkDistrictQuery = "SELECT COUNT(*) FROM user WHERE district = ? AND username = '" + Username + "';";
            try (PreparedStatement checkDistrictStatement = sqlconnection.prepareStatement(checkDistrictQuery)) {
                checkDistrictStatement.setObject(1, Selecteddistrict);
                ResultSet checkDistrictResult = checkDistrictStatement.executeQuery();

                if (checkDistrictResult.next()) {
                    int countCheck = checkDistrictResult.getInt(1);
                    if (countCheck > 0) {
                        showMessageDialog(null, "District already exists for the selected state. Please choose a different district.");
                        return;
                    }
                }
            }
            int Confirm = showConfirmDialog(null, "Do you wan to continue this action because your shopping cart will be clear", "Confirm", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (Confirm == YES_OPTION) {
                String updatequery = "UPDATE user "
                        + "SET district = ?, state= ? "
                        + "WHERE username = ?;";
                PreparedStatement updateStatement = sqlconnection.prepareStatement(updatequery);
                updateStatement.setObject(1, Selecteddistrict);
                updateStatement.setObject(2, Selectedstate);
                updateStatement.setString(3, Username);
                int rowsUpdated = updateStatement.executeUpdate();

                updateStatement.executeUpdate();
                String deletequery = "DELETE FROM shopping_cart WHERE `username` = '" + Username + "' ;";
                Statement deleteStatement = sqlconnection.createStatement();
                int delete = deleteStatement.executeUpdate(deletequery);
                if (rowsUpdated > 0 && delete > 0) {
                    showMessageDialog(null, "Update successful\nShopping cart is clear now","",JOptionPane.PLAIN_MESSAGE);
                }
                STATE.removeAllItems();
                DISTRICT.removeAllItems();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    private void STATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STATEActionPerformed
        String SUrl, SUser, SPass;
        SUrl = "jdbc:MySQL://localhost:3306/pricetracker";
        SUser = "root";
        SPass = "";
        DISTRICT.removeAllItems();
        Object Selectedstate = STATE.getSelectedItem();

        try {
            Connection sqlconnection = DriverManager.getConnection(SUrl, SUser, SPass); // Create a statement
            String Districtquery = "SELECT DISTINCT district FROM lookup_premise WHERE state = ?;";
            PreparedStatement DistrictStatement = sqlconnection.prepareStatement(Districtquery);
            DistrictStatement.setObject(1, Selectedstate);
            ResultSet District = DistrictStatement.executeQuery();

            while (District.next()) {
                DISTRICT.addItem(District.getString("district"));
            }
        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_STATEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel ChangeAdd;
    private javax.swing.JButton Confirm;
    private javax.swing.JComboBox<String> DISTRICT;
    private javax.swing.JLabel District;
    private javax.swing.JComboBox<String> STATE;
    private javax.swing.JLabel State;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
