package ics372.metrostate.edu.proj3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ClinicActivity extends AppCompatActivity implements IClinicView {

    public static final String ADDRESS = "CLINIC";
    private ClinicPresenter presenter;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic);
        presenter = new ClinicPresenter(this, this);
        presenter.createTable();
    }

    /**
     * Called when the user taps on the create button
     * Starts Create Clinic Dialog
     * @param view
     */
    public void createClinic(View view) {
        ClinicFragment clinicDialog = new ClinicFragment();
        clinicDialog.setPresenter(presenter);
        clinicDialog.show(getSupportFragmentManager(), "Create Clinic");
    }

    /**
     * Called when the user taps the delete button
     * Deletes the patient
     * @param view
     */
    public void deleteClinic(View view) {
        presenter.deleteClinic();
    }

    /**
     * Called when the user taps the view button
     * Starts Reading Activity
     * @param view
     */
    public void viewPatients(View view) {
        presenter.viewPatients();
    }

    /**
     * Called when the user taps the search button
     * Searches the clinic
     * @param view
     */
    public void searchClinic(View view) { presenter.searchClinic(); }

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
        Toast.makeText(this, "Please select a clinic first!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToPatients(Intent intent) {
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
    public void clinicCreated() {
        Toast.makeText(this, "Successfully Created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clinicCreationFailed() {
        Toast.makeText(this, "Failed! Please make sure inputs are valid!", Toast.LENGTH_SHORT).show();
    }

}
