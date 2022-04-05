package io.dewe.assignment.repository;

import io.dewe.assignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
