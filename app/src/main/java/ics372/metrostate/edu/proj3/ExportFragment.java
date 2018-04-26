package ics372.metrostate.edu.proj3;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class ExportFragment extends DialogFragment {

    private MainPresenter presenter;

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_export_content, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set title
        getDialog().setTitle(R.string.dialog_export_title);

        // edit text
        final EditText plainText = view.findViewById(R.id.plainText_exportFile);

        // set buttons on action
        view.findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = plainText.getText().toString();
                presenter.exportFile(fileName);
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

    }

}