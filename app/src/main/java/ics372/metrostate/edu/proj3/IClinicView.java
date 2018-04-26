package ics372.metrostate.edu.proj3;

import android.content.Intent;

public interface IClinicView {

    void startProgress();
    void endProgress();
    void deleteSuccessful();
    void deleteFailed();
    void nonselected();
    void navigateToPatients(Intent intent);
    void searchSuccessful(String id);
    void searchFailed();
    void clinicCreated();
    void clinicCreationFailed();

}