package com.tiy.hospital;

import java.util.Scanner;

/**
 * Created by dbashizi on 8/16/16.
 */
public class HospitalRunner {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

//        HospitalDoctor firstDoc = new SurgicalOncologist("Brice", "Blanch", "Iron Yard");
        Hospital myHospital = new Hospital();
//        HospitalDoctor secondDoc = new GeneralPractioner("James", "Gavin", "MIT");
//        HospitalDoctor thirdDoc = new EarNoseThroat("Christopher", "Turk", "Scrubs");
//        HospitalDoctor fourthDoc = new Pulmonologist("John", "Dorian", "Scrubs R' Us");

        while (true) {
            System.out.println("\nWelcome to " + myHospital.getName() + " Hospital.");
            System.out.println("Type 0 to leave.");
            System.out.println("\nhow many doctors would you like to have available today?");
            int numDoctors = Integer.valueOf(inputScanner.nextLine());
            if (numDoctors == 0) {
                break;
            }
            for (int currentDoctor = 0; currentDoctor < numDoctors; currentDoctor++) {
                System.out.println("What is this Doctor's first name?");
                String firstDoc = inputScanner.nextLine();
                System.out.println("What is this Doctor's last name?");
                String lastDoc = inputScanner.nextLine();
                System.out.println("And what University did they attend?");
                String univDoc = inputScanner.nextLine();
                System.out.println("Choose a specialy for this Doctor");
                System.out.println("1. Pulmonologist");
                System.out.println("2. Oncologist");
                System.out.println("3. Ear , Nose, and Throat");
                System.out.println("4. General Practitioner");
                int docSpecialty = Integer.valueOf(inputScanner.nextLine());
                if (docSpecialty == 1) {
                    HospitalDoctor pulmDoc = new Pulmonologist(firstDoc, lastDoc, univDoc);
                    myHospital.addDoctorsIndex(pulmDoc);
                } else if (docSpecialty == 2) {
                    HospitalDoctor oncDoc = new SurgicalOncologist(firstDoc, lastDoc, univDoc);
                    myHospital.addDoctorsIndex(oncDoc);
                } else if (docSpecialty == 3) {
                    HospitalDoctor entDoc = new EarNoseThroat(firstDoc, lastDoc, univDoc);
                    myHospital.addDoctorsIndex(entDoc);
                } else if (docSpecialty == 4) {
                    HospitalDoctor generalDoc = new GeneralPractioner(firstDoc, lastDoc, univDoc);
                    myHospital.addDoctorsIndex(generalDoc);
                }
            }

            System.out.println("And how many patients are here for treatment?");
            int numPatients = Integer.valueOf(inputScanner.nextLine());
            for (int currPatient = 0; currPatient <numPatients; currPatient++) {

                System.out.println("\nCreate a new Patient. ");
                System.out.println("What's your patient's first name?");
                String firstName = inputScanner.nextLine();
                System.out.println("What's your patient's last name?");
                String lastName = inputScanner.nextLine();
                System.out.println("What symptom does your patient have?");
                System.out.println("\n1. Difficulty Breathing");
                System.out.println("2. Severe Chronic Migraines");
                System.out.println("3. Consistent Sore Throat");
                System.out.println("4. All of the above");
                int symptom = Integer.valueOf(inputScanner.nextLine());


                Patient currentPatient = new Patient(firstName, lastName);
                currentPatient.setSick(symptom);
                myHospital.addPatientIndex(currentPatient);
            }

            for (Patient myPatient : myHospital.getPatientIndex()) {

                for (HospitalDoctor myDoc : myHospital.getDoctorsIndex()) {
                    if (myDoc instanceof GeneralPractioner) {
                        System.out.println();
                        boolean success = ((GeneralPractioner) myDoc).operate(myPatient);
                        System.out.println("Oh no, you have a Cold!");
                        if (success) {
                            System.out.println("Here's some Tylenol. Go drink some Java and you'll be cured.");
                        } else {
                            System.out.println("We don't have a doctor that can treat you! \nYou'll have to take some Tylenol or something. Sorry.");
                        }
                    }

                    if (myDoc instanceof SurgicalOncologist) {
                        System.out.println();
                        System.out.println("Oh no! You have Brain Cancer!");
                        boolean success = ((SurgicalOncologist) myDoc).operate(myPatient);
                        if (success) {
                            System.out.println("Successful operation!");
                            System.out.println(myDoc.getFirstName() + " " + myDoc.getLastName() + " from " + myDoc.getCollege() + " cured Brain Cancer");
                        } else {
                            System.out.println("\nBrice Blanch from Iron Yard miraculously appears and cures your cancer! \nThat's Week2 in the Iron Yard.");
                        }
                    }

                    if (myDoc instanceof EarNoseThroat) {
                        System.out.println();
                        boolean success = ((EarNoseThroat) myDoc).operate(myPatient);
                        System.out.println("Oh no! You have Strep Throat! ");
                        System.out.println(myDoc.getFirstName() + " " + myDoc.getLastName() + " from " + myDoc.getCollege() + " is here to treat Strep Throat.");
                        if (success) {
                            System.out.println("Successful operation!");
                        } else {
                            System.out.println("Operation failed!!!");
                        }
                    }

                    if (myDoc instanceof Pulmonologist) {
                        System.out.println();
                        boolean success = ((Pulmonologist) myDoc).operate(myPatient);
                        System.out.println("Oh no! You have Lung Cancer!");
                        if (success) {
                            System.out.println("Successful operation!");
                            System.out.println(myDoc.getFirstName() + " " + myDoc.getLastName() + " from " + myDoc.getCollege() + " cured Lung Cancer");
                        } else {
                            System.out.println("Operation failed!!!");
                        }
                    }
                    break;
                }
            }
        }
    }
}