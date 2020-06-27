package downloaders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlFileDownloader implements FileDownloader {
    @Override
    public Document fileDownload(String from) {
        Document document = null;
        try {
            document = Jsoup.connect(from).get();
        } catch (IOException e) {
            System.out.println("Возникла ошибка, проверьте правильность URL");
            System.exit(1);
        }
        return document;
    }
    public InputStream getInputStreamFromURL(String from){
        InputStream in = null;
        try {
            String USER_AGENT = "Mozilla/5.0";
            URL myUrl = new URL(from);
            HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Keep-Alive", "header");
            con.setRequestProperty("charset", "utf-8");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setConnectTimeout(60000);
            in = con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    @Override
    public InputStream getInputStreamFromFile(String from) {
        InputStream is = null;
        try {
            is = new FileInputStream(from);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }
}
