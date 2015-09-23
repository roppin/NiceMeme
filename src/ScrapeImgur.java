import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeImgur {

	static String url = "https://www.imgur.com/";

	public static void main(String args[]){
		scrape();

	}
	
	public static void scrape(){
		
	Document doc = null;
	  try {
	   doc = Jsoup.connect(url).get();
	  } catch (IOException e) {
	   System.out.println("could not connect to site.");
	  }

		Elements cards = doc.getElementsByClass("cards").first().children();
		
		for(Element card : cards)
		{
			String image = card.getElementsByTag("img").first().attr("src");
			System.out.println(image);
			
			String points = card.getElementsByClass("point-info-points").first().children().first().text();
			System.out.println(points);
			
			String name = card.getElementsByClass("hover").first().getElementsByTag("p").first().text();
			System.out.println(name);
		}

	}
	
}
