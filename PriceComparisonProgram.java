import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class PriceComparisonProgram {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            if (con != null) {
                System.out.println("Connection successful");

                // Fetch sellers and items from the database
                List<Seller> sellers = fetchSellersFromDatabase(con);
                List<Item> items = fetchItemsFromDatabase(con);

                // Create a shopping cart and allow the user to add items
                ShoppingCart cart = createShoppingCart(items);

                // Display the items in the shopping cart
                System.out.println("Items in the shopping cart:");
                for (Item item : cart.getItems()) {
                    System.out.println(item.getItemName() + " - Price: RM" + item.getPrice());
                }

                // Find the cheapest seller for each item in the cart
                System.out.println("\nCheapest sellers for selected items:");
                for (Item item : cart.getItems()) {
                    findCheapestSeller(item, sellers);
                }

                System.out.println("\nTotal cost of items in the shopping cart: RM" + cart.getTotalCost());
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static List<Seller> fetchSellersFromDatabase(Connection connection) {
        List<Seller> sellers = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            // Execute the SQL query to fetch sellers and items from pricecatcher and lookup_premise tables
            String sql = "SELECT p.premise_code, p.premise, c.item_code, c.price "
                    + "FROM lookup_premise p "
                    + "LEFT JOIN pricecatcher c ON p.premise_code = c.premise_code";
            ResultSet resultSet = statement.executeQuery(sql);

            // Map to store sellers and their items temporarily
            Map<String, Seller> sellerMap = new HashMap<>();

            // Iterate through the result set and create Seller objects
            while (resultSet.next()) {
                String premiseCode = resultSet.getString("premise_code");
                String premiseName = resultSet.getString("premise");
                String itemCode = resultSet.getString("item_code");
                double itemPrice = resultSet.getDouble("price");

                // Create a Seller if not already in the map
                Seller seller = sellerMap.computeIfAbsent(premiseCode, k -> new Seller(premiseCode, premiseName));

                // Create an Item and add it to the Seller's inventory
                Item item = new Item(itemCode, "", itemPrice); // You can fetch the item name if available
                seller.addItem(item);

                // Update the map
                sellerMap.put(premiseCode, seller);
            }

            // Add sellers from the map to the list
            sellers.addAll(sellerMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellers;
    }

    private static List<Item> fetchItemsFromDatabase(Connection connection) {
    List<Item> items = new ArrayList<>();

    try (Statement statement = connection.createStatement()) {
        String sql = "SELECT DISTINCT c.item_code, i.item, c.price "
                   + "FROM pricecatcher c "
                   + "INNER JOIN lookup_item i ON c.item_code = i.item_code";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String itemCode = resultSet.getString("item_code");
            String itemName = resultSet.getString("item");
            double itemPrice = resultSet.getDouble("price");

            Item item = new Item(itemCode, itemName, itemPrice);
            items.add(item);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return items;
}


    private static ShoppingCart createShoppingCart(List<Item> items) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add items to the shopping cart (type 'done' to finish):");
        String userInput;
        do {
            System.out.print("Item code: ");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("done")) {
                Item selectedItem = findItemByCode(userInput, items);
                if (selectedItem != null) {
                    cart.addItem(selectedItem);
                    System.out.println("Added " + selectedItem.getItemName() + " to the cart.");
                } else {
                    System.out.println("Item not found. Please enter a valid item code.");
                }
            }
        } while (!userInput.equalsIgnoreCase("done"));

        return cart;
    }

    private static Item findItemByCode(String itemCode, List<Item> items) {
        for (Item item : items) {
            if (itemCode.equals(item.getItemCode())) {
                return item;
            }
        }
        return null;
    }

    private static void findCheapestSeller(Item item, List<Seller> sellers) {
        double minPrice = Double.MAX_VALUE;
        Seller cheapestSeller = null;

        for (Seller seller : sellers) {
            for (Item sellerItem : seller.getInventory()) {
                if (item.getItemCode().equalsIgnoreCase(sellerItem.getItemCode())) {
                    if (sellerItem.getPrice() < minPrice) {
                        minPrice = sellerItem.getPrice();
                        cheapestSeller = seller;
                    }
                    break; // No need to check other items from the same seller
                }
            }
        }

        if (cheapestSeller != null) {
            System.out.println(item.getItemName() + ": Cheapest seller - " + cheapestSeller.getPremiseName()
                    + " (Premise Code: " + cheapestSeller.getPremiseCode() + ") - Price: RM" + minPrice);
        } else {
            System.out.println("No seller found for " + item.getItemName());
        }
    }
}