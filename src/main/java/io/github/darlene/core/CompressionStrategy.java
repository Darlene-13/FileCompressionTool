package io.github.darlene.core;


// Interface to define the compression strategy each algorithm must implement
// Interface methods do not have a body as they have to be implemented by the classes that implement this interface
public interface CompressionStrategy {

    // Define method to compress
    public default void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel){
        // Default implementation (can be overridden by implementing classes)
    }

    // Method to return success status
    public default void getCompressionSuccessStatus(){
    }

    // Method to return compression
    public static double getCompressionRatio(){
        return 0.0;
    }

    // Method to return time taken for compression
    public static long getCompressionTime(){
        return 0L;
    }

    // Method to return original file size
    public static long getOriginalFileSize(){
        return 0L;
    }

    // Method to return compressed file size
    public static long getCompressedFileSize(){
        return 0L;
    }

    //Method to display the compression details: Time it took, original size, compressed size,
    public static void displayCompressionDetails(){
        // Default implementation (can be overridden by implementing classes)
    }

    // Define method to decompress
    public default void decompressFile(String sourceFilePath, String destinationFilePath){
        // Default implementation (can be overridden by implementing classes)
    }

    // Decompression success status
    public default void getDecompressionSuccessStatus(){
    }

    // Method to display the decompression details
    public default void displayDecompressionDetails(){

    }
}
