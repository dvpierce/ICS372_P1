package ics372.metrostate.edu.proj3;
import java.io.FileWriter;
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

            // Is external storage available?
            String state = Environment.getExternalStorageState();

            // External storage is available:
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                JsonArray ja = new JsonArray();
                JsonObject jo = new JsonObject();
                Gson gson = new Gson();

                jo.add("patient_readings", gson.toJsonTree(Database.getInstance().getReadings()));
                ja.add(jo);

                String JSONOutput = ja.toString();

                // Create a new JSON file from the string of JSON object
                try {
                    FileWriter writer = new FileWriter(filePath);
                    writer.write(JSONOutput);
                    writer.close();
                    return true;
                } catch(Exception e) {
                    e.printStackTrace();
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
