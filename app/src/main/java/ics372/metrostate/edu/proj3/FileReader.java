package ics372.metrostate.edu.proj3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.JSONException;
import org.xml.sax.SAXException;

import com.google.gson.*;
// import com.google.gson.JsonSyntaxException;

import android.support.v4.content.*;
import android.support.v4.app.*;
import android.Manifest;
import android.content.pm.PackageManager;

import javax.xml.parsers.ParserConfigurationException;

import ics372.metrostate.edu.proj3.*;

public class FileReader {

	private FileReader() {
		return;
	}

	public static Boolean read(String filePath) {
		/** MainActivity passes path to a file, either XML or JSON.
		 *
		 * Read the file in using the correct Reader.
		 *
		 */

		System.out.println("Reading file: " + filePath);

		try {
			if (filePath.toLowerCase().endsWith("xml"))
			{
				return ReadXML.read(filePath);
			} else if (filePath.toLowerCase().endsWith("json"))
			{
				return ReadJSON.read(filePath);
			} else {
				System.out.println("File type could not be determined: please select a valid JSON file ending in \".json\", or a valid XML file ending in \".xml\".");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Object deserialize()
	{
	    try {
            FileInputStream fis = new FileInputStream("state.ser");
            ObjectInputStream oin = new ObjectInputStream(fis);

            Object thisTrial = oin.readObject();

            fis.close();
            oin.close();

            return thisTrial;
        } catch (Exception e) {
	        e.printStackTrace();
	        return null;
        }
	}
	
}
