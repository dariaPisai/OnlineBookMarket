package com.webapp.springboot.OnlineBookMarket.bookshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    // Case-insensitive, partial title search
    List<Books> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT b FROM OnlineBooks b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Books> searchByTitle(String title);


}
