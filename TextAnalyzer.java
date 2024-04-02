import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int wordCount = 0;
            int lineCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("File analysis:");
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);

            System.out.print("Enter a word to search: ");
            String searchWord = scanner.nextLine();
            int wordOccurrences = searchWordOccurrences(fileName, searchWord);
            System.out.println("Occurrences of '" + searchWord + "': " + wordOccurrences);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to search for specific word occurrences in the file
    private static int searchWordOccurrences(String fileName, String searchWord) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int occurrences = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    occurrences++;
                }
            }
        }
        reader.close();
        return occurrences;
    }
}
