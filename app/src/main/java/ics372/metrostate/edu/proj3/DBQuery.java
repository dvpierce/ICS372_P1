package ics372.metrostate.edu.proj3;

import java.util.List;

public class DBQuery {

    private DBQuery() { return; }

    public static Boolean clinicExists(String clinicQueryID) {

        // Grab the clinic list.
        List<Clinic> clinics = Database.getInstance().getClinics();

        // For each clinic in the list
        for ( Clinic c : clinics )
        {
            // Check if the clinic ID matches the requested ID.
            if ( c.getClinicID().equals(clinicQueryID) )
            {
                // Clinic with matching ID is found.
                return true;
            }
        }
        // end of loop - no match found.
        return false;
    }

    // Return true if patient exists.
    public static Boolean patientExists(String patientQueryID) {

        // Grab the patient list.
        List<Patient> patients = Database.getInstance().getPatients();

        // For each patient in the list
        for ( Patient p : patients )
        {
            // Check if the patient ID matches the requested ID.
            if ( p.getPatient_id().equals(patientQueryID) )
            {
                // Patient with matching ID is found.
                return true;
            }
        }
        // end of loop - no match found.
        return false;
    }

    // Return true if patient exists AND (!) is active.
    public static Boolean patientActive(String patientQueryID) {

        // Grab the patient list.
        List<Patient> patients = Database.getInstance().getPatients();

        // For each patient in the list
        for ( Patient p : patients )
        {
            // Check if the patient ID matches the requested ID.
            if ( p.getPatient_id().equals(patientQueryID) )
            {
                // Patient with matching ID is found.

                // Check patient status.
                PatientState patientQueryState = p.getPatientStatus();

                // If the Patient's state is active:
                if ( patientQueryState.equals(PatientState.ACTIVE) )
                {
                    // return true.
                    return true;
                } else {
                    // Otherwise, return false.
                    return false;
                }
            }
        }
        // end of loop - no match found.
        return false;
    }

    // Return true if patient exists AND (!) is active.
    public static Boolean patientComplete(String patientQueryID) {

        // Grab the patient list.
        List<Patient> patients = Database.getInstance().getPatients();

        // For each patient in the list
        for ( Patient p : patients )
        {
            // Check if the patient ID matches the requested ID.
            if ( p.getPatient_id().equals(patientQueryID) )
            {
                // Patient with matching ID is found.

                // Check patient status.
                PatientState patientQueryState = p.getPatientStatus();

                // If the Patient's state is active:
                if ( patientQueryState.equals(PatientState.COMPLETED) )
                {
                    // return true.
                    return true;
                } else {
                    // Otherwise, return false.
                    return false;
                }
            }
        }
        // end of loop - no match found.
        return false;
    }

}
