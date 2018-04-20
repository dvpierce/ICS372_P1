package ics372.metrostate.edu.proj3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.JSONException;

import com.google.gson.*;
// import com.google.gson.JsonSyntaxException;

import android.support.v4.content.*;
import android.support.v4.app.*;
import android.Manifest;
import android.content.pm.PackageManager;

import ics372.metrostate.edu.proj3.*;

public class FileReader {

	private FileReader() {
		return;
	}

	public static void read(String filePath) throws JsonIOException, JsonSyntaxException, IOException, JSONException
	{
	    /** MainActivity passes path to a file, either XML or JSON.
	     *
         * Read the file in using the correct Reader.
         *
	     */

		if (filePath.toLowerCase().endsWith("xml"))
		{
			ReadXML.read(filePath);
			return;
		} else if (filePath.toLowerCase().endsWith("json"))
		{
			ReadJSON.read(filePath);
			return;
		} else {
			System.out.println("File type could not be determined: please select a valid JSON file ending in \".json\", or a valid XML file ending in \".xml\".");
		}
		return;
	}
	
	public static Object deserialize() throws ClassNotFoundException, IOException
	{
        FileInputStream fis = new FileInputStream("state.ser");
        ObjectInputStream oin = new ObjectInputStream(fis);
         
        Object thisTrial = oin.readObject();
         
        fis.close();
        oin.close();
        
        return thisTrial;
	}
	
}
