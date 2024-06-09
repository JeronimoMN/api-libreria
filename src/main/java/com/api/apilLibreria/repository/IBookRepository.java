package com.api.apilLibreria.repository;

import com.api.apilLibreria.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Long> {
}