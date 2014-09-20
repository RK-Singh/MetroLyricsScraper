package scrapper;

import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Class for parsing a metrolyrics page and scraping the lyrics form it
 * 
 * @author RK Sanayaima Singh
 *
 */
public class MetroLyricsScrapper {
	private String lyrics = "";
	Document doc;

	/**
	 * function toinvoke parsing of the url passed
	 * 
	 * @param url
	 */

	public void parseUrL(URL url) {
		try {
			doc = Jsoup.parse(url, 3000);
		} catch (IOException e) {
			// no internet access
			JOptionPane.showMessageDialog(null, "No internet access!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * scraps and returns the lyrics from metrolyrics page
	 * 
	 * @return
	 */
	public String scrapLyrics() {

		lyrics = "";
		Elements link = doc.getElementsByClass("verse");
		for (Element e : link) {
			String txt = e.html().replace("<br />", "\n").trim()
					.replace("\n ", "\n");
			lyrics += txt + "\n\n";
		}

		return lyrics;
	}

}
