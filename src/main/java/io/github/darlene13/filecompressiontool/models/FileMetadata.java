// This file is meant to remember the original file name, verify that is wasn't corrupted during compression/decompression and track when the compression happened.

package io.github.darlene13.filecompressiontool.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FileMetadata implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String originalFilename; // What was the file called?
    private final String fileExtension; // Which type of file was it, .txt, .java, .png etc
    private final long OriginalSize; // How big was the file?
    private final LocalDateTime compressedAt; // When was the file compressed?
    private final String checksumMD5; // Fingerprint to verify integrity

    //Constructor -create file metadata
    public Metadata (String originalFilename, long originalSize, String checksumMD5){
        this.originalFilename = originalFilename;
        this.fileExtension = extractExtension(originalFilename);
        this.OriginalSize = originalSize;
        this.compressedAt = LocalDateTime.now();
        this.checksumMD5 = checksumMD5;

        System.out.println("Created metadata for: " originalFilename);
    }

    // Extract file extension from file name
    private String extractExtension(String filename){
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0 && lastDot < filename.length() - 1){
            return filename.substring(lastDot + 1).toLowerCase() //substring(startIndex) → Takes everything from startIndex to the end of the string.
        }
        return ""; // no extension
    }

    // getter methods
    public String getOriginalFilename() { return originalFilename; }
    public String getFileExtension() { return fileExtension; }
    public long getOriginalSize() { return OriginalSize; }
    public LocalDateTime getCompressedAt() { return  compressedAt; }
    public String getCheckSUmMD5() { return checkSumMD5; }

    // Get suggested name for the compressed file
    public String getCompressedFilename(){
        int lastDot = originalFilename.lastIndexOf('.');
        if (lastDot > 0) {
            return originalFilename.substring(0, lastDot) + ".huff";    // substring(0, lastDot) → Keeps everything BEFORE the last dot.
        }
        return originalFilename + ".huff";
    }
    @Override
    public String toString(){
        return String.format("File: %s (%s), Size: %d bytes, Compressed: %s", originalFilename, fileExtension, originalSize, compressedAt);
    }
}