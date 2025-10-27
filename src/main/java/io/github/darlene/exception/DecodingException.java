package io.github.darlene.exception;

public class DecodingException extends RuntimeException {

    public DecodingException(String name){
        super("Decoding error occurred in file" + name);
    }
    public DecodingException(String name, Throwable cause){
        super("Decoding error occurred in file: " + name, cause);
    }
}
