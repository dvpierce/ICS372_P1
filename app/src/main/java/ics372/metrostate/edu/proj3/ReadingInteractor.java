package ics372.metrostate.edu.proj3;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;
import java.util.Stack;

public class ReadingInteractor {

    private static final int STARTING_INDEX = 2;
    private ReadingPresenter presenter;
    private ReadingActivity activity;
    private Stack<TableRow> selectedStack;

    public ReadingInteractor(ReadingActivity activity, ReadingPresenter presenter) {
        this.presenter = presenter;
        this.activity = activity;
        this.selectedStack = new Stack<>();
    }

    public void populateAllReadingTable(TableLayout table) {

        table.setStretchAllColumns(true);
        List<Reading> readings = Database.getInstance().getReadings();

        /**
         * Test data
         */
//        for (int i = 0; i < 100; i ++) {
//            readings.add(new Reading("5", "Weight", Integer.toString(i + 1), "33.5", 345235234, "324123"));
//        }

        int index = STARTING_INDEX;
        for(Reading r : readings) {
            final TextView id = new TextView(activity);
            id.setGravity(Gravity.LEFT);
            id.setPadding(5, 10, 5, 10);
            id.setText(r.getReading_id());
            id.setTextColor(Color.parseColor("BLACK"));

            final TextView type = new TextView(activity);
            type.setGravity(Gravity.LEFT);
            type.setPadding(5, 10, 5, 10);
            type.setText(r.getReading_type());
            type.setTextColor(Color.parseColor("BLACK"));

            final TextView value = new TextView(activity);
             value.setGravity(Gravity.LEFT);
            value.setPadding(5, 10, 5, 10);
            value.setText(r.getReading_value());
            value.setTextColor(Color.parseColor("BLACK"));

            final TextView patient = new TextView(activity);
             patient.setGravity(Gravity.LEFT);
            patient.setPadding(5, 10, 5, 10);
            patient.setText(r.getPatient_id());
            patient.setTextColor(Color.parseColor("BLACK"));

            final TextView clinic = new TextView(activity);
            clinic.setGravity(Gravity.LEFT);
            clinic.setPadding(5, 10, 5, 10);
            clinic.setText(r.getClinic_id());
            clinic.setTextColor(Color.parseColor("BLACK"));

            final TextView date = new TextView(activity);
            date.setGravity(Gravity.LEFT);
            date.setPadding(5, 10, 5, 10);
            date.setText(Long.toString(r.getReading_date()));
            date.setTextColor(Color.parseColor("BLACK"));

            final TableRow row = new TableRow(activity);
            row.addView(id);
            row.addView(type);
            row.addView(value);
            row.addView(patient);
            row.addView(clinic);
            row.addView(date);
            row.setClickable(true);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!selectedStack.empty()) {
                        TableRow prev = selectedStack.pop();
                        prev.setBackgroundColor(Color.WHITE);
                    }
                    row.setBackgroundColor(Color.GRAY);
                    selectedStack.push(row);
                    presenter.setSelectedReading(id.getText().toString());
                }
            });
            table.addView(row, index ++);
        }
    }

    public void populatePatientReadingTable(TableLayout table, String patientId) {
        table.setStretchAllColumns(true);
        List<Reading> readings = DBQuery.getPatientReadings(patientId);

        int index = STARTING_INDEX;
        for(Reading r : readings) {
            final TextView id = new TextView(activity);
            id.setGravity(Gravity.LEFT);
            id.setPadding(5, 10, 5, 10);
            id.setText(r.getReading_id());
            id.setTextColor(Color.parseColor("BLACK"));

            final TextView type = new TextView(activity);
            type.setGravity(Gravity.LEFT);
            type.setPadding(5, 10, 5, 10);
            type.setText(r.getReading_type());
            type.setTextColor(Color.parseColor("BLACK"));

            final TextView value = new TextView(activity);
            value.setGravity(Gravity.LEFT);
            value.setPadding(5, 10, 5, 10);
            value.setText(r.getReading_value());
            value.setTextColor(Color.parseColor("BLACK"));

            final TextView patient = new TextView(activity);
            patient.setGravity(Gravity.LEFT);
            patient.setPadding(5, 10, 5, 10);
            patient.setText(r.getPatient_id());
            patient.setTextColor(Color.parseColor("BLACK"));

            final TextView clinic = new TextView(activity);
            clinic.setGravity(Gravity.LEFT);
            clinic.setPadding(5, 10, 5, 10);
            clinic.setText(r.getClinic_id());
            clinic.setTextColor(Color.parseColor("BLACK"));

            final TextView date = new TextView(activity);
            date.setGravity(Gravity.LEFT);
            date.setPadding(5, 10, 5, 10);
            date.setText(Long.toString(r.getReading_date()));
            date.setTextColor(Color.parseColor("BLACK"));

            final TableRow row = new TableRow(activity);
            row.addView(id);
            row.addView(type);
            row.addView(value);
            row.addView(patient);
            row.addView(clinic);
            row.addView(date);
            row.setClickable(true);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!selectedStack.empty()) {
                        TableRow prev = selectedStack.pop();
                        prev.setBackgroundColor(Color.WHITE);
                    }
                    row.setBackgroundColor(Color.GRAY);
                    selectedStack.push(row);
                    presenter.setSelectedReading(id.getText().toString());
                }
            });
            table.addView(row, index ++);
        }
    }

    public void deleteSelected(TableLayout table) {
        TableRow row = selectedStack.pop();
        table.removeView(row);
    }

}