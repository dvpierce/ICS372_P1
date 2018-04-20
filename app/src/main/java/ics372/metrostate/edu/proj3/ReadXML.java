package ics372.metrostate.edu.proj3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.XML;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadXML {

	private ReadXML()
	{
		return;
	}
	
	public static void read(String filePath) throws IOException, JSONException
	{		
		String line;
		String str = "";
	    BufferedReader br = new BufferedReader(new FileReader(filePath));
	    while ((line = br.readLine()) != null) 
	    {   
	        str+=line;  
	    }
	    br.close();

	    JSONObject TheObject = XML.toJSONObject(str);
		JsonObject jo = new JsonParser().parse(TheObject.toString()).getAsJsonObject();


		JSONLoader.load(jo);
	}
	
}
