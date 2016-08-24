package com.tiy.hospital;

import java.util.ArrayList;

/**
 * Created by Brice on 8/17/16.
 */
public class Hospital {
    private String name = "WebMD";
    ArrayList<HospitalDoctor> doctorsIndex = new ArrayList<HospitalDoctor>();

    public String getName() {
        return name;
    }

    public ArrayList<HospitalDoctor> getDoctorsIndex() {
        return doctorsIndex;
    }

    public void addDoctorsIndex(HospitalDoctor myDoc) {
        doctorsIndex.add(myDoc);
    }

    public void setName(String name) {
        this.name = name;
    }
}
