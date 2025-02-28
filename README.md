"Bookish" is a robust Java application, built on the Spring framework, that follows the Model-View-Controller (MVC) architecture. It provides users with an administrator role with an interface to efficiently manage a collection of books.
The application includes functionality such as adding, editing, deleting and searching books, ensuring ease of use and backend efficiency. The application uses multiple technologies, such as Java Persistence API (which is used for object-relational mapping), H2 Database (which was used for testing the connection to a temporary database), JavaServer Pages (used for creating a dynamic user interface) and MySQL (for the database connection).


1. Functional Specifications

a. View books: Users can view the full list of books, each containing details such as title, ISBN, description, price, language, publication date and availability.<br></br>

 <img width="435" alt="image" src="https://github.com/user-attachments/assets/4d36f7df-f984-45e7-8ea4-21830e7c032e" /><br></br>

b. Adding cards: Users can add new cards through a form interface with validation checks.<br></br>

 <img width="381" alt="image" src="https://github.com/user-attachments/assets/b1b0e439-9cad-4660-9e3c-f573de66760c" /><br></br>

c. Editing books: Existing book details can be updated via a dedicated form.<br></br>

 <img width="452" alt="image" src="https://github.com/user-attachments/assets/a578dffb-4732-4920-b8ea-b7ffaced41c9" /><br></br>

d. Deleting books: Books can be removed from the list with user confirmation to avoid accidental deletions.<br></br>

 <img width="452" alt="image" src="https://github.com/user-attachments/assets/a129c195-7eca-4868-8866-6147c6dac323" /><br></br>

e. Search for books: A search function allows users to find books by titles, using partial and case-insensitive matches.<br></br>

 <img width="452" alt="image" src="https://github.com/user-attachments/assets/542d4a70-075b-458e-88fe-0245d7048b8f" /><br></br>



2. Validation:<br></br>
   
 • Ensures data integrity through field-level constraints, such as non-null titles, a 13- digit ISBN, positive prices and correct data <br></br>
 • Personalized error messages guide users while submitting forms.<br></br>

 <img width="332" alt="image" src="https://github.com/user-attachments/assets/0830c0fc-9211-44c8-8fa9-0f22fb502a1f" /><br></br>


3. Components Description<br></br>
 
3.1 Main Backend Component<br></br>

a. Books entity (Books.java):<br></br>

  o Represents the ONLINE_BOOKS database table.<br></br>
  o Fields include id, title, ISBN, description, price, language,
  publishingDate,author andisInStock.<br></br>
  o Constraints applied using annotations such as @NotBlank, @Size and
  @Positive.<br></br>
  o Validation example: ISBN must follow a 13-digit pattern.<br></br>
  o Each field is declared as private and getter and setter methods are used to
  access them, which facilitates the encapsulation and correct use of the data o The class contains a toString() method, which was used for debugging
  when creating the project<br></br>

b. BookRepository interface (BookRepository.java):<br></br>

  o Extends JpaRepository for CRUD operations (create, read, update and
  delete), so all existing methods in BookControllerJPA are used within the
  interface.<br></br>
  o This interface contains the findByTitleContainingIgnoreCase method,
  which allows you to search by title in the website.<br></br>
  o The interface can also be used for the purpose of creating new methods
  specific to the application's functionality and allows queries to be written
  directly in the code<br></br>
  o The main role of the interface is to handle database operations in a
  straightforward way<br></br>

c. Class BookControllerJPA (BookControllerJPA.java):<br></br>

  o Manage user interactions and connect the visualization with the data
  warehouse.<br></br>
  o Control HTTP requests and responses<br></br>
  o Returns views represented by JSP pages to the user interface<br></br>
  o Invokes "repository methods" for processing data, such as saving a new book
  to the database is done using the bookRepository.save() method<br></br> 
  o Key methods:<br></br>
    § listAllBooks(): retrieves and displays all books.<br></br>
    § showAddBookPage() and addNewBook(): handles the process of
    adding new books.<br></br>
    § deleteBook(): handles deleting books with user confirmation. § searchBooks(): Facilitates searching for books based on titles.<br></br>


3.2 Secondary Backend Component<br></br>
They were created in order to create the basic functionalities of the application and to test them before connecting to the database. They are no longer used in the application, but have been kept to test for possible bugs when transitioning to the database.<br></br>

a. BookService<br></br>

  o Its role is to process requests from the BookController class o Manage data operations for the Books collection<br></br>
  o Key methods:<br></br>
    § findByTitle(String title): Returns all the books in the list of books created in memory, does not filter by title, but could have been developed to include this              
    functionality.<br></br>
    § addBook(String title, String ISBN, String description, float price, String language, LocalDate publishingDate,
    boolean isInStock): Creates a new object of type Books with a
    unique ID and adds it to the list created in memory.<br></br>
    § deleteById(int id): Searches and deletes a card from the list using its
    ID.<br></br>
    § editBook(@Valid Books book): allows the administrator to edit the book details. <br></br>

b. BookController<br></br>

  o It has exactly the same functionality as BookControllerJPA<br></br>
  o The differences between the two are:<br></br>
    § BookController uses BookService for data management, while BookControllerJPA interacts with the database and uses the BookRepository interface<br></br>
    § BookController uses an in-memory list, List< Books> to manage book-related data instead of a database.<br></br>
    § BookController could be used for applications that don't need permanent data storage or for testing an application at an early stage<br></br>
    § BookController is not a scalable class because data is lost when the application restarts<br></br>


3.3 Frontend Component<br></br>

a. JSP files:<br></br>

    o All JSP files use HTML code for page structuring together with CSS, Bootstrap (CSS framework)
    corresponding book in the list. Updates the book details with the new data.<br></br>
    o JSP is a technology that allows Java code to be embedded in HTML structures to generate code dynamically. JSP bridges the gap between the backend and the frontend by   
     allowing interaction with BookControllerJPA. Syntax such as "<% ... %> " or "${}" is what allows dynamic content to be included.<br></br>
    o welcome.jsp: Serves as home page.<br></br>
    o add-book.jsp: Form interface for adding or editing books, including field
    validation.<br></br>
    o listBooks.jsp: Displays the list of books and integrates search, edit and
    delete functions.<br></br>
    
b. Common JSP fragments:<br></br>

    o header.jspf, footer.jspf and navigation.jspf: Ensure a consistent
    look and feel and uniform navigation on all pages.<br></br>


   
4. Login System
  The application uses Spring Security to implement a secure and efficient authentication system.<br></br>

  a. Configure Spring Security (SpringSecurityConfiguration.java):<br></br>
  
    o Uses an InMemoryUserDetailsManager configuration to store user details in
    memory.<br></br>
    o Two administrator accounts are predefined:<br></br>
       § admin with password password123<br></br>
       § daria with password password123<br></br>
    o Passwords are encrypted using the BCryptPasswordEncoder for added security.<br></br>

  b. Authentication flow:<br></br>
  
    o Authentication is done through a login form generated by Spring Security.<br></br>
    o Users need to provide a valid username and password to access the application
      functionalities.<br></br>
    o After successful login, the user has access to all defined functionalities.<br></br>
    o In the application's navigation bar there is a Logout option, so the user can exit the application at any time without compromising its security<br></br>

  c. Additional security measures:<br></br>
  
    o CSRF attack protection is disabled for ease of development.<br></br>
    o The default setting blocks unauthorized access to application resources.<br></br>


5. Testing and Debugging<br></br>
  
  a. Test Validate:<br></br>
    o Test cases ensure that invalid entries (e.g. empty fields, incorrect ISBN
    formats) are rejected with appropriate error messages.<br></br> 
    
  b. Functional Testing:<br></br>
    o The end-to-end flows for adding, updating, searching and deleting cards have been verified.<br></br>
    
  c. Debugging Tools:<br></br>
    o H2Console and POSTMAN were used to validate database interactions and
    API functionality.<br></br>

 
