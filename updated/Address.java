package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Address extends javax.swing.JFrame {

    private String Username;

    Address(String Username) {
        this.Username = Username;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EnterAdd = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        State = new javax.swing.JLabel();
        District = new javax.swing.JLabel();
        Next = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EnterAdd.setBackground(new java.awt.Color(255, 255, 255));
        EnterAdd.setPreferredSize(new java.awt.Dimension(500, 400));

        Title.setBackground(new java.awt.Color(102, 204, 255));
        Title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Title.setForeground(new java.awt.Color(102, 204, 255));
        Title.setText("Please enter your district");

        State.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        State.setForeground(new java.awt.Color(102, 204, 255));
        State.setText("State:");

        District.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        District.setForeground(new java.awt.Color(102, 204, 255));
        District.setText("District:");

        Next.setForeground(new java.awt.Color(102, 204, 255));
        Next.setText("Next >>");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
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

        javax.swing.GroupLayout EnterAddLayout = new javax.swing.GroupLayout(EnterAdd);
        EnterAdd.setLayout(EnterAddLayout);
        EnterAddLayout.setHorizontalGroup(
            EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnterAddLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(District, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(State, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(STATE, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DISTRICT, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EnterAddLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EnterAddLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Next)
                .addGap(204, 204, 204))
        );
        EnterAddLayout.setVerticalGroup(
            EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnterAddLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(Title)
                .addGap(64, 64, 64)
                .addGroup(EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(State, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(EnterAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(District, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(Next)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(EnterAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(EnterAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        Object Selectedstate = STATE.getSelectedItem();
        Object Selecteddistrict = DISTRICT.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            // Query to get distinct STATE
            String updatequery = "UPDATE user "
                    + "SET district = ?, state= ? "
                    + "WHERE username = ?;";
            PreparedStatement updateStatement = sqlconnection.prepareStatement(updatequery);
            updateStatement.setObject(1, Selecteddistrict);
            updateStatement.setObject(2, Selectedstate);
            updateStatement.setString(3, Username);
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update successful");
            } else {
                System.out.println("No records were updated");
            }

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
        }

        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_NextActionPerformed

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
    private javax.swing.JComboBox<String> DISTRICT;
    private javax.swing.JLabel District;
    private javax.swing.JPanel EnterAdd;
    private javax.swing.JButton Next;
    private javax.swing.JComboBox<String> STATE;
    private javax.swing.JLabel State;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables

}
