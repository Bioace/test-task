package filesavers;

import org.jsoup.nodes.Document;

import java.io.InputStream;

public interface FileSaver {
    void saveFileTo(Document file, String saveTo);
    void saveFromStreamTo(InputStream in, String saveTo);
}
