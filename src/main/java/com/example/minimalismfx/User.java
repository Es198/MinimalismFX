package com.example.minimalismfx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String userName;
    private String userPassword;
    private String userType;
    private int UserAge;
    private String UserGender;

    public User(String userName, String userPassword, String userType, int userAge, String userGender) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        UserAge = userAge;
        UserGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserAge() {
        return UserAge;
    }

    public void setUserAge(int userAge) {
        UserAge = userAge;
    }

    public String getUserGender() {
        return UserGender;
    }

    public void setUserGender(String userGender) {
        UserGender = userGender;
    }

    public static void createUserFromCSV(){
        FileInputStream fis;
        Scanner fileScanner;
//todo: read the CSV file + need to parse it.
        try{
            fis=new FileInputStream("src/main/resources/userFile.csv");
            fileScanner=new Scanner(fis);
            fileScanner.useDelimiter(",");
            while(fileScanner.hasNextLine()){
                System.out.println(fileScanner.nextLine());
            }fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("User not found");;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
