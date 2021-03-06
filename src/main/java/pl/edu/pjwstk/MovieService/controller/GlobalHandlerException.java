package pl.edu.pjwstk.MovieService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.edu.pjwstk.MovieService.exception.NotChangedAvailabilityException;
import pl.edu.pjwstk.MovieService.exception.NotFoundMovieException;
import pl.edu.pjwstk.MovieService.exception.NotRentMovieException;
import pl.edu.pjwstk.MovieService.exception.NotReturnMovieException;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundMovieException.class)
    public ResponseEntity<String> handleNotFoundMovieException(NotFoundMovieException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidInputMovieException() {
        return ResponseEntity.status(400).body("Nieprawidłowe dane wejściowe");
    }

    @ExceptionHandler(NotChangedAvailabilityException.class)
    public ResponseEntity<String> handleInvalidChangeAvailabilityMovieException(NotChangedAvailabilityException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(NotRentMovieException.class)
    public ResponseEntity<String> handleNotRentException(NotRentMovieException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(NotReturnMovieException.class)
    public ResponseEntity<String> handleNotReturnException(NotReturnMovieException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
