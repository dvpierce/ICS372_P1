package ics372.metrostate.edu.proj3;

import android.content.Context;

import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

	private FileWriter() {
		assert true;
	}

	public static Boolean write(String fileName)
	{
		return WriteJSON.write(fileName);
	}
	
	public static Boolean serialize(String filePath)
	{
        try {
            // Get path to internal storage.

			//Save Database to File.
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(Database.getInstance());
			oos.close();
			fos.close();
			System.out.println("Persistence success!");
			return true;
		} catch (Exception e) {
            System.out.println("Error while serializing.");
            e.printStackTrace();
            return false;
        }
	}

    public static void serializeNow(Context cont) {
        File localStoragePath = cont.getFilesDir();
        String LCSFile = localStoragePath.getAbsolutePath().toString() + "/state.ser";
        System.out.println("Serializing to: " + LCSFile);
        FileWriter.serialize(LCSFile);
    }

    public static void deserializeNow(Context cont) {
        File localStoragePath = cont.getFilesDir();
        String LCSFile = localStoragePath.getAbsolutePath().toString() + "/state.ser";
        System.out.println("Loading state from: " + LCSFile);
        FileReader.deserialize(LCSFile);

    }
}
