package io.github.darlene.algorithms.huffman;


// A huffman node is a node in the huffman tree that either represents the leaf node containing the character and its frequency or the internal node containing the sum of frequencies of its child nodes.
public class HuffmanNode {
    private byte symbol;
    private int frequency;
    private HuffmanNode left;
    private HuffmanNode right;



    // Constructor for the leaf node
    public HuffmanNode(byte symbol, int frequency){
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    // Constructor for the internal node : Internal nodes don't represent a byte. They're just containers combining two child nodes
    public HuffmanNode (HuffmanNode left, HuffmanNode right){
        this.left = left;
        this.right = right;
        this.frequency = left.getFrequency() + right.getFrequency();
    }

    // Getters and Setters
    public byte getSymbol(){
        return symbol;
    }
    public int getFrequency(){
        return frequency;
    }
    public HuffmanNode getLeft(){
        return left;
    }
    public HuffmanNode getRight(){
        return right;
    }

    public void setLeft(HuffmanNode left){
        this.left = left;
    }
    public void setRight(HuffmanNode right){
        this.right = right;
    }

    // Method to check if the node is a leaf node
    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    // Override toString method for better debugging
    @Override
    public String toString(){
        return "Symbol: " + symbol + "Frequency: " + frequency;
    }

    // Comparator for sorting the priority queue
    public static class HuffmanNodeComparator implements java.util.Comparator<HuffmanNode>{
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2){
            return Integer.compare(node1.getFrequency(), node2.getFrequency());
        }
    }

}
