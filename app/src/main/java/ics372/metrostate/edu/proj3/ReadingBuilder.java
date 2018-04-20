package ics372.metrostate.edu.proj3;

import java.util.Date;

public class ReadingBuilder {

    private String reading_value, reading_clinic, reading_id, reading_type, patient_id;
    long reading_date;

    public ReadingBuilder() {
        this.ReadingDateUpdate();
    }

    public void ReadingDateUpdate() {
        Date now = new Date();
        this.reading_date = new Long(now.getTime()/1000);
    }

    public void setReading_value(String value) { this.reading_value = value; }
    public void setReading_clinic(String clinic) { this.reading_clinic = clinic; }
    public void setReading_id(String id) { this.reading_id = id; }
    public void setReading_type(String type) { this.reading_type = type; }
    public void setPatient_id(String id) { this.patient_id = id; }
    public void setReading_date(Long time) { this.reading_date = time; }

    public Reading build() {
        Reading r = null;
        if ( ( reading_value == null ) ||
                ( reading_clinic == null ) ||
                ( reading_id == null ) ||
                ( reading_type == null ) ||
                ( patient_id == null ) ) {
            return null;
        } else {
            r = new Reading(patient_id, reading_type, reading_id, reading_value, reading_date, reading_clinic);
        }
        return r;
    }
}
