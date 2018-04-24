package ics372.metrostate.edu.proj3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements IMainView {

    private MainPresenter presenter;
    public static final String ADDRESS = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FileWriter.deserializeNow(this);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this, this);
    }



    /**
     * Called when user taps the import button.
     * Prompts Import Dialog
     * @param view
     */
    public void importFile(View view) {
        presenter.openFileChooser();
    }

    /**
     * Called when the user taps the export button
     * Prompts Export Dialog
     * @param view
     */
    public void exportFile(View view) {
        ExportFragment exportDialog = new ExportFragment();
        exportDialog.setPresenter(presenter);
        exportDialog.show(getSupportFragmentManager(), "Export");
    }

    /**
     * Called when the user taps the reading button
     * Starts Reading Activity
     * @param view
     */
    public void manageReadings(View view) {
        Intent intent = new Intent(this, ReadingActivity.class);
        intent.putExtra(IntentReader.SOURCE_ADDRESS, ADDRESS);
        startActivity(intent);
    }

    /**
     * Called when the user taps the patient button
     * Starts Patient Activity
     * @param view
     */
    public void managePatients(View view) {
        Intent intent = new Intent(this, PatientActivity.class);
        intent.putExtra(IntentReader.SOURCE_ADDRESS, ADDRESS);
        startActivity(intent);
    }

    /**
     * Called when the user taps the clinic button
     * Starts Clinic Activity
     * @param view
     */
    public void manageClinics(View view) {
        Intent intent = new Intent(this, ClinicActivity.class);
        intent.putExtra(IntentReader.SOURCE_ADDRESS, ADDRESS);
        startActivity(intent);
    }

    @Override
    public void importSuccessful() {
        Toast.makeText(this, "Import Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void importFailed() {
        Toast.makeText(this, "Import Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void exportSuccessful() {
        Toast.makeText(this, "Export Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void exportFailed() {
        Toast.makeText(this, "Export Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        FileWriter.serializeNow(this);
        super.onPause();
    }
}
