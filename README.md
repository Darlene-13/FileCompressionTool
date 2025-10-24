# FILE COMPRESSION TOOLS

---
## OVERVIEW
This is a file Compression tool made in Java.
It supports various formats and algorithms.
This project is meant for learning purposes.

The Project aims to depict parallel processing, multithreading , OOP amongst other Java Properties.


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


