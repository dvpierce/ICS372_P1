package ics372.metrostate.edu.proj3;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class CreateReadingPresenter {

    private ICreateReadingView view;
    private CreateReadingActivity activity;
    private CreateReadingInteractor interactor;
    private Spinner patientSpinner;
    private Spinner clinicSpinner;
    private long date;


    public CreateReadingPresenter(CreateReadingActivity activity, ICreateReadingView view) {
        this.activity = activity;
        this.view = view;
        this.interactor = new CreateReadingInteractor(activity);
        patientSpinner = (Spinner) activity.findViewById(R.id.spinner_c_pID);
        clinicSpinner = (Spinner) activity.findViewById(R.id.spinner_c_cID);
    }

    public void createPatientSpinner() {
        List<String> ids = interactor.getPatientIDs(DBQuery.getActivePatients());
        ArrayAdapter<String> patientAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, ids);
        patientAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientSpinner.setAdapter(patientAdapter);
    }

    public void createClinicSpinner() {
        List<String> ids = interactor.getClinicIDs(DBQuery.getClinics());
        ArrayAdapter<String> clinicAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, ids);
        clinicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clinicSpinner.setAdapter(clinicAdapter);
    }

    public void getDate(int year, int month, int day) {
        date = interactor.convertDateToUnixTime(year, month, day);
        String dateInString = day + "/" + month + "/" + year;
        view.dateSelected(dateInString);
    }

    public void createReading() {
        if( isInputValid() ) {
            String id = interactor.getInputReadingID();
            String type = interactor.getInputReadingType();
            String value = interactor.getInputReadingValue();
            String pid = patientSpinner.getSelectedItem().toString();
            String cid = clinicSpinner.getSelectedItem().toString();
            long dateJSON = date;

            ReadingBuilder builder = new ReadingBuilder();
            builder.setReading_id(id)
                    .setReading_type(type)
                    .setReading_value(value)
                    .setPatient_id(pid)
                    .setReading_clinic(cid)
                    .setReading_date(dateJSON);
            Reading newReading = builder.build();
            DBQuery.addReading(newReading);
            view.createSuccessful();
        } else {
            view.createFailed();
        }
    }

    private boolean isInputValid() {
        if(interactor.getInputReadingID().equals("") || interactor.getInputReadingID() == null ||
                interactor.getInputReadingType().equals("") || interactor.getInputReadingType() == null ||
                interactor.getInputReadingValue().equals("") || interactor.getInputReadingValue() == null ||
                patientSpinner.getSelectedItem().toString() == null ||
                clinicSpinner.getSelectedItem().toString() == null ||
                date == 0) {
            return false;
        }
        return true;
    }

}