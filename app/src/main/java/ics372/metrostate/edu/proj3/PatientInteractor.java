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

public class PatientInteractor {

    private static final int STARTING_INDEX = 2;
    private PatientPresenter presenter;
    private PatientActivity activity;
    private Stack<TableRow> selectedStack;

    public PatientInteractor(PatientActivity activity, PatientPresenter presenter) {
        this.presenter = presenter;
        this.activity = activity;
        this.selectedStack = new Stack<>();
    }

    public void populateAllPatientsTable(TableLayout table) {

        table.setStretchAllColumns(true);
        List<Patient> patients = Database.getInstance().getPatients();

        /**
         *
         * Test data
         */
//        for (int i = 0; i < 20; i ++) {
//            patients.add(new Patient(Integer.toString(i + 1), PatientState.ACTIVE, Integer.toString(5)));
//        }

        int index = STARTING_INDEX;
        for(Patient p : patients) {
            final TextView id = new TextView(activity);
            id.setGravity(Gravity.LEFT);
            id.setPadding(5, 10, 5, 10);
            id.setText(p.getPatient_id());
            id.setTextColor(Color.parseColor("BLACK"));

            final TextView status = new TextView(activity);
            status.setGravity(Gravity.LEFT);
            status.setPadding(5, 10, 5, 10);
            status.setText(p.getPatientStatus().toString());
            status.setTextColor(Color.parseColor("BLACK"));



            final TableRow row = new TableRow(activity);
            row.addView(id);
            row.addView(status);
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
                    presenter.setSelectedPatient(id.getText().toString());
                }
            });
            table.addView(row, index ++);
        }
    }

    public void populateClinicPatientsTable(TableLayout table, String clinicID) {
        table.setStretchAllColumns(true);
        List<Patient> patients = DBQuery.getClinicPatients(clinicID);

        int index = STARTING_INDEX;
        for(Patient p : patients) {
            final TextView id = new TextView(activity);
            id.setGravity(Gravity.LEFT);
            id.setPadding(5, 10, 5, 10);
            id.setText(p.getPatient_id());
            id.setTextColor(Color.parseColor("BLACK"));

            final TextView status = new TextView(activity);
            status.setGravity(Gravity.LEFT);
            status.setPadding(5, 10, 5, 10);
            status.setText(p.getPatientStatus().toString());
            status.setTextColor(Color.parseColor("BLACK"));



            final TableRow row = new TableRow(activity);
            row.addView(id);
            row.addView(status);
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
                    presenter.setSelectedPatient(id.getText().toString());
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

