package ics372.metrostate.edu.proj3;
import java.io.FileWriter;
import com.google.gson.JsonArray;
import android.os.Environment;

public class WriteJSON {

	private WriteJSON()
	{
		return;
	}
	
	public static String write(JsonArray JSONStructure, String filePath) {

	    /* determine location to save data. */


        // Is external storage available?
        String state = Environment.getExternalStorageState();

        // External storage is available:
        if (Environment.MEDIA_MOUNTED.equals(state)) {

        }


        // Create a new JSON file from the string of JSON object
		try {	
			FileWriter writer = new FileWriter(filePath);
			writer.write(JSONStructure.toString());
			writer.close();
			return "File successfully exported.";
		} catch(Exception e) {
			e.printStackTrace();
			return "File could not be exported.";
		}	
	}
	
}
