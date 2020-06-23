import counters.HtmlUniqueWordsCounter;
import counters.UniqueWordsCounter;
import downloaders.FileDownloader;
import downloaders.HtmlFileDownloader;
import filesavers.FileSaver;
import filesavers.HtmlFileSaver;
import org.jsoup.nodes.Document;

import java.util.Map;

public class HtmlUniqueWordsHandler {

    FileDownloader downloader;
    FileSaver saver;
    UniqueWordsCounter counter;

    public HtmlUniqueWordsHandler(FileDownloader downloader, FileSaver saver, UniqueWordsCounter counter) {
        this.downloader = downloader;
        this.saver = saver;
        this.counter = counter;
    }

    public void saveAndCount(String getFrom, String saveTo) {
        Document document = (Document) downloader.fileDownload(getFrom);
        saver.saveFileTo(document, saveTo);
        Map<String, Integer> counterMap = counter.countUniqueWords(document);

        for(String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }
    }
}
