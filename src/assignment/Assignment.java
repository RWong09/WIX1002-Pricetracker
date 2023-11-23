/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) throws Exception {
//parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("C:\\Users\\HP\\OneDrive\\Desktop\\UM\\WIX1002\\Assignment\\lookup_premise.csv"));
//        sc.useDelimiter(",");   //sets the delimiter pattern  
//        String[] premise_code;
//        String[] premise;
//        while (sc.hasNext()) //returns a boolean value  
//        {
//            String s = sc.next();
//            System.out.print(sc.next() + " ");
//            try {
//                if (s.contains("\"")) {
//                    s.replace("\"", "");
//                }
//            } catch (Exception e) {
//
//            }
//
////find and returns the next complete token from this scanner  
//        }
//
//        sc.close();  //closes the scanner  

        List<List<String>> records = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\UM\\WIX1002\\Assignment\\lookup_premise.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String COMMA_DELIMITER=",";
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        System.out.println(records.get(2));
        System.out.println(records.get(2).get(3));
    }
}
