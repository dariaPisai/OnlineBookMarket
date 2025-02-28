package com.webapp.springboot.OnlineBookMarket.bookshop;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity(name = "OnlineBooks")
@Table(name = "ONLINE_BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Titlul nu poate fi gol")
    @Size(max = 255, message = "Title cannot exceed 255 characters!")
    private String title;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "\\d{13}", message = "ISBN must be exactly 13 digits!")
    private String ISBN;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 1000, message = "Description should have less than 1000 characters!")
    private String description;

    @Positive(message = "Price must be a positive value!")
    private float price;

    @NotBlank(message = "Language cannot be blank!")
    @Size(max = 255, message = "Title cannot exceed 255 characters!")
    private String language;

    @PastOrPresent(message = "Publishing date cannot be in the future!")
    private LocalDate publishingDate;

    @NotBlank(message = "Author cannot be blank!")
    @Size(max = 255, message = "Title cannot exceed 255 characters!")
    private String author;


    private boolean isInStock;

    public Books() {
        super();
    }

    public Books(int id, String title, String ISBN, String description, float price, String language, LocalDate publishingDate, boolean isInStock) {
        super();
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.description = description;
        this.price = price;
        this.language = language;
        this.publishingDate = publishingDate;
        this.isInStock = isInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", language='" + language + '\'' +
                ", publishingDate='" + publishingDate + '\'' +
                ", isInStock=" + isInStock + '\'' +
                ", author=" + author + '}';
    }


}
