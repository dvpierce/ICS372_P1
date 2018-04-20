package ics372.metrostate.edu.proj3;


import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
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
}
