package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewItem extends javax.swing.JFrame {

    private int itemcode;    
    private String item;
    private String unit;
    private String Username;


    ViewItem(int itemcode, String item, String unit, String Username) {
        initComponents();
        this.itemcode = itemcode;
        this.item=item;
        this.unit=unit;
        this.Username = Username;
        
        USER.setText(Username);
        
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
 
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            String DetailsQuery = "SELECT * FROM lookup_item WHERE item_code = ?";
            PreparedStatement DetailsStatement = sqlconnection.prepareStatement(DetailsQuery);
            DetailsStatement.setInt(1, itemcode);
            ResultSet ItemDetails= DetailsStatement.executeQuery();

            while (ItemDetails.next()) {
                ITemcode.setText(ItemDetails.getString("item_code"));
                ITEM.setText(ItemDetails.getString("item"));
                UNit.setText(ItemDetails.getString("unit"));
                itemcat.setText(ItemDetails.getString("item_group"));
                itemsubcat.setText(ItemDetails.getString("item_category"));      
            }
            
            String districtQuery = "SELECT district FROM user WHERE username = ?;";
            PreparedStatement districtStatement = sqlconnection.prepareStatement(districtQuery);

            districtStatement.setString(1, Username);
            ResultSet DISTRICT = districtStatement.executeQuery();
            while (DISTRICT.next()) {
            String district = DISTRICT.getString("district");
            
            String CountPQuery = "SELECT COUNT(DISTINCT pricecatcher.premise_code) AS numseller "
                    + "FROM pricecatcher "
                    + "JOIN lookup_premise ON pricecatcher.premise_code = lookup_premise.premise_code "
                    + "WHERE pricecatcher.item_code = ? AND lookup_premise.district = ? ;";
            
            PreparedStatement CountPStatement= sqlconnection.prepareStatement(CountPQuery);
            CountPStatement.setInt(1, itemcode);
            CountPStatement.setString(2, district);
            ResultSet CountP= CountPStatement.executeQuery();

            while (CountP.next()) {
                int countpremise=CountP.getInt("numseller");
                Stat.setText("There are around "+countpremise+" Seller(s) in your district("+district+")");
            }
            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
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
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Stat = new javax.swing.JTextArea();
        Item = new javax.swing.JLabel();
        Itemcode = new javax.swing.JLabel();
        UNIT = new javax.swing.JLabel();
        ItemCat = new javax.swing.JLabel();
        Itemsubcat = new javax.swing.JLabel();
        ITEM = new javax.swing.JLabel();
        ITemcode = new javax.swing.JLabel();
        UNit = new javax.swing.JLabel();
        itemcat = new javax.swing.JLabel();
        itemsubcat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        Menu.setBackground(new java.awt.Color(255, 153, 153));

        USER.setText("jLabel1");

        BrowseByCat.setBackground(new java.awt.Color(255, 153, 153));
        BrowseByCat.setText("Browse by Categories");
        BrowseByCat.setBorderPainted(false);
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
                .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseByCat, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(250, 250, 250)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setText("Welcome to Product Search and Selection");

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Stat.setEditable(false);
        Stat.setBackground(new java.awt.Color(255, 204, 204));
        Stat.setColumns(20);
        Stat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Stat.setRows(5);
        Stat.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Stat);

        Item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Item.setText("Item");

        Itemcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Itemcode.setText("Item code");

        UNIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UNIT.setText("Unit");

        ItemCat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemCat.setText("Item Category");

        Itemsubcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Itemsubcat.setText("Item Subcategory");

        ITEM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ITEM.setText("jLabel1");

        ITemcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ITemcode.setText("jLabel2");

        UNit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UNit.setText("jLabel3");

        itemcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemcat.setText("jLabel4");

        itemsubcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemsubcat.setText("jLabel5");
        itemsubcat.setPreferredSize(new java.awt.Dimension(43, 16));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Itemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Itemsubcat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemCat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(UNit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ITemcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(itemsubcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(74, 74, 74))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(itemcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Welcome)
                                .addGap(265, 265, 265))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Back)
                                .addGap(74, 74, 74))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 215, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Itemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ITemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UNit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemCat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemsubcat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Itemsubcat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemcat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        UserItem Use = new UserItem(this.item,this.unit,this.Username);
        Use.setVisible(true);
        Use.pack();
        Use.setLocationRelativeTo(null);
        System.out.println(item);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat;
    private javax.swing.JLabel ITEM;
    private javax.swing.JLabel ITemcode;
    private javax.swing.JLabel Item;
    private javax.swing.JLabel ItemCat;
    private javax.swing.JLabel Itemcode;
    private javax.swing.JLabel Itemsubcat;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Shopping;
    private javax.swing.JTextArea Stat;
    private javax.swing.JLabel UNIT;
    private javax.swing.JLabel UNit;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JLabel itemcat;
    private javax.swing.JLabel itemsubcat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
