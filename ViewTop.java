package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViewTop extends javax.swing.JFrame {

    private String Username;
    private String item;
    private String unit;
    private int itemcode;

    ViewTop(int itemcode, String item, String unit, String Username) {
        // Call the default constructor to initialize the GUI components
        initComponents();
        this.item = item;
        this.unit = unit;
        this.itemcode = itemcode;
        this.Username = Username;
//        System.out.println(Username);
//        System.out.println(item + " " + itemcode + " " + unit);
        USER.setText(Username);

        java.util.List<Record> topSellersList = new java.util.ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try (Connection sqlconnection = DriverManager.getConnection(url, user, password)) {
            String districtQuery = "SELECT district FROM user WHERE username = ?;";
            PreparedStatement districtStatement = sqlconnection.prepareStatement(districtQuery);

            districtStatement.setString(1, Username);
            ResultSet DISTRICT = districtStatement.executeQuery();
            while (DISTRICT.next()) {
                String district = DISTRICT.getString("district");

                String topPricesQuery = "SELECT DISTINCT lookup_premise.address,MIN(pricecatcher.price) AS MinPrice,lookup_premise.premise "
                        + "FROM pricecatcher "
                        + "JOIN lookup_premise ON pricecatcher.premise_code = lookup_premise.premise_code "
                        + "WHERE pricecatcher.item_code = ? AND lookup_premise.district = ? "
                        + "GROUP BY lookup_premise.address, lookup_premise.premise "
                        + "ORDER BY MinPrice ASC "
                        + "LIMIT 5;";

                PreparedStatement topPricesStatement = sqlconnection.prepareStatement(topPricesQuery);
                topPricesStatement.setInt(1, itemcode);
                topPricesStatement.setString(2, district);
                ResultSet TopSeller = topPricesStatement.executeQuery();

                if (TopSeller.next()) {
                    do {
                        double price = TopSeller.getDouble("MinPrice");
                        String address = TopSeller.getString("address");
                        String premise = TopSeller.getString("premise");
//                    System.out.println("1" + price + "2" + address + "3" + premise);
                        topSellersList.add(new Record(premise, price, address));

                    } while (TopSeller.next());
                    displayTopSellers(topSellersList);
                } else {
                cli.setText("There are no data available in this district");
            }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayTopSellers(java.util.List<Record> topSellersList) {
        StringBuilder topSellerInfo = new StringBuilder();
        int i = 1;
        for (Record topSeller : topSellersList) {
            topSellerInfo.append(i).append(". ")
                    .append("Premise: ").append(topSeller.getPremise()).append("\n ")
                    .append("Price: RM").append(String.format("%.2f", topSeller.getPrice())).append("\n ")
                    .append("Address: ").append(topSeller.getAddress())
                    .append("\n\n");

            i++;
        }
        cli.setText(topSellerInfo.toString());
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
        txt = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cli = new javax.swing.JTextArea();
        titleTop5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
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
                .addComponent(USER, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseByCat, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shopping, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(238, 238, 238)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
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

        txt.setBackground(new java.awt.Color(255, 255, 255));

        cli.setEditable(false);
        cli.setColumns(20);
        cli.setLineWrap(true);
        cli.setRows(5);
        cli.setWrapStyleWord(true);
        jScrollPane1.setViewportView(cli);

        javax.swing.GroupLayout txtLayout = new javax.swing.GroupLayout(txt);
        txt.setLayout(txtLayout);
        txtLayout.setHorizontalGroup(
            txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        txtLayout.setVerticalGroup(
            txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        titleTop5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleTop5.setText("Top 5 Cheapest Seller");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 263, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Welcome)
                                .addGap(256, 256, 256))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(titleTop5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(327, 327, 327))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Back)
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleTop5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Back)
                .addContainerGap())
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
        UserItem Use = new UserItem(this.item, this.unit, this.Username);
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
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Shopping;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JTextArea cli;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleTop5;
    private javax.swing.JPanel txt;
    // End of variables declaration//GEN-END:variables
}
