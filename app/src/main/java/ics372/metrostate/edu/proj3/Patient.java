package ics372.metrostate.edu.proj3;
import java.io.Serializable;

public class Patient implements Serializable {

	private static final long serialVersionUID = 4270476584826611310L;
	private String patient_id;
	private PatientState status;

	public Patient(String patient_id, PatientState status) {
		this.patient_id = patient_id;
		this.status = status;
	}

	public PatientState getPatientStatus() { return status; }


	public void setPatient_id(String patient_id) { this.patient_id = patient_id; }

	public String getPatient_id() { return patient_id; }



	public String toString() {
        return "Patient [patient_id = " + patient_id + ", patient_status = " + status + "]";
    }

	public void setPatient_status(PatientState status) { this.status = status; }

}





