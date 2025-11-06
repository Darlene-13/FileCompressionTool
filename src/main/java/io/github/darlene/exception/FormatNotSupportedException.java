package io.github.darlene.exception;

public class FormatNotSupportedException extends RuntimeException {
    public FormatNotSupportedException(String name){
        super("The file format is not supported: " + name);
    }
    public FormatNotSupportedException(String name, Throwable cause){
        super("The file format is not suppoted: "+ name, cause);
    }
}
