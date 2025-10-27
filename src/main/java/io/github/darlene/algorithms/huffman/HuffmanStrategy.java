package io.github.darlene.algorithms.huffman;


import io.github.darlene.core.CompressionStrategy;

public class HuffmanStrategy implements CompressionStrategy {

    private int originalFileSize;
    private int compressedFileSize;
    private double  compressionRatio;
    private boolean compressionSuccessStatus;
    private String sourceFilePath;
    private String destinationFilePath;


    // Start time of compression
    private final long startTime = System.currentTimeMillis();

    // Getter for start time
    public long getStartTime(){
        return startTime;
    }

    @Override
    public void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel) {

    }

    private final long endTime = System.currentTimeMillis();
    public long getEndTime(){
        return endTime;
    }

    @Override
    public boolean getCompressionSuccessStatus() {
        return false;
    }

    @Override
    public double getCompressionRatio() {
        compressionRatio = ((double) (originalFileSize - compressedFileSize) / originalFileSize) * 100.0;
        return 0;
    }

    @Override
    public long getCompressionTime() {
        long compressionTime = getEndTime() - getStartTime();
        return 0;
    }

    @Override
    public long getOriginalFileSize() {
        return 0;
    }

    @Override
    public long getCompressedFileSize() {
        return 0;
    }

    @Override
    public void displayCompressionDetails() {

    }

    @Override
    public void decompressFile(String sourceFilePath, String destinationFilePath) {

    }

    @Override
    public boolean getDecompressionSuccessStatus() {
        return false;
    }

    @Override
    public void displayDecompressionDetails() {

    }

    public void setCompressionRatio(double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
}
