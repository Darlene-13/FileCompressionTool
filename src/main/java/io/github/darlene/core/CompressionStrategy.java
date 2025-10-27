package io.github.darlene.core;


// Interface to define the compression strategy each algorithm must implement
// Interface methods do not have a body as they have to be implemented by the classes that implement this interface
public interface CompressionStrategy {

    // Define method to compress
    public void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel);

    // Method to return success status
    public boolean getCompressionSuccessStatus();

    // Method to return compression
    public double getCompressionRatio();

    // Method to return time taken for compression
    public long getCompressionTime();

    // Method to return original file size
    public long getOriginalFileSize();

    // Method to return compressed file size
    public long getCompressedFileSize();

    //Method to display the compression details: Time it took, original size, compressed size,
    public void displayCompressionDetails();

    // Define method to decompress
    public void decompressFile(String sourceFilePath, String destinationFilePath);

    // Decompression success status
    public boolean getDecompressionSuccessStatus();

    // Method to display the decompression details
    public void displayDecompressionDetails();
}
