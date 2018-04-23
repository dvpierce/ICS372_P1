package ics372.metrostate.edu.proj3;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.PrintWriter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import android.os.Environment;
import java.util.List;

public class WriteJSON {

	private WriteJSON()
	{
		return;
	}
	
	public static Boolean write(String filePath) {

	    try {
            // Find readings list to write to disk:
            List<Reading> readings = Database.getInstance().getReadings();

            System.out.println(readings.size());

            // Is external storage available?
            String state = Environment.getExternalStorageState();

            // External storage is available:
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                JsonObject jo = new JsonObject();
                Gson gson = new Gson();


                jo.add("patient_readings", gson.toJsonTree(readings) );

                String JSONOutput = jo.toString();
                System.out.println(JSONOutput);

                // If filePath doesn't end with .json, append it.
                if ( ! filePath.endsWith(".json") ) {
                    filePath = filePath + ".json";
                }


                filePath = Environment.getExternalStorageDirectory()+"/Download/"+filePath;
                // filePath = "/sdcard/Download/"+filePath;
                // Create a new JSON file from the string of JSON object
                try {
                    System.out.println("Attempting to write: " + filePath);
                    File outputFile = new File(filePath);
                    FileWriter writer = new FileWriter(outputFile, true);
                    writer.write(JSONOutput);

                    writer.close();
                    return true;
                } catch(Exception e) {
                    System.out.println("File output error.");
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    System.out.println(sw.toString());
                    return false;
                }
            }
            else
            {
                System.out.println("Permissions error");
                return false;
            }
        } catch (Exception e) {
	        e.printStackTrace();
	        return false;
        }
	}
	
}
