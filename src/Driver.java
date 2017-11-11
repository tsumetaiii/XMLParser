import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Driver {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException{
		XMLParser parser=new XMLParser();
		parser.parseXml("stats.xml");
		System.out.println(parser.stats1);
		System.out.println(parser.stats2);
		System.out.println(parser.stats3);
	}
}
