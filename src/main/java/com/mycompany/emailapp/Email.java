package com.mycompany.emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private final int defaultPasswordLength = 4;
    private String department;
    private int mailBoxCapacity;
    private String email;
    private String alternatEmail;
    private final String companySuffix = "google.com";
    
    // Constructor to receive first and last name    
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment();
        setRandomPassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    
    // Ask for the departemnt
    private void setDepartment(){
        Scanner keyboard = new Scanner(System.in);
        int depChoice;
        
        do{
            System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter your department :");        
            depChoice = keyboard.nextInt();

            switch (depChoice) {
                case 1:
                    this.department = "sales";
                    break;
                case 2:
                    this.department = "development";
                    break;
                case 3:
                    this.department = "accounting";
                    break;
                default:
                    this.department = "";
                    break;
            }
        }
        while(depChoice < 0 || depChoice > 3);
    }
    
    // Generate a random password
    private void setRandomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$";
        String password = "";
        
        for (int i = 0; i < length ; i ++){
           int rand = (int)(Math.random() * passwordSet.length()) ;
           password += passwordSet.charAt(rand);
        }
        this.password = password;
    }
    
    // Set mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    // Set alternate email
    public void setAlternatEmail(String alternatEmail) {
        this.alternatEmail = alternatEmail;
    }   
    
    // Change the password   
    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email{" + "firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", department=" + department + ", mailBoxCapacity=" + mailBoxCapacity + ", email=" + email + '}';
    }

    

    

    
    
    
    
}
