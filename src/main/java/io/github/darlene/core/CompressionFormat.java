package io.github.darlene.core;

public enum CompressionFormat {
    ZIP(".zip", "DEFLATE", true, 9),
    GZIP(".gz", "DEFLATE", false, 9),
    TAR_GZ(".tar.gz", "DEFLATE", true, 9),
    BZIP2(".bz2", "Burrows-Wheeler", false, 9),
    XZ(".xz", "LZMA2", false, 9),
    LZMA(".7z", "LZMA", false, 9),
    LZ4(".lz4", "LZ4", false, 9);

    private final String extension;
    private final String algorithmName;
    private final boolean supportsMultipleFiles;
    private final int defaultCompressionLevel;


    CompressionFormat(String extension, String algorithmName, boolean supportsMultipleFiles, int defaultCompressionLevel ) {
        this.extension = extension;
        this.algorithmName = algorithmName;
        this.supportsMultipleFiles = supportsMultipleFiles;
        this.defaultCompressionLevel = defaultCompressionLevel;

    }

    // Getters
    public String getExtension(){
        return extension;
    }

    public String getAlgorithmName(){
        return algorithmName;
    }
    public boolean supportsMultipleFiles() {
        return supportsMultipleFiles;
    }

    public int getDefaultCompressionLevel() {
        return defaultCompressionLevel;
    }



}
