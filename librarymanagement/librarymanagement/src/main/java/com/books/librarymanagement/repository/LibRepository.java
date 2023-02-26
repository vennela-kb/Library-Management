package com.books.librarymanagement.repository;

import com.books.librarymanagement.model.MaitlandLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibRepository extends JpaRepository<MaitlandLibrary, Integer> {

}
