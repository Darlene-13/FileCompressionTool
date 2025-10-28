package io.github.darlene.algorithms.huffman;

import java.util.ArrayList;

// Class to handle bit-level operations
// The encoder produces a string output in 0s and 1s but files store bytes not strings
public class BitStreamHandler {

    String bitString;
    private int paddingNeeded;

    // Constructor
    public BitStreamHandler(String bitString, int paddingNeeded){
        this.paddingNeeded = paddingNeeded;
        this.bitString = bitString;
        ArrayList<Byte> bits = new ArrayList<>();
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

    public String bitArrayToString(byte[] data){
        if(data == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b: data){
            String bits = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            sb.append(bits);
        }

        return sb.toString();

    }

    public int getPaddingInfo(){
        return paddingNeeded;
    }

}
