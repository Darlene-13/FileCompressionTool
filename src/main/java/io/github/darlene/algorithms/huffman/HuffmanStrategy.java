package io.github.darlene.algorithms.huffman;


// Import exceptions
import io.github.darlene.exception.CompressionException;
import io.github.darlene.exception.FileNotFoundException;
import io.github.darlene.exception.DecompressionException;




// Importing necessary libraries
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Map;
import java.io.DataOutputStream;
import java.io.DataInputStream;


import io.github.darlene.core.CompressionStrategy;

public class HuffmanStrategy implements CompressionStrategy {

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
    // Compress strategy
    /*
    * 1. Read data from the source file
    * 2. Analyze frequencies using the methods in frequency analyzer
    * 3. Build tree using HuffmanTree method
    * 4. Encode data
    * 5. Convert bits to bytes
    * 6. Write to destination file
    * 7. Calculate the metrics
    * 8. Set the success status.
    *
    * // It is important to handle file exceptions.
    * */
    public void compressFile(String sourceFilePath, String destinationFilePath, int compressionLevel) {
        startTime = System.currentTimeMillis();
        // Read the source file to byte array
        try{
            Path sourceFile = Paths.get(sourceFilePath);
            byte [] fileData = Files.readAllBytes(sourceFile);

            // Analyze the frequencies
            FrequencyAnalyzer analyzer = new FrequencyAnalyzer(fileData);
            Map<Byte, Integer> frequencies = analyzer.getFrequencyTable();

            // Build  tree using the huffman tree class
            HuffmanTree huffmanTree = new HuffmanTree(frequencies);

            // Encode data using huffman encoder to get the encoded bit string
            HuffmanEncoder encoder = new HuffmanEncoder(huffmanTree);
            String encodedBitString = encoder.encode(fileData);

            // Converting string to byte array to get original file size
            BitStreamHandler handler = new BitStreamHandler("");
            byte [] compressedBytes = handler.stringToBitArray(encodedBitString);
            int paddingInfo = handler.getPaddingInfo();

            FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);
            DataOutputStream dataOut = new DataOutputStream(fileOutputStream);
            dataOut.writeInt(paddingInfo);
            dataOut.write(compressedBytes);

            // Calculating the metrics
            this.originalFileSize = fileData.length;
            this.compressedFileSize = compressedBytes.length;

            dataOut.close(); // Close the reader stream because we are done reading and to avoid memory leaks.
            compressionSuccessStatus = true;

        } catch (FileNotFoundException e){
            compressionSuccessStatus = false;
            throw new FileNotFoundException("Source file not found: " + sourceFilePath);

        } catch (IOException e){
            compressionSuccessStatus = false;
            throw new CompressionException("Error reading file: " + e.getMessage());

        } catch (Exception e){
            compressionSuccessStatus = false;
            throw new CompressionException("Unexpected error during compression: " + e.getMessage());
        } finally {
            endTime = System.currentTimeMillis();
            compressionTime = endTime - startTime;
        }

    }

    @Override
    public boolean getCompressionSuccessStatus() {
        return compressionSuccessStatus;
    }

    @Override
    public double getCompressionRatio() {
        if (originalFileSize == 0){
            return 0.0;
        }
        compressionRatio = ((double) (originalFileSize - compressedFileSize) / originalFileSize) * 100.0;
        return compressionRatio;
    }

    @Override
    public long getCompressionTime() {
        compressionTime = endTime - startTime;
        return compressionTime;
    }

    @Override
    public long getOriginalFileSize() {
        return originalFileSize;
    }

    @Override
    public long getCompressedFileSize() {
        return compressedFileSize;
    }

    @Override
    public void displayCompressionDetails() {
        System.out.println("================================================================");
        System.out.println("Compression Details:");
        System.out.println("Success Status: " + compressionSuccessStatus);
        System.out.println("Original File Size: " + originalFileSize + " bytes");
        System.out.println("Compressed File Size: " + compressedFileSize + " bytes");
        System.out.println("Compression Ratio: " + String.format("%.2f", compressionRatio) + "%");
        System.out.println("Time Taken for Compression: " + compressionTime + " ms");
        System.out.println("================================================================");

    }

    @Override
    public void decompressFile(String sourceFilePath, String destinationFilePath) {
        startTime = System.currentTimeMillis();
        try{
            // Open input stread from the source file (Compressed file in this case)
            FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
            DataInputStream dataIn = new DataInputStream(fileInputStream);

            // Read the padding info
            int paddingInfo = dataIn.readInt();
            // Deserialize the huffman tree
            HuffmanTreeSerializer treeSerializer = new HuffmanTreeSerializer();
            HuffmanNode root = treeSerializer.deserializeTree(dataIn);
            //Read the rest of the data as byte array
            byte [] compressedBytes = dataIn.readAllBytes();
            dataIn.close();

            // Converts bytes back to bit string
            // So the path is bits to string (bitString) to original bytes
            BitStreamHandler handler = new BitStreamHandler();
            String bitString = handler.bitArrayToString(compressedBytes, paddingInfo);

            // Decode the bit string using huffman decoder
            HuffmanTree tree = new HuffmanTree(); // Dummy tree just for the root
            tree.setRoot(root);
            HuffmanDecoder decoder = new HuffmanDecoder(tree, bitString);
            decoder.decode();
            byte [] decodedData = decoder.getDecodedData().toArray();

            // Write the decoded data to the destination file
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);
            fileOutputStream.write(decodedData);
            fileOutputStream.close();

            // Calculation of the metrics
            originalFileSize = decodedData.length;
            compressedFileSize = compressedBytes.length;
            decompressionSuccessStatus = true;

        } catch (FileNotFoundException e){
            decompressionSuccessStatus = false;
            throw new FileNotFoundException("Source file not found: " + sourceFilePath);
        } catch (Exception e){
            decompressionSuccessStatus = false;
            throw new DecompressionException("Unexpected error occurred during decompression");
        } finally {
            endTime = System.currentTimeMillis();
        }

    }

    @Override
    public boolean getDecompressionSuccessStatus() {
        return decompressionSuccessStatus;
    }

    @Override
    public void displayDecompressionDetails() {
        System.out.println("================================================================");
        System.out.println("Decompression Details:");
        System.out.println("Time taken for Decompression: " + (endTime - startTime) + " ms");
        System.out.println("Success Status: " + decompressionSuccessStatus);
        System.out.println("================================================================");

    }


}
