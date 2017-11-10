import java.util.List;

/**
 * Investigator app main class
 *
 * @author Barys_Okuneu
 */
public class Main {
    public static void main(String[] args) {
        List<Sentence> sentences = FileManager.read("input.txt");
        List<Group> groups = InvestigatorManager.groupSentences(sentences);
        FileManager.write(groups, "output.txt");
    }
}
