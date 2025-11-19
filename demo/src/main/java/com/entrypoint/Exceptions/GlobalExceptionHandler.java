package com.entrypoint.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Maneja todas las excepciones de la API de manera centralizada.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> buildErrorResponse(
            HttpStatus status,
            String message,
            String path
    ) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now().toString());
        error.put("status", status.value());
        error.put("error", status.getReasonPhrase());
        error.put("message", message);
        error.put("path", path);
        return error;
    }

    /**
     * Maneja errores de validación @Valid.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        Map<String, String> validationErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        validationErrors.put(error.getField(), error.getDefaultMessage())
                );

        Map<String, Object> body = buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Error de validación",
                request.getRequestURI()
        );

        body.put("validationErrors", validationErrors);

        return ResponseEntity.badRequest().body(body);
    }

    /**
     * Manejo de excepciones JWT típicas.
     */
    @ExceptionHandler({
            io.jsonwebtoken.ExpiredJwtException.class,
            io.jsonwebtoken.MalformedJwtException.class,
            io.jsonwebtoken.SignatureException.class,
            io.jsonwebtoken.JwtException.class
    })
    public ResponseEntity<Object> handleJwtException(
            Exception ex,
            HttpServletRequest request
    ) {
        Map<String, Object> body = buildErrorResponse(
                HttpStatus.UNAUTHORIZED,
                "Token inválido o expirado",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    /**
     * Manejo de excepciones de dominio personalizadas.
     * Puedes agregar todas las tuyas aquí.
     */
    @ExceptionHandler({
            com.core.domain.exception.UsuarioNoEncontradoException.class,
            com.core.domain.exception.PasswordInvalidaException.class,
            com.core.domain.exception.UsuarioYaActivoException.class,
            com.core.domain.exception.UsuarioYaInactivoException.class,
            com.core.domain.exception.UsernameInvalidoException.class
    })
    public ResponseEntity<Object> handleDomainExceptions(
            RuntimeException ex,
            HttpServletRequest request
    ) {
        Map<String, Object> body = buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(body);
    }

    /**
     * Manejo de errores inesperados.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(
            Exception ex,
            HttpServletRequest request
    ) {
        Map<String, Object> body = buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno del servidor: " + ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}