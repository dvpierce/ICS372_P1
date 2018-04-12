package ics372.metrostate.edu.proj3;
import java.io.Serializable;

public class Patient implements Serializable {

	//Create an enum to Identify what state a particular patient is.
	enum States {
		ACTIVE, WITHDRAWN,FAILED, COMPLETED;
	}

	private static final long serialVersionUID = 4270476584826611310L;
	private String patient_id;
	private States patient_status;

	public Patient(String patient_id, States patient_status) {
		this.patient_id = patient_id;
		this.patient_status = patient_status;

	}

	public void setPatient_status(States patient_status) {
		this.patient_status = patient_status;
	}
	public void setPatient_id(String patient_id) { this.patient_id = patient_id; }

	public String getPatient_id() { return patient_id; }

	public States getPatient_status() {
		return patient_status;
	}

	public String toString() {
		return "Patient [patient_id = " + patient_id + ", patient_status = " + patient_status + "]";
	}

}
