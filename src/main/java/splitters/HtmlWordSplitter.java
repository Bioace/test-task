package splitters;

import org.jsoup.nodes.Document;

public class HtmlWordSplitter implements WordSplitter {
    @Override
    public String[] splitWords(Document document) {
        String s = document.body().text();
        String[] words;
        words = s.toLowerCase().replaceAll("[,.!?\";:)(\n\r\t]", "").split("\\s+");
        return words;
    }

}
