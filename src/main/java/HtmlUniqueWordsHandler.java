import org.jsoup.nodes.Document;

import java.util.Map;

public class HtmlUniqueWordsHandler {

    FileDownloader downloader = new HtmlFileDownloader();
    FileSaver saver = new HtmlFileSaver();
    UniqueWordsCounter counter = new HtmlUniqueWordsCounter();

    public void saveAndCount(String getFrom, String saveTo) {
        Document document = (Document) downloader.FileDownload(getFrom);
        saver.SaveFileTo(document, saveTo);
        Map<String, Integer> counterMap = counter.countUniqueWords(document);

        for(String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }
    }
}
