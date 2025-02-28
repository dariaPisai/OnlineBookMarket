<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <h1>Enter Book Details</h1>

    <!-- Display global error message if ISBN is a duplicate -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <form:form method="post"
               action="${book.id == null || book.id == 0 ? 'add-book' : 'edit-book'}"
               modelAttribute="book">
        <form:input path="id" type="hidden" /> <!-- Hidden field for book ID -->

        <!-- Title Field -->
        <fieldset class="mb-3">
            Title: <form:input path="title" class="form-control"/><br/>
            <form:errors path="title" cssClass="text-warning"/>
        </fieldset>

        <!-- Author Field -->
        <fieldset class="mb-3">
            Author: <form:input path="author" class="form-control"/><br/>
            <form:errors path="author" cssClass="text-warning"/>
        </fieldset>

        <!-- ISBN Field -->
        <fieldset class="mb-3">
            ISBN: <form:input path="ISBN" class="form-control"/><br/>
            <form:errors path="ISBN" cssClass="text-warning"/>
        </fieldset>

        <!-- Description Field -->
        <fieldset class="mb-3">
            Description: <form:input path="description" class="form-control"/><br/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <!-- Price Field -->
        <fieldset class="mb-3">
            Price: <form:input path="price" type="number" step="0.01" class="form-control"/><br/>
            <form:errors path="price" cssClass="text-warning"/>
        </fieldset>

        <!-- Language Field -->
        <fieldset class="mb-3">
            Language: <form:input path="language" class="form-control"/><br/>
            <form:errors path="language" cssClass="text-warning"/>
        </fieldset>

        <!-- Publishing Date Field -->
        <fieldset class="mb-3">
            Publishing Date: <form:input path="publishingDate" type="date" class="form-control"/><br/>
            <form:errors path="publishingDate" cssClass="text-warning"/>
        </fieldset>

        <!-- In Stock Checkbox -->
        <fieldset class="mb-3">
            In Stock: <form:checkbox path="inStock" class="form-check-input"/><br/>
            <form:errors path="inStock" cssClass="text-warning"/>
        </fieldset>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-dark">Submit</button>
    </form:form>

    <%@include file="common/footer.jspf"%>
</div>
