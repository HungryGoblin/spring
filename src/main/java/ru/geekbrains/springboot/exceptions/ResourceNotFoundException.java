package ru.geekbrains.springboot.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("Что-то пошло не так " + message);
    }
}
