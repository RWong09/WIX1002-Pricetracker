package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class SignUp extends javax.swing.JFrame {
 
    public SignUp() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelSignUp = new javax.swing.JPanel();
        SignUp = new javax.swing.JLabel();
        Pw = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        SignUpBtn = new javax.swing.JButton();
        CPW = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        statement = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelSignUp.setBackground(new java.awt.Color(255, 255, 255));
        PanelSignUp.setPreferredSize(new java.awt.Dimension(500, 400));

        SignUp.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SignUp.setForeground(new java.awt.Color(102, 204, 255));
        SignUp.setText("SIGN UP");

        Pw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pw.setForeground(new java.awt.Color(102, 204, 255));
        Pw.setText("Password");

        User.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        User.setForeground(new java.awt.Color(102, 204, 255));
        User.setText("Username\n");

        SignUpBtn.setForeground(new java.awt.Color(102, 204, 255));
        SignUpBtn.setText("Sign Up");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });

        CPW.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CPW.setForeground(new java.awt.Color(102, 204, 255));
        CPW.setText("Confirm Password");

        statement.setText("I already have an account");

        LoginBtn.setForeground(new java.awt.Color(102, 204, 255));
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSignUpLayout = new javax.swing.GroupLayout(PanelSignUp);
        PanelSignUp.setLayout(PanelSignUpLayout);
        PanelSignUpLayout.setHorizontalGroup(
            PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSignUpLayout.createSequentialGroup()
                .addGroup(PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSignUpLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass)
                            .addComponent(fname)
                            .addGroup(PanelSignUpLayout.createSequentialGroup()
                                .addComponent(CPW, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addGap(226, 226, 226))
                            .addComponent(pass1)
                            .addGroup(PanelSignUpLayout.createSequentialGroup()
                                .addGroup(PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Pw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(280, 280, 280))
                            .addGroup(PanelSignUpLayout.createSequentialGroup()
                                .addComponent(SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelSignUpLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelSignUpLayout.createSequentialGroup()
                                .addComponent(LoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGap(265, 265, 265)))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSignUpLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(SignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(209, 209, 209))
        );
        PanelSignUpLayout.setVerticalGroup(
            PanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSignUpLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(User, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fname, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pw, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPW, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SignUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statement, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        String username, Password;
        String SUrl, SUser, SPass;
        SUrl = "jdbc:MySQL://localhost:3306/pricetracker";
        SUser = "root";
        SPass = "";

        Connection con = null;
        try {
            con = DriverManager.getConnection(SUrl, SUser, SPass);
        } catch (SQLException ex) {
            
        }
       
        if ("".equals(fname.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Username is require", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(pass.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is require", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(pass1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Pls confirm your password", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!pass1.getText().equals(pass.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter the same password", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            username = fname.getText();
            Password = pass.getText();
            System.out.println(Password);

// Checking if the username already exists
            String checkUserQuery = "SELECT COUNT(username) FROM user WHERE username=?";
            try ( PreparedStatement checkUserStatement = con.prepareStatement(checkUserQuery)) {
                checkUserStatement.setString(1, username);
                ResultSet checkUserResult = checkUserStatement.executeQuery();
                if (checkUserResult.next()) {
                    int countCheck = checkUserResult.getInt(1);
                    if (countCheck > 0) {
                        showMessageDialog(null, "Username already exists. Please choose a different username.");
                        return; // Stop execution if the username already exists
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }

// Inserting the new user
            String insertUserQuery = "INSERT INTO user (username, password) VALUES (?, ?)";
            try ( PreparedStatement insertUserStatement = con.prepareStatement(insertUserQuery)) {
                insertUserStatement.setString(1, username);
                insertUserStatement.setString(2, Password);
                insertUserStatement.executeUpdate();

                // Clearing the text fields after successful insertion
                fname.setText("");
                pass.setText("");
                pass1.setText("");

                showMessageDialog(null, "New account has been created successfully!");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }
        }
    }//GEN-LAST:event_SignUpBtnActionPerformed
    


    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LoginBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPW;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel PanelSignUp;
    private javax.swing.JLabel Pw;
    private javax.swing.JLabel SignUp;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JLabel User;
    private javax.swing.JTextField fname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JLabel statement;
    // End of variables declaration//GEN-END:variables
}
