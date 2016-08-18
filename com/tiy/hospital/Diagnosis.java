package com.tiy.hospital;

/**
 * Created by dbashizi on 8/16/16.
 */
public class Diagnosis {
    public static final int LUNG_CANCER = 1;
    public static final int BRAIN_CANCER = 2;
    public static final int COMMON_COLD = 3;
    public static final int STREP_THROAT = 4;
    public static final int UNDIAGONOSED = -1;
    public static final int CURED = 0;

    private int illness = UNDIAGONOSED;

    public Diagnosis(int illness) {
        this.illness = illness;
    }


}