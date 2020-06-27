package downloaders;

import org.jsoup.nodes.Document;

import java.io.InputStream;

public interface FileDownloader {
    Document fileDownload(String from);
    InputStream getInputStreamFromURL(String from);
    InputStream getInputStreamFromFile(String from);
}

