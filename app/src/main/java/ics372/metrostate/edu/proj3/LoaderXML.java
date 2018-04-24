package ics372.metrostate.edu.proj3;

//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.parsers.DocumentBuilder;
import android.content.Context;
import android.widget.Toast;

import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.Date;


public class LoaderXML {

    private LoaderXML() { return; }

    public static Boolean load(Document doc, Context cont) {

        // Navigate the XML tree and load it into the Trial,
        // assuming it's formatted like we expect, anyway.

        ReadingBuilder builder = new ReadingBuilder();

        // Find the Clinic ID and Clinic Name
        String ClinicID = "";
        String ClinicName = "";
        try {
            Element e = (Element) doc.getDocumentElement().getElementsByTagName("Clinic").item(0);
            ClinicID = e.getAttribute("id");
            ClinicName = e.getTextContent();
        } catch ( NullPointerException e ) {
            System.out.println("This XML file is missing Clinic information.");
            Toast.makeText(cont, "Missing Clinic Information!", Toast.LENGTH_SHORT).show();
            return false;
        }
        builder.setReading_clinic(ClinicID);

        // Check to see if this clinic exists and create it, if it does not:
        if ( DBQuery.clinicExists(ClinicID) ) {
            // do nothing
            assert true;
        } else {
            // Create/add the clinic.
            Clinic clinicToAdd = new Clinic(ClinicID);
            Database.getInstance().addClinic(clinicToAdd);
        }

        // Find (filter out) the Readings.
        NodeList nList = doc.getElementsByTagName("Reading");

        // Do a simple check and see if there are readings to import.
        // If there aren't, we're done.
        if (nList.getLength() == 0) {
            Toast.makeText(cont, "File contains no readings!", Toast.LENGTH_SHORT).show();
            System.out.println("There were no readings in this file.");
            return false;
        }

        int ReadingsFound = 0;
        for ( int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            Element valueElement = (Element) eElement.getElementsByTagName("Value").item(0);

            builder.setReading_id(eElement.getAttribute("id"));
            builder.setReading_type(eElement.getAttribute("type"));
            builder.setReading_value(eElement.getElementsByTagName("Value").item(0).getTextContent());
            String tempPatientID = eElement.getElementsByTagName("Patient").item(0).getTextContent();
            builder.setPatient_id(tempPatientID);

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
                Database.getInstance().getPatients().add(new Patient(tempPatientID, PatientState.ACTIVE, ClinicID));
            }

            Reading tempReading = builder.build();
            if ( tempReading != null ) {
                Database.getInstance().addReading(tempReading);
                ReadingsFound++;
            } else {
                continue;
            }
        }
        Toast.makeText(cont, String.format("Loaded %d readings.", ReadingsFound), Toast.LENGTH_SHORT).show();
        System.out.println(String.format("Found %d readings.", ReadingsFound));
        return true;
    }


}
