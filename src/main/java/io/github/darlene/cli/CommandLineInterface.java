package io.github.darlene.cli;


import io.github.darlene.core.CompressionFormat;
import io.github.darlene.exception.CompressionException;

import java.io.Serializable;


public class CommandLineInterface {

    public void run(String[] args) {
        if(args.length == 0){
           displayHelp();
           return;
        }

        String command = args[0]; // First argument is the command

        if (command.equals("compress")){
            handleCompress(args);
        } else if (command.equals("decompress")){
            handleDecompress(args);
        } else if (command.equals("help")){
            displayHelp();
        } else if (command.equals("benchmark")){
            handleBenchMark(args);
        } else {
            System.out.println("Unknown Command");
            displayHelp();
        }
    }

    private void handleBenchMark(String[] args) {
    }

    private void handleDecompress(String[] args) {
    }

    private void handleCompress(String[] args) {
        try{
            String sourceFile = getArgumentValue(args, "-f"); // -f for file
            String destFile = getArgumentValue(args, "=o"); // -o for output
            CompressionFormat format = getArgumentValue(args, "-m");

            System.out.println("Missing required arguments");
            System.out.println("Usage: compress -f <source> -o <output> -a <algorithm>");
            return;

            // Create manager and compress
        } catch (CompressionException e){
            throw new CompressionException(e.getMessage());

        }
    }

    private Serializable getArgumentValue(String[] args, String flag, CompressionFormat format) {
        for (int i = 0; i < args.length; i++){
            if(args[i].equals(flag)){
                if(i + 1 < args.length){
                    return args[i+1];
                }
            }
        }
        return format;
    }

    private void displayHelp() {
    }
}
