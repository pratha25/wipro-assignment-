package PS_lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class IssueService {

    public static void buyBook(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String customer = sc.nextLine();

            System.out.print("Enter Book Name: ");
            String book = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String getPrice = "select price from books where name=?";

            PreparedStatement ps1 = con.prepareStatement(getPrice);

            ps1.setString(1, book);

            ResultSet rs = ps1.executeQuery();

            double price = 0;

            if (rs.next()) {

                price = rs.getDouble("price");
            }

            else {

                System.out.println("Book Not Found");
                return;
            }

            double total = price * quantity;

            String query = "insert into orders(customer_name,book_name,quantity,total) values(?,?,?,?)";

            PreparedStatement ps2 = con.prepareStatement(query);

            ps2.setString(1, customer);
            ps2.setString(2, book);
            ps2.setInt(3, quantity);
            ps2.setDouble(4, total);

            ps2.executeUpdate();

            System.out.println("\n===== BILL =====");

            System.out.println("Customer Name: " + customer);

            System.out.println("Book Name: " + book);

            System.out.println("Price: " + price);

            System.out.println("Quantity: " + quantity);

            System.out.println("Total Amount: " + total);

            System.out.println("================");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}