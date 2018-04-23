package ics372.metrostate.edu.proj3;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJSON {

	private ReadJSON()
	{
		return;
	}
	
	public static Boolean read(String filePath) {
		// Parser parses the JSON file into a JSON tree
		JsonParser parser = new JsonParser();
		System.out.println("Loading file...");
        JsonElement jsontree;
        try {
		    jsontree = parser.parse(new FileReader(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

		// Convert the JSON tree to JSON object
		System.out.println("Converting tree to object.");
        JsonObject jo;
		try {
		    jo = jsontree.getAsJsonObject();
        } catch (Exception e) {
		    e.printStackTrace();
		    return false;
        }
        System.out.println(jo.toString());
        System.out.println("Calling LoaderJSON...");

		return LoaderJSON.load(jo);
	}
}
