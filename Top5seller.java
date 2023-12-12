package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Top5seller {

    public static void main(String[] args) {
        // JDBC database URL, username, and password of MySQL server
        String url = "jdbc:mysql://127.0.0.1:3306/csv";
        String user = "root";
        String password = "";

        try {
            // Establish a connection
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            // Take user input for the item
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the item:");
            String item_input = sc.nextLine();

            String CheckItemNameQuery= "SELECT COUNT(item) FROM lookup_item where item= ?;";
            PreparedStatement CheckItemName = sqlconnection.prepareStatement(CheckItemNameQuery);
            CheckItemName.setString(1, item_input);
            ResultSet checkItemName = CheckItemName.executeQuery();
            int count_item=-1;
            if (checkItemName.next()) {
                 count_item = checkItemName.getInt(1);}
            ResultSet ItemCode;
            if(count_item>1)
            {    System.out.println("There are multiple items with the same name. Enter the unit:");
            String unit_input = sc.nextLine();
                String itemCodeQuery2 = "SELECT item_code FROM lookup_item WHERE item = ? AND unit = ?";
                PreparedStatement CheckItemCode2 = sqlconnection.prepareStatement(itemCodeQuery2);
                CheckItemCode2.setString(1, item_input);
                CheckItemCode2.setString(2,unit_input);
                 ItemCode = CheckItemCode2.executeQuery();
            }
            else {
                String itemCodeQuery = "SELECT item_code FROM lookup_item WHERE item = ?";
                PreparedStatement CheckItemCode = sqlconnection.prepareStatement(itemCodeQuery);
                CheckItemCode.setString(1, item_input);
                ItemCode = CheckItemCode.executeQuery();
            }

            // Check if the item exists
            if (ItemCode.next()) {
                // Retrieve the item code
                String itemCode = ItemCode.getString("item_code");


                // Prepare and execute the SQL query to get top 5 prices
                String topPricesQuery = " SELECT lookup_premise.address, pricecatcher.price,lookup_premise.premise " +
                        "FROM pricecatcher " +
                        "JOIN lookup_premise ON pricecatcher.premise_code = lookup_premise.premise_code " +
                        "WHERE pricecatcher.item_code = ? " +
                        "ORDER BY pricecatcher.price ASC " +
                        "LIMIT 5";

                PreparedStatement topPricesStatement = sqlconnection.prepareStatement(topPricesQuery);
                topPricesStatement.setString(1, itemCode);
                ResultSet TopSeller = topPricesStatement.executeQuery();
                System.out.println("Top 5 Cheapest Sellers for "+item_input);
                // Process the result set
                int i=1;
                if(TopSeller.next()) {
                    while (TopSeller.next()) {
                        double price = TopSeller.getDouble("price");
                        String address = TopSeller.getString("address");
                        String premise = TopSeller.getString("premise");
                        System.out.println(i++ + ". " + premise);
                        System.out.println("Price:  RM" + price);
                        System.out.println("Address: " + address);
//442 item /756
                        //1489 20899

                    }

                }
                else{
                    System.out.println("There are no data in table");
                }

                // Close the resources
                TopSeller.close();
                topPricesStatement.close();
            } else {
                System.out.println("Item not found.");
            }

            // Close the resources
            ItemCode.close();
            sqlconnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}