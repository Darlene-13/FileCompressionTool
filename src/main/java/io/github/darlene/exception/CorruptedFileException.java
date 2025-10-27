package io.github.darlene.exception;

public class CorruptedFileException extends RuntimeException {
    public CorruptedFileException(String message) {
        super(message);
    }
}
