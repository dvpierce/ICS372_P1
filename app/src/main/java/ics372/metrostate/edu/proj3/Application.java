package ics372.metrostate.edu.proj3;
import java.util.List;

public class Application {
// This method prints out the readings. This is a string of the reading
	public String printReadings() {
		List<Reading> readings = Trial.getInstance().getReadings();
		String text = "";
		for(Reading r : readings) {
			text += (r.toString() + "\n");
		}
		return text;
	}


	public String beginStudy(String patient_id) {
		// If the patient exists on record then set the patient to active
		// else patient does not exist then add the patient and set to active
		List<Patient> patients = Trial.getInstance().getPatients();
		for(Patient patient : patients) {
			if(patient.getPatient_id().equals(patient_id))
			{
				patient.setPatient_status(Patient.States.ACTIVE);
				return "Patient " + patient_id + " has been activated!";
			}
		}
		patients.add( new Patient(patient_id, Patient.States.ACTIVE) );
		return "Patient " + patient_id + " has been added and has been activated!";
	}

	public String endStudy(String patient_id) {
		// If the patient exists on record
		// then set the patient to inactive
		List<Patient> patients = Trial.getInstance().getPatients();
		for (Patient patient : patients) {
			if (patient.getPatient_id().equals(patient_id)) {
				patient.setPatient_status(Patient.States.WITHDRAWN);
				return "Patient " + patient_id + " has withdrawn from the Trial";
			}
			if (patient.getPatient_id().equals(patient_id)) {
				patient.setPatient_status(Patient.States.FAILED);
				return "Patient " + patient_id + " has failed the Trial";
			}
			if (patient.getPatient_id().equals(patient_id)) {
				patient.setPatient_status(Patient.States.COMPLETED);
				return "Patient " + patient_id + " has completed the Trial";
			}
		}
		return "Patient " + patient_id + " could not be found!";
	}
	
	public String addReading(String patient_id, String reading_type, String reading_id, String reading_value, long reading_date, String reading_clinic) {
		// If the patient exists on record and is set active
		// then add the reading to that patient
		List<Patient> patients = Trial.getInstance().getPatients();
		List<Reading> readings = Trial.getInstance().getReadings();
		for(Patient p : patients) {
			if(p.getPatient_id().equals(patient_id)) {
				readings.add(new Reading(patient_id, reading_type, reading_id, reading_value, reading_date, reading_clinic));
				return "New reading has been added to patient " + patient_id + "at the clinic " + reading_clinic +".";
			}
		}
		return "Reading could not be added: patient " + patient_id + " is not on record or is inactive. Please add the patient " + patient_id + " first!";
	}
	
	public String addClinic(String clinicID) {
		List<Clinic> clinics = Trial.getInstance().getClinics();
		
				clinics.add(new Clinic(clinicID));
				return "New clinic has been added ";
			}
		
	
	public String addPatient(String patient_id ) {
		List<Patient> patients = Trial.getInstance().getPatients();
		patients.add(new Patient(patient_id, Patient.States.ACTIVE));
		return "Patient has been added";
	}
}