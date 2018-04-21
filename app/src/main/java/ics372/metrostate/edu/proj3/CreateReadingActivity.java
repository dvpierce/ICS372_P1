package ics372.metrostate.edu.proj3;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class CreateReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reading);

        /**
         * UPDATE REQUIRED
         * TESTING PURPOSES
         */
        // Retrieve active patient IDs
        List<String> patientIDs = new ArrayList<>();
        List<Patient> patients = Database.getInstance().getPatients();
        for(Patient p : patients) {
            if(p.getPatientStatus() == PatientState.ACTIVE) {
                patientIDs.add(p.getPatient_id());
            }
        }

        /**
         * UPDATE REQUIRED
         * TESTING PURPOSES
         */
        // Retrieve all clinic IDs
        List<String> clinicIDs = new ArrayList<>();
        List<Clinic> clinics = Database.getInstance().getClinics();
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

    /**
     * Called when the user taps the set date button
     * Starts Date Picker Dialog
     * @param view
     */
    public void setDate(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "Set Date");
    }

    /**
     * Called when the user taps the create button
     * Creates a reading from the user input
     * @param view
     */
    public void createReading(View view) {

    }

    /**
     * Called when the user taps the cancel button
     * Closes the activity
     * @param view
     */
    public void cancel(View view) {
        finish();
    }

}