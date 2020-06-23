import org.jsoup.nodes.Document;

public class HtmlWordSplitter implements WordSplitter {
    @Override
    public String[] splitWords(Object o) {
        Document doc = (Document) o;
        String s = doc.body().text();
        String[] words;
        words = s.toLowerCase().replaceAll("[,.!?\";:)(\n\r\t]", "").split("\\s+");
        return words;
    }

}
