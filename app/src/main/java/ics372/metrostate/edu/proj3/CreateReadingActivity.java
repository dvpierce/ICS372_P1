package ics372.metrostate.edu.proj3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CreateReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reading);

        // Retrieve active patient IDs
        List<String> patientIDs = new ArrayList<>();
        List<Patient> patients = Trial.getInstance().getPatients();
        for(Patient p : patients) {
            if(p.getPatientStatus() == PatientState.ACTIVE) {
                patientIDs.add(p.getPatient_id());
            }
        }

        // Retrieve all clinic IDs
        List<String> clinicIDs = new ArrayList<>();
        List<Clinic> clinics = Trial.getInstance().getClinics();
        for(Clinic c : clinics) {
            clinicIDs.add(c.getClinicID());
        }

        // Create patient spinner
        Spinner patientSpinner = (Spinner) findViewById(R.id.spinner_pID);
        ArrayAdapter<String> patientAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, patientIDs);
        patientAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientSpinner.setAdapter(patientAdapter);

        // Create clinic spinner
        Spinner clinicSpinner = (Spinner) findViewById(R.id.spinner_cID);
        ArrayAdapter<String> clinicAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, clinicIDs);
        clinicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clinicSpinner.setAdapter(clinicAdapter);
    }
}