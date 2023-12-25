package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Browser extends javax.swing.JFrame {

    private String Username;
    private String item;
    private String unit;
    private String url = "jdbc:mysql://localhost:3306/pricetracker";
    private String user = "root";
    private String password = "";

    Browser(String Username) {
        initComponents();
        this.Username = Username;
        USER.setText(Username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        Browse = new javax.swing.JButton();
        Shopping = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        BrowseByCat = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        SubCategory = new javax.swing.JLabel();
        Cat = new javax.swing.JComboBox<>();

        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            // Query to get distinct item groups
            String categoryQuery = "SELECT DISTINCT item_group FROM lookup_item";
            PreparedStatement categoryStatement = sqlconnection.prepareStatement(categoryQuery);
            ResultSet categoryResult = categoryStatement.executeQuery();
            while (categoryResult.next()) {
                Cat.addItem(categoryResult.getString("item_group"));
            }

        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
        SubCat = new javax.swing.JComboBox<>();
        Next = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        ITEM = new javax.swing.JLabel();
        Item = new javax.swing.JComboBox<>();
        UNIT = new javax.swing.JLabel();
        Unit = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        Menu.setBackground(new java.awt.Color(255, 153, 153));

        USER.setText("jLabel1");

        Browse.setBackground(new java.awt.Color(255, 153, 153));
        Browse.setText("Browse by Categories");
        Browse.setBorderPainted(false);

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
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MenuLayout.createSequentialGroup()
                                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10))))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(Browse, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(236, 236, 236)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setText("  Welcome to Product Search and Selection");

        BrowseByCat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BrowseByCat.setText("Browse by Categories");

        Category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Category.setText("Select a Categories:");

        SubCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SubCategory.setText("Select a Sub Categories:");

        Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatActionPerformed(evt);
            }
        });

        SubCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCatActionPerformed(evt);
            }
        });

        Next.setText("Next >>");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        ITEM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ITEM.setText("Item:");

        Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemActionPerformed(evt);
            }
        });

        UNIT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UNIT.setText("Unit:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Unit, 0, 647, Short.MAX_VALUE)
                                    .addComponent(Item, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SubCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SubCat, 0, 647, Short.MAX_VALUE)
                                    .addComponent(Cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(298, 298, 298))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Back)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BrowseByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(304, 304, 304))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Welcome)
                                .addGap(227, 227, 227))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseByCat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubCat, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(SubCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ITEM)
                    .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UNIT))
                .addGap(18, 18, 18)
                .addComponent(Next)
                .addGap(152, 152, 152)
                .addComponent(Back)
                .addGap(19, 19, 19))
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

    private void CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatActionPerformed
        SubCat.removeAllItems();
        Object selectedCategory = Cat.getSelectedItem();

        // Check if an item is selected
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String Catquery = "SELECT DISTINCT item_category FROM lookup_item WHERE item_group = ?;";
            PreparedStatement CatStatement = sqlconnection.prepareStatement(Catquery);
            CatStatement.setObject(1, selectedCategory);
            ResultSet itemGroup = CatStatement.executeQuery();

            while (itemGroup.next()) {
                SubCat.addItem(itemGroup.getString("item_category"));
            }
            
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
//        updateSubCatComboBox(selectedCategory);

    }//GEN-LAST:event_CatActionPerformed

    private void SubCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCatActionPerformed
        Item.removeAllItems();
        Object selectedSubCategory = SubCat.getSelectedItem();

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String itemFromSameSubCat = "SELECT DISTINCT item FROM lookup_item WHERE item_category = ?;";
            PreparedStatement itemFromSameSubCatStatement = sqlconnection.prepareStatement(itemFromSameSubCat);
            itemFromSameSubCatStatement.setObject(1, selectedSubCategory);
            ResultSet itemFromSameSubCatResult = itemFromSameSubCatStatement.executeQuery();
            while (itemFromSameSubCatResult.next()) {
                Item.addItem(itemFromSameSubCatResult.getString("item"));
            }

        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_SubCatActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        item = (String) Item.getSelectedItem();
        unit = (String) Unit.getSelectedItem();
        UserItem Use = new UserItem(item, unit, this.Username);
        Use.setVisible(true);
        Use.pack();
        Use.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_NextActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Home HomeFrame = new Home(this.Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemActionPerformed
        Unit.removeAllItems();
        Object itemSelected = Item.getSelectedItem();

        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String MultipleCurrentUnitQuery = "SELECT DISTINCT `unit` FROM `lookup_item` WHERE `item` = ?";
            PreparedStatement MultipleCurrentUnitStatement = sqlconnection.prepareStatement(MultipleCurrentUnitQuery);
            MultipleCurrentUnitStatement.setObject(1, itemSelected);
            ResultSet MultipleCurrentUnitResult = MultipleCurrentUnitStatement.executeQuery();
            while (MultipleCurrentUnitResult.next()) {
                Unit.addItem(MultipleCurrentUnitResult.getString("unit"));
            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_ItemActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        AccSetting Acc = new AccSetting(this.Username);
        Acc.setVisible(true);
        Acc.pack();
        Acc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_AccountActionPerformed

    private void ShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShoppingActionPerformed
        ShopCart Shop = new ShopCart(this.Username);
        Shop.setVisible(true);
        Shop.pack();
        Shop.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ShoppingActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Browser("T").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Back;
    private javax.swing.JButton Browse;
    private javax.swing.JLabel BrowseByCat;
    private javax.swing.JComboBox<String> Cat;
    private javax.swing.JLabel Category;
    private javax.swing.JLabel ITEM;
    private javax.swing.JComboBox<String> Item;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Next;
    private javax.swing.JButton Shopping;
    private javax.swing.JComboBox<String> SubCat;
    private javax.swing.JLabel SubCategory;
    private javax.swing.JLabel UNIT;
    private javax.swing.JLabel USER;
    private javax.swing.JComboBox<String> Unit;
    private javax.swing.JLabel Welcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
