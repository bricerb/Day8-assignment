package com.tiy.hospital;

import java.util.ArrayList;

/**
 * Created by Brice on 8/17/16.
 */
public class Hospital {
    private String name = "WebMD";
    HospitalDoctor entDoc;
    HospitalDoctor pulmDoc;
    HospitalDoctor oncDoc;
    HospitalDoctor genDoc;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
