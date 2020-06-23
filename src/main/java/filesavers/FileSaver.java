package filesavers;

import org.jsoup.nodes.Document;

public interface FileSaver {
    void saveFileTo(Document file, String saveTo);
}
