package splitters;

import org.jsoup.nodes.Document;

public interface WordSplitter {
    String[] splitWords(Document document);
}
