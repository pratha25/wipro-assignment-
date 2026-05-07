package PS_lib;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!LoginService.login(username, password)) {

            System.out.println("Invalid Username or Password");
            return;
        }

        while (true) {

            System.out.println("\n===== BOOK STORE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Buy Book");
            System.out.println("6. Update Stock");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    BookService.addBook(sc);
                    break;

                case 2:
                    BookService.viewBooks();
                    break;

                case 3:
                    BookService.searchBook(sc);
                    break;

                case 4:
                    BookService.deleteBook(sc);
                    break;

                case 5:
                    IssueService.buyBook(sc);
                    break;

                case 6:
                    BookService.updateStock(sc);
                    break;

                case 7:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}