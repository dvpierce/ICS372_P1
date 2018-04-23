package ics372.metrostate.edu.proj3;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TableLayout;

public class ClinicPresenter {

    private IClinicView view;
    private ClinicActivity activity;
    private ClinicInteractor interactor;
    private String selectedClinic;
    private TableLayout table;

    public ClinicPresenter(ClinicActivity activity, IClinicView view) {
        this.view = view;
        this.activity = activity;
        this.interactor = new ClinicInteractor(activity, this);
        this.table = (TableLayout) activity.findViewById(R.id.table_layout);
    }

    public void createTable() {
        view.startProgress();
        String source = IntentReader.getSourceAddress(activity.getIntent());

        if(source.equals(MainActivity.ADDRESS)) {
            interactor.populateAllClinicsTable(table);
        }
        view.endProgress();
    }

    public void setSelectedClinic(String id) {
        selectedClinic = id;
    }

    public void deleteClinic() {
        if(selectedClinic != null) {
            boolean isSuccessful = DBQuery.deleteClinic(selectedClinic);
            if(isSuccessful) {
                view.deleteSuccessful();
                interactor.deleteSelected(table);
            } else {
                view.deleteFailed();
            }
        } else {
            view.nonselected();
        }
    }

    public void viewPatients() {
        if(selectedClinic != null) {
            Intent intent = new Intent(activity, PatientActivity.class);
            intent.putExtra(IntentReader.SOURCE_ADDRESS, ClinicActivity.ADDRESS);
            intent.putExtra(IntentReader.TARGET_ID, selectedClinic);
            view.navigateToPatients(intent);
        } else {
            view.nonselected();
        }
    }

    public void searchClinic() {
        EditText searchText = (EditText) activity.findViewById(R.id.plainText_search_clinic);
        String id = searchText.getText().toString();
        boolean isSearched = DBQuery.clinicExists(id);
        if(isSearched) {
            view.searchSuccessful(id);
        } else {
            view.searchFailed();
        }
    }

    public void createClinic(String clinicID) {
        if(clinicID.equals("") || clinicID == null) {
            view.clinicCreationFailed();
            return;
        } else {
            DBQuery.addClinic( new Clinic(clinicID) );
            view.clinicCreated();
        }
    }

}