import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Sentence entity class. Represents a sentence parsed into a date-time and a list of words.
 * Also has a set of group-index marks to speed up the process.
 *
 * @author Barys_Okuneu
 */
public class Sentence {
    private String dateTime;
    private List<String> words;
    private Set<Integer> changingWordIndexGroups = new HashSet<>();

    /**
     * A constructor to create the entity form a raw line
     *
     * @param line
     */
    public Sentence(String line) {
        dateTime = line.substring(0, 19);
        words = Arrays.asList(line.substring(20).split(" "));
    }

    @Override
    public String toString() {
        return dateTime + " " + String.join(" ", words);
    }

    /**
     * Get word by index
     *
     * @param index
     * @return
     */
    public String getWord(int index) {
        return words.get(index);
    }

    /**
     * Get word count in the sentence
     *
     * @return
     */
    public int getSize() {
        return words.size();
    }

    /**
     * Mark current sentence grouped by changingWordIndex
     *
     * @param changingWordIndex
     */
    public void markGrouped(int changingWordIndex) {
        changingWordIndexGroups.add(changingWordIndex);
    }

    /**
     * Check if current sentence already grouped by changingWordIndex
     *
     * @param changingWordIndex
     * @return
     */
    public boolean isGrouped(int changingWordIndex) {
        return changingWordIndexGroups.contains(changingWordIndex);
    }
}