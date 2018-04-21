package ics372.metrostate.edu.proj3;

import com.google.gson.JsonArray;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

	private FileWriter() {
		return;
	}

	public static Boolean write(String fileName)
	{
		return WriteJSON.write(fileName);
	}
	
	public static Boolean serialize(Object e) throws IOException
	{
        //Saving of object in a file
        FileOutputStream fos = new FileOutputStream("state.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(e);
        oos.close();
        fos.close();
        return true;
	}
	
}
