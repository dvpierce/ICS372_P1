package ics372.metrostate.edu.proj3;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReadingActivity extends AppCompatActivity implements IReadingView {

    private ReadingPresenter presenter;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        presenter = new ReadingPresenter(this, this);
        presenter.createTable();
    }

    /**
     * Called when the user taps the create button
     * Starts Create Reading Dialog
     * @param view
     */
    public void createReading(View view) {
        Intent intent = new Intent(this, CreateReadingActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the cancel button
     * Deletes the selected reading
     * @param view
     */
    public void deleteReading(View view) {
        presenter.deleteReading();
    }

    @Override
    public void startProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("Fetching readings...");
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
        Toast.makeText(this, "Please select a reading first!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        FileWriter.serializeNow(this);
        super.onPause();
    }

}
