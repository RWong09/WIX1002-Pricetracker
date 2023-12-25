package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

public class Fuzzy {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pricetracker";
        String user = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter item name : ");
            String searchTerm = sc.nextLine();
            System.out.println();
            sc.close();

            // query to get item name list
            String itemNameListQuery = "SELECT DISTINCT `item` FROM `lookup_item`";
            PreparedStatement itemNameListStatement = connection.prepareStatement(itemNameListQuery);
            ResultSet itemNameListResult = itemNameListStatement.executeQuery();
            List<String> itemNameList = new ArrayList<>();
            while (itemNameListResult.next()) {
                itemNameList.add(itemNameListResult.getString("item"));
            }

            List<ExtractedResult> results = FuzzySearch.extractTop(searchTerm, itemNameList, 5);

            List<ExtractedResult> topMatches = findTopMatches(results, 5);
            int i = 0;
            String[] itemNameArray = new String[5];
            if (!topMatches.isEmpty()) {
                System.out.println("Top Matches:");
                for (ExtractedResult match : topMatches) {
                    String itemName = match.getString();
                    itemNameArray[i] = itemName;
                    int score = match.getScore();
                    System.out.println("Match: " + itemName + " - Score: " + score);
                    i++;
                }
            } else {
                System.out.println("No match found.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getSQLState());
        }
    }

    private static List<ExtractedResult> findTopMatches(List<ExtractedResult> results, int topN) {
        List<ExtractedResult> topMatches = new ArrayList<>(results);
        Collections.sort(topMatches, Comparator.comparingInt(ExtractedResult::getScore).reversed());

        return topMatches.subList(0, Math.min(topN, topMatches.size()));
    }
}
