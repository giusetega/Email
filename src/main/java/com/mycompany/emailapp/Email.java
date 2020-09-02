package com.mycompany.emailapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final int defaultPasswordLength = 8;
    private String department;
    private final String email;
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
        int depChoice = 0;
        String msg = "DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\nEnter your department code :";
        
        do{
            boolean isInt = false;

            do{
               System.out.println(msg);  
               if(keyboard.hasNextInt()){
                    depChoice = keyboard.nextInt();
                    isInt = true;
                }else{
                    keyboard.nextLine();
                    System.out.println("Enter a valid Integer value");
                }
            } while (!isInt);

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
            }
        }
        while(depChoice <= 0 || depChoice > 3);
    }
    
    // Generate a random password
    private void setRandomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$";
        String tmpPassword = "";
        
        for (int i = 0; i < length ; i ++){
           int rand = (int)(Math.random() * passwordSet.length()) ;
           tmpPassword += passwordSet.charAt(rand);
        }
        this.password = tmpPassword;
    }
    
    // Change the password   
    public void changePassword() {
        Scanner keyboard = new Scanner(System.in);
        String tmpPassword = "";
        
        boolean hasSpecialChars;
        boolean hasNumbers;
        boolean hasLetters;
        boolean hasMinLength;
        
        do{
            System.out.println("Insert your new password:");
            try {
                tmpPassword = keyboard.nextLine();                
            } catch (InputMismatchException e) {
                System.err.println("Error!");
            }
            
            // Check if the new passowrd contains letters, numbers and special characthers
            hasMinLength = pwdHasMinLenght(tmpPassword);
            hasSpecialChars = pwdHasSpecialChars(tmpPassword);
            hasNumbers = pwdHasNumbers(tmpPassword);
            hasLetters = pwdHasLetters(tmpPassword);
            
            if (!(hasMinLength && hasSpecialChars && hasNumbers && hasLetters))
                System.out.println("You must have letters, numbers and special characters and at least 8 digits (max digits 14)");
            }
        
        while(!(hasMinLength && hasSpecialChars && hasNumbers && hasLetters));
        
        this.password = tmpPassword;     
        
        System.out.println("Password has been changed successfully!");
        
    }    
    
    private boolean pwdHasMinLenght(String password){
        return (password.length() >= 8 && password.length() <=  14);
    }
    
    private boolean pwdHasSpecialChars(String password){
        String[] specialChars = {"?","!","@","#","$"};
        boolean result = false;
        for (String specialChar : specialChars){
            if (password.contains(specialChar)){
                result = true;
                break;
            }
        }
        
        return result;
    }    
    
    private boolean pwdHasNumbers(String password){        
//        return password.matches(".*\\d*.");
        boolean result = false;
        final String [] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        
        for (String number : numbers){
            if (password.contains(number)){
                result = true;
                break;
            }        
        }
        
        return result;
    }
    
    private boolean pwdHasLetters(String password){        
        char[] alphabet = getAlphabet();
        boolean result = false;
        for (int i = 0; i < alphabet.length; i++){
           if( password.indexOf(alphabet[i]) != -1){
               result = true;
               break;               
           }
        }
       
        return result;
    }    
    
    private char[] getAlphabet(){
        char[] charLetters = new char[122-97+1];
        int tmp = 97;
        for (int i = 0; i < charLetters.length; i++){
                charLetters[i] = (char) tmp;
                tmp++;
            }        
        
        return charLetters;
    }
    
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    

    @Override
    public String toString() {
        return "Email{" + "firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", department=" + department + ", email=" + email + '}';
    }
    
}
