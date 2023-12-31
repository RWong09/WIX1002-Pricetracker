package loginregister;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class UserItem extends javax.swing.JFrame {

    private String Username;
    private String item;
    private String unit;
    private int itemcode;

    public UserItem(String item, String unit, String Username) {

        initComponents();
        ITEM.setText(item);
        UNIT.setText(unit);
        USER.setText(Username);

        this.Username = Username;
        this.item = item;
        this.unit = unit;

        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String itemCodeQuery = "SELECT `item_code` FROM `lookup_item` WHERE `item` = ? AND `unit` = ?;";
            PreparedStatement itemCodeStatement = sqlconnection.prepareStatement(itemCodeQuery);
            itemCodeStatement.setObject(1, item);
            itemCodeStatement.setObject(2, unit);
            ResultSet itemCodeResult = itemCodeStatement.executeQuery();

            while (itemCodeResult.next()) {
                itemcode = itemCodeResult.getInt("item_code");
            }

        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
        Modify_Admin.setVisible(false);
        if (Username.equals("admin")) {
            Modify_Admin.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Welcome = new javax.swing.JLabel();
        ItemDetails = new javax.swing.JButton();
        Top5 = new javax.swing.JButton();
        Trend = new javax.swing.JButton();
        AddToCart = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        SelectedItem = new javax.swing.JLabel();
        ITEM = new javax.swing.JLabel();
        UNIT = new javax.swing.JLabel();
        SelectedUnit = new javax.swing.JLabel();
        Modify_Admin = new javax.swing.JButton();
        Menu = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat = new javax.swing.JButton();
        Shopping = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setForeground(new java.awt.Color(255, 255, 255));
        Welcome.setText("Welcome to Product Search and Selection");

        ItemDetails.setText("View Item Details");
        ItemDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemDetailsActionPerformed(evt);
            }
        });

        Top5.setText("View Top 5 Cheapest Seller");
        Top5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Top5ActionPerformed(evt);
            }
        });

        Trend.setText("View Price Trend");
        Trend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrendActionPerformed(evt);
            }
        });

        AddToCart.setText("Add to Shopping Cart");
        AddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToCartActionPerformed(evt);
            }
        });

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        SelectedItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelectedItem.setForeground(new java.awt.Color(255, 255, 255));
        SelectedItem.setText("Selected Item:");

        ITEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ITEM.setForeground(new java.awt.Color(255, 255, 255));
        ITEM.setText("jLabel2");

        UNIT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UNIT.setForeground(new java.awt.Color(255, 255, 255));
        UNIT.setText("jLabel2");

        SelectedUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelectedUnit.setForeground(new java.awt.Color(255, 255, 255));
        SelectedUnit.setText("Selected Unit:");

        Modify_Admin.setText("Modify Item Details");
        Modify_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modify_AdminActionPerformed(evt);
            }
        });

        Menu.setBackground(new java.awt.Color(255, 255, 255));

        USER.setText("jLabel1");
        USER.setPreferredSize(new java.awt.Dimension(37, 43));

        BrowseByCat.setBackground(new java.awt.Color(255, 255, 255));
        BrowseByCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-search-48.png"))); // NOI18N
        BrowseByCat.setBorderPainted(false);
        BrowseByCat.setPreferredSize(new java.awt.Dimension(144, 43));
        BrowseByCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseByCatActionPerformed(evt);
            }
        });

        Shopping.setBackground(new java.awt.Color(255, 255, 255));
        Shopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-cart-48.png"))); // NOI18N
        Shopping.setBorderPainted(false);
        Shopping.setPreferredSize(new java.awt.Dimension(107, 43));
        Shopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShoppingActionPerformed(evt);
            }
        });

        Account.setBackground(new java.awt.Color(255, 255, 255));
        Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-setting-48.png"))); // NOI18N
        Account.setBorderPainted(false);
        Account.setPreferredSize(new java.awt.Dimension(114, 43));
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 255, 255));
        Logout.setText("Log Out");
        Logout.setBorderPainted(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/icons8-home-48.png"))); // NOI18N
        Home.setBorderPainted(false);
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BrowseByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Shopping, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrowseByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SelectedUnit)
                                .addGap(18, 18, 18)
                                .addComponent(UNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Back)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Top5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Trend, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Modify_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(327, 327, 327))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Welcome)
                                .addGap(299, 299, 299))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectedItem)
                    .addComponent(ITEM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectedUnit)
                    .addComponent(UNIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ItemDetails)
                .addGap(18, 18, 18)
                .addComponent(Top5)
                .addGap(18, 18, 18)
                .addComponent(Trend)
                .addGap(18, 18, 18)
                .addComponent(AddToCart)
                .addGap(18, 18, 18)
                .addComponent(Modify_Admin)
                .addGap(80, 80, 80)
                .addComponent(Back)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDetailsActionPerformed
        ViewItem Vie = new ViewItem(itemcode, item, unit, Username);
        Vie.setVisible(true);
        Vie.pack();
        Vie.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ItemDetailsActionPerformed

    private void Top5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Top5ActionPerformed
        ViewTop Vie = new ViewTop(itemcode, item, unit, Username);
        Vie.setVisible(true);
        Vie.pack();
        Vie.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Top5ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void TrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrendActionPerformed
        PriceTrend Pri = new PriceTrend(itemcode, item, unit, Username);
        Pri.setVisible(true);
        Pri.pack();
        Pri.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_TrendActionPerformed

    private void Modify_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modify_AdminActionPerformed
        Modify Mod = new Modify(itemcode, item, unit, Username);
        Mod.setVisible(true);
        Mod.pack();
        Mod.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Modify_AdminActionPerformed

    private void AddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToCartActionPerformed
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            String districtQuery = "SELECT district FROM user WHERE username = ?;";
            PreparedStatement districtStatement = sqlconnection.prepareStatement(districtQuery);

            districtStatement.setString(1, Username);
            ResultSet DISTRICT = districtStatement.executeQuery();
            if (DISTRICT.next()) {
                String district = DISTRICT.getString("district");

                String CountPQuery = "SELECT COUNT(DISTINCT pricecatcher.premise_code) AS numseller "
                        + "FROM pricecatcher "
                        + "JOIN lookup_premise ON pricecatcher.premise_code = lookup_premise.premise_code "
                        + "WHERE pricecatcher.item_code = ? AND lookup_premise.district = ? ;";

                PreparedStatement CountPStatement = sqlconnection.prepareStatement(CountPQuery);
                CountPStatement.setInt(1, itemcode);
                CountPStatement.setString(2, district);
                ResultSet CountP = CountPStatement.executeQuery();

                if (CountP.next()) {
                    int countpremise = CountP.getInt("numseller");
                    if (countpremise == 0) {
                        showMessageDialog(null, "Sorry There are not " + item + " in your district.\nYou cannot add it.\nPlease Select other item", "Item Not Available", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String insertitemQuery = "INSERT INTO shopping_cart "
                                + "VALUES ('" + this.item + "' , '" + itemcode + "' , '" + unit + "' , '" + Username + "' );";
                        Statement insertitemstatement = sqlconnection.createStatement();
                        int Update = insertitemstatement.executeUpdate(insertitemQuery);
                        if (Update > 0) {
                            showMessageDialog(null, "Add " + item + " successfully","Add item",JOptionPane.PLAIN_MESSAGE);
                            
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_AddToCartActionPerformed

    private void BrowseByCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseByCatActionPerformed
        Browser Bro = new Browser(Username);
        Bro.setVisible(true);
        Bro.pack();
        Bro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BrowseByCatActionPerformed

    private void ShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShoppingActionPerformed
        ShopCart Shop = new ShopCart(Username);
        Shop.setVisible(true);
        Shop.pack();
        Shop.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ShoppingActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        AccSetting Acc = new AccSetting(Username);
        Acc.setVisible(true);
        Acc.pack();
        Acc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_AccountActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton AddToCart;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat;
    private javax.swing.JButton Home;
    private javax.swing.JLabel ITEM;
    private javax.swing.JButton ItemDetails;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Modify_Admin;
    private javax.swing.JLabel SelectedItem;
    private javax.swing.JLabel SelectedUnit;
    private javax.swing.JButton Shopping;
    private javax.swing.JButton Top5;
    private javax.swing.JButton Trend;
    private javax.swing.JLabel UNIT;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
