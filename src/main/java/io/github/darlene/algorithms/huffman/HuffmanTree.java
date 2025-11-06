package io.github.darlene.algorithms.huffman;

import io.github.darlene.algorithms.huffman.HuffmanNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    private HuffmanNode root;
    private Map<Byte, Integer> frequencies;

    public HuffmanTree(){
        this.frequencies = new HashMap<>();
        this.root = null;
    }
    public HuffmanTree(Map<Byte, Integer> frequencies){
        this.frequencies = frequencies;
        this.root = null;
        buildTree(); // Build the tree upon initialization
    }

    // Methods to build the tree, get the root, etc. would go here
    public HuffmanNode getRoot(){
        return this.root;
    }
    public void setRoot(HuffmanNode root){
        this.root = root;
    }

    public Map<Byte, Integer> getFrequencies(){
        return this.frequencies;
    }

    // New priority queue to store the node frequencies in order
    /*
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new Comparator<HuffmanNode>()
    {
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2){
            return Integer.compare(node1.getFrequency(), node2.getFrequency());
        }
    });
    */

    // Using a lambda queue which is much cleaner

    // Looping through the frequencies map to add nodes to the priority queue
    public void buildTree(){
        // Edge case1: In case of an empty frequency map
        if(frequencies == null || frequencies.isEmpty()){
            root = new HuffmanNode((byte)0,0);
            return; // Return a dummy node
        }

        // Edge case 2: In case of a single unique byte in the frequency map
        if( frequencies.size() == 1){
            byte singleByte = frequencies.keySet().iterator().next();
            int frequency = frequencies.get(singleByte);
            HuffmanNode leafNode = new HuffmanNode(singleByte,frequency);
            HuffmanNode dummyNode = new HuffmanNode((byte)0,0);
            root = new HuffmanNode(leafNode, dummyNode);
            return;

        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>((n1, n2) ->
        Integer.compare(n1.getFrequency(), n2.getFrequency())); // Using a lambda queue which is much cleaner, it is a local variable now.


        for (Map.Entry<Byte, Integer> entry: frequencies.entrySet()){
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            queue.add(node);
        }

        // Building the tree
        while (queue.size() > 1){
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode(left, right);
            queue.add(parent);
        }
        root = queue.poll();

    }
}
