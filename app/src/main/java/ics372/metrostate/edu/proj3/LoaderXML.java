package ics372.metrostate.edu.proj3;

//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.Date;


public class LoaderXML {

    private LoaderXML() { return; }

    public static Boolean load(Document doc) {

        // Navigate the XML tree and load it into the Trial,
        // assuming it's formatted like we expect, anyway.

        // Find the Clinic ID and Clinic Name
        String ClinicID = "";
        String ClinicName = "";
        try {
            Element e = (Element) doc.getDocumentElement().getElementsByTagName("Clinic").item(0);
            ClinicID = e.getAttribute("id");
            ClinicName = e.getTextContent();
        } catch ( NullPointerException e ) {
            System.out.println("This XML file is missing Clinic information.");
            return false;
        }

        // Find (filter out) the Readings.
        NodeList nList = doc.getElementsByTagName("Reading");

        // Do a simple check and see if there are readings to import.
        // If there aren't, we're done.
        if (nList.getLength() == 0) {
            System.out.println("There were no readings in this file.");
            return false;
        }

        ReadingBuilder builder = new ReadingBuilder();
        

        int ReadingsFound = 0;
        for ( int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(ReadingsFound);



            ReadingsFound++;
        }
        System.out.println(String.format("Found %d readings.", ReadingsFound));
        return true;
    }


}
