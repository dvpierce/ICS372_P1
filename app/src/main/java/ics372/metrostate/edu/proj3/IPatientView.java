package ics372.metrostate.edu.proj3;

import android.content.Intent;

public interface IPatientView {

    void startProgress();
    void endProgress();
    void deleteSuccessful();
    void deleteFailed();
    void nonselected();
    void navigateToReadings(Intent intent);
    void searchSuccessful(String id);
    void searchFailed();
    void patientCreated();
    void patientCreationFailed();
    void editSuccessful();
    void editFailed();

}