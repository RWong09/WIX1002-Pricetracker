import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Browser {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pricetable";
        String user = "root";
        String password = "";

        try {
            // Establish a connection
            Connection sqlconnection = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            System.out.println("PriceTracker - Track Prices with Ease");
            System.out.println("Welcome to Product Search and Selection\n");
            System.out.println(
                    "1. Import Data\n2. Browse by Categories\n3. Search for a Product\n4. View Shopping cart\n5. Account Setting\n6. Exit\n");
            System.out.print("Enter your choice (1/2/3/4/5/6) : ");
            int firstChoice = sc.nextInt();
            System.out.println("");
            int i = 0;
            // need to add problem shooting to prevent invalid input

            switch (firstChoice) {
                case 1:
                    System.out.print("Number of data that wanted to be inserted : ");
                    int numberOfDataInserted = sc.nextInt();
                    while (i < numberOfDataInserted) {
                        System.out.print("Premise Code : ");
                        int newPremiseCode = sc.nextInt();
                        System.out.print("Item Code : ");
                        int newItemCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Item Name : ");
                        String newItemName = sc.nextLine();
                        System.out.print("Unit : ");
                        String newUnit = sc.nextLine();
                        System.out.print("Item Group : ");
                        String newItemGroup = sc.nextLine();
                        System.out.print("Item Category : ");
                        String newItemCategory = sc.nextLine();
                        System.out.print("Premise Name : ");
                        String newPremiseName = sc.nextLine();
                        System.out.print("Address : ");
                        String newAddress = sc.nextLine();
                        System.out.print("Premise Type : ");
                        String newPremiseType = sc.nextLine();
                        System.out.print("State : ");
                        String newState = sc.nextLine();
                        System.out.print("District : ");
                        String newDistrict = sc.nextLine();
                        System.out.print("Date[YYYY-MM-DD] : ");
                        String newDate = sc.nextLine();
                        System.out.print("Price : ");
                        Double newPrice = sc.nextDouble();

                        String importDataSQLItem = "INSERT INTO lookup_item(item_code, item, unit, item_group, item_category) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement importDataItem = sqlconnection.prepareStatement(importDataSQLItem);
                        importDataItem.setInt(1, newItemCode);
                        importDataItem.setString(2, newItemName);
                        importDataItem.setString(3, newUnit);
                        importDataItem.setString(4, newItemGroup);
                        importDataItem.setString(5, newItemCategory);

                        int rowsAffectedItem = importDataItem.executeUpdate();

                        // Insert data into lookup_premise table
                        String importDataSQLPremise = "INSERT INTO lookup_premise(premise_code, address, premise_type, state, district) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement importDataPremise = sqlconnection.prepareStatement(importDataSQLPremise);
                        importDataPremise.setInt(1, newPremiseCode);
                        importDataPremise.setString(2, newAddress);
                        importDataPremise.setString(3, newPremiseType);
                        importDataPremise.setString(4, newState);
                        importDataPremise.setString(5, newDistrict);

                        int rowsAffectedPremise = importDataPremise.executeUpdate();

                        // Insert data into pricecatcher table
                        String importDataSQLPriceCatcher = "INSERT INTO pricecatcher(item_code, premise_code, date, price) VALUES (?, ?, ?, ?)";
                        PreparedStatement importDataPriceCatcher = sqlconnection
                                .prepareStatement(importDataSQLPriceCatcher);
                        importDataPriceCatcher.setInt(1, newItemCode);
                        importDataPriceCatcher.setInt(2, newPremiseCode);
                        importDataPriceCatcher.setString(3, newDate);
                        importDataPriceCatcher.setDouble(4, newPrice);

                        int rowsAffectedPriceCatcher = importDataPriceCatcher.executeUpdate();

                        if (rowsAffectedItem > 0 && rowsAffectedPremise > 0 && rowsAffectedPriceCatcher > 0) {
                            System.out.println("Data added successfully to all tables!");
                        } else {
                            System.out.println("Failed to add data.");
                        }

                        importDataItem.close();
                        importDataPremise.close();
                        importDataPriceCatcher.close();
                    }
                    break;
                case 2:
                    System.out.println("Select a Category : \n");
                    // Query to get the count of distinct item groups
                    String categoryNumQuery = "SELECT COUNT(DISTINCT item_group) AS count_item_groups FROM lookup_item";
                    PreparedStatement categoryNumStatement = sqlconnection.prepareStatement(categoryNumQuery);
                    ResultSet categoryNumResult = categoryNumStatement.executeQuery();

                    int catNum = 0;

                    if (categoryNumResult.next()) {
                        catNum = categoryNumResult.getInt("count_item_groups");
                    }

                    // Query to get distinct item groups
                    String categoryQuery = "SELECT DISTINCT item_group FROM lookup_item";
                    PreparedStatement categoryStatement = sqlconnection.prepareStatement(categoryQuery);
                    ResultSet categoryResult = categoryStatement.executeQuery();
                    Map<Integer, String> categoryMap = new HashMap<>();

                    int j = 1; // Initialize j before using it in the loop
                    while (categoryResult.next()) {
                        String category = categoryResult.getString("item_group");
                        categoryMap.put(j, category);
                        System.out.println(j++ + ". " + category);
                    }
                    System.out.println((catNum + 1) + ". Back to Main Menu\n");

                    // select sub category
                    System.out.print("Enter your choice : ");
                    int categoryChoice = sc.nextInt();
                    System.out.println("");

                    if (categoryChoice == catNum + 1) {
                        break;
                    } else {
                        // query to count number of different subcategory in a category
                        String selectedCategory = categoryMap.get(categoryChoice);
                        String subCategoryNumQuery = "SELECT COUNT(DISTINCT item_category) AS count_item_category FROM lookup_item WHERE item_group = ?;";
                        PreparedStatement subCategoryNumStatement = sqlconnection.prepareStatement(subCategoryNumQuery);
                        subCategoryNumStatement.setString(1, selectedCategory);
                        ResultSet subCategoryNumResult = subCategoryNumStatement.executeQuery();

                        int subCatNum = 0;
                        if (subCategoryNumResult.next()) {
                            subCatNum = subCategoryNumResult.getInt("count_item_category");
                        }

                        // query to print all sub category of a category
                        String subCategoryQuery = "SELECT DISTINCT item_category FROM lookup_item WHERE item_group = ?;";
                        PreparedStatement subCategoryStatement = sqlconnection.prepareStatement(subCategoryQuery);
                        subCategoryStatement.setString(1, selectedCategory);
                        ResultSet subCategoryResult = subCategoryStatement.executeQuery();

                        Map<Integer, String> subCategoryMap = new HashMap<>();

                        int k = 1;
                        while (subCategoryResult.next()) {
                            String subCategory = subCategoryResult.getString("item_category");
                            subCategoryMap.put(k, subCategory);
                            System.out.println(k++ + ". " + subCategory);
                        }
                        System.out.println(subCatNum + 1 + ". Back to Main Menu\n");

                        // select item from subcategory
                        System.out.print("Enter your choice : ");
                        int subCatChoice = sc.nextInt();
                        System.out.println("");
                        if (subCatChoice == subCatNum + 1) {
                            break;
                        } else {
                            // query to get number of item in the subcategory
                            String selectedSubCategory = subCategoryMap.get(subCatChoice);
                            String itemNumInSubCat = "SELECT COUNT(DISTINCT item) AS count_item FROM lookup_item WHERE item_category = ?;";
                            PreparedStatement itemNumInSubCatStatement = sqlconnection
                                    .prepareStatement(itemNumInSubCat);
                            itemNumInSubCatStatement.setString(1, selectedSubCategory);
                            ResultSet itemNumInSubCatResult = itemNumInSubCatStatement.executeQuery();

                            int itemInSubCatNum = 0;
                            if (itemNumInSubCatResult.next()) {
                                itemInSubCatNum = itemNumInSubCatResult.getInt("count_item");
                            }

                            // query to get all the item from the same sub category
                            String itemFromSameSubCat = "SELECT DISTINCT item FROM lookup_item WHERE item_category = ?;";
                            PreparedStatement itemFromSameSubCatStatement = sqlconnection
                                    .prepareStatement(itemFromSameSubCat);
                            itemFromSameSubCatStatement.setString(1, selectedSubCategory);
                            ResultSet itemFromSameSubCatResult = itemFromSameSubCatStatement.executeQuery();

                            Map<Integer, String> itemMap = new HashMap<>();
                            int a = 1;
                            while (itemFromSameSubCatResult.next()) {
                                String itemFromSubCat = itemFromSameSubCatResult.getString("item");
                                itemMap.put(a, itemFromSubCat);
                                System.out.println(a++ + ". " + itemFromSubCat);
                            }
                            System.out.print(itemInSubCatNum + 1 + ". Back to Main Menu\n");

                            System.out.print("Enter your choice : ");
                            int itemChoice = sc.nextInt();
                            System.out.println("");

                            if (itemChoice == itemInSubCatNum + 1) {
                                break;
                            } else {
                                String itemSelected = itemMap.get(itemChoice);
                                System.out.printf("Selected %s\n", itemSelected);

                                // query to count number of item_code for item with same name
                      String itemNumWithSameName = "SELECT COUNT(DISTINCT unit) AS count_item_unit FROM lookup_item WHERE item = ?";
                        PreparedStatement itemNumWithSameNameStatement = sqlconnection.prepareStatement(itemNumWithSameName);
                        itemNumWithSameNameStatement.setString(1, itemSelected);
                        ResultSet itemNumWithSameNameResult = itemNumWithSameNameStatement.executeQuery();
                        int numOfDiffUnit = 0;
                        if (itemNumWithSameNameResult.next()) {
                            numOfDiffUnit = itemNumWithSameNameResult.getInt("count_item_unit");
                        }

                        String currentUnit = null;
                        if (numOfDiffUnit == 1) {
                            String currentUnitQuery = "SELECT `unit` FROM `lookup_item` WHERE `item` = ?";
                            PreparedStatement currentUnitStatement = sqlconnection.prepareStatement(currentUnitQuery);
                            currentUnitStatement.setString(1, itemSelected);
                            ResultSet currentUnitResult = currentUnitStatement.executeQuery();
                            if (currentUnitResult.next()) {
                                currentUnit = currentUnitResult.getString("unit");
                            }
                            
                        } else if (numOfDiffUnit > 1) {
                            String MultipleCurrentUnitQuery = "SELECT DISTINCT `unit` FROM `lookup_item` WHERE `item` = ?";
                            PreparedStatement MultipleCurrentUnitStatement = sqlconnection.prepareStatement(MultipleCurrentUnitQuery);
                            MultipleCurrentUnitStatement.setString(1, itemSelected);
                            ResultSet MultipleCurrentUnitResult = MultipleCurrentUnitStatement.executeQuery();
                            int z = 1;
                            Map<Integer, String> MultipleCurrentUnitMap = new HashMap<>();
                            while (MultipleCurrentUnitResult.next()) {
                                currentUnit = MultipleCurrentUnitResult.getString("unit");
                                MultipleCurrentUnitMap.put(z, currentUnit);
                                System.out.println(z++ + ". " + currentUnit);
                            }
                            System.out.print("Enter Your Choice : ");
                            int MultipleCurrentUnitChoice = sc.nextInt();
                            System.out.println();
                            currentUnit = MultipleCurrentUnitMap.get(MultipleCurrentUnitChoice);

                        }

                                System.out.println(
                                        "Select Action :\n1. View item details\n2. Modify item Details\n3. View top 5 cheapest seller\n4. View price trend\n5. Add to shopping cart");
                                System.out.print("Enter Your Choice : ");
                                int nextStepAfterGetItem = sc.nextInt();
                                switch (nextStepAfterGetItem) {
                                    case 1:

                                        break;

                                    case 2:
                                        modifyItemDetails(itemSelected, currentUnit);
                                        break;
                                    default:
                                        break;
                                }
                            }

                        }
                    }

                    break;
                case 3:
                    break;
            }
        } // Take user input for the item
        catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void modifyItemDetails(String itemSelected, String currentUnit) {
        String url = "jdbc:mysql://localhost:3306/pricetable";
        String user = "root";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Select which part to be modified : \n1. premise\n2. item\n3. price\n4. Delete item");
            Scanner sc1 = new Scanner(System.in);
            int thingToBeChange = sc1.nextInt();

            switch (thingToBeChange) {
                case 1:

                    break;
                case 2:
                    // query to get item code of the item selected
                    String itemCodeQuery = "SELECT `item_code` FROM `lookup_item` WHERE `item` = ? AND `unit` = ?;";
                    PreparedStatement itemCodeStatement = connection.prepareStatement(itemCodeQuery);
                    itemCodeStatement.setString(1, itemSelected);
                    itemCodeStatement.setString(2, currentUnit);
                    ResultSet itemCodeResult = itemCodeStatement.executeQuery();
                    int itemCode = 0;
                    if (itemCodeResult.next()) {
                        itemCode = itemCodeResult.getInt("item_code");
                    }

                    System.out.println(
                            "Thing to be modified in item : \n1. Item Name\n2. Unit\n3. Item Group\n4. Item Category");
                    System.out.println("Enter Your Choice");
                    int itemModification = sc1.nextInt();
                    sc1.nextLine();

                    

                    // item Name Modification
                    if (itemModification == 1) {
                        System.out.print("Change " + itemSelected + " to : ");
                        String newItemName = sc1.nextLine();
                        String modifyingItemQuery = "UPDATE `lookup_item` SET `item` = ? WHERE `item_code` = ?;";
                        PreparedStatement modifyingItemStatement = connection.prepareStatement(modifyingItemQuery);
                        modifyingItemStatement.setString(1, newItemName);
                        modifyingItemStatement.setInt(2, itemCode);
                        int rowsAffected = modifyingItemStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Item updated successfully.");
                        } else {
                            System.out.println("No rows were updated. Item not found or no changes made.");
                        }

                    // item Unit modification
                    } else if (itemModification == 2) {
                        System.out.print("Change " + currentUnit + " to : ");
                        String newItemUnit = sc1.nextLine();
                        String modifyingItemUnitQuery = "UPDATE `lookup_item` SET `unit` = ? WHERE `item_code` = ?";
                        PreparedStatement modifyingItemUnitStatement = connection.prepareStatement(modifyingItemUnitQuery);
                        modifyingItemUnitStatement.setString(1, newItemUnit);
                        modifyingItemUnitStatement.setInt(2, itemCode);
                        int rowsAffected = modifyingItemUnitStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Item updated successfully.");
                        } else {
                            System.out.println("No rows were updated. Item not found or no changes made.");
                        }

                    //item Group Modification
                    } else if (itemModification == 3) {
                        //query to get item current group
                        String currentItemGroupQuery = "SELECT `item_group` FROM `lookup` WHERE `item_code` = ?";
                        PreparedStatement currentItemGroupStatement = connection.prepareStatement(currentItemGroupQuery);
                        currentItemGroupStatement.setInt(1, itemCode);
                        ResultSet currentItemGroupResult = currentItemGroupStatement.executeQuery();
                        String currentItemGroup = null;
                        if (currentItemGroupResult.next()){
                            currentItemGroup = currentItemGroupResult.getString("item_group");
                        }

                        System.out.print("Change " + currentItemGroup + " to : ");
                        String  newItemGroup = sc1.nextLine();
                        String modifyingItemGroupQuery = "UPDATE `lookup_item` SET `item_group` = ? WHERE `item_code` = ?";
                        PreparedStatement modifyingItemGroupStatement = connection.prepareStatement(modifyingItemGroupQuery);
                        modifyingItemGroupStatement.setString(1, newItemGroup);
                        modifyingItemGroupStatement.setInt(2, itemCode);
                        int rowsAffected = modifyingItemGroupStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Item updated successfully.");
                        } else {
                            System.out.println("No rows were updated. Item not found or no changes made.");
                        }

                    //item Category Modification
                    } else if (itemModification == 4) {
                        //query to get item current category

                    } else {
                        System.out.println("Invalid input of item modification code");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please enter a valid input");

            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
