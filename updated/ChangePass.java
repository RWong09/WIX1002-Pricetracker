package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class ChangePass extends javax.swing.JFrame {

    private String Username;

    ChangePass(String Username) {
        this.Username = Username;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Changepass = new javax.swing.JLabel();
        NewPass = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        confirmpass = new javax.swing.JLabel();
        connewpass = new javax.swing.JPasswordField();
        Confirm = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        Changepass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Changepass.setForeground(new java.awt.Color(102, 204, 255));
        Changepass.setText("Change Password");

        NewPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NewPass.setForeground(new java.awt.Color(102, 204, 255));
        NewPass.setText("New Password:");

        confirmpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(102, 204, 255));
        confirmpass.setText("Confirm New Password:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(Changepass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(connewpass))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(268, 268, 268))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confirmpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(204, 204, 204))
                            .addComponent(newpass)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94)
                        .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Changepass, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newpass)
                .addGap(18, 18, 18)
                .addComponent(confirmpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connewpass)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(165, 165, 165))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String Newpassword;

        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            if ("".equals(newpass.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(connewpass.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Pls confirm your password", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!newpass.getText().equals(connewpass.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter the same password", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Newpassword = newpass.getText();
                System.out.println(Newpassword);

                String checkUserQuery = "SELECT * FROM user WHERE username=? and password=?";
                try (PreparedStatement checkUserStatement =  sqlconnection.prepareStatement(checkUserQuery)) {
                    checkUserStatement.setString(1, Username);
                    checkUserStatement.setString(2, Newpassword);
                    ResultSet checkUserResult = checkUserStatement.executeQuery();
                    if (checkUserResult.next()) {
                        int countCheck = checkUserResult.getInt(1);
                        if (countCheck > 0) {
                            showMessageDialog(null, "Password already exists. Please choose a different password.");
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String updatepassword = "UPDATE user"
                        + " SET password='" + Newpassword + "' WHERE username='" + Username + "'";
                System.out.println(Username);

                Statement statement =  sqlconnection.createStatement();
                int rowsUpdated = statement.executeUpdate(updatepassword);
                if (rowsUpdated > 0) {
                    System.out.println("Update successful! Rows affected: " + rowsUpdated);

                } else {
                    System.out.println("No records were updated." + Username);
                }

                newpass.setText("");
                connewpass.setText("");

                showMessageDialog(null, "New password has been updated successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Changepass;
    private javax.swing.JButton Confirm;
    private javax.swing.JLabel NewPass;
    private javax.swing.JLabel confirmpass;
    private javax.swing.JPasswordField connewpass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newpass;
    // End of variables declaration//GEN-END:variables
}
