package NaveenClass;

public class AmazonTest {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		br.initDriver("chrome");
		br.launchUrl("http://Amazon.com");
		String title=br.getTitle();
		System.out.println(title);
		
		System.out.println(br.getPageUrl());

		br.quitBrowser();
	}

}
