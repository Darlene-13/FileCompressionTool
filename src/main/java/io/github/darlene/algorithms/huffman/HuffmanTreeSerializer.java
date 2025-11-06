package io.github.darlene.algorithms.huffman;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class HuffmanTreeSerializer {

    // Method to serialize huffman tree
    public void serializeTree(HuffmanNode node, DataOutputStream out) throws IOException {
        // Write the node to data stream
        if (node.isLeaf()){
            out.writeByte(1); // Indicate that it is a leaf node
            out.writeByte(node.getSymbol()); // Write the symbol
        } else {
            out.writeByte(0); // Indicate that it is an internal node
            serializeTree(node.getLeft(), out); // Serialize the left subtree
            serializeTree(node.getRight(), out); // Serialize the right subtree
        }
    }

    // Method to deserialize huffman tree
    public HuffmanNode deserializeTree(DataInputStream in) throws IOException {
        // Read the node from the data stream
        byte isLeaf;
        try {
            isLeaf = in.readByte();
        } catch (IOException e) {
            throw new IOException("Unexpected end of the stream");
        }
        if (isLeaf == 1) {
            byte symbol = in.readByte();
            return new HuffmanNode(symbol, 0); // Frequency is not necessary for decoding
        } else {
            HuffmanNode left = deserializeTree(in);
            HuffmanNode right = deserializeTree(in);
            return new HuffmanNode(left, right);
        }
    }
}
