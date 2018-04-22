package ics372.metrostate.edu.proj3;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PatientActivity extends AppCompatActivity {

    public static final String ADDRESS = "PATIENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
    }

    /**
     * Called when the user taps the create button
     * Starts Create Patient Dialog
     * @param view
     */
    public void createPatient(View view) {
        DialogFragment createPatientDialog = new PatientFragment();
        createPatientDialog.show(getSupportFragmentManager(), "Create Patient");
    }
}
