package counters;

import org.jsoup.nodes.Document;

import java.util.Map;

public interface UniqueWordsCounter {
    Map<String, Integer> countUniqueWords(Document document);
}
