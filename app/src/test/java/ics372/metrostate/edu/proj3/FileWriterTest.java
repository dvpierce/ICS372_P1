package ics372.metrostate.edu.proj3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.nio.file.FileAlreadyExistsException;

import org.junit.Assert;
import org.junit.Test;
import org.json.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ics372.metrostate.edu.proj3.*;

public class FileWriterTest {

	// test the write method
	@Test
	public void test1() {

        String fileName = "tempFile.txt";
        JsonArray ja = new JsonArray();

        ja.add("patient_id");
        ja.add("reading_type");
        ja.add("reading_value");

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(ja.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(fileName.isEmpty());

        }
		// test serialize method
		@Test
		public void test2() throws IOException {
			Object obj = new Object();
			String serlizeName = "test.ser";
			FileOutputStream fout = new FileOutputStream(serlizeName);
			ObjectOutputStream obos = new ObjectOutputStream(fout);

			Assert.assertNotNull(obj);
            Assert.assertTrue(obos.equals(obj));
		}
}
