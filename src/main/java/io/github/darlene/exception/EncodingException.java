package io.github.darlene.exception;

public class EncodingException extends RuntimeException {
    public EncodingException(String name){
        super("Encoding error occurred in file: " + name);
    }
    public EncodingException(String name, Throwable cause){
        super("Encoding error occurred in file: " + name, cause);
    }
}
