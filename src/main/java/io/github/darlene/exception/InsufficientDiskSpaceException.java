package io.github.darlene.exception;

public class InsufficientDiskSpaceException extends RuntimeException {
    public InsufficientDiskSpaceException(String message) {
        super(message);
    }
}
