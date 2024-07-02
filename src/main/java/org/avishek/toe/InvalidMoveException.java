package org.avishek.toe;

public class InvalidMoveException extends RuntimeException{
    InvalidMoveException(String message) {
        super(message);
    }
}
