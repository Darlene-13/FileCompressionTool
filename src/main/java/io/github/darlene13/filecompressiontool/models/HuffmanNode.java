// This file is meant to build the huffman coding tree structure and compare the nodes by frequency whole building the tree

package io.github.darlene13.filecompressiontool.models;

import java.io.Serializable;

class HuffmanNode implements Comparable<HuffmanNode>, Serializable {
    private static final long serialVersionUID = 1L;

    //The node contents
    private final byte character;   // The actual letter/character (if leaf)
    private final int frequency;    // How often the character appreas
    private final HuffmanNode left; // Left child or arm
    private final HuffmanNode right;  // Right arm or child
    private final HuffmanNode isLeaf;   // Is this a person or a couple?

    // Constructor for one Leaf node

    private HuffmanNode(byte character, int frequency){
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
        this.isLeaf = true;

        System.out.println("Created leaf: '" + char(character) + "' appears" + frequency + "times.")

    }

    // Constructor for the INTERNAL nodes (combines two nodes)
    private HuffmanNode(HuffmanNode left, HuffmanNode right){
        this.character = 0;
        this.frequency = 0;
        this.left = left;
        this.right = right;
        this.isLeaf = false;

        System.out.println("Merged nodes: frequency = " + this.frequency);

    }

    // Getter methods
    public byte getCharacter() {return character; }
    public int getFrequency() { return frequency; }
    public HuffmanNode getLeft() { return left; }
    public HuffmanNode getRight() { return right; }
    public boolean isLead {return isLeaf; }

    // Comparing two nodes for priority queue
    // Smaller frequency = higher priority
    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency)
    }

    // Display the node as a text
    @Override
    public string toString() {
        if (isLeaf){
            return String.format("'%c:%d", char(character), frequency);
        } else {
            return String.format("Internal: %d", frequency);
        }
    }
}