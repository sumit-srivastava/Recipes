package com.java.se8.lambda;

import java.io.*;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("PrintWriterBufferedReader.txt"))) {
            return br.readLine();
        }
    }

	/**
	 * Execute around means the main logic is surround by some boiler plat code like
	 * for example, while file handling, the file resource mus be initialized and after processing
	 * the resource must be cleaned up. The initialization and clean up steps would be same for all the files.
	 */
	/* Combination of execute around pattern functional interface for lambda expression. */
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("PrintWriterBufferedReader.txt"))){	// execute around pattern
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
