package io.github.darlene.exception;

public class FileNotFound extends RuntimeException {

    // Name constructor
    public FileNotFound(String name){
        super("File not found:" + name); // No Args constructor thus calling super() ...all exceptions extend RuntimeException
    }

    // A constructor to take  a constructor taking message + cause (calls super(message, cause))
    public FileNotFound (String name , Throwable cause){
        super("File not found: " + name, cause);
    }

}
