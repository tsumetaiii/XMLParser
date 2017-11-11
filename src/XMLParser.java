import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class XMLParser {
	File xmlFile;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	//number of statistics as variables
	public int stats1;
	public int stats2;
	public int stats3;
	
	public void parseXml(String path) throws ParserConfigurationException, SAXException, IOException{
		try{
		//parse xml or txt file here
		xmlFile = new File(path);
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("stats");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				stats1=Integer.parseInt(eElement.getElementsByTagName("stats1").item(0).getTextContent());
				stats2=Integer.parseInt(eElement.getElementsByTagName("stats2").item(0).getTextContent());
				stats3=Integer.parseInt(eElement.getElementsByTagName("stats3").item(0).getTextContent());
			}	
		}
		}
		catch(ParserConfigurationException e){
			System.out.println("Error");
		}
		catch(SAXException e){
			System.out.println("Error");
		}
		catch(IOException e){
			System.out.println("Error");
		}
	}
}
