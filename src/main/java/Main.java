import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
      HtmlUniqueWordsHandler handler = new HtmlUniqueWordsHandler();
      handler.saveAndCount("https://pikabu.ru/","pikabu");
    }
}
