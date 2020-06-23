package downloaders;

import org.jsoup.nodes.Document;

public interface FileDownloader {
    Document fileDownload(String from);
}
