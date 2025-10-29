// Lempel–Ziv–Markov chain Algorithm 2
package io.github.darlene.algorithms.lzma2;

import io.github.darlene.core.CompressionStrategy;

public class Lzma2Strategy implements CompressionStrategy {
    @Override
    public void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel) {

    }

    @Override
    public boolean getCompressionSuccessStatus() {
        return false;
    }

    @Override
    public double getCompressionRatio() {
        return 0;
    }

    @Override
    public long getCompressionTime() {
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
}
