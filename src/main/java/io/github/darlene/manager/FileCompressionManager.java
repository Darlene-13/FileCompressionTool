// This ile is meant to coordinate multiple components to accomplish a task
// It is impportant in the occasion that the application needs to get the user input, detect file type, get the right algorithm, call compress/ decompress, handler errors , track progress, display results etc,,

package io.github.darlene.manager;



import io.github.darlene.core.CompressionStrategy;
import io.github.darlene.core.CompressionFormat;
import io.github.darlene.factory.CompressionStrategyFactory;
import io.github.darlene.exception.CompressionException;
import io.github.darlene.exception.DecompressionException;
import java.io.IOException;


public class FileCompressionManager {

    private int compressionLevel;
    private CompressionStrategy lastCompressionStrategy;
    private CompressionStrategy lastDecompressionStrategy;

    // Constructor
    public FileCompressionManager(int defaultCompressionLevel){
        this.compressionLevel = defaultCompressionLevel;
        this.lastCompressionStrategy = null;
        this.lastDecompressionStrategy = null;
    }

    public boolean compress(String sourceFile, String destFile, CompressionFormat format){
        try {
            CompressionStrategy strategy = CompressionStrategyFactory.getStrategy(format);
            strategy.compressFile(sourceFile, destFile, compressionLevel);
            // Store the strateg for later reference
            this.lastCompressionStrategy = strategy;
            strategy.displayCompressionDetails;
            return strategy.getCompressionSuccessStatus();

        } catch (CompressionException){
            throw new CompressionException("Compression error occurred in file: \" + name, cause");
        } catch (IOException){
            throw new IOException("Unexpected error");
        }
    }

    public boolean decompression(String sourceFile, String destFile, CompressionFormat format){
        try{
            // Detect fromat from file extension....optional skipping for now
            // Getting strategy from factory
            CompressionStrategy strategy = CompressionStrategyFactory.getStrategy(format);
            // Call the strategy's decompress
            strategy.decompressFile(sourceFile, destFile);
            // Store the strategy for later reference
            this.lastDecompressionStrategy = strategy;
            // Display the decompression results
            strategy.displayDecompressionDetails();
            // Display the success state
            return strategy.getDecompressionSuccessStatus
        }catch (DecompressionException){
            throw new DecompressionException("Decompression error occured in the file: \" + name, cause");
        } catch (IOException){
            throw new IOException("Unexpected error during decompression.");
        }
    }

    public CompressionStrategy getLastCompressionDetails(){
        if (lastCompressionStrategy !=null){
            return lastCompressionStrategy
        } else {
            return null
        }
    }

}