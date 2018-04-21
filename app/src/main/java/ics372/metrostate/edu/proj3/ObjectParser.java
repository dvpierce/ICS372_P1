/***
 * Commenting out the code until other classes are complete
 */
//package ics372.metrostate.edu.proj3;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
//public class ObjectParser {
//
//    public String loadFile(String filePath) {
//        int divisor = 1000;
//        Date now = new Date();
//        Long currentTime = new Long(now.getTime()/divisor);
//        try {
//            JsonObject jo = (JsonObject) FileReader.read(filePath);
//
//            // We've read in a JsonObject from the file. See if it contains
//            // a patient_readings array. If it does, import the readings in that array.
//            JsonArray ja;
//            try {
//                ja = jo.get("patient_readings").getAsJsonArray();
//                for(Object o : ja) {
//                    try {
//                        JsonObject reading = (JsonObject) o;
//                        // extract data from each reading
//                        String patient_id = reading.get("patient_id").getAsString();
//                        String reading_type = reading.get("reading_type").getAsString();
//                        String reading_id = reading.get("reading_id").getAsString();
//                        String reading_value = reading.get("reading_value").getAsString();
//                        long reading_date = reading.get("reading_date").getAsLong();
//                        String reading_clinic = reading.get("reading_clinic").getAsString();
//
//                        // populate the java objects
//                        Database.getInstance().getReadings().add( new Reading(patient_id, reading_type, reading_id, reading_value, reading_date, reading_clinic) );
//                        Database.getInstance().getPatients().add( new Patient(patient_id, PatientState.ACTIVE) );
//                        Database.getInstance().getClinics().add( new Clinic(reading_clinic) );
//                    } catch (NullPointerException f) {
//                        System.out.println("An error occured: json missing data");
//                        System.out.println(o.toString());
//                        continue;
//                    } catch (Exception e) {
//                        System.out.println("Some other error occurred.");
//                        continue;
//                    }
//                }
//                return "File successfully loaded!";
//            } catch (Exception e) {
//                // Well, okay, so if we get here, there was no patient_readings key.
//                // That probably means we got an XML file in the other file format.
//                System.out.println("Formatting of this is not consistent with JSON file format. Proceeding in XML import mode.");
//            }
//            try {
//                JsonObject rs = jo.get("ReadingSet").getAsJsonObject();
//                String ClinicID = rs.get("Clinic").getAsJsonObject().get("id").toString();
//                String ClinicName = rs.get("Clinic").getAsJsonObject().get("name").toString();
//                JsonArray ra = rs.get("Reading").getAsJsonArray();
//                for (Object o : ra)
//                {
//
//                    JsonObject reading = (JsonObject) o;
//                    String patient_id = reading.get("Patient").getAsString();
//
//                    String reading_type = reading.get("type").getAsString();
//
//                    String reading_id = reading.get("id").getAsString();
//
//                    Long reading_date = currentTime;
//
//                    String reading_clinic = ClinicID;
//
//                    // Now we have to extract the Value, which may just be a Value, or
//                    // it may be the "content" field in the "value". Fail Through.
//                    String reading_value;
//                    try {
//                        reading_value = reading.get("Value").getAsJsonObject().get("content").getAsString();
//                    } catch (NullPointerException e) {
//                        reading_value = reading.get("Value").getAsString();
//                    } catch (IllegalStateException e) {
//                        reading_value = reading.get("Value").getAsString();
//                    }
////					System.out.println(reading_value);
//
//                    // populate the java objects
//                    Trial.getInstance().getReadings().add( new Reading(patient_id, reading_type, reading_id, reading_value, reading_date, reading_clinic) );
//                    Trial.getInstance().getPatients().add( new Patient(patient_id, PatientState.ACTIVE) );
//                    Trial.getInstance().getClinics().add( new Clinic(reading_clinic) );
//
//                }
//
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//
//            return "Hello World.";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "File could not be loaded!";
//        }
//    }
//
//    public String loadData() {
//        try {
//            Trial trial = (Trial) FileReader.deserialize();
//            Trial.getInstance().setClinics(trial.getClinics());
//            Trial.getInstance().setPatients(trial.getPatients());
//            Trial.getInstance().setReadings(trial.getReadings());
//            return "Data loaded!";
//        } catch (ClassNotFoundException e) {
//        } catch (IOException e) {
//            return "No data to load";
//        }
//        return "";
//    }
//
//
//    public String saveFile(String filePath) {
//        List<Reading> readings = Trial.getInstance().getReadings();
//
//        JsonArray ja = new JsonArray();
//        JsonObject jo = new JsonObject();
//        Gson gson = new Gson();
//
//        jo.add("patient_readings", gson.toJsonTree(readings));
//        ja.add(jo);
//        return FileWriter.write(ja, filePath);
//    }
//
//    public String saveData() {
//        try {
//            return FileWriter.serialize( Trial.getInstance() );
//        } catch (IOException e) {
//            return "Data could not be saved!";
//        }
//    }
//}
