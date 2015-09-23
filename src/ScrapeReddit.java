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
		
		for(int i = 0; i < 1;i+=2){
			
			Element link = links.eq(i).first();
			
			Elements attributes = link.children();
			
			Element karma = attributes.eq(2).first();
			
			Elements votes = karma.children();
			
			String upvotes = votes.eq(2).first().text();
			
			int upvotesInt = Integer.parseInt(upvotes);
			
			Element info = attributes.eq(4).first();
			
			Elements infoArray = info.children();
			
			Element lowestLevel = infoArray.eq(0).first();
			
			Element subrOne = infoArray.eq(1).first();
			
			Elements subrA = subrOne.getElementsByTag("a");
			
			String subreddit = subrA.last().text();
			
			Elements a = lowestLevel.getElementsByTag("a");
			
			Element lowerestLevel = a.eq(0).first();
			
			String finalLink = a.attr("href");
			
			String finalTitle = lowerestLevel.text();
			
			System.out.println(subreddit);
			
		}
		
	}
	
}
