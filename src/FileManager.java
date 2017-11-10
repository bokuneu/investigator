import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class to provide file read/write operations
 *
 * @author Barys_Okuneu
 */
public class FileManager {
    /**
     * Read file input into a list of sentences
     *
     * @param fileName
     * @return
     */
    public static List<Sentence> read(String fileName) {
        List<Sentence> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(new Sentence(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return result;
    }

    /**
     * Write list of grouped sentences into output file
     *
     * @param groups
     * @param fileName
     */
    public static void write(List<Group> groups, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Group group : groups) {
                for (Sentence sentence : group.getSentences()) {
                    writer.println(sentence.toString());
                }
                writer.println(group.getChangingWordsString());
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}