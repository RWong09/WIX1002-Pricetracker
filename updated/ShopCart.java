package loginregister;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ShopCart extends javax.swing.JFrame {

    private String Username;
    static String district;
    static double lastPrice=0;
    JFrame suggestFrame = new JFrame("Suggestion Window");
    JPanel suggestPanel = new JPanel();
    private static JTextArea suggest = new JTextArea(); 
    static List<Integer> premiseCodeInShopCart = new ArrayList<>();
    static List<Integer> itemCodeToBeSelected = new ArrayList<>();
    static List<Integer> item_count = new ArrayList<>();
    static Map<Integer, Map<Integer, Double>> premiseItemNPrice = new HashMap<>();
    static Map<Integer, Map<Integer, Double>> selectedSet = new HashMap<>();
    static String url = "jdbc:mysql://localhost:3306/pricetracker";
    static String user = "root";
    static String password = "";
    

    ShopCart(String Username) {
        initComponents();
        this.Username = Username;
        System.out.println(Username);
        USER.setText(Username);
        populateTableFromDatabase();

    }

    private void populateTableFromDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try (Connection sqlconnection = DriverManager.getConnection(url, user, password)) {
            String itemunitquery = "SELECT item, unit FROM shopping_cart WHERE username = '" + Username + "';";
            Statement itemunitStatement = sqlconnection.createStatement();
            ResultSet iu = itemunitStatement.executeQuery(itemunitquery);

            while (iu.next()) {
                String itemName = iu.getString("item");
                String itemPrice = iu.getString("unit");
                model.addRow(new Object[]{itemName, itemPrice});
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exception
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat = new javax.swing.JButton();
        Shopping = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Welcome to Product Search and Selection");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Shopping Cart");

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to Product Search and Selection");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(800);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Price:");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("jLabel5");

        jButton3.setText("Suggest");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginregister/A-removebg-preview (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(285, 285, 285))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            Object s = model.getValueAt(selectedRowIndex, jTable1.getSelectedColumn());
            try {
                Connection sqlconnection = DriverManager.getConnection(url, user, password);
                int Confirm = showConfirmDialog(null, "Do you sure want to remove this item?", "Confirm", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (Confirm == YES_OPTION) {
                    String deletequery = "DELETE FROM shopping_cart WHERE `username` = '" + Username + "'" + "AND item ='" + s + "';";
                    Statement deleteStatement = sqlconnection.createStatement();
                    int delete = deleteStatement.executeUpdate(deletequery);
                    if (delete > 0) {
                        showMessageDialog(null, "Delete successfully", "", JOptionPane.PLAIN_MESSAGE);
                    }
                    model.removeRow(selectedRowIndex);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            showMessageDialog(null, "You does not select the item!", "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
        suggestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        suggest.setEditable(false);
        suggestPanel.add(suggest);

        suggestFrame.add(suggestPanel);
        suggest.setSize(600, 500);
        suggestPanel.setSize(600, 500);
        suggestFrame.setSize(600, 500);

        // Center the JFrame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - suggestFrame.getWidth()) / 2;
        int y = (screenSize.height - suggestFrame.getHeight()) / 2;
        suggestFrame.setLocation(x, y);

        suggestFrame.setVisible(true);
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            String districtQuery = "SELECT district FROM user WHERE username = '" + Username + "' ";
            Statement premiseCodeAvailableStatement = sqlconnection.createStatement();
            ResultSet districtget = premiseCodeAvailableStatement.executeQuery(districtQuery);
            while (districtget.next()) {
                district = districtget.getString("district");
            }

            String premiseCodeAvailableQuery = "SELECT DISTINCT premise_code, COUNT(rankedpricetable.item_code) AS item_count "
                    + "FROM rankedpricetable "
                    + "JOIN shopping_cart ON shopping_cart.item_code = rankedpricetable.item_code "
                    + "WHERE shopping_cart.username = '" + Username + "' "
                    + "AND rankedpricetable.district ='" + district + "' "
                    + "GROUP BY premise_code";

            ResultSet premiseCodeAvailableResult = premiseCodeAvailableStatement.executeQuery(premiseCodeAvailableQuery);

            while (premiseCodeAvailableResult.next()) {
                premiseCodeInShopCart.add(premiseCodeAvailableResult.getInt("premise_code"));
                item_count.add(premiseCodeAvailableResult.getInt("item_count"));
            }

            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

            List<Future<Map<Integer, Double>>> futures = new ArrayList<>();

            for (int i = 0; i < premiseCodeInShopCart.size(); i++) {
                int premiseCode = premiseCodeInShopCart.get(i);
                Future<Map<Integer, Double>> future = executorService.submit(() -> createItemPrices(premiseCode));
                futures.add(future);
            }

            for (int i = 0; i < premiseCodeInShopCart.size(); i++) {
                try {
                    Map<Integer, Double> itemNPrices = futures.get(i).get();
                    premiseItemNPrice.put(premiseCodeInShopCart.get(i), itemNPrices);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            String allItemquery = "SELECT item_code FROM shopping_cart WHERE username = '" + Username + "' ";
            ResultSet queryResult = premiseCodeAvailableStatement.executeQuery(allItemquery);
            while (queryResult.next()) {
                itemCodeToBeSelected.add(queryResult.getInt("item_code"));
            }
            while (!itemCodeToBeSelected.isEmpty()) {
                selection();
            }

            printSelectedSet();
            executorService.shutdown();
            sqlconnection.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static Map<Integer, Double> createItemPrices(int premiseCode) {
        Map<Integer, Double> innerMap = new HashMap<>();
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            String itemNPriceQuery = "SELECT shopping_cart.item_code AS itemcode, rankedpricetable.price AS Price "
                    + "FROM rankedpricetable "
                    + "JOIN shopping_cart ON shopping_cart.item_code = rankedpricetable.item_code "
                    + "WHERE rankedpricetable.district = '" + district + "' "
                    + "AND rankedpricetable.premise_code = ? ;";

            PreparedStatement itemNPriceStatement = sqlconnection.prepareStatement(itemNPriceQuery);
            itemNPriceStatement.setInt(1, premiseCode);

            ResultSet itemNPriceResult = itemNPriceStatement.executeQuery();

            while (itemNPriceResult.next()) {
                int itemCodeFromRanked = itemNPriceResult.getInt("itemcode");
                double price = itemNPriceResult.getDouble("Price");
                innerMap.put(itemCodeFromRanked, price);
            }

            sqlconnection.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return innerMap;
    }

    private static void selection() {
        int maxInnerMapSize = 0;
        Map<Integer, Double> maxInnerMap = null;
        int selectedPremiseCode = 0;
        List<Integer> keysToRemove = new ArrayList<>(); // New list to store keys to be removed

        for (Map.Entry<Integer, Map<Integer, Double>> entry : premiseItemNPrice.entrySet()) {
            int premiseCode = entry.getKey();
            Map<Integer, Double> itemNPrice = entry.getValue();
            int innerMapSize = itemNPrice.size();

            if (innerMapSize > maxInnerMapSize) {
                maxInnerMap = itemNPrice;
                maxInnerMapSize = innerMapSize;
                selectedPremiseCode = premiseCode;

            } else if (innerMapSize == maxInnerMapSize) {
                List<Integer> commonItems = new ArrayList<>(itemNPrice.keySet());
                commonItems.retainAll(maxInnerMap.keySet());

                if (compareInnerMapPrices(itemNPrice, commonItems) < compareInnerMapPrices(maxInnerMap, commonItems)) {
                    maxInnerMap = itemNPrice;
                    maxInnerMapSize = innerMapSize;
                    selectedPremiseCode = premiseCode;

                }
            }
        }

        if (maxInnerMap != null) {
            keysToRemove.addAll(maxInnerMap.keySet());
            Map<Integer, Double> selectedInnerMap = new HashMap<>(maxInnerMap);
            selectedSet.put(selectedPremiseCode, selectedInnerMap);
            itemCodeToBeSelected.removeAll(keysToRemove);

            for (Map<Integer, Double> itemNPrice : premiseItemNPrice.values()) {
                for (Integer keyToRemove : keysToRemove) {
                    itemNPrice.remove(keyToRemove);
                }
            }

            keysToRemove.clear(); // Clear the list for the next iteration
        }

    }

    private static double compareInnerMapPrices(Map<Integer, Double> itemPrices, List<Integer> commonItems) {
        double totalInnerMapPrice = 0.0;

        List<Integer> commonItemsCopy = new ArrayList<>(commonItems);

        for (int itemCode : commonItemsCopy) {
            if (itemPrices.containsKey(itemCode)) {
                totalInnerMapPrice += itemPrices.get(itemCode);
            }
        }
        return totalInnerMapPrice;
    }

    private static void printSelectedSet() {
        for (Map.Entry<Integer, Map<Integer, Double>> entry : selectedSet.entrySet()) {
            int premiseCode = entry.getKey();
            Map<Integer, Double> itemNPrice = entry.getValue();
            suggest.setText("Premise Code: " + premiseCode+"\n");
            suggest.setText("Item and Prices:\n");
            for (Map.Entry<Integer, Double> itemEntry : itemNPrice.entrySet()) {
                int itemCode = itemEntry.getKey();
                double price = itemEntry.getValue();
                suggest.setText(String.format("Item Code: %-6d-Price: %-5.2f\n",itemCode, price));
                lastPrice += price;
            }
            suggest.setText("-------------------\n");
        }
        suggest.setText(String.format("Total Price : %.2f\n" , lastPrice));
    

    
  
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton BrowseByCat;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Shopping;
    private javax.swing.JLabel USER;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
