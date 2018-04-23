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
                    String tempClinicID = reading.get("reading_clinic").getAsString();
                    builder.setReading_clinic(tempClinicID);
                    String tempPatientID = reading.get("patient_id").getAsString();
                    builder.setPatient_id( tempPatientID );
                    builder.setReading_id(reading.get("reading_id").getAsString());
                    builder.setReading_type(reading.get("reading_type").getAsString());
                    builder.setReading_value(reading.get("reading_value").getAsString());
                    builder.setReading_date(reading.get("reading_date").getAsLong());

                    // Check to see if this clinic exists and create it, if it does not:
                    if ( DBQuery.clinicExists(tempClinicID) ) {
                        // do nothing
                        assert true;
                    } else {
                        // Create/add the clinic.
                        Clinic clinicToAdd = new Clinic(tempClinicID);
                        Database.getInstance().addClinic(clinicToAdd);
                    }

                    // Verify that the patient for this reading exists.
                    // If it does not exist, add it.
                    // If it does exist, check whether patient is active or completed
                    // skip readings for non-Active/Completed patients.

                    if ( DBQuery.patientExists( tempPatientID ) ) {

                        // Patient exists:
                        if ( ( DBQuery.patientActive( tempPatientID ) ) ||
                                ( DBQuery.patientComplete( tempPatientID ) ) ) {
                            // Patient is active or complete. Do nothing.
                            assert true;
                        } else {
                            // Patient exists, but is in an invalid state.
                            // Do not add the reading.
                            continue;
                        }
                    } else {

                        // Patient does not exist:
                        // Create the patient and proceed.
                        System.out.println("Patient " + (String) tempPatientID + " does not exist. Adding.");
                        Database.getInstance().getPatients().add(new Patient(tempPatientID, PatientState.ACTIVE, tempClinicID));
                    }

                    Reading tempReading = builder.build();
                    if ( tempReading != null ) {
                        System.out.println("Adding reading.");
                        Database.getInstance().addReading(tempReading);

                    } else {
                        // do nothing.
                        assert true;
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
            System.out.println("Formatting of this is not consistent with JSON file format.");
            return false;
        }
    }
}
