<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">
    <H1> Books </H1>

    <!-- No Results Message -->
    <c:if test="${empty books}">
        <p>No books found matching your search.</p>
    </c:if>

    <!-- Books Table -->
    <c:if test="${!empty books}">
        <table class="table">
            <thead>
            <tr>
<%--                <th> id </th>--%>
                <th> Title </th>
                <th> Author </th>
                <th> ISBN </th>
                <th> Description </th>
                <th> Price </th>
                <th> Language </th>
                <th> Publishing Date </th>
                <th> Is it in stock? </th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
<%--                    <td> ${book.id} </td>--%>
                    <td> ${book.title} </td>
                    <td> ${book.author} </td>
                    <td> ${book.ISBN} </td>
                    <td> ${book.description} </td>
                    <td> ${book.price} </td>
                    <td> ${book.language} </td>
                    <td> ${book.publishingDate} </td>
                    <td> ${book.inStock} </td>
                    <td> <a href="delete-book?id=${book.id}" class="btn btn-dark">Delete</a></td>
                    <td> <a href="edit-book?id=${book.id}" class="btn btn-outline-dark">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <a href="add-book" class="btn btn-dark">Add a book</a>
</div>

<%@include file="common/footer.jspf"%>
