import counters.HtmlUniqueWordsCounter;
import downloaders.HtmlFileDownloader;
import filesavers.HtmlFileSaver;
import splitters.HtmlWordSplitter;



public class Main {

    public static void main(String[] args) {
      HtmlUniqueWordsHandler handler = new HtmlUniqueWordsHandler(new HtmlFileDownloader(),
              new HtmlFileSaver(),
              new HtmlUniqueWordsCounter(new HtmlWordSplitter()));
      handler.saveAndCount("https://pikabu.ru/","pikabu");
    }
}
