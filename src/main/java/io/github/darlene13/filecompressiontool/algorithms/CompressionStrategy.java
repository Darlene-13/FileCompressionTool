// This file is meant to allow us to add more compression algorithms later like the LZW or ZIP etc
// All algorithms work the same way from outside
// It is easy to swith between different compression methods

package io.github.darlene13.filecompressiontool.algorithms;
public interface CompressionStrategy {
    // Every compression algorithm should be able to compress data

    byte[] compress(byte[] originalData);

    // Every compression algorithm should be able to decompress data
    byte[] decompress(byte[] compressedData, object decompressionInfo);

    //Every compression algorithm must tell us its name
    String getAlgorithmname();

    //Every compression algorithm must tell us about itself
    String getDescription();

    // Is this algorithm good for this type of data
    boolean isGoodforData(byte[] data);
}