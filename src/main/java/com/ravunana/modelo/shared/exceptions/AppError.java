package com.ravunana.modelo.shared.exceptions;

public class AppError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AppError(String message) {
        super(message);
    }
}
