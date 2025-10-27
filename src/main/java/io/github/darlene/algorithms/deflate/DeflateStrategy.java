package io.github.darlene.algorithms.deflate;

import io.github.darlene.core.CompressionStrategy;

public class DeflateStrategy implements CompressionStrategy {

    private int originalFileSize;
    private int compressedFileSize;
    private double  compressionRatio;
    private boolean compressionSuccessStatus;
    private boolean decompressionSuccessStatus;
    private String sourceFilePath;
    private String destinationFilePath;
    private long startTime;
    private long endTime;
    private long compressionTime;


    @Override
    public void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel) {
        startTime = System.currentTimeMillis();




        compressionSuccessStatus = true;
        endTime = System.currentTimeMillis();

    }

    @Override
    public boolean getCompressionSuccessStatus() {
        return false;
    }

    @Override
    public double getCompressionRatio(){
        compressionRatio = ((double )(originalFileSize - compressedFileSize)/ originalFileSize) * 100.0;
        return compressionRatio;
    }

    @Override
    public long getCompressionTime(){
        compressionTime = endTime - startTime;
        return compressionTime;
    }

    @Override
    public long getOriginalFileSize(){
        return originalFileSize;
    }

    @Override
    public long getCompressedFileSize(){
        return compressedFileSize;
    }

    @Override
    public void displayCompressionDetails(){
        System.out.println("================================================================");
        System.out.println("Deflate Compression Details:");
        System.out.println("Compression Successful: " + compressionSuccessStatus);
        System.out.println("Original File Size: " + originalFileSize + " bytes");
        System.out.println("Compressed File Size: " + compressedFileSize + " bytes");
        System.out.printf("Compression Ratio: %.2f%%\n", compressionRatio);
        System.out.println("Time Taken for Compression: " + compressionTime + " ms");
        System.out.println("================================================================");
    }
    @Override
    public void decompressFile(String sourceFilePath, String destinationFilePath){
        startTime = System.currentTimeMillis();

        decompressionSuccessStatus = true;
        endTime = System.currentTimeMillis();
    }

    @Override
    public boolean getDecompressionSuccessStatus(){
        return false;
    }

    @Override
    public void displayDecompressionDetails(){
        System.out.println("================================================================");
        System.out.println("Deflate Decompression Details:");
        System.out.println("Decompression Successful: " + decompressionSuccessStatus);
        System.out.println("================================================================");

    }
}
