package io.github.darlene.algorithms.huffman;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    private HuffmanNode root;
    Map<Byte, String> codingTable;

    // Constructor
    public HuffmanEncoder(HuffmanTree tree){
        this.root = tree.getRoot();
        this.codingTable = new HashMap<>();
        generateCodes();
    }

    //Generate codes method
    public void generateCodes(){
        buildCodingTable(this.root,"");
    }

    public void buildCodingTable(HuffmanNode node, String code){
        // Edge case 1: If node is null
        if (node == null){
            return;
        }
        // Edge case 2: If node is a leaf node
        if (node.isLeaf()){
            codingTable.put(node.getSymbol(), code);
            return;
        }
        // Recursive calls for left and right child nodes
        buildCodingTable(node.getLeft(), code + "0");
        buildCodingTable(node.getRight(), code + "1");


    }
    // Method to get codes
    public String getCodes(byte symbol){
        return codingTable.get(symbol);
    }

    // Method to encode
    public void enCode(byte[] fileData){
        // Empty String builder to hold the lists


    }

}
