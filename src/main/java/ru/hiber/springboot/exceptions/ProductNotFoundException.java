package ru.hiber.springboot.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super("Ошибка каталога продуктов: " + message);
    }
}
