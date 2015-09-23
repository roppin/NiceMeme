import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeReddit {
	
	static String url = "https://www.reddit.com/";

	
	public static void scrape(){
		
	Document doc = null;
	  try {
	   doc = Jsoup.connect(url).get();
	  } catch (IOException e) {
	   System.out.println("could not connect to site.");
	  }
		String title = doc.title();
		
		Elements body = doc.getElementsByTag("body");
		
		Elements content = body.eq(0).first().getElementsByClass("content");
		
		Element siteTable = content.eq(0).first().getElementById("siteTable");
		
		Elements links = siteTable.children();
		
		for(int i = 0; i < links.size()-1;i+=2){
			
			Element link = links.eq(i).first();
			
			Elements attributes = link.children();
			
			Element karma = attributes.eq(2).first();
			
			Elements votes = karma.children();
			
			String upvotes = votes.eq(2).first().text();
			
			System.out.println(Integer.parseInt(upvotes));
			
		}
		
	}
	
}
