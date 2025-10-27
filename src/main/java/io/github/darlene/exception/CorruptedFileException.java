package io.github.darlene.exception;

public class CorruptedFileException extends RuntimeException {


    public CorruptedFileException(String name){
        super("The file is corrupted: " + name);

    }
    public CorruptedFileException(String name, Throwable cause){
        super("The file is corrupted: " + name, cause);
    }
}
