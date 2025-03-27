# Digital Library Book Management System  

This is a simple **Java-based console application** designed to manage a digital library's book records. It allows users (librarians) to add, update, view, search, and delete books from the collection. The system is modular, handles exceptions, and enforces basic validation rules (e.g., unique Book IDs).

---

## **Features**
- **Add a Book:** Add a new book by entering the Book ID, Title, Author, Genre, and Availability.  
- **View All Books:** Display all the books currently in the library.  
- **Search Books:** Search by Book ID or Title.  
- **Update Book Details:** Modify book information, such as the title, author, or availability status.  
- **Delete a Book:** Remove a book record from the library collection.  
- **Exit the System:** End the program.  

---

## **Project Folder Structure**
src
└── main
└── com
└── library
├── Book.java // Represents the Book entity
└── LibraryManager.java // Main class with the application logic


---

## **Setup Instructions**  

### **1. Prerequisites**
- Java Development Kit (JDK) 8 or higher  
- Eclipse IDE or any Java IDE (Optional)  

### **2. Steps to Run in Eclipse**  
1. **Clone the Repository**  
   Clone the GitHub repository locally or download the source code files.
   git clone <repository-link>


2.**Open Eclipse**
Go to File > Open Projects from File System and import the project folder.
The folder should follow the structure mentioned above.

3.**Run the Program**
Navigate to the LibraryManager.java file.
Right-click on the file and select Run As > Java Application.

4.**Using the Menu**
Follow the menu options displayed in the console to interact with the Digital Library system.

### **Example Program Output**
--- Digital Library Book Management System ---
1. Add a Book
2. View All Books
3. Search Book by ID or Title
4. Update Book Details
5. Delete a Book
6. Exit
Enter your choice: 

### **Code Highlights**
Input Validation:
Book IDs must be unique.
Title and Author must be non-empty strings.
Availability status must be either "Available" or "Checked Out".

## Exception Handling:
Catches invalid inputs (e.g., non-integer Book IDs).
Provides user-friendly messages when invalid data is entered.

## Modular Design:
The code is divided into methods (addBook(), viewAllBooks(), etc.) for easy maintenance and scalability.

### **Potential Improvements**
If given more time, the following improvements could be made:
Database Integration: Store and manage book records in a database instead of an in-memory collection.
GUI Enhancement: Build a graphical user interface for better user interaction.
Additional Features: Implement book borrowing/returning functionality, along with user authentication.

### **Reflection and Challenges Faced**
During the development process, key challenges included implementing robust input validation and exception handling to ensure smooth user experience. These were addressed by adding checks for null or invalid inputs and gracefully handling exceptions with appropriate messages.


## Author
Created as part of a Java learning project focused on object-oriented programming (OOP) concepts and modular application design.
