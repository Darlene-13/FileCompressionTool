// This file is the creator of objects, it centralizes objects creation logic.
// It creates the different compression strategies based on the formats
package io.github.darlene.factory;


import io.github.darlene.core.CompressionStrategy;
import io.github.darlene.core.CompressionFormat;
import io.github.darlene.exception.FormatNotSupportedException;
import io.github.darlene.strategies.RarCompressionStrategy;
import io.github.darlene.strategies.DeflateCompressionStrategy;
import io.github.darlene.strategies.Bzip2CompressionStrategy;
import io.github.darlene.strategies.XzCompressionStrategy;

public class CompressionStrategyFactory{

    public static CompressionStrategy getStrategy(CompressionFormat format){

        switch (format) {
            case TAR_GZ, ZIP, GZIP:
                return new DeflateCompressionStrategy();
            case BZIP2:
                return new Bzip2CompressionStrategy();
            case XZ:
                return new XzCompressionStrategy();
            case RAR:
                return new RarCompressionStrategy();
            default:
                throw new FormatNotSupportedException("Format not supported: " + format);
        }
    }

}