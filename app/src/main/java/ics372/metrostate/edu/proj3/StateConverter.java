package ics372.metrostate.edu.proj3;
//different states of patients in the study
public class StateConverter {

    public static PatientState convertString(String s) {
        switch (s) {
            case "ACTIVE":
                return PatientState.ACTIVE;
            case "FAILED":
                return PatientState.FAILED;
            case "COMPLETED":
                return PatientState.COMPLETED;
            case "WITHDRAWN":
                return PatientState.WITHDRAWN;
            default:
                return PatientState.ACTIVE;
        }
    }
}