package io.github.darlene.exception;

public class InsufficientDiskSpaceException extends RuntimeException {
    public InsufficientDiskSpaceException(String path){
        super("Insufficient disk space at path: " + path);
    }
}
