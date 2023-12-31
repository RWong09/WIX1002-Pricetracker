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

public class ChangeUser extends javax.swing.JFrame {

    private String Username;

    ChangeUser(String Username) {
        this.Username = Username;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ChangeUser = new javax.swing.JLabel();
        NewUser = new javax.swing.JLabel();
        newuser = new javax.swing.JTextField();
        Confirm = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        ChangeUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ChangeUser.setForeground(new java.awt.Color(102, 204, 255));
        ChangeUser.setText("Change Username");

        NewUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NewUser.setForeground(new java.awt.Color(102, 204, 255));
        NewUser.setText("New Username:");

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
                .addComponent(ChangeUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(278, 278, 278))
                            .addComponent(newuser)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(82, 82, 82)
                        .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ChangeUser, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newuser)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(240, 240, 240))
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
        String Newuser;
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            if ("".equals(newuser.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Username is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Newuser = newuser.getText();
                System.out.println(Newuser);

                String checkUserQuery = "SELECT COUNT(username) FROM user WHERE username=?";
                try (PreparedStatement checkUserStatement = sqlconnection.prepareStatement(checkUserQuery)) {
                    checkUserStatement.setString(1, Newuser);
                    ResultSet checkUserResult = checkUserStatement.executeQuery();
                    if (checkUserResult.next()) {
                        int countCheck = checkUserResult.getInt(1);
                        if (countCheck > 0) {
                            showMessageDialog(null, "Username already exists. Please choose a different username.");
                            return; // Stop execution if the username already exists
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String updatepassword = "UPDATE user"
                        + " SET username='" + Newuser + "' WHERE username='" + Username + "'";
                System.out.println(Username);
                // Create a statement
                Statement statement = sqlconnection.createStatement();
                int rowsUpdated = statement.executeUpdate(updatepassword);
                if (rowsUpdated > 0) {
                    Username = Newuser;
                    System.out.println("Update successful! Rows affected: " + rowsUpdated);
                } else {
                    System.out.println("No records were updated.");
                }

                newuser.setText("");
                showMessageDialog(null, "New username has been updated successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel ChangeUser;
    private javax.swing.JButton Confirm;
    private javax.swing.JLabel NewUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newuser;
    // End of variables declaration//GEN-END:variables
}
