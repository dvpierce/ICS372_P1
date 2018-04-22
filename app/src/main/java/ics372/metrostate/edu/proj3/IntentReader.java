package ics372.metrostate.edu.proj3;

import android.content.Intent;

public class IntentReader {

    public static final String SOURCE_ADDRESS = "ics372.metrostate.edu.proj3.ADDRESS";
    public static final String TARGET_ID = "ics372.metrostate.edu.proj3.TARGET_ID";

    public static String getSourceAddress(Intent intent) {
        if(intent.getExtras() != null) {
            String address = intent.getStringExtra(SOURCE_ADDRESS);
            return address;
        }
        return null;
    }

    public static String getTargetID(Intent intent) {
        if(intent.getExtras() != null) {
            String targetID = intent.getStringExtra(TARGET_ID);
            return targetID;
        }
        return null;
    }
}