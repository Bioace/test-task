package filesavers;

import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlFileSaver implements FileSaver {
    @Override
    public void saveFileTo(Document file, String saveTo) {

        String filename = saveTo +".html";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(file.outerHtml());
        } catch (IOException e) {
            System.out.println("Проверьте корректность пути файла.");
            System.exit(1);
        }

    }
}
