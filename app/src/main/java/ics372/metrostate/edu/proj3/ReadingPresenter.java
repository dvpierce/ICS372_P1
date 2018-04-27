package ics372.metrostate.edu.proj3;

import android.content.Intent;
import android.widget.TableLayout;
import android.widget.TableRow;
// This class is used to view tables for the patient reading
public class ReadingPresenter {

    private IReadingView view;
    private ReadingActivity activity;
    private ReadingInteractor interactor;
    private String selectedReading;
    private TableLayout table;

    public ReadingPresenter(ReadingActivity activity, IReadingView view) {
        this.view = view;
        this.activity = activity;
        this.interactor = new ReadingInteractor(activity, this);
        this.table = (TableLayout) activity.findViewById(R.id.table_layout);
    }
//create table to view readings
    public void createTable() {
        view.startProgress();
        String source = IntentReader.getSourceAddress(activity.getIntent());

        if(source.equals(MainActivity.ADDRESS)) {
            interactor.populateAllReadingTable(table);
        } else if(source.equals(PatientActivity.ADDRESS)) {
            String patientID = IntentReader.getTargetID(activity.getIntent());
            interactor.populatePatientReadingTable(table, patientID);
        } else {}
        view.endProgress();
    }

    public void setSelectedReading(String id) {
        selectedReading = id;
    }
// delete reading if desired
    public void deleteReading() {
        if(selectedReading != null) {
            boolean isSuccessful = DBQuery.deleteReading(selectedReading);
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

}