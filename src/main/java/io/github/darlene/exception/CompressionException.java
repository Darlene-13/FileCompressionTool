package io.github.darlene.exception;

public class CompressionException extends RuntimeException {

    public CompressionException(String name){
        super("Compression error occurred in file: " + name);
    }

    public CompressionException(String name, Throwable cause){
        super("Compression error occurred in file: " + name, cause);
    }
}
