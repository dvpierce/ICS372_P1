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

public class EditPatientFragment extends DialogFragment {

    private PatientPresenter presenter;

    public void setPresenter(PatientPresenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_patient, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set title
        getDialog().setTitle(R.string.dialog_patient_title);

        // Create the spinner
        final Spinner spinner = (Spinner) getView().findViewById(R.id.spinner_pEdit);
        ArrayAdapter<PatientState> dataAdapter = new ArrayAdapter<PatientState>(getActivity(), android.R.layout.simple_spinner_item, PatientState.values());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // set buttons on action
        view.findViewById(R.id.button_edit_pEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientState state = StateConverter.convertString(spinner.getSelectedItem().toString());
                presenter.editPatient(state);
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.button_cancel_pEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

    }

}