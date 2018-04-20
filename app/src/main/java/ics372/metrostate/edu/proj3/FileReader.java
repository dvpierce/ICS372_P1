package ics372.metrostate.edu.proj3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.JSONException;

import com.google.gson.*;
// import com.google.gson.JsonSyntaxException;

import ics372.metrostate.edu.proj3.*;

public class FileReader {

	private FileReader() {
		return;
	}

	public static JsonObject read(String fileName) throws JsonIOException, JsonSyntaxException, IOException, JSONException
	{
		if (fileName.toLowerCase().endsWith("xml"))
		{
			return ReadXML.read(fileName);
		} else if (fileName.toLowerCase().endsWith("json"))
		{
			return ReadJSON.read(fileName);
		} else {
			System.out.println("File type could not be determined: please select a valid JSON file ending in \".json\", or a valid XML file ending in \".xml\".");
		}
		return null;
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
