package io.github.darlene.exception;

public class DecompressionException extends RuntimeException{

    public DecompressionException(String name){
        super("Decompression error occurred in file: " + name);
    }
    public DecompressionException(String name, Throwable cause){
        super("Decompression error occurred in file: " + name, cause);

    }
}
