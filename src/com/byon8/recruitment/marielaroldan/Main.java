package com.byon8.recruitment.marielaroldan;

import java.io.IOException;
import java.util.Scanner;

/**
 * Present three questions to a patient, including his name
 * to be save in a data base for future information to the Doctors
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static final String[] questions = new String[]{
            "Have you some Allergies: (y/n)",
            "Do you have a chronic disease? (y/n)",
            "Do you have any kind of pain?:(y/n)"
    };
    private static final String[] secondaryQuestions = new String[]{
            "Please, write which allergies do you have? or press enter to continue.",
            "Which ones, or press enter to continue",
            "Please, specify where, or press enter to continue"
    };

    private static MockedPatientDataBase patientsDataBase = new MockedPatientDataBase();

    public static void main(String[] args) {

        String patientName;

        System.out.println("Welcome to your pre-appointment form, we want to ask you some questions before your visit.");
        System.out.println("We need you to answer some question relate to you actual health situation");
        System.out.println();
        System.out.println("First, What is your name?");
        patientName = sc.nextLine();

        String[] patientAnswers = questions();

        try {
            patientsDataBase.add(new Patient(patientName,patientAnswers[0],patientAnswers[1],patientAnswers[2]));
        } catch (IOException e) {
            System.err.println("Problem writing in the Database");
            e.printStackTrace();
        }
    }

    private static String[] questions(){

        String[] answers = new String[3];

        for (int i = 0; i < 3; i++) {

            System.out.println(questions[i]);
            String op = sc.nextLine();
            String answer = null;
            if (op.equalsIgnoreCase("y")) {
                System.out.println(secondaryQuestions[i]);
                answer = sc.nextLine();
                if (answer.trim().isEmpty()){
                    answer=null;
                }
            }
            answers[i] = answer;
        }
        return answers;
    }
}
