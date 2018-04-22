package ics372.metrostate.edu.proj3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ClinicFragment extends DialogFragment {

    private ClinicPresenter presenter;

    public void setPresenter(ClinicPresenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clinic_content, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set title
        getDialog().setTitle(R.string.dialog_clinic_title);

        // edit text
        final EditText text = view.findViewById(R.id.editText_id_enterClinic);

        // set buttons on action
        view.findViewById(R.id.button_create_fc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clinicID = text.getText().toString();
                presenter.createClinic(clinicID);
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.button_cancel_fc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

    }

}