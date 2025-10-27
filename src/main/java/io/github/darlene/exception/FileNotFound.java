package io.github.darlene.exception;

public class FileNotFound extends RuntimeException {
    private String name;

    // Name constructor
    public FileNotFound(String name){
        super("File not found:" + name); // No Args constructor thus calling super() ...all exceptions extend RuntimeException
        this.name = name;
    }

    // A constructor to take  a constructor taking message + cause (calls super(message, cause))
    public FileNotFound (String name , Throwable cause){
        super("File not found: " + name, cause);
        this.name = name;
    }

}
