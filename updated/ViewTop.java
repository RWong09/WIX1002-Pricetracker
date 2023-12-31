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
        Welcome = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        txt = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cli = new javax.swing.JTextArea();
        titleTop5 = new javax.swing.JLabel();
        Menu1 = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat2 = new javax.swing.JButton();
        Shopping1 = new javax.swing.JButton();
        Account1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Home1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        txtLayout.setVerticalGroup(
            txtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        titleTop5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleTop5.setForeground(new java.awt.Color(255, 255, 255));
        titleTop5.setText("Top 5 Cheapest Seller");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Back)
                            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Welcome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(titleTop5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)))
                        .addGap(289, 289, 289))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        UserItem Use = new UserItem(item, unit, Username);
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
    private javax.swing.JButton Logout1;
    private javax.swing.JPanel Menu1;
    private javax.swing.JButton Shopping1;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JTextArea cli;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleTop5;
    private javax.swing.JPanel txt;
    // End of variables declaration//GEN-END:variables
}
