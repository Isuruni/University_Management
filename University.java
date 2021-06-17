package com.Isuruni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.*;
import java.util.Scanner;

public class University {
     Scanner input=new Scanner(System.in);

     String name,username,password;
    int age;

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static String [] course_no=new String[3];
    public void signup() throws IOException {

        System.out.println();
        System.out.println("Name:");
        name=input.nextLine();
        System.out.println("Username:");
        username=input.nextLine();
        System.out.println("Password :");
        password=input.nextLine();
        System.out.println("Age:");
        age=input.nextInt();
        System.out.println("3. Select a course number from the following list,");
        System.out.println("[1] SENG 11111 - Introduction to Programming.\n[2] SENG 11112 - Fundamentals of Engineering \n[3] SENG 11113 - Data structures and Algorithms.");
        course_no = in.readLine().split(",");


    }
    public  void signIn() throws IOException{
        System.out.println();
        System.out.println("Name:");
        name=input.nextLine();
        System.out.println("Username:");
        username=input.nextLine();
        System.out.println("Password :");
        password=input.nextLine();
        System.out.println("Hi "+ name+".");



    }
    public static void display_information(){


        System.out.println("You have successfully registered for");
        for(int i=0;i<course_no.length;i++){

            switch(course_no[i]){
                case "1":
                    System.out.println("1. Subject: SENG 11111 - Introduction to Programming.");
                    break;
                case "2":
                    System.out.println("2. Subject: SENG 11112 - Fundamentals of Engineering ");
                    break;
                case "3":
                    System.out.println("3. Subject: SENG 11113 - Data structures and Algorithms.");
                    break;

            }
        }

    }
}
class Student extends University{
    public void signup() throws IOException{
        super.signup();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stateuniversity", "root", "Isuruni1998@");
            Statement stmt = con.createStatement();
            for(int i=0;i< course_no.length;i++){
                String query = " insert into student (SNAME, SUSERNAME, SAGE, CID, SPASSWORD)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, name);
                preparedStmt.setString (2, username);
                preparedStmt.setInt  (3, age);
                preparedStmt.setString(4, course_no[i]);
                preparedStmt.setString   (5, password);

                preparedStmt.execute();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public  void signIn() throws IOException{
        super.signIn();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stateuniversity", "root", "Isuruni1998@");
            Statement stmt = con.createStatement();
            String sql = "select CNAME  from COURSE,STUDENT where  STUDENT.CID=COURSE.CID AND STUDENT.SPASSWORD LIKE ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();

            System.out.println("You have successfully registered for the following courses :");
            while(rs.next())
                System.out.println(rs.getString(1));
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
class Lecturer extends University{
    public void signup() throws IOException{
        super.signup();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stateuniversity", "root", "Isuruni1998@");
            Statement stmt = con.createStatement();
            for(int i=0;i< course_no.length;i++){
                 String query = " insert into LECTURER (LNAME, LUSERNAME, LAGE, CID, LPASSWORD)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, name);
                preparedStmt.setString (2, username);
                preparedStmt.setInt  (3, age);
                preparedStmt.setString(4, course_no[i]);
                preparedStmt.setString   (5, password);


                preparedStmt.execute();
            }
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public  void signIn() throws IOException{
        super.signIn();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stateuniversity", "root", "Isuruni1998@");

            String sql = "select CNAME  from LECTURER,COURSE where  LECTURER.CID=COURSE.CID AND LECTURER.LPASSWORD LIKE ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("You have successfully registered for the following courses :");
            while(rs.next())
                System.out.println(rs.getString(1));
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

}