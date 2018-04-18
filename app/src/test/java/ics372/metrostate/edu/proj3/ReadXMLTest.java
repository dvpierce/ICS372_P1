package ics372.metrostate.edu.proj3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import junit.framework.TestCase;

public class ReadXMLTest extends TestCase {
    //test read method
    @Test
    public void test() throws IOException, JSONException {

        String line;
        String str = "";
        String filePath = "test.txt";
        String expected = "This is a demo text that will be read from.";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null)
        {
           // str+=line;
        }
        br.close();

        JSONObject TheObject = XML.toJSONObject(str);
        JsonObject jo = new JsonParser().parse(TheObject.toString()).getAsJsonObject();

         String jString = jo.toString();
         Assert.assertNotNull(jo);
         Assert.assertFalse(jString.contentEquals(expected));
    }
    }


