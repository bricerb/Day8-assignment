package com.tiy.hospital;

/**
 * Created by Brice on 8/17/16.
 */
public class EarNoseThroat extends HospitalDoctor implements Surgeon{

    public EarNoseThroat(String firstName, String lastName, String college) {
        super(firstName, lastName, college);
    }

    public Diagnosis diagnose() {
        return new Diagnosis(Diagnosis.STREP_THROAT);
    }

    public boolean operate(Patient patient) {
        patient.setSick(0);
        return true; // successfull operation
    }
//    }
}