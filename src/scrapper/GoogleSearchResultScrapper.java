package scrapper;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Provides interface for searching google and scraping a link to metrolyrics
 * 
 * @author RK Sanayaima Singh
 *
 */
public class GoogleSearchResultScrapper {
	private String searchKeywords;
	private JRootPane rootPane = null;

	/**
	 * frame to display error massage
	 * 
	 * @param frame
	 */
	public void setCallingFrame(JFrame frame) {
		this.rootPane = frame.getRootPane();
	}

	/**
	 * set the search keywords
	 * 
	 * @param str
	 */
	public void setSearchKeywords(String str) {
		this.searchKeywords = "https://www.google.com/search?q="
				+ str.trim().replace(" ", "+") + "+metrolyrics";
	}

	/**
	 * returns the search string
	 * 
	 * @return searchKeywords
	 */
	public String getSearchKeywords() {
		return this.searchKeywords;
	}

	/**
	 * google search result parsing and scraping metrolyrics link address
	 * 
	 * @return metrolyrics link
	 */
	public String getLink() {

		Document doc;
		try {
			doc = Jsoup.connect(searchKeywords).userAgent("Mozilla")
					.ignoreHttpErrors(true).timeout(0).get();
			Element link = doc.select("cite:contains(metrolyrics)").first();

			// + "//li[class=g] a:contains(metrolyrics)")

			if (link != null) {
				String linkAddress = "http://" + link.text();
				return linkAddress;
			}

		} catch (IOException e) {
			// no internet access
			JOptionPane.showMessageDialog(rootPane, "No internet access!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return "";
	}
}
