package ics372.metrostate.edu.proj3;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ics372.metrostate.edu.proj3.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when user taps the import button.
     * Prompts Import Dialog
     * @param view
     */
    public void importFile(View view) {
        ImportFragment importDialog = new ImportFragment();
        importDialog.show(getSupportFragmentManager(), "Import");
    }

    /**
     * Called when the user taps the export button
     * Prompts Export Dialog
     * @param view
     */
    public void exportFile(View view) {
        ExportFragment exportDialog = new ExportFragment();
        exportDialog.show(getSupportFragmentManager(), "Export");

    }

    /**
     * Called when the user taps the reading button
     * Starts Reading Activity
     * @param view
     */
    public void manageReadings(View view) {
        Intent intent = new Intent(this, ReadingActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the patient button
     * Starts Patient Activity
     * @param view
     */
    public void managePatients(View view) {
        Intent intent = new Intent(this, PatientActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the clinic button
     * Starts Clinic Activity
     * @param view
     */
    public void manageClinics(View view) {
        Intent intent = new Intent(this, ClinicActivity.class);
        startActivity(intent);
    }

}
