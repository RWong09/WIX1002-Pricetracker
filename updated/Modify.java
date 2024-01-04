package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Modify extends javax.swing.JFrame {

    private static String Username;
    private String item;
    private String unit;
    private int itemcode;
    private String url = "jdbc:mysql://localhost:3306/pricetracker";
    private String user = "root";
    private String password = "";

    public Modify() {
        initComponents();
    }

    Modify(int itemcode, String item, String unit, String Username) {
        initComponents();
        this.Username = Username;
        this.item = item;
        this.unit = unit;
        this.itemcode = itemcode;
        USER.setText(Username);
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String DetailsQuery = "SELECT * FROM lookup_item WHERE item_code = ?";
            PreparedStatement DetailsStatement = sqlconnection.prepareStatement(DetailsQuery);
            DetailsStatement.setInt(1, this.itemcode);
            ResultSet ItemDetails = DetailsStatement.executeQuery();
            while (ItemDetails.next()) {
                ITemcode.setText(ItemDetails.getString("item_code"));
                ITEM.setText(ItemDetails.getString("item"));
                UNit.setText(ItemDetails.getString("unit"));
                itemcat.setText(ItemDetails.getString("item_group"));
                itemsubcat.setText(ItemDetails.getString("item_category"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton22 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        Modify = new javax.swing.JLabel();
        item1 = new javax.swing.JLabel();
        unit1 = new javax.swing.JLabel();
        itemcat1 = new javax.swing.JLabel();
        itemsubcat1 = new javax.swing.JLabel();
        New = new javax.swing.JLabel();
        item2 = new javax.swing.JLabel();
        unit2 = new javax.swing.JLabel();
        itemcat2 = new javax.swing.JLabel();
        itemsubcat2 = new javax.swing.JLabel();
        modifyitem = new javax.swing.JTextField();
        modifyunit = new javax.swing.JTextField();
        modifycat = new javax.swing.JTextField();
        modifysub = new javax.swing.JTextField();
        itemcode1 = new javax.swing.JLabel();
        ITemcode = new javax.swing.JLabel();
        ITEM = new javax.swing.JLabel();
        UNit = new javax.swing.JLabel();
        itemcat = new javax.swing.JLabel();
        itemsubcat = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        Menu1 = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat2 = new javax.swing.JButton();
        Shopping1 = new javax.swing.JButton();
        Account1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Home1 = new javax.swing.JButton();

        jButton22.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setForeground(new java.awt.Color(255, 255, 255));
        Welcome.setText("Welcome to Product Search and Selection");

        Modify.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Modify.setForeground(new java.awt.Color(255, 255, 255));
        Modify.setText("Modify Item Details");

        item1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        item1.setForeground(new java.awt.Color(255, 255, 255));
        item1.setText("Item:");

        unit1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        unit1.setForeground(new java.awt.Color(255, 255, 255));
        unit1.setText("Unit:");

        itemcat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemcat1.setForeground(new java.awt.Color(255, 255, 255));
        itemcat1.setText("Item Group:");

        itemsubcat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemsubcat1.setForeground(new java.awt.Color(255, 255, 255));
        itemsubcat1.setText("Item Category:");

        New.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        New.setForeground(new java.awt.Color(255, 255, 255));
        New.setText("New Item Details");

        item2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        item2.setForeground(new java.awt.Color(255, 255, 255));
        item2.setText("Item:");

        unit2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        unit2.setForeground(new java.awt.Color(255, 255, 255));
        unit2.setText("Unit:");

        itemcat2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemcat2.setForeground(new java.awt.Color(255, 255, 255));
        itemcat2.setText("Item Group:");

        itemsubcat2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemsubcat2.setForeground(new java.awt.Color(255, 255, 255));
        itemsubcat2.setText("Item Category:");

        modifyunit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyunitActionPerformed(evt);
            }
        });

        modifycat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifycatActionPerformed(evt);
            }
        });

        itemcode1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemcode1.setForeground(new java.awt.Color(255, 255, 255));
        itemcode1.setText("Itemcode:");

        ITemcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ITemcode.setForeground(new java.awt.Color(255, 255, 255));
        ITemcode.setText("jLabel13");

        ITEM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ITEM.setForeground(new java.awt.Color(255, 255, 255));
        ITEM.setText("jLabel14");

        UNit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UNit.setForeground(new java.awt.Color(255, 255, 255));
        UNit.setText("jLabel15");

        itemcat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemcat.setForeground(new java.awt.Color(255, 255, 255));
        itemcat.setText("jLabel16");

        itemsubcat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemsubcat.setForeground(new java.awt.Color(255, 255, 255));
        itemsubcat.setText("jLabel17");

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Menu1.setBackground(new java.awt.Color(255, 255, 255));

        USER.setText("jLabel1");
        USER.setPreferredSize(new java.awt.Dimension(37, 43));

        BrowseByCat2.setBackground(new java.awt.Color(255, 255, 255));
        BrowseByCat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-search-48.png"))); // NOI18N
        BrowseByCat2.setBorderPainted(false);
        BrowseByCat2.setPreferredSize(new java.awt.Dimension(144, 43));
        BrowseByCat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseByCat2ActionPerformed(evt);
            }
        });

        Shopping1.setBackground(new java.awt.Color(255, 255, 255));
        Shopping1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-cart-48.png"))); // NOI18N
        Shopping1.setBorderPainted(false);
        Shopping1.setPreferredSize(new java.awt.Dimension(107, 43));
        Shopping1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Shopping1ActionPerformed(evt);
            }
        });

        Account1.setBackground(new java.awt.Color(255, 255, 255));
        Account1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-setting-48.png"))); // NOI18N
        Account1.setBorderPainted(false);
        Account1.setPreferredSize(new java.awt.Dimension(114, 43));
        Account1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Account1ActionPerformed(evt);
            }
        });

        Logout1.setBackground(new java.awt.Color(255, 255, 255));
        Logout1.setText("Log Out");
        Logout1.setBorderPainted(false);
        Logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ActionPerformed(evt);
            }
        });

        Home1.setBackground(new java.awt.Color(255, 255, 255));
        Home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-home-48.png"))); // NOI18N
        Home1.setBorderPainted(false);
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Menu1Layout = new javax.swing.GroupLayout(Menu1);
        Menu1.setLayout(Menu1Layout);
        Menu1Layout.setHorizontalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BrowseByCat2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Shopping1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Account1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(Home1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Menu1Layout.setVerticalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrowseByCat2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(item1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemsubcat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemcode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemcat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(item2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemsubcat2)
                                .addComponent(itemcat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemsubcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UNit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ITemcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(modifysub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                                    .addComponent(modifycat)
                                    .addComponent(modifyunit, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemcat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modifyitem, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Welcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(Modify)
                                .addGap(149, 149, 149)))
                        .addGap(269, 269, 269))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(New)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(Confirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back)
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Modify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemcode1)
                    .addComponent(ITemcode))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item1)
                    .addComponent(ITEM))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unit1)
                    .addComponent(UNit))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemcat1)
                    .addComponent(itemcat))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsubcat1)
                    .addComponent(itemsubcat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(New)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(item2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(unit2)
                                    .addComponent(modifyunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(modifyitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(itemcat2))
                    .addComponent(modifycat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsubcat2)
                    .addComponent(modifysub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirm)
                    .addComponent(Back))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        String Modifyitem, Modifyunit, Modifycat, Modifysub;

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String DetailsQuery = "SELECT * FROM lookup_item WHERE item_code = ?";
            PreparedStatement DetailsStatement = sqlconnection.prepareStatement(DetailsQuery);
            DetailsStatement.setInt(1, itemcode);
            ResultSet ItemDetails = DetailsStatement.executeQuery();

            Modifyitem = modifyitem.getText();
            Modifyunit = modifyunit.getText();
            Modifycat = modifycat.getText();
            Modifysub = modifysub.getText();
            if ("".equals(Modifyitem) && "".equals(Modifyunit) && "".equals(Modifycat) && "".equals(Modifysub)) {
                JOptionPane.showMessageDialog(new JFrame(), "At least update 1 detail", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String sQuery = "UPDATE lookup_item "
                        + "SET item = CASE WHEN '" + Modifyitem + "' <> '' THEN '" + Modifyitem + "' ELSE item END, "
                        + "unit = CASE WHEN '" + Modifyunit + "' <> '' THEN '" + Modifyunit + "' ELSE unit END, "
                        + "item_group = CASE WHEN '" + Modifycat + "' <> '' THEN '" + Modifycat + "' ELSE item_group END, "
                        + "item_category = CASE WHEN '" + Modifysub + "' <> '' THEN '" + Modifysub + "' ELSE item_category END "
                        + "WHERE item_code = '" + itemcode + "'";
                try ( Statement updateStatement = sqlconnection.createStatement()) {
                    int rowsUpdated = updateStatement.executeUpdate(sQuery);
                    if (rowsUpdated > 0) {
                        showMessageDialog(null, "Item has been updated successfully!");
                    } else {
                        showMessageDialog(null, "No items were updated.");
                    }
                } catch (Exception e) {
                    System.out.println("Error updating item: " + e.getMessage());
                }

                modifyitem.setText("");
                modifyunit.setText("");
                modifycat.setText("");
                modifysub.setText("");

                Modify modifyFrame = new Modify(itemcode, item, unit, Username);
                modifyFrame.setVisible(true);
                modifyFrame.pack();
                modifyFrame.setLocationRelativeTo(null);
                this.dispose();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    private void BrowseByCat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseByCat2ActionPerformed
        Browser Bro = new Browser(Username);
        Bro.setVisible(true);
        Bro.pack();
        Bro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BrowseByCat2ActionPerformed

    private void Shopping1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Shopping1ActionPerformed
        ShopCart Shop = new ShopCart(Username);
        Shop.setVisible(true);
        Shop.pack();
        Shop.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Shopping1ActionPerformed

    private void Account1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Account1ActionPerformed
        AccSetting Acc = new AccSetting(Username);
        Acc.setVisible(true);
        Acc.pack();
        Acc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Account1ActionPerformed

    private void Logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout1ActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Logout1ActionPerformed

    private void Home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home1ActionPerformed
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Home1ActionPerformed

    private void modifyunitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyunitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyunitActionPerformed

    private void modifycatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifycatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifycatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account1;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat2;
    private javax.swing.JButton Confirm;
    private javax.swing.JButton Home1;
    private javax.swing.JLabel ITEM;
    private javax.swing.JLabel ITemcode;
    private javax.swing.JButton Logout1;
    private javax.swing.JPanel Menu1;
    private javax.swing.JLabel Modify;
    private javax.swing.JLabel New;
    private javax.swing.JButton Shopping1;
    private javax.swing.JLabel UNit;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JLabel item1;
    private javax.swing.JLabel item2;
    private javax.swing.JLabel itemcat;
    private javax.swing.JLabel itemcat1;
    private javax.swing.JLabel itemcat2;
    private javax.swing.JLabel itemcode1;
    private javax.swing.JLabel itemsubcat;
    private javax.swing.JLabel itemsubcat1;
    private javax.swing.JLabel itemsubcat2;
    private javax.swing.JButton jButton22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField modifycat;
    private javax.swing.JTextField modifyitem;
    private javax.swing.JTextField modifysub;
    private javax.swing.JTextField modifyunit;
    private javax.swing.JLabel unit1;
    private javax.swing.JLabel unit2;
    // End of variables declaration//GEN-END:variables
}
