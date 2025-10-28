package io.github.darlene.algorithms.huffman;



import java.util.ArrayList;
import java.util.List;

public class HuffmanDecoder {
    private HuffmanNode root;
    private String encodedData;
    private List<Byte> decodedData;

    // Constructor
    public HuffmanDecoder(HuffmanTree tree, String encodedData){
        this.root = tree.getRoot();
        this.encodedData = encodedData;
        this.decodedData = new ArrayList<>();
    }

    public void decode(){
        // Empty list to store decoded bytes
        HuffmanNode currentNode = root;
        // For each bit in encoded data
        for (char bit: encodedData.toCharArray()){
            if (bit == '0'){
                currentNode = currentNode.getLeft();
            } else {
                if(bit == '1'){
                    currentNode = currentNode.getRight();
                }
            }
            // Check if we have reached the leaf
            if(currentNode.isLeaf()){
                this.decodedData.add(currentNode.getSymbol()); // Populating the decodedData arrayList
                currentNode = root; // Reset to root for next byte
            }

        }

    }

    public List<Byte> getDecodedData(){
        return this.decodedData;
    }

}
