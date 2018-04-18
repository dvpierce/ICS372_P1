package ics372.metrostate.edu.proj3;

import org.junit.Test;

public class PatientTest {

	@Test
	public void test() {
		//test patient class constructor
		Patient newPatient = new Patient("231",true);
			
		// test getPatient_id
		String getpatient = newPatient.getPatient_id();
		
		// test setPatient_id
		newPatient.setPatient_id("3455");
		
		// test isPatientActive
		boolean isActive = newPatient.isPatient_active();
		
		// test setPatientActive
		newPatient.setPatient_active(true);
		
		//test the toString method for the patient class.
		String Patient_toString = newPatient.toString(); 
	}

}
