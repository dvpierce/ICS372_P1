package ics372.metrostate.edu.proj3;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TableLayout;

public class PatientPresenter {

    private IPatientView view;
    private PatientActivity activity;
    private PatientInteractor interactor;
    private String selectedPatient;
    private TableLayout table;

    public PatientPresenter(PatientActivity activity, IPatientView view) {
        this.view = view;
        this.activity = activity;
        this.interactor = new PatientInteractor(activity, this);
        this.table = (TableLayout) activity.findViewById(R.id.table_layout);
    }

    public PatientActivity getActivity() {
        return this.activity;
    }
//create table
    public void createTable() {
        view.startProgress();
        String source = IntentReader.getSourceAddress(activity.getIntent());

        if(source.equals(MainActivity.ADDRESS)) {
            interactor.populateAllPatientsTable(table);
        } else if(source.equals(ClinicActivity.ADDRESS)) {
            String clinicID = IntentReader.getTargetID(activity.getIntent());
            interactor.populateClinicPatientsTable(table, clinicID);
        } else {}
        view.endProgress();
    }

    public void setSelectedPatient(String id) {
        selectedPatient = id;
    }
//delete patient
    public void deletePatient() {
        if(selectedPatient != null) {
            boolean isSuccessful = DBQuery.deletePatient(selectedPatient);
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
//view patient reading
    public void viewReadings() {
        if(selectedPatient != null) {
            Intent intent = new Intent(activity, ReadingActivity.class);
            intent.putExtra(IntentReader.SOURCE_ADDRESS, PatientActivity.ADDRESS);
            intent.putExtra(IntentReader.TARGET_ID, selectedPatient);
            view.navigateToReadings(intent);
        } else {
            view.nonselected();
        }
    }
//search patient
    public void searchPatient() {
        EditText searchText = (EditText) activity.findViewById(R.id.plainText_search_patient);
        String id = searchText.getText().toString();
        boolean isSearched = DBQuery.patientExists(id);
        if(isSearched) {
            view.searchSuccessful(id);
        } else {
            view.searchFailed();
        }
    }
//create patient if ID does not exits
    public void createPatient(String patientID, PatientState state) {
        if(patientID.equals("")) {
            view.patientCreationFailed();
            return;
        } else {
            DBQuery.addPatient(new Patient(patientID, state, "-1"));
            view.patientCreated();
        }
    }
//edit patient info in database
    public void editPatient(PatientState state) {
        if (selectedPatient != null) {
            boolean isSuccessful = DBQuery.changePatientStatus(selectedPatient, state);
            if(isSuccessful) {
                view.editSuccessful();
            } else {
                view.editFailed();
            }
        } else {
            view.nonselected();
        }
    }

    public boolean hasSelection() {
        if (selectedPatient != null) {
            return true;
        } else {
            view.nonselected();
            return false;
        }
    }

}