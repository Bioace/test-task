import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlFileSaver implements FileSaver {
    @Override
    public void SaveFileTo(Object file, String saveTo) {
        Document document = (Document) file;

        String filename = saveTo +".html";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(document.outerHtml());
        } catch (IOException e) {
            System.out.println(filename);
            System.out.println("Проверьте корректность пути файла.");
            System.exit(1);
        }

    }
}
