import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Business logic implementation for the app
 *
 * @author Barys_Okuneu
 */
public class InvestigatorManager {
    /**
     * Distribute sentences into groups
     *
     * @param sentences
     * @return
     */
    public static List<Group> groupSentences(List<Sentence> sentences) {
        List<Group> groups = new ArrayList<>();
        int sentenceCount = sentences.size();

        for (int i = 0; i < sentenceCount; i++) {
            Sentence sentence1 = sentences.get(i);
            Map<Integer, Group> sentence1Groups = new HashMap<>();

            for (int j = i + 1; j < sentenceCount; j++) {
                Sentence sentence2 = sentences.get(j);

                int changingWordIndex = compare(sentence1, sentence2);

                if (changingWordIndex>-1 && !sentence2.isGrouped(changingWordIndex)) {
                    Group group = sentence1Groups.get(changingWordIndex);
                    if (group == null) {
                        group = new Group(sentence1, changingWordIndex);
                        sentence1Groups.put(changingWordIndex, group);
                    }
                    group.addSentence(sentence2);
                    sentence2.markGrouped(changingWordIndex);
                }
            }

            groups.addAll(sentence1Groups.values());
        }

        return groups;
    }

    /**
     * Compare two sentences to have difference in no more than one word
     *
     * @param sentence1
     * @param sentence2
     * @return - Changing word index in case of success. -1 if the sentences can not be grouped.
     */
    protected static int compare(Sentence sentence1, Sentence sentence2) {
        int changingWordCount = 0;
        int changingWordIndex = 0;

        if (sentence1.getSize() != sentence2.getSize()) {
            return -1;
        }

        for (int i = 0; i < sentence1.getSize(); i++) {
            if (!sentence1.getWord(i).equals(sentence2.getWord(i))) {
                changingWordCount++;
                changingWordIndex = i;
            }
            if (changingWordCount > 1) {
                return -1;
            }
        }

        return changingWordIndex;
    }
}