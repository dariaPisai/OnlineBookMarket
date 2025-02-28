

# Bookish

"Bookish" is a robust Java application, built on the Spring framework, that follows the Model-View-Controller (MVC) architecture. It provides users with an administrator role with an interface to efficiently manage a collection of books. The application includes functionality such as adding, editing, deleting, and searching books, ensuring ease of use and backend efficiency. The application uses multiple technologies, such as Java Persistence API (JPA) for object-relational mapping, H2 Database (for testing the connection to a temporary database), JavaServer Pages (JSP) for creating a dynamic user interface, and MySQL for the database connection.

---

## 1. Functional Specifications

### a. View Books
Users can view the full list of books, each containing details such as title, ISBN, description, price, language, publication date, and availability.

![View Books](https://github.com/user-attachments/assets/4d36f7df-f984-45e7-8ea4-21830e7c032e)

### b. Adding Cards
Users can add new cards through a form interface with validation checks.

![Add Cards](https://github.com/user-attachments/assets/b1b0e439-9cad-4660-9e3c-f573de66760c)

### c. Editing Books
Existing book details can be updated via a dedicated form.

![Edit Books](https://github.com/user-attachments/assets/a578dffb-4732-4920-b8ea-b7ffaced41c9)

### d. Deleting Books
Books can be removed from the list with user confirmation to avoid accidental deletions.

![Delete Books](https://github.com/user-attachments/assets/a129c195-7eca-4868-8866-6147c6dac323)

### e. Search for Books
A search function allows users to find books by titles, using partial and case-insensitive matches.

![Search Books](https://github.com/user-attachments/assets/542d4a70-075b-458e-88fe-0245d7048b8f)

---

## 2. Validation

- Ensures data integrity through field-level constraints, such as non-null titles, a 13-digit ISBN, positive prices, and correct data formatting.
- Personalized error messages guide users while submitting forms.

![Validation](https://github.com/user-attachments/assets/0830c0fc-9211-44c8-8fa9-0f22fb502a1f)

---

## 3. Components Description

### 3.1 Main Backend Component

#### a. Books Entity (`Books.java`)

- Represents the `ONLINE_BOOKS` database table.
- Fields include `id`, `title`, `ISBN`, `description`, `price`, `language`, `publishingDate`, `author`, and `isInStock`.
- Constraints applied using annotations such as `@NotBlank`, `@Size`, and `@Positive`.
- Validation example: ISBN must follow a 13-digit pattern.
- Each field is declared as private, and getter and setter methods are used to access them, facilitating encapsulation and correct data use.
- The class contains a `toString()` method, used for debugging during the project creation.

#### b. BookRepository Interface (`BookRepository.java`)

- Extends `JpaRepository` for CRUD operations (create, read, update, and delete), so all existing methods in `BookControllerJPA` are used within the interface.
- Contains the `findByTitleContainingIgnoreCase` method, allowing you to search by title on the website.
- Can be used to create new methods specific to the application's functionality and allows queries to be written directly in the code.
- Handles database operations in a straightforward way.

#### c. Class BookControllerJPA (`BookControllerJPA.java`)

- Manages user interactions and connects the visualization with the data warehouse.
- Controls HTTP requests and responses.
- Returns views represented by JSP pages to the user interface.
- Invokes repository methods for processing data (e.g., saving a new book to the database using `bookRepository.save()`).

**Key Methods:**

- `listAllBooks()`: Retrieves and displays all books.
- `showAddBookPage()` and `addNewBook()`: Handles the process of adding new books.
- `deleteBook()`: Handles deleting books with user confirmation.
- `searchBooks()`: Facilitates searching for books based on titles.

---

### 3.2 Secondary Backend Component

These components were created to establish the basic functionalities of the application and test them before connecting to the database. They are no longer used in the application but are retained to test for potential bugs during the transition to the database.

#### a. BookService

- Processes requests from the `BookController` class.
- Manages data operations for the books collection.

**Key Methods:**

- `findByTitle(String title)`: Returns all books in the list created in memory (not filtered by title but could be developed to include this functionality).
- `addBook(...)`: Creates a new `Books` object with a unique ID and adds it to the list created in memory.
- `deleteById(int id)`: Searches and deletes a card from the list using its ID.
- `editBook(@Valid Books book)`: Allows the administrator to edit the book details.

#### b. BookController

- Functions identically to `BookControllerJPA`, but with key differences:
  - `BookController` uses `BookService` for data management, while `BookControllerJPA` interacts with the database and uses the `BookRepository` interface.
  - `BookController` uses an in-memory list (`List<Books>`) to manage book-related data instead of a database.
  - `BookController` is useful for applications that don't need permanent data storage or for testing an application at an early stage.
  - It is not a scalable class since data is lost when the application restarts.

---

### 3.3 Frontend Component

#### a. JSP Files

- All JSP files use HTML code for page structuring, together with CSS and Bootstrap (CSS framework).
- JSP is a technology that allows Java code to be embedded in HTML structures to generate code dynamically. It bridges the gap between the backend and frontend, allowing interaction with `BookControllerJPA`.
- **`welcome.jsp`**: Serves as the home page.
- **`add-book.jsp`**: Form interface for adding or editing books, including field validation.
- **`listBooks.jsp`**: Displays the list of books and integrates search, edit, and delete functions.

#### b. Common JSP Fragments

- **`header.jspf`, `footer.jspf`, and `navigation.jspf`**: Ensure a consistent look and feel and uniform navigation on all pages.

---

## 4. Login System

The application uses Spring Security to implement a secure and efficient authentication system.

### a. Configure Spring Security (`SpringSecurityConfiguration.java`)

- Uses an `InMemoryUserDetailsManager` configuration to store user details in memory.
- Two administrator accounts are predefined:
  - `admin` with password `password123`
  - `daria` with password `password123`
- Passwords are encrypted using `BCryptPasswordEncoder` for added security.

### b. Authentication Flow

- Authentication is done through a login form generated by Spring Security.
- Users must provide a valid username and password to access the application functionalities.
- After a successful login, the user has access to all defined functionalities.
- The navigation bar includes a "Logout" option for users to exit the application securely.

### c. Additional Security Measures

- CSRF attack protection is disabled for ease of development.
- The default setting blocks unauthorized access to application resources.

---

## 5. Testing and Debugging

### a. Test Validate

- Test cases ensure that invalid entries (e.g., empty fields, incorrect ISBN formats) are rejected with appropriate error messages.

### b. Functional Testing

- End-to-end flows for adding, updating, searching, and deleting books have been verified.

### c. Debugging Tools

- **H2Console** and **POSTMAN** were used to validate database interactions and API functionality.

---

This is the final formatted version of your README file!
