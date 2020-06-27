package counters;

import org.jsoup.nodes.Document;
import splitters.HtmlWordSplitter;
import splitters.WordSplitter;

import java.util.HashMap;
import java.util.Map;

public class HtmlUniqueWordsCounter implements UniqueWordsCounter {

    private WordSplitter splitter;

    public HtmlUniqueWordsCounter(WordSplitter splitter) {
        this.splitter = splitter;
    }

    @Override
    public Map<String, Integer> countUniqueWords(Document document) {
        Map<String, Integer> counterMap = new HashMap<>();
        String[] words = splitter.splitWords(document);
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }
        return counterMap;
    }
}
