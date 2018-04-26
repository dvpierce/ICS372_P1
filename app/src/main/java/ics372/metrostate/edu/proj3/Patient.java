package ics372.metrostate.edu.proj3;
import java.io.Serializable;
// Class used to get patient
// Implements serialization to restore original state
public class Patient implements Serializable {

	private static final long serialVersionUID = 4270476584826611310L;
	private String patient_id;
	private PatientState status;
	private String clinic_id;

	public Patient(String patient_id, PatientState status, String clinic_id) {
		this.patient_id = patient_id;
		this.status = status;
		this.clinic_id = clinic_id;
	}

	public PatientState getPatientStatus() { return status; }
	public String getPatient_id() { return patient_id; }
	public String getClinic_id() { return clinic_id; }

	public void setPatient_id(String patient_id) { this.patient_id = patient_id; }
	public void setPatient_status(PatientState status) { this.status = status; }
	public void setClinic_id(String clinic_id) { this.clinic_id = clinic_id; }

	public String toString() {
        return "Patient [patient_id = " + patient_id + ", patient_status = " + status + "]";
    }

}





