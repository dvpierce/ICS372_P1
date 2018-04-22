package ics372.metrostate.edu.proj3;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

public class CreateReadingInteractor {

    private CreateReadingActivity activity;

    public CreateReadingInteractor(CreateReadingActivity activity) {
        this.activity = activity;
    }

    public List<String> getPatientIDs(List<Patient> patients) {
        List<String> ids = new ArrayList<>();
        for(Patient p : patients) {
            ids.add(p.getPatient_id());
        }
        return ids;
    }

    public List<String> getClinicIDs(List<Clinic> clinics) {
        List<String> ids = new ArrayList<>();
        for(Clinic c : clinics) {
            ids.add(c.getClinicID());
        }
        return ids;
    }

    public long convertDateToUnixTime(int year, int month, int day) {
        Calendar date = Calendar.getInstance();
        date.clear();
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.YEAR, year);
        long dateInMilli = date.getTimeInMillis();
        return dateInMilli;
    }

    public String getInputReadingID() {
        EditText idText = (EditText) activity.findViewById(R.id.editText_c_reading_id);
        String id = idText.getText().toString();
        return id;
    }

    public String getInputReadingType() {
        EditText typeText = (EditText) activity.findViewById(R.id.editText_c_reading_type);
        String type = typeText.getText().toString();
        return type;
    }

    public String getInputReadingValue() {
        EditText valueText = (EditText) activity.findViewById(R.id.editText_c_reading_value);
        String value = valueText.getText().toString();
        return value;
    }

}