import java.util.ArrayList;
import java.util.List;

/**
 * Group entity class. Represents a structure of grouped sentences.
 *
 * @author Barys_Okuneu
 */
public class Group {
    private List<Sentence> sentences = new ArrayList<>();
    private int changingWordIndex = -1;

    /**
     * A constructor to create a group from a sentence
     *
     * @param sentence
     * @param changingWordIndex
     */
    public Group(Sentence sentence, int changingWordIndex) {
        sentences.add(sentence);
        this.changingWordIndex = changingWordIndex;
    }

    /**
     * Return a comma-separated string of changing words
     *
     * @return
     */
    public String getChangingWordsString() {
        List<String> changingWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            changingWords.add(sentence.getWord(changingWordIndex));
        }
        return "The changing word was: " + String.join(", ", changingWords);
    }

    /**
     * Add a sentence to the group
     *
     * @param sentence
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Get the list of sentences in the group
     *
     * @return
     */
    public List<Sentence> getSentences() {
        return sentences;
    }
}
