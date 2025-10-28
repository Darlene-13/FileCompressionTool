package io.github.darlene.algorithms.huffman;

import io.github.darlene.algorithms.huffman.HuffmanTree;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    private HuffmanNode root;
    Map<Byte, String> codingTable;

    // Constructor
    public HuffmanEncoder(HuffmanTree){
        this.root = HuffmanTree.getRoot();
        this.codingTable = new HashMap<>();
        buildCodingTable(this.root, "");
    }

    //Generate codes method
    public void generateCodes(){




    }

    public void getCodes(){
        // Return the coding table


    }

    public void buildCodingTable(HuffmanNode node, String code){

    }

}
