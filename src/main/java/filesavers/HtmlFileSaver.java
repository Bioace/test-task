package filesavers;

import org.apache.commons.io.IOUtils;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HtmlFileSaver implements FileSaver {
    @Override
    public void saveFileTo(Document file, String saveTo) {
        String filename = saveTo + ".html";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(file.outerHtml());
        } catch (IOException e) {
            System.out.println("Проверьте корректность пути файла.");
            System.exit(1);
        }
    }
    public void saveFromStreamTo(InputStream in, String saveTo){
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveTo + ".html"))) {
            in.transferTo(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
