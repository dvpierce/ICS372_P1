
public class Reading {
	
	private String patient_id;
	private String reading_type;
	private String reading_id;
	private String reading_value;
	private long reading_date;
	private String reading_clinic;
	
	
	public Reading(String patient_id, String reading_type, String reading_id, String reading_value, long reading_date,
			String reading_clinic) {
		this.patient_id = patient_id;
		this.reading_type = reading_type;
		this.reading_id = reading_id;
		this.reading_value = reading_value;
		this.reading_date = reading_date;
		this.reading_clinic = reading_clinic;
	}


	public String getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}


	public String getReading_type() {
		return reading_type;
	}


	public void setReading_type(String reading_type) {
		this.reading_type = reading_type;
	}


	public String getReading_id() {
		return reading_id;
	}


	public void setReading_id(String reading_id) {
		this.reading_id = reading_id;
	}


	public String getReading_value() {
		return reading_value;
	}


	public void setReading_value(String reading_value) {
		this.reading_value = reading_value;
	}


	public long getReading_date() {
		return reading_date;
	}


	public void setReading_date(long reading_date) {
		this.reading_date = reading_date;
	}


	public String getReading_clinic() {
		return reading_clinic;
	}


	public void setReading_clinic(String reading_clinic) {
		this.reading_clinic = reading_clinic;
	}
	
	
		
	
	
	
	

}
