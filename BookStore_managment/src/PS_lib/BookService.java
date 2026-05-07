package PS_lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookService {

    public static void addBook(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            sc.nextLine();

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String query = "insert into books(name,author,price,quantity) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

 
    public static void viewBooks() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "select * from books";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== BOOK LIST =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("quantity"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

  
    public static void searchBook(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            sc.nextLine();

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            String query = "select * from books where name=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("quantity"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

  
    public static void deleteBook(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            String query = "delete from books where book_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Deleted Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void updateStock(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();

            String query = "update books set quantity=? where book_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Stock Updated Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}