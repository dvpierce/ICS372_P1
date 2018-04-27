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

public class ClinicInteractor {

    private static final int STARTING_INDEX = 2;
    private ClinicPresenter presenter;
    private ClinicActivity activity;
    private Stack<TableRow> selectedStack;

    public ClinicInteractor(ClinicActivity activity, ClinicPresenter presenter) {
        this.presenter = presenter;
        this.activity = activity;
        this.selectedStack = new Stack<>();
    }
//populate clinics table
    public void populateAllClinicsTable(TableLayout table) {

        table.setStretchAllColumns(true);
        List<Clinic> clinics = Database.getInstance().getClinics();


        int index = STARTING_INDEX;
        for(Clinic c : clinics) {
            final TextView id = new TextView(activity);
            id.setGravity(Gravity.LEFT);
            id.setPadding(5, 10, 5, 10);
            id.setText(c.getClinicID());
            id.setTextColor(Color.parseColor("BLACK"));

            final TableRow row = new TableRow(activity);
            row.addView(id);
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
                    presenter.setSelectedClinic(id.getText().toString());
                }
            });
            table.addView(row, index ++);
        }
    }
//delete clinic if desired
    public void deleteSelected(TableLayout table) {
        TableRow row = selectedStack.pop();
        table.removeView(row);
    }

}