package io.github.darlene.exception;

public class FormatNotSupportedException extends RuntimeException {
    public FormatNotSupportedException(String name){
        super("The file is corrupted: " + name);
    }
    public FormatNotSupportedException(String name, Throwable cause){
        super("The file is corrupted: "+ name, cause);
    }
}
