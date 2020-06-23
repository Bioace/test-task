import java.util.HashMap;
import java.util.Map;

public class HtmlUniqueWordsCounter implements UniqueWordsCounter {

    WordSplitter splitter = new HtmlWordSplitter();

    @Override
    public Map<String, Integer> countUniqueWords(Object document) {
        Map<String, Integer> counterMap = new HashMap<>();
        String[] words = splitter.splitWords(document);
        for (String word : words) {
            if(!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if(count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }
        return counterMap;
    }
}
