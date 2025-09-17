// We need this file because when we compress the data we need to save both the Data and the tree, because without the tree it would be impossible to decompress
// The tree hold the codes or the manual used in compressing the file that should be reversely followed so as to decompress it.


package io.github.darlene13.filecompressiontool.models;

import java.io.Serializable;

/*
* This is like a report card for compression
* Contains everything that should be decompressed later.
* */

public class CompressionResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final byte[] compressedData;   // The compresed or squeezed data
    private final HuffmanNode huffmanTree;  // The decorder or ring
    private final int originallength;   // How big was the original
    private final int paddingBits;   // Extra bits we added.

    /*
    * Constructor - creates a compression report
    * */
    public CompressionResult(byte[] compressedData, HuffmanNode huffmanTree, int originalLength, int paddingBits ){
        this.compressedData = compressedData;
        this.huffmanTree = huffmanTree;
        this.originallength = originalLength;
        this.paddingBits = paddingBits;

        System.out.println("Compression result created: ");
        System.out.println(" Original: " + originalLength + " bytes");
        System.out.println(" Compressed: " + compressedData.length + " bytes");
        System.out.println(" Saved: " + (originalLength - compressedData.length))
    }

    // Getter methods
    public byte[] getCompressedData() {
        return compressedData; // Return copy for safety
    }
    public HuffmanNode getHuffmanTree(){
        return huffmanTree;
    }
    public int getOriginalLength() { return originalLength; }
    public int getPaddingBits() { return paddingBits; }

    // Calculate how much space we saved as a percentage
    public double getCompressionRation(){
        if (originalLength == 0) return 0.0;
        return ((double)(originalLength - compressedData.length)/ originalLength * 100.0);
    }

    // Is compression worth it
    public boolean isCompressionEffective(){
        return getCompressionRation() > 5.0;
    }
}