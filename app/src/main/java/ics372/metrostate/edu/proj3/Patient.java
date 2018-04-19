package ics372.metrostate.edu.proj3;
import java.io.Serializable;

public class Patient implements Serializable {

	private static final long serialVersionUID = 4270476584826611310L;
	private String patient_id;
	private boolean patient_active;

	public Patient(String patient_id,  boolean patient_active) {
		this.patient_id = patient_id;

		this.patient_active = patient_active;
	}
	public boolean isPatient_active() { return patient_active; }


	public void setPatient_active(boolean patient_active) {
		this.patient_active = patient_active;
	}

	public void setPatient_id(String patient_id) { this.patient_id = patient_id; }

	public String getPatient_id() { return patient_id; }



	public String toString() {
		return "Patient [patient_id = " + patient_id + ", patient_status = " + patient_active + "]";
	}

		}





