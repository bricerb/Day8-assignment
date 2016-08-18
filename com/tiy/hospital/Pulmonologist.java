package com.tiy.hospital;

/**
 * Created by Brice on 8/17/16.
 */
public class Pulmonologist extends HospitalDoctor implements Surgeon{

    public Pulmonologist(String firstName, String lastName, String college) {
        super(firstName, lastName, college);
    }

    public Diagnosis diagnose() {
        return new Diagnosis(Diagnosis.COMMON_COLD);
    }

    public boolean operate(Patient patient) {
        patient.setSick(0);
        return true; // successfull operation
    }
//    }
}