package com.books.librarymanagement.service;

import com.books.librarymanagement.model.MaitlandLibrary;

import java.util.List;

public interface LibService {

    MaitlandLibrary addBook(MaitlandLibrary library);

    List<MaitlandLibrary> getTotalBooks();

    void deleteBook(Integer id);

    MaitlandLibrary updateBooks(Integer id, MaitlandLibrary library);

    MaitlandLibrary getBookData(Integer id);
}
