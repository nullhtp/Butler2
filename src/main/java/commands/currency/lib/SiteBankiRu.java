package commands.currency.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by takito on 09.01.16.
 */
public  class  SiteBankiRu {

    public static String getCurrencyValue(String currency){
        Document document = null;
        try {
            document = Jsoup.connect("http://www.banki.ru/products/currency/cb/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByAttributeValue("data-currency-code",currency);
        Element element = elements.get(0);
        element = element.child(3);
        return element.text();
    }
}
