package com.books.librarymanagement.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse {
    @Schema(name = "message",defaultValue = "failed to execute and has an error")
    String message;
}
