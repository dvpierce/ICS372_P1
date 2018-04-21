package ics372.metrostate.edu.proj3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

public class ExportFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Create content
        builder.setTitle(R.string.dialog_export_title)
                .setMessage(R.string.dialog_export_message);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because it's going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_export_content, null));


        // Create action buttons
        builder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // export
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