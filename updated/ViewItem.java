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
        Menu1 = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat2 = new javax.swing.JButton();
        Shopping1 = new javax.swing.JButton();
        Account1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Home1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setForeground(new java.awt.Color(255, 255, 255));
        Welcome.setText("Welcome to Product Search and Selection");

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Stat.setEditable(false);
        Stat.setBackground(new java.awt.Color(102, 204, 255));
        Stat.setColumns(20);
        Stat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Stat.setForeground(new java.awt.Color(255, 255, 255));
        Stat.setRows(5);
        Stat.setBorder(null);
        Stat.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Stat);

        Item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Item.setForeground(new java.awt.Color(255, 255, 255));
        Item.setText("Item");

        Itemcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Itemcode.setForeground(new java.awt.Color(255, 255, 255));
        Itemcode.setText("Item code");

        UNIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UNIT.setForeground(new java.awt.Color(255, 255, 255));
        UNIT.setText("Unit");

        ItemCat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemCat.setForeground(new java.awt.Color(255, 255, 255));
        ItemCat.setText("Item Category");

        Itemsubcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Itemsubcat.setForeground(new java.awt.Color(255, 255, 255));
        Itemsubcat.setText("Item Subcategory");

        ITEM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ITEM.setForeground(new java.awt.Color(255, 255, 255));
        ITEM.setText("jLabel1");

        ITemcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ITemcode.setForeground(new java.awt.Color(255, 255, 255));
        ITemcode.setText("jLabel2");

        UNit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UNit.setForeground(new java.awt.Color(255, 255, 255));
        UNit.setText("jLabel3");

        itemcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemcat.setForeground(new java.awt.Color(255, 255, 255));
        itemcat.setText("jLabel4");

        itemsubcat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemsubcat.setForeground(new java.awt.Color(255, 255, 255));
        itemsubcat.setText("jLabel5");
        itemsubcat.setPreferredSize(new java.awt.Dimension(43, 16));

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
                        .addGap(107, 107, 107)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 225, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        UserItem Use = new UserItem(this.item,this.unit,this.Username);
        Use.setVisible(true);
        Use.pack();
        Use.setLocationRelativeTo(null);
        System.out.println(item);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account1;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat2;
    private javax.swing.JButton Home1;
    private javax.swing.JLabel ITEM;
    private javax.swing.JLabel ITemcode;
    private javax.swing.JLabel Item;
    private javax.swing.JLabel ItemCat;
    private javax.swing.JLabel Itemcode;
    private javax.swing.JLabel Itemsubcat;
    private javax.swing.JButton Logout1;
    private javax.swing.JPanel Menu1;
    private javax.swing.JButton Shopping1;
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
