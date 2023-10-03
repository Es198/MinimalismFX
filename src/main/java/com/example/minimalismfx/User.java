package com.example.minimalismfx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void createUserFromCSV() {
        FileInputStream fis;
        Scanner fileScanner;
        ArrayList<User> userList = new ArrayList<>();
        try {
            fis = new FileInputStream("src/main/resources/userFile.csv");
            fileScanner = new Scanner(fis);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] userRow = line.split(",");
                if (userRow.length == 5) {
                    String userName = userRow[0].trim();
                    String userPassword = userRow[1].trim();
                    String userType = userRow[2].trim();
                    int userAge = Integer.parseInt(userRow[3].trim());
                    String userGender = userRow[4].trim();
                    userList.add(new User(userName, userPassword, userType, userAge, userGender));
                }
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("User not found");
            ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
