import counters.HtmlUniqueWordsCounter;
import downloaders.FileDownloader;
import downloaders.HtmlFileDownloader;
import filesavers.FileSaver;
import filesavers.HtmlFileSaver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import splitters.HtmlWordSplitter;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        HtmlUniqueWordsHandler handler = new HtmlUniqueWordsHandler(new HtmlFileDownloader(),
                new HtmlFileSaver(),
                new HtmlUniqueWordsCounter(new HtmlWordSplitter()));
       // handler.saveAndCount("https://pikabu.ru/", "pikabu");

        FileSaver saver = new HtmlFileSaver();
        FileDownloader downloader = new HtmlFileDownloader();
        InputStream in =  downloader.getInputStreamFromURL("https://pikabu.ru/");
        //parse(in);
     //   String fileName
        saver.saveFromStreamTo(in,"pikabu2");
        in = downloader.getInputStreamFromFile("pikabu2.html");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(in));

           // reader = new BufferedReader(new InputStreamReader(in,"cp1251"));
            String charset = "";
            while (reader.ready()&&charset.equals("")){
                String string = reader.readLine();
                    charset = Jsoup.parse(string).getElementsByAttribute("charset").attr("charset");
                if (charset.equals("windows-1251")){
                    reader = new BufferedReader(new InputStreamReader(in,"cp1251"));
                }
            }
            while (reader.ready()){
                String line = reader.readLine();
                String str = Jsoup.parse(line).text();
                if (!str.equals(""))
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


       // parse(in);
    }
    public static void parse (InputStream in){


    }
}
