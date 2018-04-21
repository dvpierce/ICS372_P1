package ics372.metrostate.edu.proj3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
	
	private static final long serialVersionUID = 8968341436485461953L;
	private List<Patient> patients = new ArrayList<Patient>();
	private List<Reading> readings = new ArrayList<Reading>();
	private List <Clinic> clinics = new ArrayList<Clinic>();
	private static Database instance = null;
	
	public Database() {}
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}	
		return instance;
	}
	
	public List<Patient> getPatients() { return patients; }
	public List<Reading> getReadings() { return readings; }
	public List<Clinic> getClinics() { return clinics; }
	
	public void setPatients(List<Patient> newPatients) { patients = newPatients; }
	public void setReadings(List<Reading> newReadings) { readings = newReadings; }
	public void setClinics(List<Clinic> newClinics) { clinics = newClinics; }
	
}