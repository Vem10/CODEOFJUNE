import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Word Count Program");

        System.out.print("Enter text or provide a file path: ");
        String userInput = scanner.nextLine();

        // Check if the user input is a file path
        File file = new File(userInput);
        if (file.exists() && file.isFile()) {
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
                return;
            }
        } else {
            text = userInput;
        }

        // Split the text into words using space or punctuation as delimiters
        String[] words = text.split("\\s+|\\p{Punct}");

        // Initialize counters
        int totalWords = 0;
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Count the words and collect additional statistics
        for (String word : words) {
            if (!word.isEmpty()) {
                totalWords++;
                uniqueWords.add(word);

                // Increment word frequency count
                int count = wordFrequency.getOrDefault(word, 0);
                wordFrequency.put(word, count + 1);
            }
        }

        System.out.println("Word Count: " + totalWords);
        System.out.println("Unique Words: " + uniqueWords.size());

        // Print word frequencies
        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
