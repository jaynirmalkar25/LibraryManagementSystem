package main.com.library;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book Details");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String status = scanner.nextLine();
                    manager.addBook(new Book(id, title, author, genre, status));
                    break;
                case 2:
                    manager.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    Book book = manager.searchBookById(scanner.nextLine());
                    System.out.println(book != null ? book : "Book not found.");
                    break;
                case 4:
                    System.out.print("Enter Title: ");
                    book = manager.searchBookByTitle(scanner.nextLine());
                    System.out.println(book != null ? book : "Book not found.");
                    break;
                case 5:
                    System.out.print("Enter Book ID to update: ");
                    manager.updateBookDetails(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Book ID to delete: ");
                    manager.deleteBook(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
