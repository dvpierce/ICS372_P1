package ics372.metrostate.edu.proj3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.JSONException;
import org.xml.sax.SAXException;

import com.google.gson.*;
// import com.google.gson.JsonSyntaxException;

import android.content.Context;
import android.support.v4.content.*;
import android.support.v4.app.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;

import javax.xml.parsers.ParserConfigurationException;

import ics372.metrostate.edu.proj3.*;

public class FileReader {

	private FileReader() {
		return;
	}

	public static Boolean read(String filePath, Context cont) {

		// MainActivity.getContext();

		/** MainActivity passes path to a file, either XML or JSON.
		 *
		 * Read the file in using the correct Reader.
		 *
		 */

		System.out.println("Reading file: " + filePath);

		try {
			if (filePath.toLowerCase().endsWith("xml"))
			{
				Boolean result = ReadXML.read(filePath, cont);
                return result;
			} else if (filePath.toLowerCase().endsWith("json"))
			{
				Boolean result = ReadJSON.read(filePath, cont);
                return result;
			} else {
				System.out.println("File type could not be determined: please select a valid JSON file ending in \".json\", or a valid XML file ending in \".xml\".");
                Toast.makeText(cont, "Could not determine file type!", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
            Toast.makeText(cont, "Could not open file!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean deserialize(String filePath)
	{
	    try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream oin = new ObjectInputStream(fis);

            Object thisDatabase = oin.readObject();

            fis.close();
            oin.close();

            Database.setSelf((Database) thisDatabase);

            return true;
        } catch (Exception e) {
	        e.printStackTrace();
	        return false;
        }
	}
	
}
