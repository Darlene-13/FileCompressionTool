// This ile is meant to coordinate multiple components to accomplish a task
// It is impportant in the occasion that the application needs to get the user input, detect file type, get the right algorithm, call compress/ decompress, handler errors , track progress, display results etc,,

public class FileCompressionManager {

    private int compressionLevel;

    public void compress(sourceFile, destFile, format){
        try {
            strategy = factory.getStrategy(format);

            // Ask factory for strategy


            // call strategy compress


            // catch exceptions


            // Display results


            // Return the success state .. boolean
        }
    }

    public void decompression(sourceFile, destFile, format){
        // Receives user request to compress or decompres file with format

        // Ask factory for strategy


        // call strategy decompress


        // catch exceptions


        // Display results


        // Return the succ
    }

    public getLastCompressionDetails(){

    }

}