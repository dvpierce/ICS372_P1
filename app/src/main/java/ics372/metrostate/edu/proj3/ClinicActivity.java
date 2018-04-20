package ics372.metrostate.edu.proj3;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClinicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic);
    }

    /**
     * Called when the user taps on the create button
     * Starts Create Clinic Dialog
     * @param view
     */
    public void createClinic(View view) {
        DialogFragment clinicDialog = new ClinicFragment();
        clinicDialog.show(getSupportFragmentManager(), "Create Clinic");
    }
}
