package io.github.darlene.core;

import java.util.Set;

// This are file compressions mapped to the algorithms they use
public enum CompressionFormat {

    ZIP(Set.of(CompressionType.DEFLATE), ".zip", 9),
    TAR(Set.of(), ".tar", 9),   // Archive format without compression
    GZIP(Set.of(CompressionType.DEFLATE), ".gz", 9),
    TAR_GZ(Set.of(CompressionType.DEFLATE), ".tar.gz", 9),
    BZIP2(Set.of(CompressionType.BWT, CompressionType.MTF, CompressionType.HUFFMAN), ".bz2", 9),
    XZ(Set.of(CompressionType.LZMA2), ".xz", 9),
    RAR(Set.of(CompressionType.PPM, CompressionType.LZSS, CompressionType.RANGE), ".rar", 9);


    private final Set<CompressionType> algorithms;
    private final String fileExtension;
    private final int defaultCompressionLevel;



    // Constructors and methods
    CompressionFormat (Set<CompressionType> algorithms, String fileExtension, int defaultCompressionLevel){
        this.algorithms = algorithms;
        this.fileExtension = fileExtension;
        this.defaultCompressionLevel = defaultCompressionLevel;
    }

    // Getter
    public Set<CompressionType> getAlgorithms(){
        return algorithms;
    }

    public int getDefaultCompressionLevel() {
        return defaultCompressionLevel;
    }

    //Method to find file format based on file extension
    public CompressionFormat getCompressionFormatByExtension(String extension){
        for (CompressionFormat format: CompressionFormat.values()){
            if(format.fileExtension.equalsIgnoreCase(extension)){
                return format;
            }
        }
        return null;
    }
}
