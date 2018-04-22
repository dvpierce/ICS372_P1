package ics372.metrostate.edu.proj3;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateReadingActivity extends AppCompatActivity implements ICreateReadingView {

    private CreateReadingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reading);
        presenter = new CreateReadingPresenter(this, this);
        presenter.createPatientSpinner();
        presenter.createClinicSpinner();
    }

    /**
     * Called when the user taps the set date button
     * Starts Date Picker Dialog
     * @param view
     */
    public void setDate(View view) {
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setPresenter(presenter);
        datePicker.show(getSupportFragmentManager(), "Set Date");
    }

    /**
     * Called when the user taps the create button
     * Creates a reading from the user input
     * @param view
     */
    public void createReading(View view) {
        presenter.createReading();
    }

    /**
     * Called when the user taps the cancel button
     * Closes the activity
     * @param view
     */
    public void cancel(View view) {
        finish();
    }

    @Override
    public void createSuccessful() {
        Toast.makeText(this, "Created Successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createFailed() {
        Toast.makeText(this, "Failed! Please make sure all inputs are entered!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dateSelected(String date) {
        Toast.makeText(this, "Date: " + date + " set!", Toast.LENGTH_SHORT).show();
    }

}