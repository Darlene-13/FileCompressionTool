package io.github.darlene.algorithms.huffman;

import java.util.ArrayList;

// Class to handle bit-level operations
// The encoder produces a string output in 0s and 1s but files store bytes not strings
public class BitStreamHandler {

    private ArrayList<Byte> bits;
    String bitString;

    // Constructor
    public BitStreamHandler(String bitString){
        this.bitString = bitString;
        this.bits = new ArrayList<>();
    }


    // String to bit array
    public byte[] stringToBitArray(String bitString){
        if (bitString == null || bitString.isEmpty()){
            return new byte[0];
        }

        ArrayList<Byte> byteList = new ArrayList<>();

        // Calculate the padding needed
        int remainder = bitString.length() % 8;
        int paddingNeeded = 0;
        if(remainder != 0){
            paddingNeeded = 8 - remainder;
        }

        // Add padding zeros to the end
        // Redo this.
        StringBuilder bitStringBuilder = new StringBuilder(bitString);
        for (int i = 0; i < paddingNeeded - 1; i++){
            bitStringBuilder.append("0");
        }
        bitString = bitStringBuilder.toString();

        // Convert each 8-bit chunk to byte
        for (int i = 0; i == bitString.length(); i+=8 ){
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

    public void bitArrayToString(byte[] data){

    }

    public void getPaddingInfo(){

    }

}
