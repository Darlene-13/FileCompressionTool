// This is the heart of the compression tool, it implements the huffman algorithm, it breaks down the algorithm to small simple steps

package io.github.darlene13.filecompressiontool.algorithms;

import io.github.darlene13.filecompressiontool.models.*;
import io.github.darlene13.filecompressiontool.utils.BitUtils;
import java.util.*;

/* Huffman Compression Algorithm Implementation
* HOW IT WORKS
* 1. Count how often each character appears
* 2. Build a tree where common characters are near the top
* 3. Assign short codes to common characters, long codes to rare ones
* 4. Replace the characters with codes
*  */

public class HuffmanCompressor implements CompressionStrategy{
    @Override
    public byte[] compress(byte[] originalData){
        System.out.println(" Starting Huffman Compression....");

        if (originalData.length == 0){
            return new byte[0];
        }

        //Step 1: Count character frequencies
        Map<Byte, Integer> frequencies = countFrequencies(originalData);
        System.out.println("Found " + frequencies.size() + " unique characters");

        //Step 2: Build Huffman tree
        HuffmanNode root = buildHuffmanTree(frequencies);
        System.out.println("Huffman Tree Built");

        //Step 3: Generate compression codes
        Map<Byte, String> codes = generateCodes(root);
        System.out.println("Generated " + codes.size() + " character codes");

        //Step 4: Compress the data
        String compressedBits = compressedData(originalData, codes);
        byte[] compressedBytes = BitUtils.bitsToBytes(compressedBits);

        System.out.println("Compression compelet !");

        return compressedBytes;
    }

    // Step 1: Count how many times each character appears
    private Map<Byte Integer> countFrequencies = countFrequencies(byte[] data){
        Map<Byte, Integer> frequencies = newHashMap<>();

        for (byte b: data){
            frequencies.put(b, frequencies.getOrDefault(b, 0) + 1);
        }
        //Print some statistics
        System.out.println("Most common characters: ");
        frequencies.entrySet().stream().sorted(
                Map.Entry.<Byte, Integer>comparingByValue().reversed()
        ).limit(5).forEach(entry ->
                System.out.println(" '" + (char)(byte).entry.getKey() + " ': " + entry.getValue()));
        return frequencies;
    }

    //Step 2: Build the Huffman tree

}