package ics372.metrostate.edu.proj3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;

public class PatientFragment extends DialogFragment {

    private PatientPresenter presenter;

    public void setPresenter(PatientPresenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_content, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set title
        getDialog().setTitle(R.string.dialog_patient_title);

        // Create the spinner
        final Spinner spinner = (Spinner) getView().findViewById(R.id.spinner);
        ArrayAdapter<PatientState> dataAdapter = new ArrayAdapter<PatientState>(getActivity(), android.R.layout.simple_spinner_item, PatientState.values());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // edit text
        final EditText plainText = view.findViewById(R.id.editText_p_id);

        // set buttons on action
        view.findViewById(R.id.button_create_p).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patientID = plainText.getText().toString();
                PatientState state = StateConverter.convertString(spinner.getSelectedItem().toString());
                presenter.createPatient(patientID, state);
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.button_cancel_p).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

    }

}