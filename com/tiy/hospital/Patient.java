package com.tiy.hospital;

/**
 * Created by dbashizi on 8/16/16.
 */
public class Patient extends Person {
    private int isSick= -1;

    public void setSick(int sick) {
        this.isSick = sick;
    }

    public Patient(String firstName, String lastName) {
        super(firstName, lastName);
    }


}
