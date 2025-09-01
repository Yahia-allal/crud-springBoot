package com.yahia.crud_springBoot;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String message;      // Message d'erreur explicite
    private int code;           // Code HTTP (404, 500, etc.)
    private LocalDateTime timestamp; // Quand l'erreur s'est produite
}