package io.github.darlene.factory;
import io.github.darlene.exception.FormatNotSupportedException;
import io.github.darlene.core.CompressionFormat;

public class FileTypeDetector{

    public static CompressionFormat detectFormat(String filename){
        // Get the extension, last part after the dot
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex == -1){
            throw new FormatNotSupportedException(" No file extension for the file : " + filename);
        }
        // Extract the extension
        String extension = "." + filename.substring(lastDotIndex + 1);

        // Use compression format enum method
        try{
            CompressionFormat format = CompressionFormat.getCompressionFormatByExtension(extension);
            return format;
        } catch (IllegalArgumentException e){
            throw new FormatNotSupportedException("Unsupported format: " + extension);
        }
    }
}