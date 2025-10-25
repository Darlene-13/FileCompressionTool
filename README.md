# FILE COMPRESSION TOOLS

---
## OVERVIEW
This is a file Compression tool made in Java.
It supports various formats and algorithms.
This project is meant for learning purposes.

The Project aims to depict parallel processing, multithreading , OOP amongst other Java Properties.

**The Core Problem:**
When you have a file, it's made of bytes. Each byte is a number from 0-255. A file takes up space. The goal of compression is to represent the same information using fewer bytes.
Think of it like language: If I write "the the the the the" five times, I could instead write "the (×5)" and save space. Compression finds these patterns and represents them more efficiently.

**Why does this matter?** Storage is cheaper with smaller files. Transmission is faster. Backup is quicker.

---
## FEATURES
1. File Compression 
2. File Decompression



---
## SUPPORTED FORMATS AND ALGORITHMS


| Format | Extension | Primary Algorithm | Secondary Algorithm | Library | Characteristics |
|--------|-----------|------------------|-------------------|---------|-----------------|
| ZIP | .zip | DEFLATE (LZ77 + Huffman) | Store (uncompressed) | java.util.zip (built-in) | Multi-file, directories, widely compatible |
| GZIP | .gz | DEFLATE (LZ77 + Huffman) | - | java.util.zip (built-in) | Single file, fast, Unix standard |
| TAR + GZIP | .tar.gz / .tgz | DEFLATE | LZ77 + Huffman | Apache Commons Compress | Preserves Unix permissions, multi-file |
| BZIP2 | .bz2 | Burrows-Wheeler Transform + Move-to-Front + Huffman | RLE | Apache Commons Compress | Better compression than GZIP, slower |
| XZ | .xz | LZMA2 | Range Encoder + Huffman variants | Apache Commons Compress | Excellent compression, very slow |
| 7-Zip | .7z | LZMA2 | Multiple codecs | Apache Commons Compress / Sevenz | Best compression, slowest |
| RAR | .rar | PPM (Prediction by Partial Matching) or LZ | Huffman | Not recommended (proprietary, limited Java support) | Skip for this project |
| LZ4 | .lz4 | LZ4 (fast LZ variant) | - | lz4-java library | Ultra-fast, lower compression |

---
### Algorithms Deep Dive
1. **DEFLATE (ZIP, GZIP, TAR.GZ)**
- This algorithm combines LZ77 (Lempel-Ziv) with Huffman Coding
- LZ77: Finds repeated sequences and replaces with back sequence.
- It is built into java and thus no external dependency needed.

2. **HUFFMAN CODING**
- Variable length prefix free codes
- Frequency symbols get shorter codes
- It uses a binary tree (min heap/ priority queue)
- This is the core of compression and decompression of files

3. Burrows-Wheeler Transform
- It re-arranges data to improve compressibility
- Followed by Move-to-Front and Run-Length Encoding
- Then Huffman Encoding
- It has a better compression Ratio as compared to DEFLATE

4. LZMA/LZMA2 (XZ, 7Z)
- Advanced LZ variant with range encoding
- It has an extremely high compression ratio.
- Much slower than DEFLATE
- It follows the modern standard for archival

5. LZ4 (ULTRA FAST)
- It is a simplified LZ Algorithm
- It Prioritizes speeed over compression ration
-  It is used when in need of fast compression with decent ratio.

## FILE STRUCTURE AND ARCHITECTURE DESIGN
### Layer 1: FILE TYPE DETECTION
> - Input: Filename with extension
> - Process: Map extension to the suitable algorithm
> - CompressionFormat enum
>
>  
> We need: FileTypeDetector class (utility class), FileCompression format (enum, matches compression format to necessary algorithms) and FormatDetectionException to handle edge cases like wrong file input.


### Layer 2: COMPRESSION STRATEGY
````
CompressionStrategy (Interface)
├── DeflateCompressionStrategy (ZIP/GZIP/TAR.GZ)
├── Bzip2CompressionStrategy (BZIP2)
├── XzCompressionStrategy (XZ)
├── LzmaCompressionStrategy (7Z)
├── Lz4CompressionStrategy (LZ4)
└── HuffmanCompressionStrategy (Your custom implementation)

Each implements:
- compress(sourceFile, destinationFile, compressionLevel, progressListener)
- decompress(sourceFile, destinationFile, progressListener)
- getCompressionRatio()
- validateFormat(file)
- getSupportedExtensions()
```` 

### LAYER 3: CUSTOM HUFFMAN IMPLEMENTATION
````
HuffmanCoding (Your core algorithm implementation)
├── HuffmanNode (binary tree node)
├── HuffmanTree (builds tree from frequencies)
├── HuffmanEncoder (compress)
├── HuffmanDecoder (decompress)
├── FrequencyAnalyzer (count byte frequencies)
└── BitStreamHandler (convert binary strings ↔ bytes)

Key classes:
- HuffmanNode: left, right, frequency, symbol
- PriorityQueue<HuffmanNode>: min-heap for tree building
- HashMap<Byte, String>: map symbols to bit codes
- BitSet or custom BitStream: handle bit-level operations

````

### LAYER 4: FILE I/O & STREAMING LAYER
``````
CompressionStreamHandler (manages file operations)
├── readFileInChunks(file, chunkSize)
├── writeFileInChunks(outputStream, chunkSize)
├── handleLargeFiles(useThreadPool)
├── validateSourceFile(file)
├── createDestinationFile(file)
└── calculateFileSize(file)

Supporting classes:
- BufferedInputStream/OutputStream (Java built-in)
- Custom ChunkProcessor (manage chunks)
- ProgressTracker (monitor progress)

``````

### LAYER 5: PROGRESS & MONITORING LAYER
````
CompressionProgressListener (Observer pattern)
├── onCompressionStarted(fileName, fileSize)
├── onProgress(bytesProcessed, totalBytes, percentage)
├── onCompressionCompleted(compressionRatio, timeElapsed)
└── onError(exception, recoverable)

Supporting classes:
- CompressionStatistics (track metrics)
- PerformanceMonitor (time, memory usage)
- ProgressCallback

````

### LAYER 6: CONFIGURATION & PROFILING LAYER
```
CompressionProfile (encapsulates settings)
├── SPEED (for fast compression, lower ratio)
├── BALANCED (mix of speed and compression)
├── MAXIMUM (best compression, slowest)
├── PARALLEL (multi-threaded)
└── STREAMING (for huge files)

CompressionConfig
├── compressionLevel (1-9)
├── chunkSize (64KB, 256KB, 1MB)
├── threadPoolSize (for parallel processing)
├── preserveMetadata (timestamps, permissions)
├── deleteSourceAfterCompression
└── compressionAlgorithmPreference
```

### LAYER 7: ERROR HANDLING LAYER
```
CompressionException (base)
├── FormatNotSupportedException
├── CorruptedFileException
├── InsufficientDiskSpaceException
├── InvalidCompressionParametersException
├── FileAccessException
├── EncodingException
└── DecodingException
```

### LAYER 8: ORCHESTRATION (MAIN CONTROLLER)
```
FileCompressionManager (Main coordinator)
├── compressFile(source, destination, format, profile, listener)
├── decompressFile(source, destination, listener)
├── compressDirectory(source, destination, format, recursive, listener)
├── decompressDirectory(source, destination, listener)
├── autoDetectAndDecompress(source, destination, listener)
├── compareCompressionMethods(file)
└── getCompressionStatistics()

This ties all layers together