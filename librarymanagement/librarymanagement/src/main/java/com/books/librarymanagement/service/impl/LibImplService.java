package com.books.librarymanagement.service.impl;

import com.books.librarymanagement.model.MaitlandLibrary;
import com.books.librarymanagement.repository.LibRepository;
import com.books.librarymanagement.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibImplService implements LibService {
    @Autowired
    private LibRepository repository;


    @Override
    public MaitlandLibrary addBook(MaitlandLibrary library) {
        return this.repository.save(library);
    }

    @Override
    public List<MaitlandLibrary> getTotalBooks() {
        return this.repository.findAll();
    }

    @Override
    public void deleteBook(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public MaitlandLibrary updateBooks(Integer id, MaitlandLibrary library) {
          MaitlandLibrary library1 = this.repository.findById(id).get();
            library1.setBookName(library.getBookName());
            library1.setBookType(library.getBookType());
            library1.setShelfLocation(library.getShelfLocation());
            this.repository.save(library1);
            return library1;
    }

    @Override
    public MaitlandLibrary getBookData(Integer id) {
        return this.repository.findById(id).get();
    }
}
