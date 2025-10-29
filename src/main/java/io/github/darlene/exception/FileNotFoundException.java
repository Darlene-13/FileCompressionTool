package io.github.darlene.exception;

public class FileNotFoundException extends RuntimeException {

    // Name constructor
    public FileNotFoundException(String name){
        super("File not found:" + name); // No Args constructor thus calling super() ...all exceptions extend RuntimeException
    }

    // A constructor to take  a constructor taking message + cause (calls super(message, cause))
    public FileNotFoundException(String name , Throwable cause){
        super("File not found: " + name, cause);
    }

}
