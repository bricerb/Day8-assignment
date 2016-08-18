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
            System.out.println("Welcome to " + myHospital.getName());
            System.out.println("\nhow many doctors would you like to have available today?");
            int numDoctors = Integer.valueOf(inputScanner.nextLine());
            for (int currentDoctor = 0;currentDoctor < numDoctors; currentDoctor++) {
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
                    myHospital.pulmDoc = pulmDoc;
                } else if (docSpecialty == 2) {
                    HospitalDoctor oncDoc = new SurgicalOncologist(firstDoc, lastDoc, univDoc);
                    myHospital.oncDoc = oncDoc;
                } else if (docSpecialty == 3) {
                    HospitalDoctor entDoc = new EarNoseThroat(firstDoc, lastDoc, univDoc);
                    myHospital.entDoc = entDoc;
                } else if (docSpecialty == 4) {
                    HospitalDoctor generalDoc = new GeneralPractioner(firstDoc, lastDoc, univDoc);
                    myHospital.genDoc = generalDoc;
                }
            }



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


            if (myHospital.genDoc instanceof GeneralPractioner) {
                System.out.println();
                boolean success = ((GeneralPractioner) myHospital.genDoc).operate(currentPatient);
                System.out.println("Oh no, you have a Cold!");
                if (success) {
                    System.out.println("Here's some Tylenol. Go drink some Java and you'll be cured.");
                } else {
                    System.out.println("We don't have a doctor that can treat you! \nYou'll have to take some Tylenol or something. Sorry.");
                }
            }

            if (myHospital.oncDoc instanceof SurgicalOncologist) {
                System.out.println();
                System.out.println("Oh no! You have Brain Cancer!");
                boolean success = ((SurgicalOncologist) myHospital.oncDoc).operate(currentPatient);
                if (success) {
                    System.out.println("Successful operation!");
                    System.out.println(myHospital.oncDoc.getFirstName() + " " + myHospital.oncDoc.getLastName() + " from " + myHospital.oncDoc.getCollege() + " cured Brain Cancer");
                } else {
                    System.out.println("\nBrice Blanch from Iron Yard miraculously appears and cures your cancer! \nThat's Week2 in the Iron Yard.");
                }
            }

            if (myHospital.entDoc instanceof EarNoseThroat) {
                System.out.println();
                boolean success = ((EarNoseThroat) myHospital.entDoc).operate(currentPatient);
                System.out.println("Oh no! You have Strep Throat! ");
                System.out.println(myHospital.entDoc.getFirstName() + " " + myHospital.entDoc.getLastName() + " from " + myHospital.entDoc.getCollege() + " is here to treat Strep Throat.");
                if (success) {
                    System.out.println("Successful operation!");
                } else {
                    System.out.println("Operation failed!!!");
                }
            }

            if (myHospital.pulmDoc instanceof Pulmonologist) {
                System.out.println();
                boolean success = ((Pulmonologist) myHospital.pulmDoc).operate(currentPatient);
                System.out.println("Oh no! You have Lung Cancer!");
                if (success) {
                    System.out.println("Successful operation!");
                    System.out.println(myHospital.pulmDoc.getFirstName() + " " + myHospital.pulmDoc.getLastName() + " from " + myHospital.pulmDoc.getCollege() + " cured Lung Cancer");
                } else {
                    System.out.println("Operation failed!!!");
                }
            }

            System.out.println("HospitalRunner.main() - done!");
            break;
        }
    }
}