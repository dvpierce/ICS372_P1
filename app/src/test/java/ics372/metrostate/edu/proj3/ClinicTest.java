package ics372.metrostate.edu.proj3;

import ics372.metrostate.edu.proj3.*;
import junit.framework.TestCase;

public class ClinicTest extends TestCase {

	public void test() 
	{
//		@SuppressWarnings("unused")
		Clinic newClinic = new Clinic("4688");

		// test getClinicID method
		@SuppressWarnings("unused")
		String clinicID = newClinic.getClinicID();
		
		//test setClinicID method
		newClinic.setClinicID("Gjx5678");

		//test toString method
		String testToString = newClinic.toString();
	}

}