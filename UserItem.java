package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UserItem extends javax.swing.JFrame {

    private  String Username;
    private  String item;
    private  String unit;
    private  int itemcode;

  
    public UserItem(String item, String unit, String Username) {
        
        initComponents();
        ITEM.setText(item);
        UNIT.setText(unit);
        USER.setText(Username);
        
        this.Username = Username;
        this.item=item;
        this.unit=unit;
        
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
        Menu = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat = new javax.swing.JButton();
        Shopping = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        Menu.setBackground(new java.awt.Color(255, 153, 153));

        USER.setText("jLabel1");

        BrowseByCat.setBackground(new java.awt.Color(255, 153, 153));
        BrowseByCat.setText("Browse by Categories");
        BrowseByCat.setBorderPainted(false);
        BrowseByCat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BrowseByCatMouseMoved(evt);
            }
        });
        BrowseByCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseByCatActionPerformed(evt);
            }
        });

        Shopping.setBackground(new java.awt.Color(255, 153, 153));
        Shopping.setText("Shopping Cart");
        Shopping.setBorderPainted(false);
        Shopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShoppingActionPerformed(evt);
            }
        });

        Account.setBackground(new java.awt.Color(255, 153, 153));
        Account.setText("Account Setting");
        Account.setBorderPainted(false);
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 153, 153));
        Logout.setText("Log Out");
        Logout.setBorderPainted(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BrowseByCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseByCat, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(248, 248, 248)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        SelectedItem.setText("Selected Item:");

        ITEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ITEM.setText("jLabel2");

        UNIT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UNIT.setText("jLabel2");

        SelectedUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelectedUnit.setText("Selected Unit:");

        Modify_Admin.setText("Modify Item Details");
        Modify_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modify_AdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SelectedUnit)
                                .addGap(18, 18, 18)
                                .addComponent(UNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 244, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Top5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Trend, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Modify_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(263, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
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
                .addGap(57, 57, 57)
                .addComponent(Back)
                .addGap(23, 23, 23))
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

    private void BrowseByCatMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrowseByCatMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_BrowseByCatMouseMoved

    private void BrowseByCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseByCatActionPerformed
        Browser Bro = new Browser(this.Username);
        Bro.setVisible(true);
        Bro.pack();
        Bro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BrowseByCatActionPerformed

    private void ShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShoppingActionPerformed
        ShopCart Shop = new ShopCart(this.Username);
        Shop.setVisible(true);
        Shop.pack();
        Shop.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ShoppingActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        AccSetting Acc = new AccSetting(this.Username);
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

    private void ItemDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDetailsActionPerformed
        ViewItem Vie = new ViewItem(itemcode,this.item,this.unit, this.Username);
        Vie.setVisible(true);
        Vie.pack();
        Vie.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ItemDetailsActionPerformed

    private void Top5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Top5ActionPerformed
        ViewTop Vie = new ViewTop(itemcode,this.item,this.unit, this.Username);
        Vie.setVisible(true);
        Vie.pack();
        Vie.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Top5ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Home HomeFrame = new Home(this.Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void TrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrendActionPerformed
        PriceTrend Pri = new PriceTrend(itemcode,this.item,this.unit, this.Username);
        Pri.setVisible(true);
        Pri.pack();
        Pri.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_TrendActionPerformed

    private void Modify_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modify_AdminActionPerformed

        Modify Mod = new Modify(itemcode,this.item,this.unit, this.Username);
        Mod.setVisible(true);
        Mod.pack();
        Mod.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Modify_AdminActionPerformed

    private void AddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToCartActionPerformed
        
    }//GEN-LAST:event_AddToCartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton AddToCart;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat;
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
