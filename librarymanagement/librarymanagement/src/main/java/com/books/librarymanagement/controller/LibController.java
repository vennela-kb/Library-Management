package com.books.librarymanagement.controller;

import com.books.librarymanagement.model.MaitlandLibrary;
import com.books.librarymanagement.requests.ErrorResponse;
import com.books.librarymanagement.service.LibService;
import com.books.librarymanagement.service.impl.LibImplService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/libloans")
@Tag(name = "library management", description = "this project handles library management")
public class LibController {

    private String message = "i am a message";
    @Autowired
    private LibImplService libService;

    //add books
    @Operation(summary = "add a new book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = MaitlandLibrary.class),mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class),mediaType = "application/json")
            })
    })
    @PostMapping("/add")
    public MaitlandLibrary addNewBook(@RequestBody MaitlandLibrary library){
        return this.libService.addBook(library);
    }

    //get all books
    @Operation(summary = "fetch all books")
    @GetMapping("/all")
    public List<MaitlandLibrary> getAllBooks(){
        return this.libService.getTotalBooks();
    }

    //delete books
    @Operation(summary = "delete a specific book based on id mentioned")
    @DeleteMapping("/all/{id}")
    public void deleteSingleBook(@PathVariable Integer id, @RequestBody MaitlandLibrary library){
        this.libService.deleteBook(id);
    }

    //update existing books
    @Operation(summary = "update details of existing book")
    @PutMapping("/{id}")
    public MaitlandLibrary updateBookData(@PathVariable Integer id, @RequestBody MaitlandLibrary library){
        return this.libService.updateBooks(id, library);
    }

    //get single book
    @Operation(summary = "get a single book which id is mentioned")
    @GetMapping("/{id}")
    public MaitlandLibrary getSingleBook(@PathVariable Integer id){
        return this.libService.getBookData(id);
    }

    @GetMapping("/welcome")
    public String getMessage(){
        return this.message;
    }

}

