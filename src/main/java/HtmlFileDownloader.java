import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlFileDownloader implements FileDownloader {
    @Override
    public Object FileDownload(String from) {
        Document document = null;
        try {
            document = Jsoup.connect(from).get();
        } catch (IOException e) {
            System.out.println("Возникла ошибка, проверьте правильность URL");
            System.exit(1);
        }
        return document;
    }
}
