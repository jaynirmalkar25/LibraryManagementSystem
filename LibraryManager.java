package main.com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        // Validate unique bookId and non-empty fields
        if (books.stream().anyMatch(b -> b.getBookId().equals(book.getBookId()))) {
            System.out.println("Book ID must be unique!");
            return;
        }
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            System.out.println("Title and Author cannot be empty!");
            return;
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public Book searchBookById(String bookId) {
        return books.stream().filter(b -> b.getBookId().equals(bookId)).findFirst().orElse(null);
    }

    public Book searchBookByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public void updateBookDetails(String bookId) {
        Book book = searchBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new Title: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Enter new Author: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Enter new Genre: ");
        book.setGenre(scanner.nextLine());
        System.out.println("Enter new Availability Status (Available/Checked Out): ");
        book.setAvailabilityStatus(scanner.nextLine());

        System.out.println("Book details updated successfully.");
    }

    public void deleteBook(String bookId) {
        books.removeIf(b -> b.getBookId().equals(bookId));
        System.out.println("Book deleted successfully.");
    }
}

