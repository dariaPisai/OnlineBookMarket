<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<style>
    html, body {
        height: 100%; /* Ensure full height for the document */
        margin: 0;
        display: flex;
        flex-direction: column;
    }

    .container {
        flex: 1; /* Pushes footer to the bottom if content is less */
    }

    .footer {
        background-color: #343a40; /* Dark background for footer */
        color: #ffffff; /* White text for visibility */
        text-align: center;
        padding: 10px 0; /* Padding for better spacing */
    }
</style>

<div class="container">
    <!-- Main Content -->
    <div class="jumbotron bg-light p-4 shadow-sm rounded">
        <h1 class="display-4">Welcome, ${name}!</h1>
        <p class="lead">Explore our vast collection of books and manage your inventory with ease.</p>
        <hr class="my-4">
        <a href="list-books" class="btn btn-dark btn-lg">Go to the Book Website</a>
    </div>

    <!-- Features Section -->
    <div class="row mt-5">
        <div class="col-md-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Browse Books</h5>
                    <p class="card-text">Search and explore a wide variety of books categorized by genres, authors, and languages.</p>
                    <a href="list-books" class="btn btn-outline-dark">Browse Now</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Manage Inventory</h5>
                    <p class="card-text">Add, edit, and remove books in the collection with a few simple clicks.</p>
                    <a href="add-book" class="btn btn-outline-dark">Manage Books</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Track Availability</h5>
                    <p class="card-text">Keep track of books in stock and ensure users can easily find what they need.</p>
                    <a href="list-books" class="btn btn-outline-dark">Check Availability</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <p class="mb-0">&copy; 2025 Bookish. All rights reserved.</p>
</div>

<%@include file="common/footer.jspf"%>
