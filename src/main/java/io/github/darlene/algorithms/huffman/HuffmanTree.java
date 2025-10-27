package io.github.darlene.algorithms.huffman;

import io.github.darlene.algorithms.huffman.HuffmanNode;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {

    private HuffmanNode root;

    public HuffmanTree(){
        this.root = null;
    }


    Map<Byte, Integer> frequencies = new HashMap<>();
}
