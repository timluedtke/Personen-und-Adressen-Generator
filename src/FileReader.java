import java.io.*;

public class FileReader {

    public String[] readFile(String filename) throws IOException {
        int lines = countLinesInFile(filename);
        String[] outputLines = saveFileToArraySplittedByLines(filename, lines);
        System.out.println(lines + " Zeilen von " + filename + " importiert.");
        return outputLines;
    }

    private String[] saveFileToArraySplittedByLines(String filename, int lines) throws IOException {
        BufferedReader incomingLines = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
        String[] outputLines = new String[lines];
        for ( int i = 0; i < lines; i++ ) {
            outputLines[i] = incomingLines.readLine();
        }
        return outputLines;
    }

    private int countLinesInFile(String filename) throws IOException {
        java.io.FileReader fileReader;
        fileReader = new java.io.FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int numberOfLines = 0;
        while ( bufferedReader.readLine() != null ) {
            numberOfLines++;
        }
        bufferedReader.close();
        return numberOfLines;
    }
}
