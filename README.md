"Bookish" is a robust Java application, built on the Spring framework, that follows the Model-View-Controller (MVC) architecture. It provides users with an administrator role with an interface to efficiently manage a collection of books.
The application includes functionality such as adding, editing, deleting and searching books, ensuring ease of use and backend efficiency. The application uses multiple technologies, such as Java Persistence API (which is used for object-relational mapping), H2 Database (which was used for testing the connection to a temporary database), JavaServer Pages (used for creating a dynamic user interface) and MySQL (for the database connection).
1. Functional Specifications

a. View books: Users can view the full list of books, each containing details such as title, ISBN, description, price, language, publication date and availability.
<img width="435" alt="image" src="https://github.com/user-attachments/assets/4d36f7df-f984-45e7-8ea4-21830e7c032e" />
b. Adding cards: Users can add new cards through a form interface with validation checks.
<img width="381" alt="image" src="https://github.com/user-attachments/assets/b1b0e439-9cad-4660-9e3c-f573de66760c" />
c. Editing books: Existing book details can be updated via a dedicated form.
<img width="452" alt="image" src="https://github.com/user-attachments/assets/a578dffb-4732-4920-b8ea-b7ffaced41c9" />
d. Deleting books: Books can be removed from the list with user confirmation to avoid accidental deletions.
<img width="452" alt="image" src="https://github.com/user-attachments/assets/a129c195-7eca-4868-8866-6147c6dac323" />
e. Search for books: A search function allows users to find books by titles, using partial and case-insensitive matches.
<img width="452" alt="image" src="https://github.com/user-attachments/assets/542d4a70-075b-458e-88fe-0245d7048b8f" />



2. Validation:
• Ensures data integrity through field-level constraints, such as non-null titles, a 13- digit ISBN, positive prices and correct data
• Personalized error messages guide users while submitting forms.
<img width="332" alt="image" src="https://github.com/user-attachments/assets/0830c0fc-9211-44c8-8fa9-0f22fb502a1f" />


3. Components Description
 
3.1 Main Backend Component

a. Books entity (Books.java):
  o Represents the ONLINE_BOOKS database table.
  o Fields include id, title, ISBN, description, price, language,
  publishingDate,author andisInStock.
  o Constraints applied using annotations such as @NotBlank, @Size and
  @Positive.
  o Validation example: ISBN must follow a 13-digit pattern.
  o Each field is declared as private and getter and setter methods are used to
  access them, which facilitates the encapsulation and correct use of the data o The class contains a toString() method, which was used for debugging
  when creating the project

b. BookRepository interface (BookRepository.java):
  o Extends JpaRepository for CRUD operations (create, read, update and
  delete), so all existing methods in BookControllerJPA are used within the
  interface.
  o This interface contains the findByTitleContainingIgnoreCase method,
  which allows you to search by title in the website.
  o The interface can also be used for the purpose of creating new methods
  specific to the application's functionality and allows queries to be written
  directly in the code
  o The main role of the interface is to handle database operations in a
  straightforward way

c. Class BookControllerJPA (BookControllerJPA.java):
  o Manage user interactions and connect the visualization with the data
  warehouse.
  o Control HTTP requests and responses
  o Returns views represented by JSP pages to the user interface
  o Invokes "repository methods" for processing data, such as saving a new book
  to the database is done using the bookRepository.save() method o Key methods:
    § listAllBooks(): retrieves and displays all books.
    § showAddBookPage() and addNewBook(): handles the process of
    adding new books.
    § deleteBook(): handles deleting books with user confirmation. § searchBooks(): Facilitates searching for books based on titles.


3.2 Secondary Backend Component
They were created in order to create the basic functionalities of the application and to test them before connecting to the database. They are no longer used in the application, but have been kept to test for possible bugs when transitioning to the database.

a. BookService
  o Its role is to process requests from the BookController class o Manage data operations for the Books collection
  o Key methods:
    § findByTitle(String title): Returns all the books in the list of books created in memory, does not filter by title, but could have been developed to include this functionality.
    § addBook(String title, String ISBN, String description, float price, String language, LocalDate publishingDate,
    boolean isInStock): Creates a new object of type Books with a
    unique ID and adds it to the list created in memory.
    § deleteById(int id): Search and delete a card from the list using its
    ID.
    § editBook(@Valid Books book): Validates the book ID and finds the

b. BookController
  o It has exactly the same functionality as BookControllerJPA o The differences between the two are:
    § BookController uses BookService for data management, while BookControllerJPA interacts with the database and uses the BookRepository interface
    § BookController uses an in-memory list, List< Books> to manage book-related data instead of a database.
    § BookController could be used for applications that don't need permanent data storage or for testing an application at an early stage
    § BookController is not a scalable class because data is lost when the application restarts


3.3 Frontend Component
a. JSP files:
    o All JSP files use HTML code for page structuring together with CSS, Bootstrap (CSS framework)
    corresponding book in the list. Updates the book details with the new data.

    o JSP is a technology that allows Java code to be embedded in HTML structures to generate code dynamically. JSP bridges the gap between the backend and the frontend by allowing interaction with BookControllerJPA. Syntax such as "<% ... %> " or "${}" is what allows dynamic content to be included.
    o welcome.jsp: Serves as home page.
    o add-book.jsp: Form interface for adding or editing books, including field
    validation.
    o listBooks.jsp: Displays the list of books and integrates search, edit and
    delete functions.
    
b. Common JSP fragments:
    o header.jspf, footer.jspf and navigation.jspf: Ensure a consistent
    look and feel and uniform navigation on all pages.


   
4. Login System
  The application uses Spring Security to implement a secure and efficient authentication system.

  a. Configure Spring Security (SpringSecurityConfiguration.java):
    o Uses an InMemoryUserDetailsManager configuration to store user details in
    memory.
    o Two administrator accounts are predefined: § admin with password password123 § daria withpassword
    o Passwords are encrypted using the BCryptPasswordEncoder for added security.

  b. Authentication flow:
    o Authentication is done through a login form generated by Spring Security.
    o Users need to provide a valid username and password to access the application
      functionalities.
    o After successful login, the user has access to all defined functionalities.
    o In the application's navigation bar there is a Logout option, so the user can exit the application at any time without compromising its security

  c. Additional security measures:
    o CSRF attack protection is disabled for ease of development.
    o The default setting blocks unauthorized access to application resources.


5. Testing and Debugging
  
  a. Test Validate:
    o Test cases ensure that invalid entries (e.g. empty fields, incorrect ISBN
    formats) are rejected with appropriate error messages. 2. Functional Testing:
    o The end-to-end flows for adding, updating, searching and deleting cards have been verified.
    
  b. Debugging Tools:
    o H2Console and POSTMAN were used to validate database interactions and
    API functionality.

 
