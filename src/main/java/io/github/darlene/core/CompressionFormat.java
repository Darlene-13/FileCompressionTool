package io.github.darlene.core;

import java.util.Set;


public enum CompressionFormat {

    ZIP(Set.of(CompressionType.DEFLATE), ".zip"),
    TAR(Set.of(), ".tar"),   // Archive format without compression
    GZIP(Set.of(CompressionType.DEFLATE), ".gz"),
    TAR_GZ(Set.of(CompressionType.DEFLATE), ".tar.gz"),
    BZIP2(Set.of(CompressionType.BWT, CompressionType.MTF, CompressionType.HUFFMAN), ".bz2"),
    XZ(Set.of(CompressionType.LZMA2), ".xz"),
    RAR(Set.of(CompressionType.PPM, CompressionType.LZSS, CompressionType.RANGE), ".rar");


    private final Set<CompressionType> algorithms;
    private final String fileExtension;



    // Constructors and methods
    CompressionFormat (Set<CompressionType> algorithms, String fileExtension){
        this.algorithms = algorithms;
        this.fileExtension = fileExtension;
    }

    // Getter
    public Set<CompressionType> getAlgorithms(){
        return algorithms;
    }

    //Method to find file format based on file extension
    public static CompressionFormat getCompressionFormatByExtension(String extension){
        for (CompressionFormat format: CompressionFormat.values()){
            if(format.fileExtension.equalsIgnoreCase(extension)){
                return format;
            }
        }
        return null;
    }

}
