package com.Isuruni;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class University_Management_System {
    public static void main(String[] args) throws IOException {
        int n;
        int press;

            Scanner input = new Scanner(System.in);
            print();
            do {
                System.out.println("Select, [1] sign up, [2] sign in");
                n = input.nextInt();
            } while (n != 1 && n != 2);

            do {

                System.out.println("Press [1] : Register as a student.\nPress [2] : Register as a Lecturer.");
                press = input.nextInt();
            } while (press != 1 && press != 2);
        University student=new Student();
        University lecturer=new Lecturer();
            if (n == 1) {
                print();
                if (press == 1) {
                    System.out.println("Student Registration Form");
                    student.signup();

                } else {
                    System.out.println("Lecturer Registration Form");
                    lecturer.signup();
                }

                University.display_information();
                System.out.println("Thank you!");
            } else if (n == 2) {
                print();
                if (press == 1) {
                    System.out.println("Student Login Form");
                    student.signIn();
                } else {
                    System.out.println("Lecturer Login Form");
                    lecturer.signIn();

                }
                System.out.println("\nPlease select an option\n[1] Exit\n[2] Register for a new course.");
                press= input.nextInt();
                if(press==1){
                    System.exit(1);
                }
                else if(press==2){
                    do {

                        System.out.println("Press [1] : Register as a student.\nPress [2] : Register as a Lecturer.");
                        press = input.nextInt();
                    } while (press != 1 && press != 2);

                    print();
                        if (press == 1) {
                            System.out.println("Student Registration Form");
                            student.signup();

                        } else {
                            System.out.println("Lecturer Registration Form");
                            lecturer.signup();
                        }

                        University.display_information();
                        System.out.println("Thank you!");
                    }
                }

            }



    public static void print () {
        System.out.println("Welcome to University Management System");
        System.out.println();
        System.out.println("............");
    }

}


