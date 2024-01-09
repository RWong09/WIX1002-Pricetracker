package PriceTracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ShopCart extends javax.swing.JFrame {

    private static String Username;
    static String district;
    static double lastPrice = 0;
    JFrame suggestFrame = new JFrame("Suggestion Window");
    JPanel suggestPanel = new JPanel();
    JScrollPane scrollPanel = new JScrollPane(suggest);
    private static JTextArea suggest = new JTextArea();
    static List<Integer> premiseCodeInShopCart = new ArrayList<>();
    static List<Integer> itemCodeToBeSelected = new ArrayList<>();
    static List<Integer> itemRepetition = new ArrayList<>();
    static List<Integer> item_count = new ArrayList<>();
    static Map<Integer, Integer> priceMulti = new HashMap<>();
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
        DefaultTableModel model = (DefaultTableModel) ShopCartTable.getModel();

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

    class PriceTracker extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(219, 215, 210);
            Color color2 = new Color(176, 196, 222);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new PriceTracker();
        SHOPPINGCART = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShopCartTable = new javax.swing.JTable();
        Remove = new javax.swing.JButton();
        Menu = new javax.swing.JPanel();
        USER = new javax.swing.JLabel();
        BrowseByCat = new javax.swing.JButton();
        Shopping = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Suggest = new javax.swing.JButton();
        NewBie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        SHOPPINGCART.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SHOPPINGCART.setForeground(new java.awt.Color(29, 41, 81));
        SHOPPINGCART.setText("Shopping Cart");

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Welcome.setForeground(new java.awt.Color(29, 41, 81));
        Welcome.setText("Welcome to Product Search and Selection");

        ShopCartTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ShopCartTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(ShopCartTable);
        if (ShopCartTable.getColumnModel().getColumnCount() > 0) {
            ShopCartTable.getColumnModel().getColumn(0).setPreferredWidth(800);
            ShopCartTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setForeground(new java.awt.Color(255, 255, 255));

        USER.setText("jLabel1");
        USER.setPreferredSize(new java.awt.Dimension(37, 43));

        BrowseByCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceTracker/icons8-search-48.png"))); // NOI18N
        BrowseByCat.setBorderPainted(false);
        BrowseByCat.setPreferredSize(new java.awt.Dimension(144, 43));
        BrowseByCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseByCatActionPerformed(evt);
            }
        });

        Shopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceTracker/icons8-cart-48.png"))); // NOI18N
        Shopping.setBorderPainted(false);
        Shopping.setPreferredSize(new java.awt.Dimension(107, 43));
        Shopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShoppingActionPerformed(evt);
            }
        });

        Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceTracker/icons8-setting-48.png"))); // NOI18N
        Account.setBorderPainted(false);
        Account.setPreferredSize(new java.awt.Dimension(114, 43));
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });

        Logout.setText("Log Out");
        Logout.setBorderPainted(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceTracker/icons8-home-48.png"))); // NOI18N
        Home.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        Suggest.setText("Suggest");
        Suggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestActionPerformed(evt);
            }
        });

        NewBie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceTracker/A-removebg-preview (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Suggest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewBie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(SHOPPINGCART))
                            .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(285, 285, 285))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SHOPPINGCART)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(NewBie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Suggest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Back)))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
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
        Home HomeFrame = new Home(Username);
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) ShopCartTable.getModel();
        int[] selectedRows = ShopCartTable.getSelectedRows();

        if (selectedRows.length > 0) {
            try {
                Connection sqlconnection = DriverManager.getConnection(url, user, password);
                int Confirm = showConfirmDialog(null, "Do you sure want to remove this item?", "Confirm", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                int delete = 0;
                if (Confirm == YES_OPTION) {
                    int selectedRowIndex = selectedRows[0];
                    for (int i = 0; i < selectedRows.length; i++) {
                        Object item = model.getValueAt(selectedRowIndex, ShopCartTable.getSelectedColumn());
                        String deleteQuery = "DELETE FROM shopping_cart WHERE `username` = '" + Username + "' AND item ='" + item + "' LIMIT 1;";
                        Statement deleteStatement = sqlconnection.createStatement();
                        delete += deleteStatement.executeUpdate(deleteQuery);
                        model.removeRow(selectedRowIndex);
                    }
                    if (delete > 0) {
                        showMessageDialog(null, "Delete successfully " + delete + " item(s)", "Delete", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            showMessageDialog(null, "You have not selected any items to remove!", "Remove Item", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_RemoveActionPerformed

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

    private void SuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestActionPerformed

        suggestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        suggest.setEditable(false);
        suggestFrame.add(scrollPanel);
        
        suggest.setSize(600, 600);
        scrollPanel.setPreferredSize(new Dimension(600, 800));
        suggestFrame.setSize(600, 600);
        

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

            String allItemquery = "SELECT DISTINCT item_code ,COUNT(item_code) AS itemRepetition FROM shopping_cart WHERE username =  '" + Username + "' "
                    + "GROUP BY item_code";

            ResultSet queryResult = premiseCodeAvailableStatement.executeQuery(allItemquery);
            while (queryResult.next()) {
                int itemCode = queryResult.getInt("item_code");
                itemCodeToBeSelected.add(itemCode);
                priceMulti.put(itemCode, queryResult.getInt("itemRepetition"));
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
        premiseCodeInShopCart.clear();
        itemCodeToBeSelected.clear();
        item_count.clear();
        premiseItemNPrice.clear();
        selectedSet.clear();
    }

    private static Map<Integer, Double> createItemPrices(int premiseCode) {
        Map<Integer, Double> innerMap = new HashMap<>();
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            String itemNPriceQuery = "SELECT shopping_cart.item_code AS itemcode, rankedpricetable.price AS Price "
                    + "FROM rankedpricetable "
                    + "JOIN shopping_cart ON shopping_cart.item_code = rankedpricetable.item_code "
                    + "WHERE shopping_cart.username = '" + Username + "' "
                    + "AND rankedpricetable.district = '" + district + "' "
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
        Map<Integer, Double> maxInnerMap = new HashMap<>();
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
        StringBuilder resultText = new StringBuilder();
        try {
            Connection sqlconnection = DriverManager.getConnection(url, user, password);
            for (Map.Entry<Integer, Map<Integer, Double>> entry : selectedSet.entrySet()) {
                int premiseCode = entry.getKey();

                Statement details = sqlconnection.createStatement();
                String Findpremisequery = "SELECT premise,address FROM lookup_premise where premise_code = " + premiseCode;
                ResultSet FindpremiseResult = details.executeQuery(Findpremisequery);
                String address = null, premise = null;
                while (FindpremiseResult.next()) {
                    premise = FindpremiseResult.getString("premise");
                    address = FindpremiseResult.getString("address");
                }

                Map<Integer, Double> itemNPrice = entry.getValue();
                resultText.append("Premise Code: ").append(premiseCode).append("\n");
                resultText.append(premise).append("\n").append(address).append("\n");
                resultText.append("---".repeat(50)).append("\n");
                resultText.append("Item\t\tPrice\n");
                resultText.append("---".repeat(50)).append("\n");

                for (Map.Entry<Integer, Double> itemEntry : itemNPrice.entrySet()) {
                    int itemCode = itemEntry.getKey();

                    String Finditemquery = "SELECT item FROM lookup_item where item_code = " + itemCode;
                    ResultSet FinditemResult = details.executeQuery(Finditemquery);
                    String item = null;
                    while (FinditemResult.next()) {
                        item = FinditemResult.getString("item");
                    }

                    int tempItemCode = itemCode;
                    int space = 0;
                    int counter = 0;
                    while (tempItemCode != 0) {
                        tempItemCode /= 10;
                        counter++;
                    }
                    switch (counter) {
                        case 1 ->
                            space = 18;
                        case 2 ->
                            space = 16;
                        case 3 ->
                            space = 14;
                        case 4 ->
                            space = 12;
                        case 5 ->
                            space = 10;
                    }
                    double price = itemEntry.getValue();
                    double secondPrice = price * (priceMulti.get(itemCode));
                    resultText.append(item);
                    resultText.append("\nItem Code:       ").append(itemCode).append(" ".repeat(space));
                    resultText.append(String.format("Item Price(Per Item): RM %.2f\t", price));
                    resultText.append("Quantity : ").append(priceMulti.get(itemCode)).append("\t\t\t\n");
                    lastPrice += secondPrice;
                }
                resultText.append("---".repeat(50)).append("\n");
            }
            resultText.append(String.format("Total Price : RM %.2f\n", lastPrice));
            lastPrice = 0;
            suggest.setText(resultText.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SuggestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseByCat;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel NewBie;
    private javax.swing.JButton Remove;
    private javax.swing.JLabel SHOPPINGCART;
    private javax.swing.JTable ShopCartTable;
    private javax.swing.JButton Shopping;
    private javax.swing.JButton Suggest;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel Welcome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
