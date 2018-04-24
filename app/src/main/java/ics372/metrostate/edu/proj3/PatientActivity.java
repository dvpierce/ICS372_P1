package ics372.metrostate.edu.proj3;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity implements IPatientView {

    public static final String ADDRESS = "PATIENT";
    private PatientPresenter presenter;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        presenter = new PatientPresenter(this, this);
        presenter.createTable();
    }

    /**
     * Called when the user taps the create button
     * Starts Create Patient Dialog
     * @param view
     */
    public void createPatient(View view) {
        PatientFragment createPatientDialog = new PatientFragment();
        createPatientDialog.setPresenter(presenter);
        createPatientDialog.show(getSupportFragmentManager(), "Create Patient");
    }

    /**
     * Called when the user taps the delete button
     * Deletes the patient
     * @param view
     */
    public void deletePatient(View view) {
        presenter.deletePatient();
    }

    /**
     * Called when the user taps the view button
     * Starts Reading Activity
     * @param view
     */
    public void viewReadings(View view) {
        presenter.viewReadings();
    }

    /**
     * Called when the user taps the search button
     * Searches the patient
     * @param view
     */
    public void searchPatient(View view) { presenter.searchPatient(); }

    /**
     * Called when the user taps the edit button
     * Edits the status of the patient
     * @param view
     */
    public void editPatient(View view) {
        EditPatientFragment editDialog = new EditPatientFragment();
        editDialog.setPresenter(presenter);
        if(presenter.hasSelection()) editDialog.show(getSupportFragmentManager(), "Edit Patient");
    }

    @Override
    public void startProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("Fetching patients...");
    }

    @Override
    public void endProgress() {
        if(progress != null) progress.dismiss();
    }

    @Override
    public void deleteSuccessful() {
        Toast.makeText(this, "Delete Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteFailed() {
        Toast.makeText(this, "Delete Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nonselected() {
        Toast.makeText(this, "Please select a patient first!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToReadings(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void searchSuccessful(String id) {
        Toast.makeText(this, "Search Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchFailed() {
        Toast.makeText(this, "Search Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void patientCreated() {
        Toast.makeText(this, "Created Successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void patientCreationFailed() {
        Toast.makeText(this, "Failed! Please make sure inputs are valid!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editSuccessful() {
        Toast.makeText(this, "Edit Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editFailed() {
        Toast.makeText(this, "Edit Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        FileWriter.serializeNow(this);
        super.onPause();
    }

}

