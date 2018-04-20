package ics372.metrostate.edu.proj3;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class LoaderJSON {

    private LoaderJSON()
    {
        return;
    }


    public static Boolean load(JsonObject jo) {

        // Navigate the JSON tree and load Readings into the Trial,
        // assuming it's formatted like we expect, anyway.

        ReadingBuilder builder = new ReadingBuilder();

//        Need to call the following:
//        builder.setReading_clinic();
//        builder.setPatient_id();
//        builder.setReading_id();
//        builder.setReading_type();
//        builder.setReading_value();
//        builder.setReading_date();

        JsonArray ja;
        try {
            ja = jo.get("patient_readings").getAsJsonArray();
            for(Object o : ja) {
                try {
                    JsonObject reading = (JsonObject) o;
                    // extract data from each reading
                    builder.setReading_clinic(reading.get("reading_clinic").getAsString());
                    builder.setPatient_id(reading.get("patient_id").getAsString());
                    builder.setReading_id(reading.get("reading_id").getAsString());
                    builder.setReading_type(reading.get("reading_type").getAsString());
                    builder.setReading_value(reading.get("reading_value").getAsString());
                    builder.setReading_date(reading.get("reading_date").getAsLong());

                    Reading tempReading = builder.build();
                    if ( tempReading != null ) {
                        // Domain.AddReading(tempReading);

                    } else {

                    }

                } catch (NullPointerException f) {
                    System.out.println("An error occured: json missing data");
                    System.out.println(o.toString());
                    continue;
                } catch (Exception e) {
                    System.out.println("Some other error occurred.");
                    continue;
                }
            }
            return true;
        } catch (Exception e) {
            // Well, okay, so if we get here, there was no patient_readings key.
            // That probably means we got an XML file in the other file format.
            System.out.println("Formatting of this is not consistent with JSON file format. Proceeding in XML import mode.");
            return false;
        }
    }
}
