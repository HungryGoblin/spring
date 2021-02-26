package ru.hiber.springboot.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("Внутренняя ошибка сервера: " + message);
    }
}
