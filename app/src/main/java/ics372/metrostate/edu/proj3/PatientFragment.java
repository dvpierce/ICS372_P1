package ics372.metrostate.edu.proj3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PatientFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Create the view
        View view = inflater.inflate(R.layout.fragment_patient_content, null);

        // Create the spinner
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        List<PatientState> states = new ArrayList<>(EnumSet.allOf(PatientState.class));
        ArrayAdapter<PatientState> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because it's going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_patient_content, null));
        builder.setTitle(R.string.dialog_patient_title);

        // Create action buttons
        builder.setPositiveButton(R.string.button_create, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // create
                    }
                })
                .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // cancel
                        dialog.dismiss();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}