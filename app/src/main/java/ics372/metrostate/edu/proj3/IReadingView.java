package ics372.metrostate.edu.proj3;

public interface IReadingView {

    void startProgress();
    void endProgress();
    void deleteSuccessful();
    void deleteFailed();
    void nonselected();

}