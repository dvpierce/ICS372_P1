package ics372.metrostate.edu.proj3;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;


public class DatabaseTest /*extends TestCase*/{

    private List<Patient> patients = new ArrayList<Patient>();
    private List<Reading> readings = new ArrayList<Reading>();
    private List <Clinic> clinics = new ArrayList<Clinic>();
    private static Database instance = null;

	@Test
	public void test() {
        //super(Trial.class);


        Database database = new Database();

        Patient pt1 = new Patient("1001", PatientState.ACTIVE);
        Patient pt2 = new Patient("1002", PatientState.FAILED);
        patients.add(pt1);
        patients.add(pt2);

        Reading rd1 = new Reading("1001", "temp", "T01", "110/70", 10 / 10 / 2017,
                "Fairview");
        Reading rd2 = new Reading("1002", "Weight", "W01", "180", 03 / 05 / 2017,
                "Clinic1");
        readings.add(rd1);
        readings.add(rd2);

        Clinic cl1 = new Clinic("FV01");
        Clinic cl2 = new Clinic("Dl2");
        //Clinic cl3 = new Clinic("MV3");
        clinics.add(cl1);
        clinics.add(cl2);



        database.getInstance();
        TestCase.assertEquals(null, instance);

        //test for getPatients() method
        database.getPatients();
        TestCase.assertEquals(patients.size(),2);
        TestCase.assertEquals(patients.get(1),pt2);

        //test for getReadings() method
        database.getReadings();
        TestCase.assertEquals(readings.size(),2);
        TestCase.assertEquals(readings.get(0),rd1);


        //test for getClinics() method
        database.getClinics();
        TestCase.assertEquals(clinics.size(),2);
        TestCase.assertEquals(clinics.get(1),cl2);

        //test for setClinic
        List<Clinic> newClinic = new ArrayList<Clinic>();
        Clinic cl3 = new Clinic("MV3");
        Clinic cl4 = new Clinic("PV3");
        newClinic.add(cl3);
        newClinic.add(cl4);
        database.setClinics(newClinic);
        TestCase.assertEquals(newClinic.size(),2);
        TestCase.assertEquals(newClinic.get(1),cl4);


        //test for setPatient() method
        List<Patient> newPatient = new ArrayList<Patient>();
        Patient pt3 = new Patient("0011", PatientState.ACTIVE);
        newPatient.add(pt3);
        database.setPatients(newPatient);
        TestCase.assertEquals(newPatient.size(),1);


        //test for setReading() method
        List<Reading> newReading = new ArrayList<Reading>();
        Reading rd3 = new Reading("0011","temp","T04","120/80",11/11/2017,"FV");
        newReading.add(rd3);
        database.setReadings(newReading);
        TestCase.assertEquals(newReading.get(0),rd3);









	}

}
