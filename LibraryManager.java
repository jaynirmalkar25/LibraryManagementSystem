package main.com.library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewAllBooks();
                case 3 -> searchBook();
                case 4 -> updateBookDetails();
                case 5 -> deleteBook();
                case 6 -> exitSystem();
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Digital Library Book Management System ---");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by ID or Title");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete a Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number between 1 and 6.");
            scanner.nextLine(); // Clear the invalid input
            return -1; // Return an invalid choice to prompt user again
        }
    }

    private static void addBook() {
        try {
            System.out.print("Enter Book ID (Integer): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Check for duplicate ID
            for (Book book : bookList) {
                if (book.getId() == id) {
                    System.out.println("Book ID already exists. Please enter a unique ID.");
                    return;
                }
            }

            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty!");

            System.out.print("Enter Book Author: ");
            String author = scanner.nextLine().trim();
            if (author.isEmpty()) throw new IllegalArgumentException("Author cannot be empty!");

            System.out.print("Enter Book Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Enter Availability (Available/Checked Out): ");
            String availability = scanner.nextLine().trim();
            if (!availability.equalsIgnoreCase("Available") && 
                !availability.equalsIgnoreCase("Checked Out")) {
                throw new IllegalArgumentException("Invalid availability status!");
            }

            bookList.add(new Book(id, title, author, genre, availability));
            System.out.println("Book added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for Book ID! Please enter an integer.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- Book List ---");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        scanner.nextLine(); // Consume newline left after previous input
        String searchInput = scanner.nextLine().trim();

        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (String.valueOf(book.getId()).equals(searchInput) || 
                book.toString().toLowerCase().contains(searchInput.toLowerCase())) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No matching book found.");
        } else {
            System.out.println("Matching Books:");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    private static void updateBookDetails() {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book bookToUpdate = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate == null) {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Enter new Title (leave blank to keep unchanged): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isBlank()) bookToUpdate.setTitle(newTitle);

        System.out.print("Enter new Author (leave blank to keep unchanged): ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.isBlank()) bookToUpdate.setAuthor(newAuthor);

        System.out.print("Enter new Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine();
        if (!newAvailability.isBlank()) bookToUpdate.setAvailability(newAvailability);

        System.out.println("Book details updated successfully!");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();

        boolean removed = bookList.removeIf(book -> book.getId() == id);
        if (removed) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void exitSystem() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }
}
