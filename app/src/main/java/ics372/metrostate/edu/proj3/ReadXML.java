package ics372.metrostate.edu.proj3;
// used to read xml file passes to the software
import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReadXML {

	private ReadXML()
	{
		return;
	}
	
	public static Boolean read(String filePath, Context cont)
	{

        Document doc;
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            Toast.makeText(cont, "Error - Invalid XML", Toast.LENGTH_SHORT).show();
            return false;
        }
		return LoaderXML.load(doc, cont);
	}
	
}
