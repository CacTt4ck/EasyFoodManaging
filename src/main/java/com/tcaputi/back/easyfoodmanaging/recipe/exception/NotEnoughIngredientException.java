package com.tcaputi.back.easyfoodmanaging.recipe.exception;

public class NotEnoughIngredientException extends RuntimeException {

    public NotEnoughIngredientException(String message) {
        super(message);
    }

    public NotEnoughIngredientException(String message, Throwable cause) {
        super(message, cause);
    }
}
