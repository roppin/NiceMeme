import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class GenerateHTML {

	public static void generateHTML()
	{
		String content = "<html>"
				+"<header>"	
				+"  <title> NiceMeme </title>"
				+"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				+"</header>"
				+"<body>"
				+"	<h1>Ok sir yes sir.</h1>"	
				+"</body>"
				+"</html>";
		
		try {
			PrintWriter out = new PrintWriter("index.html");
			out.print(content);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
