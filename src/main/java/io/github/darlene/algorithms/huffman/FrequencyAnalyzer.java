
package io.github.darlene.algorithms.huffman;

import java.util.HashMap;
import java.util.Map;


// Calculates and analyzes how many times each byte appears and returns map of byte and frequency.
public class FrequencyAnalyzer {

    Map<Byte, Integer> frequencyTable;

    // Constructor
    public FrequencyAnalyzer(byte[] data){
        this.frequencyTable = new HashMap<>();
        analyze(data);
    }

    // Method to analyze
    public void analyze(byte[] data){
        // Counts the byte
        for (byte b: data){
            if (frequencyTable.containsKey(b)){
                frequencyTable.put(b, frequencyTable.get(b) +1);
            } else{
                frequencyTable.put(b, 1 );
            }
        }
    }

    // Populate the map
    public Map<Byte, Integer> getFrequencyTable(){
        return frequencyTable;
    }
}


