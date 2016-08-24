package com.tiy.hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Brice on 8/17/16.
 */
public class Hospital {
    private String name = "WebMD";
    ArrayList<HospitalDoctor> doctorsIndex = new ArrayList<HospitalDoctor>();
    ArrayList<Patient> patientIndex = new ArrayList<Patient>();

    public String getName() {
        return name;
    }

    public ArrayList<HospitalDoctor> getDoctorsIndex() {
        return doctorsIndex;
    }

    public void addDoctorsIndex(HospitalDoctor myDoc) {
        doctorsIndex.add(myDoc);
    }

    public ArrayList<Patient> getPatientIndex() {
        return patientIndex;
    }

    public void addPatientIndex(Patient patient) {
        patientIndex.add(patient);
    }
}
