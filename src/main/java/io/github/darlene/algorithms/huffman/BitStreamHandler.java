package io.github.darlene.algorithms.huffman;

import java.util.ArrayList;

// Class to handle bit-level operations
// The encoder produces a string output in 0s and 1s but files store bytes not strings
public class BitStreamHandler {

    String bitString;
    private int paddingNeeded;

    // Constructor
    // Use constructor when the object NEEDS that data to function properly from the start.
    //Use method parameters when the data is specific to THAT operation, not the entire object
    public BitStreamHandler(String bitString){
        this.bitString = bitString;
    }


    // String to bit array
    // When converting bits to byte array, the bitString length must always be a multiple of 8, 1byte = 8 bits.
    // Padding is adding "0" to the end of the bitString to make its length and multiple of 8 and this must be specified in decompression
    public byte[] stringToBitArray(String bitString){
        if (bitString == null || bitString.isEmpty()){
            return new byte[0];
        }

        ArrayList<Byte> byteList = new ArrayList<>();

        // Calculate the padding needed
        int remainder = bitString.length() % 8;
        this.paddingNeeded = 0;
        if(remainder != 0){
            this.paddingNeeded = 8 - remainder;
        }

        // Add padding zeros to the end
        bitString = bitString + "0".repeat(paddingNeeded);

        // Convert each 8-bit chunk to byte
        for (int i = 0; i < bitString.length(); i+=8 ){
            String eightBits = bitString.substring(i,i+8);
            int byteValue = Integer.parseInt(eightBits,2); // binary to int
            byteList.add((byte) byteValue);
        }

        //  Converting ArrayList<Byte> to byte[]
        byte[] result = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++){
            result[i] = byteList.get(i);
        }

        return result;

    }


    // Key thing to note is that if we happen to have padding added during compression then we need to remove that padding when converting back to string
    public String bitArrayToString(byte[] data, int paddingToRemove){
        if(data == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b: data){
            String bits = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            sb.append(bits);
        }

        String result = sb.toString();

        // Remove padding if any
        if (paddingToRemove > 0){
            result = result.substring(0, result.length() - paddingNeeded);
        }
        return result;

    }

    public int getPaddingInfo(){
        return paddingNeeded;
    }

}
