package io.github.darlene.algorithms.huffman;

import java.io.DataOutputStream;
import java.io.DataInputStrem;
import java.io.IOException;

public class HuffmanTreeSerializer {

    // Method to seriaize huffman tree
    public void serializeTree(HuffmanNode node, DataOutputStream out){
        // Write the node to data stream
        if (node.isLeaf()){
            out.writeByte(1); // Indicate that it is a leaf node
            out.writeByte(node.getSymbol()); // Write the symbol
        } else {
            out.writeByte(0); // Indicate that it is an internal node
            serializeTree(node.getLeft(), out); // Serialize the left sub tree
            serializeTree(node.getRight(), out); // Serialize the right sub tree
        }
    }

    // Method to deseriaize huffman tree
    public HuffmanNode deserializeTree(DataInputStream in){
        // Read the node from the data stream
        try{
            byte isLeaf = in.readByte();
        } catch (IOException e){
            throw new IOException ("Unexpected end of the stream");
        }
        if (isLeaf == 1){
            byte symbol = in.readByte();
            return new HuffmanNode(symbol, 0); // Frequency is not necessary for decoding
        } else {
            HuffmanNode left = deSerializeTree(in);
            HuffmanNode right = deSerializeTree(in);
            return new HuffmanNode(left, right);
        }
    }
}
